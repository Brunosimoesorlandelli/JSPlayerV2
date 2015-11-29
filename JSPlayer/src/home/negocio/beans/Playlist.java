package home.negocio.beans;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Playlist implements Serializable {

	private String nomeP;
	private ArrayList<Musica> playlist;

	public String getNomeP() {
		return nomeP;
	}

	public void setNomeP(String nomeP) {
		this.nomeP = nomeP;
	}

	public ArrayList<Musica> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(ArrayList<Musica> playlist) {
		this.playlist = playlist;
	}

	public Playlist() {
		nomeP = "Untitled";
		playlist = new ArrayList<Musica>();
	}

	public Playlist(String nomeP) {
		this.nomeP = nomeP;
		playlist = new ArrayList<Musica>();
	}

	public boolean loadSongs(String fileName) {
		File file = new File(fileName);
		Scanner scan;
		try {
			scan = new Scanner(file);

			while (scan.hasNext()) {
				String titulo = null;
				String artista = null;
				int minutes = -1;
				int seconds = -1;

				String s = scan.nextLine();

				if (!(s.equalsIgnoreCase(""))) {

					if (titulo == null) {

						trimmer(s);
						titulo = s;
					}
					if (artista == null) {
						try {
							s = scan.nextLine();
							trimmer(s);
							artista = s;
						} catch (Exception e) {
							break;
						}

					}
					if (minutes == -1) {
						s = scan.nextLine();
						trimmer(s);
						String[] s1 = s.split(":");
						int min = Integer.parseInt(s1[0]);
						int sec = Integer.parseInt(s1[1]);

						while (sec >= 60) {
							sec = sec - 60;
							min++;
						}

						minutes = min;
						seconds = sec;
					}

					if (!(seconds == -1)) {
						Musica s1 = new Musica(titulo, artista, minutes, seconds);
						addSong(s1);
					}

				}

			}

			return true;

		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return false;
		}

	}

	private void trimmer(String s) {
		if (s == "") {
			return;
		} else {
			s = s.trim();
			if (s.contains("//")) {
				s = s.substring(s.indexOf("//"));
			}
		}

	}

	public boolean clear() {
		playlist.clear();
		return true;
	}

	public boolean addSong(Musica s) {
		playlist.add(s);
		return true;
	}

	public Musica removeSong(int index) {
		playlist.trimToSize();
		if (index > playlist.size()) {
			return null;
		}
		Musica s = playlist.get(index);
		playlist.remove(index);
		return s;
	}

	public Musica removeSong(Musica s) {
		playlist.trimToSize();
		if (playlist.contains(s)) {
			playlist.remove(s);
			return s;
		}
		return null;

	}

	public Musica getSong(int index) {
		playlist.trimToSize();
		if (playlist.size() >= index) {
			return playlist.get(index);
		} else
			return null;
	}

	public void sortByArtist() {
		Collections.sort(playlist);
	}

	public int size() {
		playlist.trimToSize();
		return playlist.size();
	}

	public String totalPlayTime() {
		int tempHoras = 0;
		int tempMinutos = 0;
		int tempSegundos = 0;

		for (Musica s : playlist) {
			tempMinutos += s.getMinutos();
			tempSegundos += s.getSegundos();
		}

		while (tempSegundos >= 60) {
			tempSegundos = tempSegundos - 60;
			tempMinutos++;
		}
		while (tempMinutos >= 60) {
			tempMinutos = tempMinutos - 60;
			tempHoras++;
		}
		return tempHoras + ":" + tempMinutos + ":" + tempSegundos;
	}

	public static void main(String[] args) {
		Playlist p = new Playlist();
		p.loadSongs("BancoDeMusicas\\RepositorioMusicaArray.db");
		System.out.println(p.getPlaylist());
		p.sortByArtist();
		System.out.println(p.totalPlayTime());
		p.clear();
		System.out.println(p.getPlaylist());
	}

	public ArrayList<Musica> ordenar() {
		for (Musica m : playlist) {
			for (Musica s : playlist) {
				m.compareTo(s);
			}
		}
		return playlist;
	}

}
