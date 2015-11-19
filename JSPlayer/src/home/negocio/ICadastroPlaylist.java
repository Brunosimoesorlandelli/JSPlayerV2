package home.negocio;

import home.negocio.beans.Playlist;

public interface ICadastroPlaylist {

	public void cadastrar (Playlist list);
	
	public void descadastrar(String nomeP);
	
	public Playlist procurar(String nomeP);
	
	public boolean existe(String nomeP);
	
	public void remover(String nomeP);
}
