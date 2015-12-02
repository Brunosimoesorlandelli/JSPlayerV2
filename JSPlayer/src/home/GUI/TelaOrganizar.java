package home.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import home.negocio.Fachada;
import home.negocio.IFachada;
import home.negocio.beans.Playlist;
import home.negocio.beans.Usuario;
import javax.swing.ListSelectionModel;

public class TelaOrganizar extends JFrame {

	private String[] valores;
	private int i;
	private JPanel contentPane;
	private List l = null;
	private List<String> stringsInput = new ArrayList<String>();
	private List<String> stringsOutput = new ArrayList<String>();
	private JTextField textNomeP;
	private JList Banco;
	private SortedListModel sourceListModel;
	private JList Playlist;
	private SortedListModel destListModel;

	public void clearSourceListModel() {
		sourceListModel.clear();
	}

	public void clearDestinationListModel() {
		destListModel.clear();
	}

	public void addSourceElements(ListModel newValue) {
		fillListModel(sourceListModel, newValue);
	}

	public void setSourceElements(ListModel newValue) {
		clearSourceListModel();
		addSourceElements(newValue);
	}

	public void addDestinationElements(ListModel newValue) {
		fillListModel(destListModel, newValue);
	}

	private void fillListModel(SortedListModel model, ListModel newValues) {
		int size = newValues.getSize();
		for (int i = 0; i < size; i++) {
			model.add(newValues.getElementAt(i));
		}
	}

	public void addSourceElements(Object newValue[]) {
		fillListModel(sourceListModel, newValue);
	}

	public void setSourceElements(Object newValue[]) {
		clearSourceListModel();
		addSourceElements(newValue);
	}

	public void addDestinationElements(Object newValue[]) {
		fillListModel(destListModel, newValue);
	}

	private void fillListModel(SortedListModel model, Object newValues[]) {
		model.addAll(newValues);
	}

	private void clearSourceSelected() {
		Object selected[] = Banco.getSelectedValues();
		for (int i = selected.length - 1; i >= 0; --i) {
			sourceListModel.removeElement(selected[i]);
		}
		Banco.getSelectionModel().clearSelection();
	}

	private void clearDestinationSelected() {
		Object selected[] = Playlist.getSelectedValues();
		for (int i = selected.length - 1; i >= 0; --i) {
			destListModel.removeElement(selected[i]);
		}
		Playlist.getSelectionModel().clearSelection();
	}

	public TelaOrganizar(Usuario u, Playlist lista) {

		sourceListModel = new SortedListModel();
		Banco = new JList(sourceListModel);
		Banco.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		destListModel = new SortedListModel();
		Playlist = new JList(destListModel);
		Playlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		IFachada f = Fachada.getInstance();
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagens\\f39bfcb5.png"));
		setTitle("JSPlayer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDigiteONome = new JLabel("Deseja mudar o nome da sua playlist?");
		lblDigiteONome.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		lblDigiteONome.setBounds(10, 34, 360, 14);
		contentPane.add(lblDigiteONome);

		textNomeP = new JTextField();
		textNomeP.setBounds(380, 26, 260, 33);
		contentPane.add(textNomeP);
		textNomeP.setColumns(10);

		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(
				new TitledBorder(null, "Banco de Musicas", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, null));
		leftPanel.setBounds(100, 96, 274, 354);
		contentPane.add(leftPanel);
		leftPanel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		leftPanel.add(scrollPane, BorderLayout.CENTER);

		scrollPane.setViewportView(Banco);

		JButton addButton = new JButton(">>");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selected[] = Banco.getSelectedValues();
				addDestinationElements(selected);
				clearSourceSelected();
			}
		});

		leftPanel.add(addButton, BorderLayout.SOUTH);

		JPanel rightPanel = new JPanel();
		rightPanel.setBorder(
				new TitledBorder(null, "Sua Playlist", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, null));
		rightPanel.setBounds(382, 96, 274, 354);
		contentPane.add(rightPanel);
		rightPanel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		rightPanel.add(scrollPane_1, BorderLayout.CENTER);

		scrollPane_1.setViewportView(Playlist);

		JButton removeButton = new JButton("<<");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				Object selected[] = Playlist.getSelectedValues();
				String a = (String) Playlist.getModel().getElementAt(Playlist.getSelectedIndex());
				String titulo = a.substring(0, a.indexOf("-"));
				String artista = a.substring(a.indexOf("-") + 1);
				lista.removeSong(f.procurarMusica(titulo, artista));
				addSourceElements(selected);
				clearDestinationSelected();
			}
		});

		rightPanel.add(removeButton, BorderLayout.SOUTH);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lista.setNomeP(textNomeP.getText());
				for (int indice = 0; indice <= Playlist.getLastVisibleIndex(); indice++) {
					String a = (String) Playlist.getModel().getElementAt(indice);
					String titulo = a.substring(0, a.indexOf("-"));
					String artista = a.substring(a.indexOf("-") + 1);
					lista.addSong(f.procurarMusica(titulo, artista));
				}
				f.cadastrarPlaylist(lista);
				f.salvar();
				dispose();
				TelaUsuario telaUsuario = new TelaUsuario(u);
				telaUsuario.setVisible(true);
				telaUsuario.setLocationRelativeTo(null);
				telaUsuario.setResizable(false);
			}
		});
		btnSalvar.setBounds(709, 437, 90, 33);
		contentPane.add(btnSalvar);

		JButton btnRetornar = new JButton("Retornar");
		btnRetornar.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		btnRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				TelaUsuario telaUsuario = new TelaUsuario(u);
				telaUsuario.setVisible(true);
				telaUsuario.setLocationRelativeTo(null);
				telaUsuario.setResizable(false);
			}
		});
		btnRetornar.setBounds(10, 451, 90, 33);
		contentPane.add(btnRetornar);

	}

}
