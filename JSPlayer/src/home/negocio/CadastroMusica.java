package home.negocio;

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
    
    public void printar (Musica m){
    	this.repositorio.printar(m);
    }
}
