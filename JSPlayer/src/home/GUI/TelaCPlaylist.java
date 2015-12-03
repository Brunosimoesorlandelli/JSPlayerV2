package home.GUI;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import home.negocio.Fachada;
import home.negocio.IFachada;
import home.negocio.beans.Musica;
import home.negocio.beans.Playlist;
import home.negocio.beans.Usuario;

import java.awt.Toolkit;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.ListModel;

import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;

 class SortedListModel extends AbstractListModel {
	SortedSet<Object> model;

	public SortedListModel() {
		model = new TreeSet<Object>();
	}

	public int getSize() {
		return model.size();
	}

	public Object getElementAt(int index) {
		return model.toArray()[index];
	}

	public void add(Object element) {
		if (model.add(element)) {
			fireContentsChanged(this, 0, getSize());
		}
	}

	public void addAll(Object elements[]) {
		Collection<Object> c = Arrays.asList(elements);
		model.addAll(c);
		fireContentsChanged(this, 0, getSize());
	}

	public void clear() {
		model.clear();
		fireContentsChanged(this, 0, getSize());
	}

	public boolean contains(Object element) {
		return model.contains(element);
	}

	public Object firstElement() {
		return model.first();
	}

	public Iterator iterator() {
		return model.iterator();
	}

	public Object lastElement() {
		return model.last();
	}

	public boolean removeElement(Object element) {
		boolean removed = model.remove(element);
		if (removed) {
			fireContentsChanged(this, 0, getSize());
		}
		return removed;
	}
}

public class TelaCPlaylist extends JFrame {

	private String[] valores;
	private int i;
	private JPanel contentPane;
	private List l = null;
	private List<String> stringsInput = new ArrayList<String>();
	private List<String> stringsOutput = new ArrayList<String>();
	private JTextField textNomeP;
	private JList list;
	private SortedListModel sourceListModel;
	private JList list_1;
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
		Object selected[] = list.getSelectedValues();
		for (int i = selected.length - 1; i >= 0; --i) {
			sourceListModel.removeElement(selected[i]);
		}
		list.getSelectionModel().clearSelection();
	}

	private void clearDestinationSelected() {
		Object selected[] = list_1.getSelectedValues();
		for (int i = selected.length - 1; i >= 0; --i) {
			destListModel.removeElement(selected[i]);
		}
		list_1.getSelectionModel().clearSelection();
	}

	
	public TelaCPlaylist(Usuario u) {
		
		sourceListModel = new SortedListModel();
		list = new JList(sourceListModel);
		list.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		destListModel = new SortedListModel();
		list_1 = new JList(destListModel);
		list_1.setFont(new Font("OCR A Extended", Font.PLAIN, 14));

		IFachada f = Fachada.getInstance();
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagens\\f39bfcb5.png"));
		setTitle("JSPlayer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		
		JLabel lblDigiteONome = new JLabel("Digite o nome da sua Playlist: ");
		lblDigiteONome.setForeground(SystemColor.controlHighlight);
		lblDigiteONome.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		lblDigiteONome.setBounds(10, 34, 248, 15);
		contentPane.add(lblDigiteONome);

		textNomeP = new JTextField();
		textNomeP.setBounds(304, 25, 260, 33);
		contentPane.add(textNomeP);
		textNomeP.setColumns(10);

		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Banco de M\u00FAsicas", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		leftPanel.setBounds(100, 96, 274, 354);
		contentPane.add(leftPanel);
		leftPanel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		leftPanel.add(scrollPane, BorderLayout.CENTER);

		scrollPane.setViewportView(list);

		JButton addButton = new JButton(">>");
		addButton.addActionListener(new AddListener());

		leftPanel.add(addButton, BorderLayout.SOUTH);

		JPanel rightPanel = new JPanel();
		rightPanel.setBorder(
				new TitledBorder(null, "Sua Playlist", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, null));
		rightPanel.setBounds(382, 96, 274, 354);
		contentPane.add(rightPanel);
		rightPanel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		rightPanel.add(scrollPane_1, BorderLayout.CENTER);

		scrollPane_1.setViewportView(list_1);

		JButton removeButton = new JButton("<<");
		removeButton.addActionListener(new RemoveListener());
		rightPanel.add(removeButton, BorderLayout.SOUTH);

		JButton btnCriar = new JButton("Criar");
		btnCriar.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Playlist lista = new Playlist();
				lista.setNomeP(textNomeP.getText());
				for (int indice = 0; indice <= list_1.getLastVisibleIndex(); indice++) {
					String a = (String) list_1.getModel().getElementAt(indice);
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
		btnCriar.setBounds(709, 437, 73, 23);
		contentPane.add(btnCriar);
		
		JButton btnRetornar = new JButton("Retornar");
		btnRetornar.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		btnRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				TelaUsuario telaUsuario = new TelaUsuario(u);
				telaUsuario.setVisible(true);
				telaUsuario.setLocationRelativeTo(null);
				telaUsuario.setResizable(false);
			}
		});
		btnRetornar.setBounds(10, 451, 97, 23);
		contentPane.add(btnRetornar);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon("Imagens\\JSPlayer 4.jpg"));
		label.setBounds(0, 0, 844, 500);
		contentPane.add(label);

	}

	

	public class AddListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object selected[] = list.getSelectedValues();
			addDestinationElements(selected);
			clearSourceSelected();
		}
	}

	public class RemoveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object selected[] = list_1.getSelectedValues();
			addSourceElements(selected);
			clearDestinationSelected();
		}
	}
}
