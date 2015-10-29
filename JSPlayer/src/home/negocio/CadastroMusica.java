package home.negocio;

import home.dados.RepositorioMusicaArray;

public class CadastroMusica {

private RepositorioMusicaArray repositorio;
    
    public CadastroMusica() {
        this.repositorio = new RepositorioMusicaArray(100); 
    }
    
    public void cadastrar (Musica mus) {
        if (mus == null) {
        	System.out.println("PARAMETRO INVALIDO");
        } else {
            if (!this.existe(mus.getTitulo(), mus.getArtista())) {
                this.repositorio.cadastrar(mus);
                
            }else{
            	System.out.println("ERRO! MUSICA JÁ ADICIONADA!");
            }
        }        
    }
    
    public void descadastrar(String titulo, String artista) {
    	Musica mus = this.repositorio.procurar(titulo, artista);
    	if (mus != null) {
    		this.repositorio.remover(titulo, artista);
    		
		} else {
		    }
    }

    public Musica procurar(String titulo, String artista) {
        return this.repositorio.procurar(titulo, artista);
    }
    
    public boolean existe(String titulo, String artista) {
    	return this.repositorio.existe(titulo, artista);
    }

    public void remover(String titulo, String artista) {
        this.repositorio.remover(titulo, artista);
    }
    public void call(){
    	this.repositorio.call();
    }
}
