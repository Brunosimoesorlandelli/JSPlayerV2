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
import home.negocio.beans.Playlist;
import home.negocio.beans.Usuario;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.sound.sampled.AudioFileFormat;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.SortedSet;

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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaUsuario extends JFrame {

	private Usuario amigo;
	private String uso;
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

		SortedListModel model = new SortedListModel();
		IFachada f = Fachada.getInstance();
		model.addAll(f.retornaMusicas());
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagens\\f39bfcb5.png"));
		setTitle("JSPlayer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 528);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnPerfil = new JMenu("Perfil");
		menuBar.add(mnPerfil);

		JMenuItem mntmAlterarDados = new JMenuItem("Alterar Dados");
		mntmAlterarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comp) {
					p.resume();
					p.getPlayer().close();
					comp = false;
				}
				dispose();
				TelaAlterar telaAlterar = new TelaAlterar(u);
				telaAlterar.setVisible(true);
				telaAlterar.setLocationRelativeTo(null);
				telaAlterar.setResizable(false);

			}
		});
		mnPerfil.add(mntmAlterarDados);

		

		JMenuItem mntmDeslogar = new JMenuItem("Deslogar");
		mntmDeslogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comp) {
					p.resume();
					p.getPlayer().close();
					comp = false;
				}
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
		label_1.setForeground(new Color(204, 255, 51));
		label_1.setFont(new Font("OCR A Extended", Font.BOLD, 14));
		label_1.setBounds(16, 14, 210, 14);
		contentPane.add(label_1);

		JComboBox comboMigo = new JComboBox();
		comboMigo.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		comboMigo.setModel(new DefaultComboBoxModel(new String[] { "Vazio" }));
		comboMigo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 1) {
					uso = (String) comboMigo.getSelectedItem();
					Playlist p = amigo.getRepoP().procurar(uso);
					if (!(p == null)) {
						model.clear();
						model.addAll(p.retornaMusicasP());
					} else {
						JOptionPane.showMessageDialog(null, "Serio que vc clickou?");
					}
				}
			}
		});
		comboMigo.setBounds(23, 218, 165, 26);
		contentPane.add(comboMigo);

		JButton btnMigo = new JButton("Visualizar");
		btnMigo.setForeground(new Color(204, 255, 51));
		btnMigo.setBackground(new Color(0, 0, 0));
		btnMigo.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		btnMigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(comboMigo == null)) {
					uso = (String) comboMigo.getSelectedItem();
					Playlist p = amigo.getRepoP().procurar(uso);
					if (!(p == null)) {
						model.clear();
						model.addAll(p.retornaMusicasP());
					} else {
						JOptionPane.showMessageDialog(null, "Vazio");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Nao existe o que visualizar");
				}
			}
		});
		btnMigo.setBounds(43, 275, 124, 39);
		contentPane.add(btnMigo);

		JMenuItem mntmProcurarUsuarios = new JMenuItem("Procurar Usuarios");
		mntmProcurarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeDoAmigo = JOptionPane.showInputDialog("Nome: ",
						"Digite o nome do usuario que deseja procurar: ");
				String emailDoAmigo = JOptionPane.showInputDialog("Email: ",
						"Digite o email do usuario que deseja procurar: ");
				if (!nomeDoAmigo.equals(null) && !emailDoAmigo.equals(null)) {
					amigo = f.procurarUsuario(nomeDoAmigo, emailDoAmigo);
					comboMigo.setModel(new DefaultComboBoxModel(amigo.getRepoP().retornarPlaylist()));
				} else {
					JOptionPane.showMessageDialog(null, "Campos Vazios");
				}
			}
		});
		mnPerfil.add(mntmProcurarUsuarios);
		
		JButton procurar = new JButton("Procurar Usuario");
		procurar.setForeground(new Color(204, 255, 51));
		procurar.setBackground(new Color(0, 0, 0));
		procurar.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		procurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeDoAmigo = JOptionPane.showInputDialog("Nome: ",
						"Digite o nome do usuario que deseja procurar: ");
				String emailDoAmigo = JOptionPane.showInputDialog("Email: ",
						"Digite o email do usuario que deseja procurar: ");
				if (!nomeDoAmigo.equals(null) && !emailDoAmigo.equals(null)) {
					amigo = f.procurarUsuario(nomeDoAmigo, emailDoAmigo);
					comboMigo.setModel(new DefaultComboBoxModel(amigo.getRepoP().retornarPlaylist()));
				} else {
					JOptionPane.showMessageDialog(null, "Campos Vazios");
				}
			}
		});
		procurar.setBounds(23, 140, 165, 39);
		contentPane.add(procurar);

		JButton btnCMusica = new JButton("Cadastrar Musica");
		btnCMusica.setForeground(new Color(204, 255, 51));
		btnCMusica.setBackground(new Color(0, 0, 0));
		btnCMusica.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		btnCMusica.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (comp) {
					p.resume();
					p.getPlayer().close();
					comp = false;
				}
				dispose();
				TelaCMusica telaCMusica = new TelaCMusica(u);
				telaCMusica.setVisible(true);
				telaCMusica.setResizable(false);
				telaCMusica.setLocationRelativeTo(null);
			}
		});
		btnCMusica.setBounds(637, 308, 165, 39);
		contentPane.add(btnCMusica);

		JLabel lblMusica = new JLabel("Musica");
		lblMusica.setForeground(new Color(204, 255, 51));
		lblMusica.setFont(new Font("OCR A Extended", Font.BOLD, 14));
		lblMusica.setBounds(758, 270, 70, 26);
		contentPane.add(lblMusica);

		JLabel lblPlaylist = new JLabel("Playlist");
		lblPlaylist.setForeground(new Color(204, 255, 51));
		lblPlaylist.setFont(new Font("OCR A Extended", Font.BOLD, 14));
		lblPlaylist.setBounds(738, 9, 90, 24);
		contentPane.add(lblPlaylist);

		JButton button_2 = new JButton("Criar Playlist");
		button_2.setForeground(new Color(204, 255, 51));
		button_2.setBackground(new Color(0, 0, 0));
		button_2.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comp) {
					p.resume();
					p.getPlayer().close();
					comp = false;
				}
				dispose();
				TelaCPlaylist telaCPlaylist = new TelaCPlaylist(u);
				telaCPlaylist.setVisible(true);
				telaCPlaylist.setResizable(false);
				telaCPlaylist.setLocationRelativeTo(null);
				telaCPlaylist.addSourceElements(f.retornaMusicas());
			}
		});
		button_2.setBounds(646, 45, 146, 39);
		contentPane.add(button_2);

		JButton btnPrintarMusica = new JButton("Printar Musica");
		btnPrintarMusica.setForeground(new Color(204, 255, 51));
		btnPrintarMusica.setBackground(new Color(0, 0, 0));
		btnPrintarMusica.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		btnPrintarMusica.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					f.printarDadosMusica(f.procurarMusica(titulo, artista));
				} catch (Exception ey) {

				}
			}
		});
		btnPrintarMusica.setBounds(646, 359, 146, 39);
		contentPane.add(btnPrintarMusica);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(222, 9, 365, 261);
		contentPane.add(scrollPane);

		JEditorPane dtrpnTocando = new JEditorPane();
		dtrpnTocando.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		dtrpnTocando.setEditable(false);
		dtrpnTocando.setBounds(222, 281, 365, 24);
		contentPane.add(dtrpnTocando);

		JList list = new JList();
		list.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
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
							dtrpnTocando.setText("Tocando: " + a);
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
		list.addMouseListener(new MouseAdapter() {

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
							dtrpnTocando.setText("Tocando: " + a);
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
		list.setBorder(new TitledBorder(null, "Musicas", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null,
				SystemColor.desktop));
		list.setModel(model);

		JButton previous = new JButton("");
		previous.setForeground(new Color(204, 255, 51));
		previous.setBackground(new Color(0, 0, 0));
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
							dtrpnTocando.setText("Tocando: " + a);
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
		previous.setBounds(313, 378, 63, 39);
		contentPane.add(previous);

		JButton next = new JButton("");
		next.setForeground(new Color(204, 255, 51));
		next.setBackground(new Color(0, 0, 0));
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
							dtrpnTocando.setText("Tocando: " + a);
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
		next.setBounds(459, 378, 63, 39);
		contentPane.add(next);

		JToggleButton playPause = new JToggleButton("");
		playPause.setForeground(new Color(204, 255, 51));
		playPause.setBackground(new Color(0, 0, 0));
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
		playPause.setBounds(386, 378, 63, 39);
		contentPane.add(playPause);
		JButton btnTocar = new JButton("Tocar");
		btnTocar.setForeground(new Color(204, 255, 51));
		btnTocar.setBackground(new Color(0, 0, 0));
		btnTocar.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		btnTocar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
						dtrpnTocando.setText("Tocando: " + a);
						comp = true;

					} else {
						JOptionPane.showMessageDialog(null, "ERRO\nMUSICA INCORRETA OU INEXISTENTE");
					}
				} else {
					JOptionPane.showMessageDialog(null, "ERRO\nCAMPO VAZIO");
				}
			}
		});
		btnTocar.setBounds(372, 332, 90, 34);
		contentPane.add(btnTocar);

		JComboBox comboUsuario = new JComboBox();
		comboUsuario.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		comboUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 1) {
					uso = (String) comboUsuario.getSelectedItem();
					Playlist p = f.procurarPlaylist(uso);
					model.clear();
					model.addAll(p.retornaMusicasP());
				}
			}
		});
		comboUsuario.setModel(new DefaultComboBoxModel(f.retornarPlaylist()));
		comboUsuario.setBounds(638, 110, 164, 26);
		contentPane.add(comboUsuario);

		JButton btnUsuario = new JButton("Visualizar");
		btnUsuario.setForeground(new Color(204, 255, 51));
		btnUsuario.setBackground(new Color(0, 0, 0));
		btnUsuario.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				uso = (String) comboUsuario.getSelectedItem();
				Playlist p = f.procurarPlaylist(uso);
				model.clear();
				model.addAll(p.retornaMusicasP());

			}
		});
		btnUsuario.setBounds(657, 210, 124, 39);
		contentPane.add(btnUsuario);
		
		JButton btnOrganizar = new JButton("Organizar");
		btnOrganizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comp) {
					p.resume();
					p.getPlayer().close();
					comp = false;
				}
				dispose();
				TelaOrganizar telaOrganizar = new TelaOrganizar(u,f.procurarPlaylist((String)comboUsuario.getSelectedItem()));
				telaOrganizar.setVisible(true);
				telaOrganizar.setResizable(false);
				telaOrganizar.setLocationRelativeTo(null);
				telaOrganizar.addSourceElements(f.retornaMusicas());
				telaOrganizar.addDestinationElements(f.procurarPlaylist((String)comboUsuario.getSelectedItem()).retornaMusicasP());
			}
		});
		btnOrganizar.setForeground(new Color(204, 255, 51));
		btnOrganizar.setBackground(new Color(0, 0, 0));
		btnOrganizar.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		btnOrganizar.setBounds(646, 159, 146, 39);
		contentPane.add(btnOrganizar);
		
				JLabel labelFundo = new JLabel(" ");
				labelFundo.setIcon(new ImageIcon("Imagens\\JSPlayer fundo 2.png"));
				labelFundo.setBounds(6, -61, 844, 528);
				contentPane.add(labelFundo);

	}
}
