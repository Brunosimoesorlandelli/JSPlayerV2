package home.dados;

import home.negocio.beans.Usuario;

public interface IRepositorioUsuarios {
	
	public void salvar();

	public void cadastrar(Usuario x);
	
	public int procurarIndice(String nome, String email);
	
	public void remover(String nome, String email);
	
	public boolean existe(String nome, String email);
	
	public Usuario procurar(String nome, String email);
	
	public void printar(Usuario x);
	
}
