package home.negocio;

import home.negocio.beans.Musica;
import home.negocio.beans.Playlist;
import home.negocio.beans.Usuario;

public class Fachada implements IFachada {

	private ICadastroPlaylist listas;
	private ICadastroMusica musicas;
	private ICadastroUsuario usuarios;

	private static Fachada instance;

	private Fachada() {
		this.usuarios = new CadastroUsuario();
		this.musicas = new CadastroMusica();
		this.listas = new CadastroPlaylist();
	}

	public static Fachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}

	public boolean cadastrarUsuario(Usuario u) {
		return usuarios.cadastrar(u);
	}

	public Usuario procurarUsuario(String nome, String email) {
		return usuarios.procurar(nome, email);

	}

	public boolean existeUsuario(String nome, String email) {
		return usuarios.existe(nome, email);
	}

	public void removerUsuario(String nome, String email) {
		usuarios.remover(nome, email);
	}

	public void cadastrarMusica(Musica mus) {
		musicas.cadastrar(mus);
	}

	public Musica procurarMusica(String titulo, String artista) {
		return musicas.procurar(titulo, artista);

	}

	public boolean existeMusica(String titulo, String artista) {
		return musicas.existe(titulo, artista);
	}

	public void removerMusica(String titulo, String artista) {
		musicas.remover(titulo, artista);
	}

	public boolean loginUsuario(String nome, String email) {
		return usuarios.login(nome, email);
	}

	public void callMusica() {
		musicas.call();
	}

	public void cadastrarPlaylist(Playlist list) {
		listas.cadastrar(list);
	}

	public Playlist procurarPlaylist(String nomeP) {
		return listas.procurar(nomeP);

	}

	public boolean existePlaylist(String nomeP) {
		return listas.existe(nomeP);
	}

	public void removerPlaylist(String nomeP) {
		listas.remover(nomeP);
	}

	public void printarDadosUsuario(Usuario u) {
		usuarios.printar(u);
	}
	
	public void printarDadosMusica(Musica m) {
		musicas.printar(m);
	}
}
