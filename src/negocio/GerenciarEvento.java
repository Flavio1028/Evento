package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Util.ConferenceUtil;

public class GerenciarEvento {

	/**
	 * Atributo que contem a lista de eventos carregada sem organizar os dados
	 */
	private List<Evento> listaEventos;

	/**
	 * Atributo que contem a lista de eventos do dia
	 */
	private List<EventosDia> listaEventosDia;

	/**
	 * Atributo controle indicador hora evento
	 */
	private boolean controleIndicador = Boolean.TRUE;

	/**
	 * Construtor padrao
	 */
	public GerenciarEvento() {
		this.listaEventos = new ArrayList<>();
		this.listaEventosDia = new ArrayList<>();
	}

	/**
	 * @return the listaEventos
	 */
	public List<Evento> getListaEventos() {
		return listaEventos;
	}

	/**
	 * @param listaEventos
	 *            the listaEventos to set
	 */
	public void setListaEventos(List<Evento> listaEventos) {
		this.listaEventos = listaEventos;
	}

	/**
	 * @return the listaEventos
	 */
	public List<EventosDia> getListaEventosDia() {
		return listaEventosDia;
	}

	/**
	 * Carrega os eventos e adiciona eles a lista
	 */
	public void carregarEventos() {
		listaEventos.add(new Evento("Writing Fast Tests Against Enterprise Rails", 60));
		listaEventos.add(new Evento("Overdoing it in Python", 45));
		listaEventos.add(new Evento("Lua for the Masses", 30));
		listaEventos.add(new Evento("Ruby Errors from Mismatched Gem Versions", 45));
		listaEventos.add(new Evento("Common Ruby Errors", 60));
		listaEventos.add(new Evento("Rails for Python Developers lightning Communicating Over Distance", 30));
		listaEventos.add(new Evento("Accounting-Driven Development", 30));
		listaEventos.add(new Evento("Woah", 45));
		listaEventos.add(new Evento("Sit Down and Write", 30));
		listaEventos.add(new Evento("Pair Programming vs Noise", 45));
		listaEventos.add(new Evento("Rails Magic", 60));
		listaEventos.add(new Evento("Ruby on Rails: Why We Should Move On", 60));
		listaEventos.add(new Evento("Clojure Ate Scala (on my project)", 45));
		listaEventos.add(new Evento("Programming in the Boondocks of Seattle", 30));
		listaEventos.add(new Evento("Ruby vs. Clojure for Back-End Development", 30));
		listaEventos.add(new Evento("Ruby on Rails Legacy App Maintenance", 60));
		listaEventos.add(new Evento("A World Without HackerNews", 30));
		listaEventos.add(new Evento("User Interface CSS in Rails Apps", 30));
	}

	/**
	 * Este metodo organiza os eventos que deverao acontecer no dia
	 */
	public void gerarListaEventos() {
		// Maximo de horas disponiveis no periodo da manha e tarde
		double totalHoras = 0;
		// Lista para armazernar os eventos do dia
		this.listaEventosDia = new ArrayList<>();
		// indice para a lista de eventos do dia
		int indiceEventosDia = 0;
		// data inicio do evento
		Date dataAtual = new Date();
		// Objeto eventos do dia
		EventosDia eventosDia = new EventosDia(new ArrayList<>(), dataAtual);
		listaEventosDia.add(eventosDia);

		for (int index = 0; index < this.getListaEventos().size(); index++) {

			// Calcula o todal de horas para o evento atual
			totalHoras = this.getListaEventos().get(index).getDuracaoEvento() + totalHoras;

			// Verifica se o total de eventos nao utrapassou o maximo de horas
			if ((totalHoras / 60) <= 3) {
				// Objeto evento
				Evento evento = this.getListaEventos().get(index);
				listaEventosDia.get(indiceEventosDia).getListaEventosDoDia().add(this.adicionarInformacaoEvento(evento,dataAtual,totalHoras));

			} else {
				// Verifica se o dia deve ser atualizado
				if (!controleIndicador) {
					dataAtual = ConferenceUtil.somarUmDiaData(dataAtual);
				}
				eventosDia = new EventosDia(new ArrayList<>(), dataAtual);
				listaEventosDia.add(eventosDia);
				totalHoras = 0;
				index = index - 1;
				indiceEventosDia++;
				controleIndicador = !controleIndicador;
			}

		}
	}

	private Evento adicionarInformacaoEvento(Evento evento, Date data, double totalHoras) {
		// Verifica qual o periodo
		char indicadorPeriodo = controleIndicador ? 'M' : 'T';
		evento.setIndicadorPeriodo(indicadorPeriodo);
	
		return evento;
	}
}