package home.negocio.beans;

import java.util.ArrayList;

public class Playlist {

	private ArrayList<Musica> playlist;
	private String nomeP;
	
	public ArrayList<Musica> getPlaylist() {
		return playlist;
	}
	public String getNomeP() {
		return nomeP;
	}
	public void setPlaylist(ArrayList<Musica> playlist) {
		this.playlist = playlist;
	}
	public void setNomeP(String nomeP) {
		this.nomeP = nomeP;
	}
	
	public Playlist() {
		nomeP = "Untitled";
		playlist = new ArrayList<Musica>();
	}

	public Playlist(String nomeP) {
		this.nomeP = nomeP;
		playlist = new ArrayList<Musica>();
	}
	
	public void addMusic(Musica m) {
		playlist.add(m);
	}
	
	public void removeMusic(Musica m) {
		playlist.remove(playlist.indexOf(m));
	}
	
	public void changeMusicsPosition(Musica m, Musica x) {
		int i = playlist.indexOf(m);
		playlist.set(playlist.indexOf(x), m);
		playlist.set(i, x);
	}

	
}
