package home.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import home.negocio.beans.Usuario;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import java.awt.Component;
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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaUsuario extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public TelaUsuario(Usuario u) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagens\\IconeJSP.jpg"));
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
		label_1.setBounds(10, 11, 188, 14);
		contentPane.add(label_1);
		
		JButton button = new JButton("Procurar Usuario");
		button.setBounds(10, 36, 165, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Adicionar Musica");
		button_1.setBounds(616, 232, 165, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Criar Playlist");
		button_2.setBounds(616, 36, 165, 23);
		contentPane.add(button_2);
		
		JLabel label_2 = new JLabel("Playlist");
		label_2.setForeground(new Color(0, 255, 255));
		label_2.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		label_2.setBounds(616, 12, 85, 14);
		contentPane.add(label_2);
		
		JLabel lblMusica = new JLabel("Musica");
		lblMusica.setForeground(new Color(0, 255, 255));
		lblMusica.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		lblMusica.setBounds(616, 207, 85, 14);
		contentPane.add(lblMusica);
		
		JLabel label = new JLabel(" ");
		label.setBackground(new Color(119, 136, 153));
		label.setBounds(0, 0, 844, 479);
		label.setIcon(new ImageIcon("Imagens\\JSPlayer 3.jpg"));
		contentPane.add(label);
	}
}
