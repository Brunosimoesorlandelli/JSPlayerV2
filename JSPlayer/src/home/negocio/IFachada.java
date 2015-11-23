package home.negocio;

import home.negocio.beans.Musica;
import home.negocio.beans.Playlist;
import home.negocio.beans.Usuario;

public interface IFachada {
	
	public void instanciarRepositorioUsuarios();
	
	public void cadastrarUsuario(Usuario u);
	
	public Usuario procurarUsuario(String nome, String email);
	
	public boolean existeUsuario(String nome, String email);
	
	public void removerUsuario(String nome, String email);
	
	public void cadastrarMusica(Musica mus);
	
	public Musica procurarMusica(String titulo, String artista);
	
	public boolean existeMusica(String titulo, String artista);
	
	public void removerMusica(String titulo, String artista);
	
	public boolean loginUsuario(String nome, String email);
	
	public void callMusica();
	
	public void cadastrarPlaylist(Playlist list);
	
	public Playlist procurarPlaylist(String nomeP);
	
	public boolean existePlaylist(String nomeP);
	
	public void removerPlaylist(String nomeP);
	
	public void printarDados(Usuario u);
}
