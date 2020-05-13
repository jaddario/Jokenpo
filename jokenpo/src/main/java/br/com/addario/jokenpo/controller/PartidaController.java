package br.com.addario.jokenpo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.addario.jokenpo.enums.Jogada;
import br.com.addario.jokenpo.pojo.Empate;
import br.com.addario.jokenpo.pojo.Jogador;
import br.com.addario.jokenpo.pojo.JogadorInvalido;

@RestController
@RequestMapping("/jokenpo")
public class PartidaController {
	private List<Jogador> jogadores = new ArrayList<Jogador>();

	public PartidaController() {
	}

	public PartidaController(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	@GetMapping
	@RequestMapping("/jogadores")
	public List<Jogador> getAllPlayers() {
		return jogadores;
	}

	@PostMapping
	public boolean criaJogador(@RequestBody Jogador jogador) {
		return jogadores.add(jogador);
	}

	@PutMapping(path = "/altera/{id}/{jogada}")
	public boolean alteraJogador(@PathVariable("id") int id, @PathVariable("jogada") Jogada jogada) {
		Jogador jogadorAlterado = obtemJogador(id);
		boolean encontrouJogador = jogadorAlterado.isValido();

		if (encontrouJogador)
			jogadorAlterado.setJogada(jogada);

		return encontrouJogador;
	}

	@DeleteMapping(path = "/remove/{id}")
	public boolean removeJogador(@PathVariable("id") int id) {
		Jogador jogadorASerRemovido = obtemJogador(id);
		boolean encontrouJogador = jogadorASerRemovido.isValido();
		return encontrouJogador ? jogadores.remove(jogadorASerRemovido) : false;
	}

	@GetMapping("/vencedores")
	public Jogador getVencedorGeral() {
		Stack<Jogador> vencedor = new Stack<Jogador>();
		jogadores.forEach(jogador -> {
			if (vencedor.empty())
				vencedor.push(jogador);
			else {
				Jogador ultimoVencedor = vencedor.peek();
				Jogador vencedorDaRodada = this.getVencedor(jogador, ultimoVencedor);
				if (!vencedorDaRodada.equals(ultimoVencedor)) {
					vencedor.pop();
					vencedor.push(vencedorDaRodada);
				}
			}
		});
		return vencedor.peek();
	}

	public Jogador getVencedor(Jogador playerUm, Jogador playerDois) {
		if (playerUm.getJogada().equals(playerDois.getJogada()))
			return new Empate();

		boolean resultado = playerUm.getJogada().compara(playerDois.getJogada());
		playerUm.setVenceu(resultado);
		return resultado ? playerUm : playerDois;
	}

	private Jogador obtemJogador(int id) {
		Jogador jogadorAlterado = jogadores.stream().filter(jogador -> id == jogador.getId()).findAny()
				.orElse(new JogadorInvalido());
		return jogadorAlterado;
	}
}
