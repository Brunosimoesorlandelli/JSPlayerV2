package home.negocio;

import home.dados.IRepositorioPlaylist;
import home.dados.RepositorioPlaylistArray;
import home.negocio.beans.Playlist;

public class CadastroPlaylist implements ICadastroPlaylist{

private IRepositorioPlaylist repositorio;
    
    public CadastroPlaylist() {
    }
    
    public void pegarRepositorioDoUsuario(IRepositorioPlaylist repoP) {
    	this.repositorio = repoP;
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
