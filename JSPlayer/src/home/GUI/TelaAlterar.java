package home.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import home.negocio.Fachada;
import home.negocio.IFachada;
import home.negocio.beans.Usuario;

public class TelaAlterar extends JFrame {

	private JPanel contentPane;
	private JTextField textCidade;
	private JTextField textEmail;
	private JTextField textNome;
	private JTextField textCEmail;

	public TelaAlterar(Usuario u) {
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
		spinIdade.setValue(u.getIdade());
		spinIdade.setBounds(140, 307, 97, 29);
		contentPane.add(spinIdade);

		JLabel lblConfirmaoDeEmail = new JLabel("Confirma\u00E7\u00E3o de Email: ");
		lblConfirmaoDeEmail.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		lblConfirmaoDeEmail.setForeground(SystemColor.controlHighlight);
		lblConfirmaoDeEmail.setBounds(10, 136, 227, 37);
		contentPane.add(lblConfirmaoDeEmail);

		JLabel lblNomeDoUsuario = new JLabel("Nome do Usu\u00E1rio: ");
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
		comboSexo.setSelectedItem(u.getSexo());
		comboSexo.setBounds(180, 250, 132, 29);
		contentPane.add(comboSexo);

		JComboBox comboEstado = new JComboBox();
		comboEstado.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		comboEstado.setModel(new DefaultComboBoxModel(
				new String[] { "<Selecione>", "AC\t ", "AL\t ", "AP\t ", "AM\t ", "BA\t ", "CE\t ", "DF\t ", "ES\t ",
						"GO\t ", "MA\t ", "MT\t ", "MS\t ", "MG\t ", "PA\t ", "PB\t ", "PR\t ", "PE\t ", "PI\t ",
						"RJ\t ", "RN\t ", "RS\t ", "RO\t ", "RR\t ", "SC\t ", "SP\t ", "SE\t ", "TO" }));
		comboEstado.setSelectedItem(u.getEstado());
		comboEstado.setBounds(565, 197, 132, 29);
		contentPane.add(comboEstado);

		textCEmail = new JTextField();
		textCEmail.setBounds(247, 140, 195, 29);
		contentPane.add(textCEmail);
		textCEmail.setColumns(10);

		textCidade = new JTextField();
		textCidade.setBounds(247, 196, 190, 29);
		textCidade.setText(u.getCidade());
		contentPane.add(textCidade);
		textCidade.setColumns(10);

		textEmail = new JTextField();
		textEmail.setBounds(247, 84, 195, 29);
		textEmail.setText(u.getEmail());
		contentPane.add(textEmail);
		textEmail.setColumns(10);

		textNome = new JTextField();
		textNome.setBounds(247, 28, 195, 28);
		textNome.setText(u.getNome());
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
									u.setNome(textNome.getText());
									u.setEmail(textEmail.getText());
									u.setCidade(textCidade.getText());
									u.setEstado(comboEstado.getSelectedItem());
									u.setSexo(comboSexo.getSelectedItem());
									u.setIdade(spinIdade.getValue());
									dispose();
									TelaUsuario telaUsuario = new TelaUsuario(u);
									telaUsuario.setVisible(true);
									telaUsuario.setLocationRelativeTo(null);
									telaUsuario.setResizable(false);
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
				TelaUsuario telaUsuario = new TelaUsuario(u);
				telaUsuario.setVisible(true);
				telaUsuario.setLocationRelativeTo(null);
				telaUsuario.setResizable(false);
			}
		});
		btnRetornar.setBounds(140, 450, 97, 23);
		contentPane.add(btnRetornar);

		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon("Imagens\\JSPlayer 4.jpg"));
		label.setBounds(0, 0, 844, 500);
		contentPane.add(label);

	}

}
