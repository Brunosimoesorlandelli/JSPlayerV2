package home.GUI;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import home.negocio.Fachada;
import home.negocio.IFachada;

import java.awt.Toolkit;
import javax.swing.ListSelectionModel;

public class TelaCPlaylist extends JFrame {

	private String[] valores;
	private int i;
	private JPanel contentPane;
	private List l = null;
	private JList listIn;
	private JList listOut;
	private List<String> stringsInput = new ArrayList<String>();
	private List<String> stringsOutput = new ArrayList<String>();

	/**
	 * Create the frame.
	 */
	public TelaCPlaylist() {
		IFachada f = Fachada.getInstance();
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\HP\\git\\JSPlayerV7\\JSPlayer\\Imagens\\f39bfcb5.png"));
		setTitle("JSPlayer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEntrada = new JLabel("Entrada");
		lblEntrada.setBounds(168, 50, 46, 14);
		contentPane.add(lblEntrada);

		listIn = new JList();
		listIn.setBounds(76, 90, 230, 319);
		contentPane.add(listIn);
		listIn.setModel(new AbstractListModel() {

			String[] values = f.retornaMusicas();

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});

		JLabel lblSada = new JLabel("Sa\u00EDda");
		lblSada.setBounds(616, 50, 46, 14);
		contentPane.add(lblSada);

		JButton changeBt = new JButton(">>");
		changeBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l = listIn.getSelectedValuesList();
				listOut.setListData(l.toArray());
				i = listOut.getModel().getSize();
				i++;
			}
		});
		changeBt.setBounds(372, 228, 78, 51);
		contentPane.add(changeBt);

		listOut = new JList();
		listOut.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listOut.setValueIsAdjusting(true);
		listOut.setBounds(524, 90, 230, 319);
		contentPane.add(listOut);
		listOut.setModel(new AbstractListModel() {
			
			@Override
			public Object getElementAt(int index) {
				return valores[index];
			}
			
			@Override
			public int getSize() {
				return valores.length;
			}
			
		});
	
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		TelaCPlaylist frame = new TelaCPlaylist();
		frame.setVisible(true);
	}

}
