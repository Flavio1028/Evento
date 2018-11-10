package negocio;

import java.util.Date;
import java.util.List;

public class EventosDia {

	/**
	 * Atributo Lista de Evento do Dia
	 */
	private List<Evento> listaEventosDoDia;

	/**
	 * Atributo Dia do Evento
	 */
	private Date diaEvento;

	/**
	 * @param listaEventosDoDia
	 * @param diaEvento
	 */
	public EventosDia(List<Evento> listaEventosDoDia, Date diaEvento) {
		this.listaEventosDoDia = listaEventosDoDia;
		this.diaEvento = diaEvento;
	}

	/**
	 * @return the listaEventosDoDia
	 */
	public List<Evento> getListaEventosDoDia() {
		return listaEventosDoDia;
	}

	/**
	 * @param listaEventosDoDia
	 *            the listaEventosDoDia to set
	 */
	public void setListaEventosDoDia(List<Evento> listaEventosDoDia) {
		this.listaEventosDoDia = listaEventosDoDia;
	}

	/**
	 * @return the diaEvento
	 */
	public Date getDiaEvento() {
		return diaEvento;
	}

	/**
	 * @param diaEvento
	 *            the diaEvento to set
	 */
	public void setDiaEvento(Date diaEvento) {
		this.diaEvento = diaEvento;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EventosDia [listaEventosDoDia=" + listaEventosDoDia + ", diaEvento=" + diaEvento + "]";
	}
}