package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import negocio.EventosDia;
import negocio.GerenciarEvento;
import util.ConferenceUtil;

public class JanelaPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton bVerEventos, bFechar;
	private JPanel pEsquerda, pCentro;
	public Container janela;
	private JTextArea area = new JTextArea();
	private JPanel pCentroAdd;
	private JScrollPane barra_rolagem;

	public void Janela() {
		setTitle("Lista Eventos");
		setSize(600, 400);
		setLocation(400, 150);
		setResizable(false);

		janela = getContentPane();
		janela.setLayout(new BorderLayout());

		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			// e.printStackTrace();
		}

		// Itens Painel Esquerda
		pEsquerda = new JPanel(new GridLayout(0, 1, 2, 2));
		pEsquerda.setPreferredSize(new Dimension(100, 100));
		pEsquerda.add(bVerEventos = new JButton("Ver Eventos"));
		bVerEventos.addActionListener(this);
		pEsquerda.add(bFechar = new JButton("Fechar"));
		bFechar.addActionListener(this);

		// Itens Painel Centro
		pCentro = new JPanel(new FlowLayout());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.add(pEsquerda, BorderLayout.WEST);
		janela.add(pCentro, BorderLayout.CENTER);
		setVisible(true);
	}

	public void janelaAdicionar() {
		pCentroAdd = new JPanel(new GridLayout(0, 1, 1, 1));

		barra_rolagem = new JScrollPane(area = new JTextArea());
		area.setEditable(Boolean.FALSE);
		this.add(barra_rolagem);

		pCentroAdd.add(barra_rolagem);

		area.setText(this.gerarLista());

		janela.add(pEsquerda, BorderLayout.WEST);
		janela.add(pCentroAdd, BorderLayout.CENTER);
		setVisible(true);
	}

	/**
	 * Gera a lista para ver na tela
	 * 
	 * @return String
	 */
	private String gerarLista() {
		String saida = "";
		GerenciarEvento gerenciarEvento = new GerenciarEvento();
		gerenciarEvento.carregarEventos();
		gerenciarEvento.gerarListaEventos();

		for (int i = 0; i < gerenciarEvento.getListaEventosDia().size(); i++) {
			EventosDia eDia = gerenciarEvento.getListaEventosDia().get(i);
			saida += "**Dia dio Evento: " + ConferenceUtil.dataFormatada(eDia.getDiaEvento()) + " **\n";

			for (int j = 0; j < eDia.getListaEventosDoDia().size(); j++) {
				saida += "Nome: " + eDia.getListaEventosDoDia().get(j).getNomeEvento() + "\n";
				saida += "Periodo: " + eDia.getListaEventosDoDia().get(j).getIndicadorPeriodoFormatado() + "\n";
				saida += "Duração: " + eDia.getListaEventosDoDia().get(j).getDuracaoEvento() + "\n\n";
			}

			saida += "\n\n";
		}

		return saida;
	}

	/**
	 * Eventos da tela
	 */
	public void actionPerformed(ActionEvent evento) {

		// finaliza a aplicacao
		if (evento.getSource() == bFechar) {
			System.exit(0);
		}

		// finaliza a aplicacao
		if (evento.getSource() == bVerEventos) {
			janela.removeAll();
			janelaAdicionar();
		}

	}

}