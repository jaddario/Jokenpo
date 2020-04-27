package br.com.addario.jokenpo.enums;

public enum Jogada {
	pedra("pedra"), papel("papel"), tesoura("tesoura"), lagarto("lagarto"), spock("spock"), empate("empate");

	private String descricao;
	private boolean PERDE = false;
	private boolean GANHA = true;

	private Jogada(String descricao) {
		this.descricao = descricao;
	}

	public boolean compara(Jogada jogada) {
		switch (this) {
		case pedra:
			if (jogada == Jogada.tesoura || jogada == Jogada.lagarto || jogada == Jogada.empate) {
				return GANHA;
			} else
				return PERDE;
		case papel:
			if (jogada == Jogada.pedra || jogada == Jogada.spock || jogada == Jogada.empate) {
				return GANHA;
			} else
				return PERDE;
		case tesoura:
			if (jogada == Jogada.papel || jogada == Jogada.lagarto || jogada == Jogada.empate) {
				return GANHA;
			} else
				return PERDE;
		case lagarto:
			if (jogada == Jogada.papel || jogada == Jogada.spock || jogada == Jogada.empate) {
				return GANHA;
			} else
				return PERDE;
		case spock:
			if (jogada == Jogada.pedra || jogada == Jogada.tesoura || jogada == Jogada.empate) {
				return GANHA;
			} else
				return PERDE;

		default:
			return PERDE;
		}
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
