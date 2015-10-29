package home.negocio;
import home.dados.RepositorioUsuarioArray;
import home.negocio.Usuario;

public class CadastroUsuario {

private RepositorioUsuarioArray repositorio;
    
    public CadastroUsuario() {
        this.repositorio = new RepositorioUsuarioArray(100); 
    }
    
    public void administrador(){
        repositorio.administrador();
       }
    
    public void cadastrar (Usuario u) {
        if (u == null) {
        	System.out.println("PARAMETRO INVALIDO");
        } else {
            if (!this.existe(u.getNome(), u.getEmail())) {
                this.repositorio.cadastrar(u);
                
            }else{
            	System.out.println("ERRO! EMAIL JÁ CADASTRADO!");
            }
        }        
    }
    
    public void descadastrar(String nome, String email) {
    	Usuario u = this.repositorio.procurar(nome, email);
    	if (u != null) {
    		this.repositorio.remover(nome, email);
    		
		} else {
		    }
    }

    public Usuario procurar(String nome, String email) {
        return this.repositorio.procurar(nome, email);
    }
    
    public boolean existe(String nome, String email) {
    	return this.repositorio.existe(nome, email);
    }

    public void remover(String nome, String email) {
        this.repositorio.remover(nome, email); 
    }
    
    public boolean login(String nome, String email){
		boolean login = false;
		if(repositorio.existe(nome, email)){
			login = true;
			System.out.println("LOGIN REALIZADO COM SUCESSO");
			repositorio.printar(repositorio.procurar(nome, email));
		}else{
			System.out.println("LOGIN NÃO REALIZADO");
		}
			return login;			
	}
    
    public void printar(Usuario u){
    	this.repositorio.printar(u);
    }
}