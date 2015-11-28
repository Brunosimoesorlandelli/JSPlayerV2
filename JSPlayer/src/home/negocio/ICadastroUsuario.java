package home.negocio;

import home.negocio.beans.Usuario;


public interface ICadastroUsuario {
	
	public boolean cadastrar (Usuario u);
	
	public void descadastrar(String nome, String email);
	
	public Usuario procurar(String nome, String email);
	
	public boolean existe(String nome, String email);
	
	public boolean existe(String email);
	
	public void remover(String nome, String email);
	
	public boolean login(String nome, String email);
	
	public void printar(Usuario u);
}