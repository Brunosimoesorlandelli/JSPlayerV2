package home.negocio;

import home.dados.IRepositorioPlaylist;
import home.negocio.beans.Musica;
import home.negocio.beans.Playlist;
import home.negocio.beans.Usuario;

public interface IFachada {
	
	public void pegarRepositorioPlaylistDoUsuario(IRepositorioPlaylist repoP);
	
	public boolean cadastrarUsuario(Usuario u);
	
	public boolean loginUsuario(String nome, String email);
	
	public Usuario procurarUsuario(String nome, String email);
	
	public boolean existeUsuario(String nome, String email);
	
	public void removerUsuario(String nome, String email);
	
	public void printarDadosUsuario(Usuario u);
	
	public void cadastrarMusica(Musica mus);
	
	public Musica procurarMusica(String titulo, String artista);
	
	public void removerMusica(String titulo, String artista);
	
	public void printarDadosMusica(Musica m);
	
	public void cadastrarPlaylist(Playlist list);
	
	public Playlist procurarPlaylist(String nomeP);
	
	public boolean existePlaylist(String nomeP);
	
	public void removerPlaylist(String nomeP);
}