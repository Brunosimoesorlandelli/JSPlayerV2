package home.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import home.negocio.Fachada;
import home.negocio.IFachada;
import home.negocio.beans.Musica;
import home.negocio.beans.Usuario;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLayeredPane;
import javax.swing.JToolBar;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;

public class TelaUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textTituloTocar;
	private JTextField textArtistaTocar;
	private JTextField textTitulo;
	private JTextField textArtista;

	/**
	 * Create the frame.
	 */
	public TelaUsuario(Usuario u) {

		IFachada f = Fachada.getInstance();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\Pictures\\unnamed (2).png"));
		setTitle("JSPlayer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 528);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnPerfil = new JMenu("Perfil");
		menuBar.add(mnPerfil);

		JMenuItem mntmAlterarDados = new JMenuItem("Alterar Dados");
		mnPerfil.add(mntmAlterarDados);

		JMenuItem mntmProcurarUsuarios = new JMenuItem("Procurar Usuarios");
		mnPerfil.add(mntmProcurarUsuarios);

		JMenuItem mntmDeslogar = new JMenuItem("Deslogar");
		mntmDeslogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaLogin telaLogin = new TelaLogin();
				telaLogin.setVisible(true);
				telaLogin.setLocationRelativeTo(null);
				telaLogin.setResizable(false);

			}
		});
		mnPerfil.add(mntmDeslogar);

		JMenu mnNewMenu = new JMenu("Ajuda");
		menuBar.add(mnNewMenu);

		JMenuItem mntmSobreOJsplayer = new JMenuItem("Sobre o JSPlayer");
		mnNewMenu.add(mntmSobreOJsplayer);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label_1 = new JLabel("Bem Vindo ao JSPlayer");
		label_1.setForeground(new Color(0, 255, 255));
		label_1.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		label_1.setBounds(16, 6, 188, 14);
		contentPane.add(label_1);

		JButton button = new JButton("Procurar Usuario");
		button.setBounds(16, 31, 165, 23);
		contentPane.add(button);

		JButton btnCMusica = new JButton("Cadastrar Musica");
		btnCMusica.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaCMusica telaCMusica = new TelaCMusica(u);
				telaCMusica.setVisible(true);
				telaCMusica.setResizable(false);
				telaCMusica.setLocationRelativeTo(null);
			}
		});
		btnCMusica.setBounds(645, 239, 165, 23);
		contentPane.add(btnCMusica);

		JLabel lblMusica = new JLabel("Musica");
		lblMusica.setForeground(new Color(0, 255, 255));
		lblMusica.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		lblMusica.setBounds(646, 213, 85, 14);
		contentPane.add(lblMusica);

		JLabel lblPlaylist = new JLabel("Playlist");
		lblPlaylist.setBounds(645, 18, 55, 16);
		contentPane.add(lblPlaylist);

		JButton button_2 = new JButton("Criar Playlist");
		button_2.setBounds(645, 58, 146, 28);
		contentPane.add(button_2);

		JButton btnPrintarMusica = new JButton("Printar Musica");
		btnPrintarMusica.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.printarDadosMusica();
			}
		});
		btnPrintarMusica.setBounds(645, 290, 146, 25);
		contentPane.add(btnPrintarMusica);

		JButton btnTocarMusica = new JButton("Tocar Musica");
		btnTocarMusica.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (textTitulo.getText().length() > 0 && textArtista.getText().length() > 0) {
					Musica m = f.procurarMusica(textTitulo.getText(), textArtista.getText());
					if (m != null) {
						TelaPlayer telaPlayer = TelaPlayer.getInstance();
						if (telaPlayer.getFunk()) {
							telaPlayer.fechar();
							telaPlayer.setFunk(false);
						}
						telaPlayer.setMus(m);
						telaPlayer.rodar();
						telaPlayer.setFunk(true);
						telaPlayer.setVisible(true);
						telaPlayer.setResizable(false);
						telaPlayer.setLocationRelativeTo(null);
					} else {
						JOptionPane.showMessageDialog(null, "ERRO\nMUSICA INCORRETA OU INEXISTENTE");
					}
				} else {
					JOptionPane.showMessageDialog(null, "ERRO\nCAMPO VAZIO");
				}
			}
		});
		btnTocarMusica.setBounds(645, 339, 146, 25);
		contentPane.add(btnTocarMusica);

		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(278, 294, 56, 16);
		contentPane.add(lblTitulo);

		JLabel lblArtista = new JLabel("Artista:");
		lblArtista.setBounds(278, 348, 56, 16);
		contentPane.add(lblArtista);

		textTitulo = new JTextField();
		textTitulo.setBounds(346, 291, 116, 22);
		contentPane.add(textTitulo);
		textTitulo.setColumns(10);

		textArtista = new JTextField();
		textArtista.setBounds(346, 342, 116, 22);
		contentPane.add(textArtista);
		textArtista.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 139, 188, 186);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		list.setForeground(SystemColor.inactiveCaptionText);
		scrollPane.setViewportView(list);
		list.setBorder(new TitledBorder(null, "Banco de Musicas", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, SystemColor.desktop));
		list.setModel(new AbstractListModel() {
			
			String[] values = f.retornaMusicas();
			
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JLabel labelFundo = new JLabel(" ");
		  labelFundo.setIcon(new ImageIcon("Imagens\\Fundo Usuario.png"));
		  labelFundo.setBounds(0, 0, 847, 478);
		  contentPane.add(labelFundo);

	}
}
