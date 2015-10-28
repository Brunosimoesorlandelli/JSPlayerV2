package home.negocio;

import home.negocio.Usuario;
import home.negocio.Musica;

public class Controlador {

	private CadastroMusica musicas;
	private CadastroUsuario usuarios;

	private static Controlador instance;

	private Controlador() {
		this.usuarios = new CadastroUsuario();
	}

	public void administrador(){
	     usuarios.administrador();
	    }
	
	public static Controlador getInstance() {
		if (instance == null) {
			instance = new Controlador();
		}
		return instance;
	}

	public void cadastrarUsuario(Usuario u) {
		usuarios.cadastrar(u);
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
	
	public boolean loginUsuario(String nome, String email){
		return usuarios.login(nome, email);
	}
	public void callMusica(){
		musicas.call();
	}
}
