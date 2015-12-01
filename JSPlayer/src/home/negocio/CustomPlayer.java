package home.negocio;

import home.negocio.beans.Musica;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import javazoom.jl.player.Player;

public class CustomPlayer {

	private static CustomPlayer instance;
	private Player player;
	private FileInputStream FIS;
	private BufferedInputStream BIS;
	private boolean canResume;
	private String path;
	private int total;
	private int stopped;
	private boolean valid;

	public static synchronized CustomPlayer getInstance(){
		if(instance == null){
			instance = new CustomPlayer();
		}
		return instance;
	}
	
	private CustomPlayer() {
		player = null;
		FIS = null;
		valid = false;
		BIS = null;
		path = null;
		total = 0;
		stopped = 0;
		canResume = false;
	}

	public boolean getCanResume() {
		return canResume;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public boolean canRepeat() throws IOException{
		int i = 0;
		boolean can = false;
		while(i == 0){
		total = FIS.available();
		if(total == 0){
			can = true;
			i++;
		}
		}
		return can;
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
						JOptionPane.showMessageDialog(null, "Erro1");
						valid = false;
					}
				}
			}).start();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro2");
			valid = false;
		}
		return valid;
	}

}
