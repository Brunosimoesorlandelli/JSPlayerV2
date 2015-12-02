package home.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import home.negocio.Fachada;
import home.negocio.IFachada;
import home.negocio.beans.Usuario;
import java.awt.Font;

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

		try {
			 for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			 if ("Nimbus".equals(info.getName())) {
			 UIManager.setLookAndFeel(info.getClassName());
			 break;
			 }
			 }
			 } catch (UnsupportedLookAndFeelException e) {
			 // handle exception
			 } catch (ClassNotFoundException e) {
			 // handle exception
			 } catch (InstantiationException e) {
			 // handle exception
			 } catch (IllegalAccessException e) {
			 // handle exception
			 }
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagens\\f39bfcb5.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeDoUsuario = new JLabel("Nome do Usuario: ");
		lblNomeDoUsuario.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		lblNomeDoUsuario.setForeground(Color.LIGHT_GRAY);
		lblNomeDoUsuario.setBounds(10, 70, 166, 14);
		contentPane.add(lblNomeDoUsuario);

		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		lblEmail.setForeground(Color.LIGHT_GRAY);
		lblEmail.setBounds(10, 151, 166, 14);
		contentPane.add(lblEmail);

		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNome.setBounds(186, 61, 245, 35);
		contentPane.add(textNome);
		textNome.setColumns(10);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textEmail.setBounds(186, 142, 245, 35);
		contentPane.add(textEmail);
		textEmail.setColumns(10);

		JButton btnLogar = new JButton("Logar");
		btnLogar.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		btnLogar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					btnLogar.requestFocusInWindow();
					Usuario u = f.procurarUsuario(textNome.getText(), textEmail.getText());
				if (f.loginUsuario(u.getNome(), u.getEmail())) {
					f.pegarRepositorioPlaylistDoUsuario(u.getRepoP());
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
					f.pegarRepositorioPlaylistDoUsuario(u.getRepoP());
					dispose();					
					TelaUsuario telaUsuario = new TelaUsuario(u);
					telaUsuario.setVisible(true);
					telaUsuario.setLocationRelativeTo(null);
					telaUsuario.setResizable(false);
				}
			}
		});
		btnLogar.setBounds(219, 236, 89, 28);
		contentPane.add(btnLogar);

		JButton btnNewButton = new JButton("Registre-se agora!");
		btnNewButton.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaCadastro telaCadastro = new TelaCadastro();
				telaCadastro.setVisible(true);
				telaCadastro.setResizable(false);
				telaCadastro.setLocationRelativeTo(null);
			}
		});
		btnNewButton.setBounds(141, 435, 245, 28);
		contentPane.add(btnNewButton);

		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon("Imagens\\JSPlayer 4.jpg"));
		label.setBounds(0, 0, 844, 500);
		contentPane.add(label);

	}
}
