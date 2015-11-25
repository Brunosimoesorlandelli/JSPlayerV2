package home.negocio;

import home.negocio.beans.Musica;

public interface ICadastroMusica {
	
	public void cadastrar (Musica mus);
	
	public void descadastrar(String titulo, String artista);
	
	public Musica procurar(String titulo, String artista);
	
	public boolean existe(String titulo, String artista);
	
	public void remover(String titulo, String artista);
	
	public void call();
	
	public void printar(Musica m);
}
