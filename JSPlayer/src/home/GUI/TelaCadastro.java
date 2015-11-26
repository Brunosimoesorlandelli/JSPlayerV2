package home.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JLabel lblEstado;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(40, 24, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(40, 100, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(40, 136, 46, 14);
		contentPane.add(lblIdade);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(40, 175, 46, 14);
		contentPane.add(lblSexo);
		
		JLabel lblLocalizao = new JLabel("Cidade:");
		lblLocalizao.setBounds(40, 217, 46, 14);
		contentPane.add(lblLocalizao);
		
		textField = new JTextField();
		textField.setBounds(96, 21, 196, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(96, 97, 196, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(97, 130, 46, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(96, 214, 196, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(313, 217, 46, 14);
		contentPane.add(lblEstado);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Selecione>", "AC\t ", "AL\t ", "AP\t ", "AM\t ", "BA\t ", "CE\t ", "DF\t ", "ES\t ", "GO\t ", "MA\t ", "MT\t ", "MS\t ", "MG\t ", "PA\t ", "PB\t ", "PR\t ", "PE\t ", "PI\t ", "RJ\t ", "RN\t ", "RS\t ", "RO\t ", "RR\t ", "SC\t ", "SP\t ", "SE\t ", "TO"}));
		comboBox.setBounds(369, 214, 86, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"<Selecione>", "Masculino", "Feminino"}));
		comboBox_1.setBounds(98, 169, 86, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(40, 62, 46, 14);
		contentPane.add(lblLogin);
		
		textField_3 = new JTextField();
		textField_3.setBounds(96, 59, 196, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setBounds(442, 294, 116, 40);
		contentPane.add(btnCadastrar);
	}
}
