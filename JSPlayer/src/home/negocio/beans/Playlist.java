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

	public int size() {
		playlist.trimToSize();
		return playlist.size();
	}
	
	public String[] retornaMusicasP() {
		int i = 0;
		String[] listaMusicas = new String[0];
		for (Musica m : playlist) {
			if (m != null) {
				String[] listaMusicas2 = new String[listaMusicas.length + 1];
				for (int h = 0; h < listaMusicas.length; h++) {
					listaMusicas2[h] = listaMusicas[h];
				}
				listaMusicas = listaMusicas2;
				listaMusicas[i] = m.getTitulo() + "-" + m.getArtista();
			}
			i++;
		}
		return listaMusicas;
	}

}
