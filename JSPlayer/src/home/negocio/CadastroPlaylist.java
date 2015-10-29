package home.negocio;

import home.dados.RepositorioPlaylistArray;

public class CadastroPlaylist {

private RepositorioPlaylistArray repositorio;
    
    public CadastroPlaylist() {
        this.repositorio = new RepositorioPlaylistArray(100); 
    }
    
    public void cadastrar (Playlist list) {
        if (list == null) {
            System.out.println("PARAMETRO INVALIDO");
        } else {
            if (!this.existe(list.getNomeP())) {
                this.repositorio.cadastrar(list);
                
            }else{
            	System.out.println("ERRO! MUSICA JÁ ADICIONADA!");
            }
        }        
    }
    
    public void descadastrar(String nomeP) {
    	Playlist list = this.repositorio.procurar(nomeP);
    	if (list != null) {
    		this.repositorio.remover(nomeP);
    		
		} else {
		    }
    }

    public Playlist procurar(String nomeP) {
        return this.repositorio.procurar(nomeP);
    }
    
    public boolean existe(String nomeP) {
    	return this.repositorio.existe(nomeP);
    }

    public void remover(String nomeP) {
        this.repositorio.remover(nomeP);
    }
}
