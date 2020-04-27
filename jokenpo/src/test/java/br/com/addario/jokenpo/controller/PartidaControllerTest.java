package br.com.addario.jokenpo.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.addario.jokenpo.enums.Jogada;
import br.com.addario.jokenpo.pojo.Jogador;

class PartidaControllerTest {
	private PartidaController partida;
	private Jogador playerUm;
	private Jogador playerDois;
	private List<Jogador> jogadores;

	@BeforeEach
	void init() {
		partida = new PartidaController();
		playerUm = new Jogador("Carlos");
		playerDois = new Jogador("Pedro");
		jogadores = new ArrayList<Jogador>();
	}

	//Pedra
	
	@Test
	void deveRetornarUmEmpateEmCasoDeJogadasIguais() {
		playerUm.setJogada(Jogada.pedra);
		playerDois.setJogada(Jogada.pedra);
		Jogador empate = partida.getVencedor(playerUm, playerDois);
		assertEquals("empate", empate.getNome());
	}

	@Test
	void deveRetornarPlayerDoisPedraEhCobertaPeloPapel() {
		playerUm.setJogada(Jogada.pedra);
		playerDois.setJogada(Jogada.papel);
		Jogador vencedor = partida.getVencedor(playerUm, playerDois);
		assertEquals(playerDois.getNome(), vencedor.getNome());
	}

	@Test
	void deveRetornarPlayerUmPedraQuebraTesoura() {
		playerUm.setJogada(Jogada.pedra);
		playerDois.setJogada(Jogada.tesoura);
		Jogador vencedor = partida.getVencedor(playerUm, playerDois);
		assertEquals(playerUm.getNome(), vencedor.getNome());
	}

	@Test
	void deveRetornarPlayerUmPedraEsmagaLagarto() {
		playerUm.setJogada(Jogada.pedra);
		playerDois.setJogada(Jogada.lagarto);
		Jogador vencedor = partida.getVencedor(playerUm, playerDois);
		assertEquals(playerUm.getNome(), vencedor.getNome());
	}

	@Test
	void deveRetornarPlayerDoisPedraEhVaporizadaPeloSpock() {
		playerUm.setJogada(Jogada.pedra);
		playerDois.setJogada(Jogada.spock);
		Jogador vencedor = partida.getVencedor(playerUm, playerDois);
		assertEquals(playerDois.getNome(), vencedor.getNome());
	}
	
	//Papel

	@Test
	void deveRetornarPlayerUmPapelCobrePedra() {
		playerUm.setJogada(Jogada.papel);
		playerDois.setJogada(Jogada.pedra);
		Jogador vencedor = partida.getVencedor(playerUm, playerDois);
		assertEquals(playerUm.getNome(), vencedor.getNome());
	}

	@Test
	void deveRetornarPlayerDoisPapelEhCortadaPelaTesoura() {
		playerUm.setJogada(Jogada.papel);
		playerDois.setJogada(Jogada.tesoura);
		Jogador vencedor = partida.getVencedor(playerUm, playerDois);
		assertEquals(playerDois.getNome(), vencedor.getNome());
	}

	@Test
	void deveRetornarPlayerDoisPapelEhComidoPeloLagarto() {
		playerUm.setJogada(Jogada.papel);
		playerDois.setJogada(Jogada.lagarto);
		Jogador vencedor = partida.getVencedor(playerUm, playerDois);
		assertEquals(playerDois.getNome(), vencedor.getNome());
	}

	@Test
	void deveRetornarPlayerUmPapelRefutaSpock() {
		playerUm.setJogada(Jogada.papel);
		playerDois.setJogada(Jogada.spock);
		Jogador vencedor = partida.getVencedor(playerUm, playerDois);
		assertEquals(playerUm.getNome(), vencedor.getNome());
	}
	
	//Tesoura
	
	@Test
	void deveRetornarPlayerDoisTesouraEhQuebradaPelaPedra() {
		playerUm.setJogada(Jogada.tesoura);
		playerDois.setJogada(Jogada.pedra);
		Jogador vencedor = partida.getVencedor(playerUm, playerDois);
		assertEquals(playerDois.getNome(), vencedor.getNome());
	}

	@Test
	void deveRetornarPlayerUmTesouraCortaPapel() {
		playerUm.setJogada(Jogada.tesoura);
		playerDois.setJogada(Jogada.papel);
		Jogador vencedor = partida.getVencedor(playerUm, playerDois);
		assertEquals(playerUm.getNome(), vencedor.getNome());
	}

	@Test
	void deveRetornarPlayerUmTesouraMataLagarto() {
		playerUm.setJogada(Jogada.tesoura);
		playerDois.setJogada(Jogada.lagarto);
		Jogador vencedor = partida.getVencedor(playerUm, playerDois);
		assertEquals(playerUm.getNome(), vencedor.getNome());
	}

	@Test
	void deveRetornarPlayerDoisTesouraEhQuebradaPorSpock() {
		playerUm.setJogada(Jogada.tesoura);
		playerDois.setJogada(Jogada.spock);
		Jogador vencedor = partida.getVencedor(playerUm, playerDois);
		assertEquals(playerDois.getNome(), vencedor.getNome());
	}
	
	//Lagarto
	
	@Test
	void deveRetornarPlayerDoisLagartoEhEsmagadoPelaPedra() {
		playerUm.setJogada(Jogada.lagarto);
		playerDois.setJogada(Jogada.pedra);
		Jogador vencedor = partida.getVencedor(playerUm, playerDois);
		assertEquals(playerDois.getNome(), vencedor.getNome());
	}
	
	@Test
	void deveRetornarPlayerUmLagartoComePapel() {
		playerUm.setJogada(Jogada.lagarto);
		playerDois.setJogada(Jogada.papel);
		Jogador vencedor = partida.getVencedor(playerUm, playerDois);
		assertEquals(playerUm.getNome(), vencedor.getNome());
	}
	
	@Test
	void deveRetornarPlayerDoisLagartoEhMortoPelaTesoura() {
		playerUm.setJogada(Jogada.lagarto);
		playerDois.setJogada(Jogada.tesoura);
		Jogador vencedor = partida.getVencedor(playerUm, playerDois);
		assertEquals(playerDois.getNome(), vencedor.getNome());
	}
	
	@Test
	void deveRetornarPlayerUmLagartoEnvenenaSpock() {
		playerUm.setJogada(Jogada.lagarto);
		playerDois.setJogada(Jogada.spock);
		Jogador vencedor = partida.getVencedor(playerUm, playerDois);
		assertEquals(playerUm.getNome(), vencedor.getNome());
	}
	
	//Spock
	
	@Test
	void deveRetornarPlayerUmSpockVaporizaPedra() {
		playerUm.setJogada(Jogada.spock);
		playerDois.setJogada(Jogada.pedra);
		Jogador vencedor = partida.getVencedor(playerUm, playerDois);
		assertEquals(playerUm.getNome(), vencedor.getNome());
	}
	
	@Test
	void deveRetornarPlayerDoisSpockEhRefutadoPeloPapel() {
		playerUm.setJogada(Jogada.spock);
		playerDois.setJogada(Jogada.papel);
		Jogador vencedor = partida.getVencedor(playerUm, playerDois);
		assertEquals(playerDois.getNome(), vencedor.getNome());
	}
	
	@Test
	void deveRetornarPlayerUmSpockQuebraTesoura() {
		playerUm.setJogada(Jogada.spock);
		playerDois.setJogada(Jogada.tesoura);
		Jogador vencedor = partida.getVencedor(playerUm, playerDois);
		assertEquals(playerUm.getNome(), vencedor.getNome());
	}
	
	@Test
	void deveRetornarPlayerDoisSpockEhEnvenenadoPeloLagarto() {
		playerUm.setJogada(Jogada.spock);
		playerDois.setJogada(Jogada.lagarto);
		Jogador vencedor = partida.getVencedor(playerUm, playerDois);
		assertEquals(playerDois.getNome(), vencedor.getNome());
	}

	// Finalmente testa o quem é o jogador que ganhou no final

	@Test
	void deveRetornarUmJogadorDaListaDeJogadoresCasoAListaTenhaUmJogador() {
		playerUm.setJogada(Jogada.pedra);
		jogadores.add(playerUm);
		Jogador vencedor = new PartidaController(jogadores).getVencedorGeral();
		assertEquals(playerUm.getNome(), vencedor.getNome());
	}

	@Test
	void deveRetornarUmEmpateCasoAsJogadasSejamIguais() {
		playerUm.setJogada(Jogada.pedra);
		playerDois.setJogada(Jogada.pedra);
		jogadores.add(playerUm);
		jogadores.add(playerDois);
		Jogador vencedor = new PartidaController(jogadores).getVencedorGeral();
		assertEquals("empate", vencedor.getNome());
	}

	@Test
	void deveRetornarUltimoJogadorCasoDeEmpateDaListaDeJogadores() {
		playerUm.setJogada(Jogada.pedra);
		playerDois.setJogada(Jogada.pedra);
		Jogador playerTres = new Jogador("Flavio");
		playerTres.setJogada(Jogada.tesoura);
		jogadores.add(playerUm);
		jogadores.add(playerDois);
		jogadores.add(playerTres);
		Jogador vencedor = new PartidaController(jogadores).getVencedorGeral();
		assertEquals(playerTres.getNome(), vencedor.getNome());
	}

}
