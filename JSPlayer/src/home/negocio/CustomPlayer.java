package home.negocio;

import home.negocio.beans.Musica;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Scanner;

import javax.swing.JOptionPane;

import javazoom.jl.player.Player;

public class CustomPlayer {

	private Player player;
	private FileInputStream FIS;
	private BufferedInputStream BIS;
	private boolean canResume;
	private String path;
	private int total;
	private int stopped;
	private boolean valid;

	public CustomPlayer() {
		player = null;
		FIS = null;
		valid = false;
		BIS = null;
		path = null;
		total = 0;
		stopped = 0;
		canResume = false;
	}

	public boolean canResume() {
		return canResume;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void pause() {
		try {
			stopped = FIS.available();
			player.close();
			FIS = null;
			BIS = null;
			player = null;
			if (valid)
				canResume = true;
		} catch (Exception e) {

		}
	}

	public void resume() {
		if (!canResume)
			return;
		if (play(total - stopped - 30000))
			canResume = false;
	}

	public boolean play(int pos) {
		valid = true;
		canResume = false;
		try {
			FIS = new FileInputStream(path);
			total = FIS.available();
			if (pos > -1)
				FIS.skip(pos);
			BIS = new BufferedInputStream(FIS);
			player = new Player(BIS);
			new Thread(new Runnable() {
				public void run() {
					try {
						player.play();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Erro");
						valid = false;
					}
				}
			}).start();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro");
			valid = false;
		}
		return valid;
	}

	public void Play(Musica m) {
		int w = 0;
		Scanner sc = new Scanner(System.in);
		String musica = "Musicas\\" + m.getTitulo() + ".mp3";
		setPath(musica);
		play(-1);
		System.out.println("\nTOCANDO: " + m.getArtista() + " - " + m.getTitulo());
		while (w == 0) {
			w =0;
			String controle = sc.nextLine();
			
			if (controle.equals("P") || controle.equals("p")) {
				pause();
				System.out.println("PAUSADA!");
			} else if (controle.equals("R") || controle.equals("r")) {
				resume();
				System.out.println("TOCANDO!");

			} else if (controle.equals("S") || controle.equals("s")) {
				pause();
				player = null;
				System.out.println("ENCERRADA!");
				w++;
			} else if (controle.equals(".")){
				nextMusic();
				System.out.println("PROXIMA MUSICA\n");
			} else if (controle.equals(",")) {
				previousMusic();
				System.out.println("MUSICA ANTERIOR\n");
			}

		}
	}
	
	
	public void nextMusic(){
	
	}
	
	public void previousMusic(){
		
	}
}
