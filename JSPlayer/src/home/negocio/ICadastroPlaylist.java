package home.negocio;

import home.dados.IRepositorioPlaylist;
import home.negocio.beans.Playlist;

public interface ICadastroPlaylist {
	
	public void pegarRepositorioDoUsuario(IRepositorioPlaylist repoP);

	public void cadastrar (Playlist list);
	
	public void descadastrar(String nomeP);
	
	public Playlist procurar(String nomeP);
	
	public boolean existe(String nomeP);
	
	public void remover(String nomeP);
	
	public String[] retornarPlaylist();
}
