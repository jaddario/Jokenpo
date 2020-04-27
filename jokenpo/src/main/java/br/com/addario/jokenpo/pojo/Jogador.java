package br.com.addario.jokenpo.pojo;

import java.util.concurrent.atomic.AtomicInteger;

import br.com.addario.jokenpo.enums.Jogada;

public class Jogador {
	
	private static AtomicInteger ID_GENERATOR = new AtomicInteger();
	private long id;

	private String nome;
	private Jogada jogada;
	private boolean venceu;

	public Jogador() {
		id = ID_GENERATOR.getAndIncrement();
		this.venceu = false;
	}

	public Jogador(String nome) {
		id = ID_GENERATOR.getAndIncrement();
		this.nome = nome;
		this.venceu = false;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Jogada getJogada() {
		return jogada;
	}

	public void setJogada(Jogada jogada) {
		this.jogada = jogada;
	}

	public boolean isVenceu() {
		return venceu;
	}

	public void setVenceu(boolean venceu) {
		this.venceu = venceu;
	}

}
