package home.negocio;

public class Playlist {

	private Musica[] playlist;
	private String nomeP;

	public Playlist(String nomeP) {
		playlist = new Musica[100];
		this.nomeP = nomeP;
	}

	public String getNomeP() {
		return nomeP;
	}

	public void setNomeP(String nomeP) {
		this.nomeP = nomeP;
	}

	public Musica[] getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Musica[] playlist) {
		this.playlist = playlist;
	}

}
