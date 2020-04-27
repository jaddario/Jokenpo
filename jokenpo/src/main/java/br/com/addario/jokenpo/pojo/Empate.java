package br.com.addario.jokenpo.pojo;

import br.com.addario.jokenpo.enums.Jogada;

public class Empate extends Jogador {
	private String nome;
	private Jogada jogada;

	public Empate() {
		this.nome = "empate";
		this.jogada = Jogada.empate;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Jogada getJogada() {
		return jogada;
	}
	
}
