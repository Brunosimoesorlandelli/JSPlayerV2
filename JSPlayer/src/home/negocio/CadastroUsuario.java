package home.negocio;
import home.dados.RepositorioUsuarioArray;
import home.negocio.Usuario;

public class CadastroUsuario {

private RepositorioUsuarioArray repositorio;
    
    public CadastroUsuario() {
        this.repositorio = new RepositorioUsuarioArray(100); 
    }
    
    public void cadastrar (Usuario u) {
        if (u == null) {
            throw new IllegalArgumentException("Parâmetro inválido");
        } else {
            if (!this.existe(u.getEmail())) {
                this.repositorio.cadastrar(u);
                
            }else{
            	System.out.println("ERRO! EMAIL JÁ CADASTRADO!");
            }
        }        
    }
    
    public void descadastrar(String email) {
    	Usuario u = this.repositorio.procurar(email);
    	if (u != null) {
    		this.repositorio.remover(email);
    		
		} else {
		    }
    }

    public Usuario procurar(String email) {
        return this.repositorio.procurar(email);
    }
    
    public boolean existe(String email) {
    	return this.repositorio.existe(email);
    }

    public void remover(String email) {
        this.repositorio.remover(email);
    }
}