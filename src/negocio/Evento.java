package negocio;

import java.util.Date;

public class Evento {

	/**
	 * Atributo com o nome do evento
	 */
	private String nomeEvento;

	/**
	 * Atributo a duracao do evento
	 */
	private int duracaoEvento;

	/**
	 * Atributo com a hora que o evento comeca
	 */
	private Date inicioEvento;

	/**
	 * Atributo com a hora que o evento termina
	 */
	private Date fimEvento;

	/**
	 * Atributo para indicar se o evento ocorre na parte da manha ou da tarde M =
	 * manha | T = tarde
	 */
	private char indicadorPeriodo;

	/**
	 * 
	 * @param nomeEvento
	 * @param duracaoEvento
	 */
	public Evento(String nomeEvento, int duracaoEvento) {
		this.nomeEvento = nomeEvento;
		this.duracaoEvento = duracaoEvento;
	}

	/**
	 * Construtor padrao da classe
	 */
	public Evento() {
		this.nomeEvento = "";
		this.duracaoEvento = 0;
		this.inicioEvento = null;
		this.fimEvento = null;
	}

	/**
	 * @return the nomeEvento
	 */
	public String getNomeEvento() {
		return nomeEvento;
	}

	/**
	 * @param nomeEvento
	 *            the nomeEvento to set
	 */
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	/**
	 * @return the duracaoEvento
	 */
	public int getDuracaoEvento() {
		return duracaoEvento;
	}

	/**
	 * @param duracaoEvento
	 *            the duracaoEvento to set
	 */
	public void setDuracaoEvento(int duracaoEvento) {
		this.duracaoEvento = duracaoEvento;
	}

	/**
	 * @return the inicioEvento
	 */
	public Date getInicioEvento() {
		return inicioEvento;
	}

	/**
	 * @param inicioEvento
	 *            the inicioEvento to set
	 */
	public void setInicioEvento(Date inicioEvento) {
		this.inicioEvento = inicioEvento;
	}

	/**
	 * @return the fimEvento
	 */
	public Date getFimEvento() {
		return fimEvento;
	}

	/**
	 * @param fimEvento
	 *            the fimEvento to set
	 */
	public void setFimEvento(Date fimEvento) {
		this.fimEvento = fimEvento;
	}

	/**
	 * @return the indicadorPeriodo
	 */
	public char getIndicadorPeriodo() {
		return indicadorPeriodo;
	}

	/**
	 * @param indicadorPeriodo
	 *            the indicadorPeriodo to set
	 */
	public void setIndicadorPeriodo(char indicadorPeriodo) {
		this.indicadorPeriodo = indicadorPeriodo;
	}

	/**
	 * @return the indicadorPeriodo Formatado
	 */
	public String getIndicadorPeriodoFormatado() {

		if (this.indicadorPeriodo == 'M') {
			return "Manhã";

		}
		return "Tarde";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Evento [nomeEvento=" + nomeEvento + ", duracaoEvento=" + duracaoEvento + ", inicioEvento="
				+ inicioEvento + ", fimEvento=" + fimEvento + ", indicadorPeriodo=" + indicadorPeriodo + "]";
	}
}