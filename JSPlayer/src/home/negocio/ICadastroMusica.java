package home.negocio;

import home.negocio.beans.Musica;

public interface ICadastroMusica {
	
	public void cadastrar(Musica mus);
	
	public void remover(Musica s);
	
	public Musica procurar(String titulo, String artista);
	
	public void printar(Musica m);
}
