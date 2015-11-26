import java.awt.EventQueue;
import java.util.Scanner;

import javax.swing.JOptionPane;

import home.GUI.TelaPrincipal;
import home.negocio.Fachada;
import home.negocio.IFachada;
import home.negocio.Menu;
import home.negocio.RecebimentoDados;


public class Teste {

	public static void main(String[] args) {
		RecebimentoDados dados = new RecebimentoDados();
		JOptionPane.showMessageDialog(null, "Bem-vindo ao gerenciador de musicas JSPlayer.");
		Scanner scan = new Scanner(System.in);
		IFachada f = Fachada.getInstance();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	//new Menu();
	}

}
