package home.dados;

import home.negocio.beans.Playlist;

public interface IRepositorioPlaylist {

	public void cadastrar(Playlist list);
	
	public int procurarIndice(String nomeP);
	
	public void remover(String nomeP);
	
	public boolean existe(String nomeP);
	
	public Playlist procurar(String nomeP);
}
