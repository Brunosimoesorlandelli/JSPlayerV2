package home.negocio;

import java.util.ArrayList;

import home.dados.IRepositorioPlaylist;
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

	public static synchronized Fachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}
	
	public void pegarRepositorioPlaylistDoUsuario(IRepositorioPlaylist repoP) {
		listas.pegarRepositorioDoUsuario(repoP);
	}
	
	public void salvar(){
		usuarios.salvar();
	}

	public boolean cadastrarUsuario(Usuario u) {
		return usuarios.cadastrar(u);
	}
	
	public boolean loginUsuario(String nome, String email) {
		return usuarios.login(nome, email);
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
	
	public void printarDadosUsuario(Usuario u) {
		usuarios.printar(u);
	}

	public void cadastrarMusica(Musica mus) {
		musicas.cadastrar(mus);
	}

	public Musica procurarMusica(String titulo, String artista) {
		return musicas.procurar(titulo, artista);

	}

	public void removerMusica(String titulo, String artista) {
		musicas.remover(procurarMusica(titulo, artista));
	}
	
	public void printarDadosMusica(Musica m) {
		musicas.printar(m);
	}
	
	public String[] retornaMusicas() {
		return this.musicas.retornaMusicas();
	}
	
	public ArrayList<Musica> getMusicas() {
		return musicas.getMusicas();
	}

	public void cadastrarPlaylist(Playlist list) {
		listas.cadastrar(list);
	}
	
	public Playlist procurarPlaylist(String nomeP) {
		return listas.procurar(nomeP);

	}
	
	public String[] retornarPlaylist(){
		return listas.retornarPlaylist();
	}

	public boolean existePlaylist(String nomeP) {
		return listas.existe(nomeP);
	}

	public void removerPlaylist(String nomeP) {
		listas.remover(nomeP);
	}
}
