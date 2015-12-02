package home.negocio;

import java.util.ArrayList;

import home.negocio.beans.Musica;

public interface ICadastroMusica {
	
	public void cadastrar(Musica mus);
	
	public void remover(Musica s);
	
	public Musica procurar(String titulo, String artista);
	
	public void printar(Musica m);
	
	public String[] retornaMusicas();
	
	public ArrayList<Musica> getMusicas();
}
