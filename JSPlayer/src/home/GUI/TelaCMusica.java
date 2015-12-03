package home.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import home.negocio.Fachada;
import home.negocio.IFachada;
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

	
	public TelaCadastro() {
		IFachada f = Fachada.getInstance();

		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagens\\f39bfcb5.png"));
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
		spinIdade.setBounds(140, 307, 97, 29);
		contentPane.add(spinIdade);

		JLabel lblConfirmaoDeEmail = new JLabel("Confirma\u00E7\u00E3o de Email: ");
		lblConfirmaoDeEmail.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		lblConfirmaoDeEmail.setForeground(SystemColor.controlHighlight);
		lblConfirmaoDeEmail.setBounds(10, 136, 227, 37);
		contentPane.add(lblConfirmaoDeEmail);

		JLabel lblNomeDoUsuario = new JLabel("Nome do Usuario: ");
		lblNomeDoUsuario.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		lblNomeDoUsuario.setForeground(SystemColor.controlHighlight);
		lblNomeDoUsuario.setBounds(10, 35, 188, 14);
		contentPane.add(lblNomeDoUsuario);

		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		lblEmail.setForeground(SystemColor.controlHighlight);
		lblEmail.setBounds(10, 91, 188, 14);
		contentPane.add(lblEmail);

		JLabel lblLocalizao = new JLabel("Cidade: ");
		lblLocalizao.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		lblLocalizao.setForeground(SystemColor.controlHighlight);
		lblLocalizao.setBounds(10, 203, 188, 14);
		contentPane.add(lblLocalizao);

		JLabel lblEstado = new JLabel("Estado: ");
		lblEstado.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		lblEstado.setForeground(SystemColor.controlHighlight);
		lblEstado.setBounds(447, 203, 108, 14);
		contentPane.add(lblEstado);

		JLabel lblSexo = new JLabel("Sexo: ");
		lblSexo.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		lblSexo.setForeground(SystemColor.controlHighlight);
		lblSexo.setBounds(10, 257, 97, 14);
		contentPane.add(lblSexo);

		JLabel lblIdade = new JLabel("Idade: ");
		lblIdade.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		lblIdade.setForeground(SystemColor.controlHighlight);
		lblIdade.setBounds(10, 314, 97, 14);
		contentPane.add(lblIdade);

		JComboBox comboSexo = new JComboBox();
		comboSexo.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		comboSexo.setToolTipText("");
		comboSexo.setModel(new DefaultComboBoxModel(new String[] { "<Selecione>", "Masculino", "Feminino" }));
		comboSexo.setBounds(180, 250, 132, 29);
		contentPane.add(comboSexo);

		JComboBox comboEstado = new JComboBox();
		comboEstado.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		comboEstado.setModel(new DefaultComboBoxModel(
				new String[] { "<Selecione>", "AC\t ", "AL\t ", "AP\t ", "AM\t ", "BA\t ", "CE\t ", "DF\t ", "ES\t ",
						"GO\t ", "MA\t ", "MT\t ", "MS\t ", "MG\t ", "PA\t ", "PB\t ", "PR\t ", "PE\t ", "PI\t ",
						"RJ\t ", "RN\t ", "RS\t ", "RO\t ", "RR\t ", "SC\t ", "SP\t ", "SE\t ", "TO" }));
		comboEstado.setBounds(565, 197, 132, 29);
		contentPane.add(comboEstado);

		textCEmail = new JTextField();
		textCEmail.setBounds(247, 140, 195, 29);
		contentPane.add(textCEmail);
		textCEmail.setColumns(10);

		textCidade = new JTextField();
		textCidade.setBounds(247, 196, 190, 29);
		contentPane.add(textCidade);
		textCidade.setColumns(10);

		textEmail = new JTextField();
		textEmail.setBounds(247, 84, 195, 29);
		contentPane.add(textEmail);
		textEmail.setColumns(10);

		textNome = new JTextField();
		textNome.setBounds(247, 28, 195, 28);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
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

		btnNewButton.setBounds(252, 362, 190, 29);
		contentPane.add(btnNewButton);
		
		JButton btnRetornar = new JButton("Retornar");
		btnRetornar.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		btnRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaLogin telaLogin = new TelaLogin();
				telaLogin.setVisible(true);
				telaLogin.setLocationRelativeTo(null);
				telaLogin.setResizable(false);
			}
		});
		btnRetornar.setBounds(140, 450, 108, 29);
		contentPane.add(btnRetornar);
				
				JLabel lblserUsadoPara = new JLabel("(Ser\u00E1 usado para o login)");
				lblserUsadoPara.setForeground(SystemColor.controlHighlight);
				lblserUsadoPara.setFont(new Font("OCR A Extended", Font.BOLD, 15));
				lblserUsadoPara.setBounds(450, 34, 266, 16);
				contentPane.add(lblserUsadoPara);
		
				JLabel label = new JLabel(" ");
				label.setIcon(new ImageIcon("Imagens\\JSPlayer 4.jpg"));
				label.setBounds(0, 0, 844, 500);
				contentPane.add(label);

	}
}
