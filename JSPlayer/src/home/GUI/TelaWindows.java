package home.GUI;

import javax.swing.JFrame;

public class TelaWindows extends JFrame{


		
		public TelaWindows(){
			
			setTitle("JSPlayer");
			setSize(1920, 1024);
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			setLocationRelativeTo(null);
		}

		public static void main(String[] args) {
			new TelaWindows();
		}
		
	}


