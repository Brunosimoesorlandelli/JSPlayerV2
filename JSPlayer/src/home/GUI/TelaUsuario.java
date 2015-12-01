package home.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import home.negocio.CustomPlayer;
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
import java.awt.event.MouseListener;

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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class TelaUsuario extends JFrame {

	private CustomPlayer p = CustomPlayer.getInstance();
	private JPanel contentPane;
	private JTextField textTituloTocar;
	private JTextField textArtistaTocar;
	private String titulo = null;
	private String artista = null;
	private boolean comp = false;
	private String a = null;
	private int i;

	/**
	 * Create the frame.
	 */
	public TelaUsuario(Usuario u) {

		IFachada f = Fachada.getInstance();
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagens\\f39bfcb5.png"));
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
		mntmSobreOJsplayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Aplicativo desenvolvido pela Organização Dream Team, composta por:\nBruno Simões (Touldor)\nEduardo Lisbôa (Snotmetal)\nEduardo Roque (Mestreedu)\nMateus Fittipaldi (Flyby)");

			}
		});
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
		btnCMusica.setBounds(645, 123, 165, 23);
		contentPane.add(btnCMusica);

		JLabel lblMusica = new JLabel("Musica");
		lblMusica.setForeground(new Color(0, 255, 255));
		lblMusica.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		lblMusica.setBounds(646, 97, 85, 14);
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
		btnPrintarMusica.setBounds(645, 174, 146, 25);
		contentPane.add(btnPrintarMusica);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(222, 9, 365, 453);
		contentPane.add(scrollPane);

		JList list = new JList();
		list.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getClickCount() == 2) {
					a = (String) list.getModel().getElementAt(list.getSelectedIndex());
					i = list.getSelectedIndex();
					titulo = a.substring(0, a.indexOf("-"));
					artista = a.substring(a.indexOf("-") + 1);
					if (!titulo.equals(null) && !artista.equals(null)) {
						Musica m = f.procurarMusica(titulo, artista);

						if (m != null) {
							if (comp) {
								p.resume();
								p.getPlayer().close();
								comp = false;
							}
							p.setPath(m.getEndereco());
							p.play(-1);
							comp = true;

						} else {
							JOptionPane.showMessageDialog(null, "ERRO\nMUSICA INCORRETA OU INEXISTENTE");
						}
					} else {
						JOptionPane.showMessageDialog(null, "ERRO\nCAMPO VAZIO");
					}
				}
			}

		});

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setForeground(SystemColor.inactiveCaptionText);
		scrollPane.setViewportView(list);
		list.setBorder(new TitledBorder(null, "Banco de Musicas", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null,
				SystemColor.desktop));
		list.setModel(new AbstractListModel() {

			String[] values = f.retornaMusicas();

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});

		JButton previous = new JButton("");
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!a.equals(null)) {
					list.setSelectedIndex(i);
					if (list.getSelectedIndex() - 1 < 0) {
						list.setSelectedIndex(list.getLastVisibleIndex());
					} else {
						list.setSelectedIndex(list.getSelectedIndex() - 1);
					}
					i = list.getSelectedIndex();
					a = (String) list.getModel().getElementAt(list.getSelectedIndex());
					titulo = a.substring(0, a.indexOf("-"));
					artista = a.substring(a.indexOf("-") + 1);
					if (!titulo.equals(null) && !artista.equals(null)) {
						Musica m = f.procurarMusica(titulo, artista);

						if (m != null) {
							if (comp) {
								p.resume();
								p.getPlayer().close();
								comp = false;
							}
							p.setPath(m.getEndereco());
							p.play(-1);
							comp = true;

						} else {
							JOptionPane.showMessageDialog(null, "ERRO\nMUSICA INCORRETA OU INEXISTENTE");
						}
					} else {
						JOptionPane.showMessageDialog(null, "ERRO\nCAMPO VAZIO");
					}
				}
			}
		});
		previous.setIcon(new ImageIcon("Imagens\\previous.novo.png"));
		previous.setBounds(616, 259, 63, 39);
		contentPane.add(previous);

		JButton next = new JButton("");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!a.equals(null)) {
					list.setSelectedIndex(i);
					if (list.getSelectedIndex() + 1 > list.getLastVisibleIndex()) {
						list.setSelectedIndex(0);
					} else {
						list.setSelectedIndex(list.getSelectedIndex() + 1);
					}
					i = list.getSelectedIndex();
					a = (String) list.getModel().getElementAt(list.getSelectedIndex());
					titulo = a.substring(0, a.indexOf("-"));
					artista = a.substring(a.indexOf("-") + 1);
					if (!titulo.equals(null) && !artista.equals(null)) {
						Musica m = f.procurarMusica(titulo, artista);

						if (m != null) {
							if (comp) {
								p.resume();
								p.getPlayer().close();
								comp = false;
							}
							p.setPath(m.getEndereco());
							p.play(-1);
							comp = true;

						} else {
							JOptionPane.showMessageDialog(null, "ERRO\nMUSICA INCORRETA OU INEXISTENTE");
						}
					} else {
						JOptionPane.showMessageDialog(null, "ERRO\nCAMPO VAZIO");
					}
				}
			}
		});
		next.setIcon(new ImageIcon("Imagens\\next.novo.png"));
		next.setBounds(762, 259, 63, 39);
		contentPane.add(next);

		JToggleButton playPause = new JToggleButton("");
		playPause.setSelectedIcon(new ImageIcon("Imagens\\pause.novo.png"));
		playPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (playPause.isSelected()) {
					p.pause();
				} else {
					p.resume();
				}
			}
		});
		playPause.setIcon(new ImageIcon("Imagens\\play.novo.png"));
		playPause.setBounds(689, 259, 63, 39);
		contentPane.add(playPause);

		JLabel labelFundo = new JLabel(" ");
		labelFundo.setIcon(new ImageIcon("Imagens\\Fundo Usuario.png"));
		labelFundo.setBounds(0, 0, 847, 478);
		contentPane.add(labelFundo);

	}
}
