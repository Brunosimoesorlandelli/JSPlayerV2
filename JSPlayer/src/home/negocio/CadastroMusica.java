package home.negocio;

import java.util.ArrayList;

import home.dados.IRepositorioMusica;
import home.dados.RepositorioMusicaArray;
import home.negocio.beans.Musica;

public class CadastroMusica implements ICadastroMusica{

private IRepositorioMusica repositorio;
    
    public CadastroMusica() {
    	this.repositorio = RepositorioMusicaArray.getInstance();
    }
    
    public void cadastrar (Musica mus) {
        repositorio.cadastrar(mus);      
    }
    
    public void remover(Musica s) {
    	repositorio.remover(s);
    }

    public Musica procurar(String titulo, String artista) {
        return this.repositorio.procurar(titulo, artista);
    }
    
    public void printar (){
    	this.repositorio.printar();
    }
    
    public String[] retornaMusicas() {
		return this.repositorio.retornaMusicas();
	}
    
    public ArrayList<Musica> getMusicas() {
    	return this.repositorio.getMusicas();
    }
}
