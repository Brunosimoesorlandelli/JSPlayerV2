package home.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import home.negocio.Fachada;
import home.negocio.IFachada;
import home.negocio.beans.Usuario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setTitle("JSPlayer");
		IFachada f = Fachada.getInstance();

		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagens\\IconeJSP.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeDoUsuario = new JLabel("Nome do Usuario: ");
		lblNomeDoUsuario.setForeground(Color.LIGHT_GRAY);
		lblNomeDoUsuario.setBounds(10, 70, 105, 14);
		contentPane.add(lblNomeDoUsuario);

		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setForeground(Color.LIGHT_GRAY);
		lblEmail.setBounds(10, 95, 37, 14);
		contentPane.add(lblEmail);

		textNome = new JTextField();
		textNome.setBounds(136, 67, 245, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);

		textEmail = new JTextField();
		textEmail.setBounds(136, 92, 245, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);

		JButton btnLogar = new JButton("Logar");
		btnLogar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					btnLogar.requestFocusInWindow();
					Usuario u = f.procurarUsuario(textNome.getText(), textEmail.getText());
				if (f.loginUsuario(u.getNome(), u.getEmail())) {
					dispose();
					TelaUsuario telaUsuario = new TelaUsuario(u);
					telaUsuario.setVisible(true);
					telaUsuario.setLocationRelativeTo(null);
					telaUsuario.setResizable(false);
				}
				}

			}
		});
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario u = f.procurarUsuario(textNome.getText(), textEmail.getText());
				if (f.loginUsuario(u.getNome(), u.getEmail())) {
					dispose();
					TelaUsuario telaUsuario = new TelaUsuario(u);
					telaUsuario.setVisible(true);
					telaUsuario.setLocationRelativeTo(null);
					telaUsuario.setResizable(false);
				}
			}
		});
		btnLogar.setBounds(221, 123, 89, 23);
		contentPane.add(btnLogar);

		JButton btnNewButton = new JButton("Registre-se agora!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaCadastro telaCadastro = new TelaCadastro();
				telaCadastro.setVisible(true);
				telaCadastro.setResizable(false);
				telaCadastro.setLocationRelativeTo(null);
			}
		});
		btnNewButton.setBounds(136, 440, 245, 23);
		contentPane.add(btnNewButton);

		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon("Imagens\\JSPlayer 3.jpg"));
		label.setBounds(0, 0, 844, 500);
		contentPane.add(label);

	}
}
