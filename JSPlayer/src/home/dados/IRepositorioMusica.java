package home.dados;

import home.negocio.beans.Musica;

public interface IRepositorioMusica {
	
	public void cadastrar(Musica mus);
	
	public int procurarIndice(String titulo, String artista);
	
	public void remover(String titulo, String artista);
	
	public boolean existe(String titulo,String artista);
	
	public Musica procurar(String titulo, String artista);
	
	public void call();

}
