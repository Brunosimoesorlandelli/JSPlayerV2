package home.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import home.negocio.Fachada;
import home.negocio.IFachada;
import home.negocio.RecebimentoDados;
import home.negocio.beans.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.SystemColor;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textCidade;
	private JTextField textEmail;
	private JTextField textNome;
	private JTextField textCEmail;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaCadastro() {
		IFachada f = Fachada.getInstance();

		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\Pictures\\unnamed (2).png"));
		setTitle("JSPlayer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JSpinner spinIdade = new JSpinner();
		spinIdade.setToolTipText("");
		spinIdade.setModel(new SpinnerNumberModel(new Integer(13), new Integer(13), null, new Integer(1)));
		spinIdade.setBounds(66, 265, 97, 29);
		contentPane.add(spinIdade);

		JLabel lblConfirmaoDeEmail = new JLabel("Confirma\u00E7\u00E3o de Email: ");
		lblConfirmaoDeEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblConfirmaoDeEmail.setForeground(SystemColor.controlHighlight);
		lblConfirmaoDeEmail.setBounds(10, 118, 110, 37);
		contentPane.add(lblConfirmaoDeEmail);

		JLabel lblNomeDoUsuario = new JLabel("Nome do Usuario: ");
		lblNomeDoUsuario.setForeground(SystemColor.controlHighlight);
		lblNomeDoUsuario.setBounds(10, 43, 110, 14);
		contentPane.add(lblNomeDoUsuario);

		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setForeground(SystemColor.controlHighlight);
		lblEmail.setBounds(10, 84, 46, 14);
		contentPane.add(lblEmail);

		JLabel lblLocalizao = new JLabel("Cidade: ");
		lblLocalizao.setForeground(SystemColor.controlHighlight);
		lblLocalizao.setBounds(10, 175, 46, 14);
		contentPane.add(lblLocalizao);

		JLabel lblEstado = new JLabel("Estado: ");
		lblEstado.setForeground(SystemColor.controlHighlight);
		lblEstado.setBounds(266, 175, 46, 14);
		contentPane.add(lblEstado);

		JLabel lblSexo = new JLabel("Sexo: ");
		lblSexo.setForeground(SystemColor.controlHighlight);
		lblSexo.setBounds(10, 225, 46, 14);
		contentPane.add(lblSexo);

		JLabel lblIdade = new JLabel("Idade: ");
		lblIdade.setForeground(SystemColor.controlHighlight);
		lblIdade.setBounds(10, 277, 46, 14);
		contentPane.add(lblIdade);

		JComboBox comboSexo = new JComboBox();
		comboSexo.setToolTipText("");
		comboSexo.setModel(new DefaultComboBoxModel(new String[] { "<Selecione>", "Masculino", "Feminino" }));
		comboSexo.setBounds(66, 213, 132, 29);
		contentPane.add(comboSexo);

		JComboBox comboEstado = new JComboBox();
		comboEstado.setModel(new DefaultComboBoxModel(
				new String[] { "<Selecione>", "AC\t ", "AL\t ", "AP\t ", "AM\t ", "BA\t ", "CE\t ", "DF\t ", "ES\t ",
						"GO\t ", "MA\t ", "MT\t ", "MS\t ", "MG\t ", "PA\t ", "PB\t ", "PR\t ", "PE\t ", "PI\t ",
						"RJ\t ", "RN\t ", "RS\t ", "RO\t ", "RR\t ", "SC\t ", "SP\t ", "SE\t ", "TO" }));
		comboEstado.setBounds(322, 163, 132, 29);
		contentPane.add(comboEstado);

		textCEmail = new JTextField();
		textCEmail.setBounds(130, 117, 195, 29);
		contentPane.add(textCEmail);
		textCEmail.setColumns(10);

		textCidade = new JTextField();
		textCidade.setBounds(66, 163, 190, 29);
		contentPane.add(textCidade);
		textCidade.setColumns(10);

		textEmail = new JTextField();
		textEmail.setBounds(130, 72, 195, 29);
		contentPane.add(textEmail);
		textEmail.setColumns(10);

		textNome = new JTextField();
		textNome.setBounds(130, 32, 195, 28);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JButton btnNewButton = new JButton("Confimar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textNome.getText().length() > 0) {
					if (textEmail.getText().contains("@") && textEmail.getText().length() > 0
							&& textEmail.getText().equals(textCEmail.getText())) {
						if (textCidade.getText().length() > 0) {
							if (!comboEstado.getSelectedItem().equals("<Selecione>")) {
								if (comboSexo.getSelectedItem().equals("Masculino")
										|| comboSexo.getSelectedItem().equals("Feminino")) {
									if (f.cadastrarUsuario(new Usuario(textNome.getText(), textEmail.getText(),
											textCidade.getText(), comboEstado.getSelectedItem(),
											comboSexo.getSelectedItem(), spinIdade.getValue()))) {
										dispose();
										TelaLogin telaLogin = new TelaLogin();
										telaLogin.setVisible(true);
										telaLogin.setLocationRelativeTo(null);
										telaLogin.setResizable(false);
									}
								} else {
									JOptionPane.showMessageDialog(null, "ERRO, SEXO INVALIDO");
								}
							} else {
								JOptionPane.showMessageDialog(null, "ERRO, ESTADO INVALIDO");
							}
						} else {
							JOptionPane.showMessageDialog(null, "ERRO, CIDADE INVALIDA");
						}
					} else {
						JOptionPane.showMessageDialog(null, "ERRO, EMAIL INVALIDO");
					}
				} else {
					JOptionPane.showMessageDialog(null, "ERRO, NOME INVALIDO");
				}
			}

		}	

		);

		btnNewButton.setBounds(252, 299, 190, 29);
		contentPane.add(btnNewButton);
		
		JButton btnRetornar = new JButton("Retornar");
		btnRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaLogin telaLogin = new TelaLogin();
				telaLogin.setVisible(true);
				telaLogin.setLocationRelativeTo(null);
				telaLogin.setResizable(false);
			}
		});
		btnRetornar.setBounds(130, 460, 89, 29);
		contentPane.add(btnRetornar);
		
				JLabel label = new JLabel(" ");
				label.setIcon(new ImageIcon("Imagens\\JSPlayer 3.jpg"));
				label.setBounds(0, 0, 844, 500);
				contentPane.add(label);

	}
}
