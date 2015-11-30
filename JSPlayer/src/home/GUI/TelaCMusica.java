package home.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import home.negocio.Fachada;
import home.negocio.IFachada;
import home.negocio.beans.Musica;
import home.negocio.beans.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class TelaCMusica extends JFrame {

	private JPanel contentPane;
	private JTextField textTitulo;
	private JTextField textArtista;
	private JTextField textEndereco;
	private JTextField textGenero;
	private JTextField textAlbum;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaCMusica(Usuario u) {
		IFachada f = Fachada.getInstance();

		setTitle("JSPlayer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeDaMsica = new JLabel("Titulo:");
		lblNomeDaMsica.setBounds(12, 13, 103, 26);
		contentPane.add(lblNomeDaMsica);

		JLabel lblArtista = new JLabel("Artista:");
		lblArtista.setBounds(12, 52, 56, 16);
		contentPane.add(lblArtista);

		JLabel lbllbum = new JLabel("Album:");
		lbllbum.setBounds(12, 91, 56, 16);
		contentPane.add(lbllbum);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(12, 126, 56, 16);
		contentPane.add(lblAno);

		JLabel lblGnero = new JLabel("Genero:");
		lblGnero.setBounds(12, 155, 56, 16);
		contentPane.add(lblGnero);

		JLabel lblEndereo = new JLabel("Endereco:");
		lblEndereo.setBounds(12, 243, 82, 16);
		contentPane.add(lblEndereo);

		JLabel lblExemploMusicasmp = new JLabel("Modelo: Musicas\\\\<nome_da_musica>.mp3");
		lblExemploMusicasmp.setBounds(95, 272, 288, 16);
		contentPane.add(lblExemploMusicasmp);

		textTitulo = new JTextField();
		textTitulo.setBounds(142, 15, 158, 22);
		contentPane.add(textTitulo);
		textTitulo.setColumns(10);

		textArtista = new JTextField();
		textArtista.setBounds(142, 49, 158, 22);
		contentPane.add(textArtista);
		textArtista.setColumns(10);

		textAlbum = new JTextField();
		textAlbum.setBounds(142, 88, 158, 22);
		contentPane.add(textAlbum);
		textAlbum.setColumns(10);

		JSpinner spinAno = new JSpinner();
		spinAno.setModel(new SpinnerNumberModel(new Integer(1900), new Integer(1500), null, new Integer(1)));
		spinAno.setBounds(142, 123, 97, 22);
		contentPane.add(spinAno);

		textGenero = new JTextField();
		textGenero.setBounds(142, 158, 158, 22);
		contentPane.add(textGenero);
		textGenero.setColumns(10);

		textEndereco = new JTextField();
		textEndereco.setText("Musicas\\\\<escreva_aqui>.mp3");
		textEndereco.setBounds(95, 240, 307, 22);
		contentPane.add(textEndereco);
		textEndereco.setColumns(10);

		JButton btnCadastrar = new JButton("Confirmar");
		btnCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (textTitulo.getText().length() > 0) {
					if (textArtista.getText().length() > 0) {
						if (textAlbum.getText().length() > 0) {
							if (textGenero.getText().length() > 0) {
								if (textEndereco.getText().length() > 0) {
									f.cadastrarMusica(
											new Musica(textTitulo.getText(), textArtista.getText(), textAlbum.getText(),
													spinAno.getValue(), textGenero.getText(), textEndereco.getText()));
									dispose();
									TelaUsuario telaUsuario = new TelaUsuario(u);
									telaUsuario.setVisible(true);
									telaUsuario.setResizable(false);
									telaUsuario.setLocationRelativeTo(null);
									
								} else {
									JOptionPane.showMessageDialog(null, "ERRO, ENDERECO INVALIDO");
								}
							} else {
								JOptionPane.showMessageDialog(null, "ERRO, GENERO INVALIDO");
							}
						} else {
							JOptionPane.showMessageDialog(null, "ERRO, ALBUM INVALIDO");
						}
					} else {
						JOptionPane.showMessageDialog(null, "ERRO, ARTISTA INVALIDO");
					}
				} else {
					JOptionPane.showMessageDialog(null, "ERRO, TITULO INVALIDO");
				}
			}
		});
		btnCadastrar.setBounds(305, 322, 97, 25);
		contentPane.add(btnCadastrar);

		JButton btnRetornar = new JButton("Retornar");
		btnRetornar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaUsuario telaUsuario = new TelaUsuario(u);
				telaUsuario.setVisible(true);
				telaUsuario.setResizable(false);
				telaUsuario.setLocationRelativeTo(null);
			}
		});
		btnRetornar.setBounds(80, 443, 97, 25);
		contentPane.add(btnRetornar);
	}
}
