package home.negocio;
import home.dados.RepositorioUsuarioArray;

public class CadastroUsuario {

private RepositorioUsuarioArray repositorio;
    
    public CadastroUsuario() {
        this.repositorio = new RepositorioUsuarioArray(100); 
    }
    
    public void cadastrar(Usuario u) {
        if (u == null) {
            throw new IllegalArgumentException("Parâmetro inválido");
        } else {
            if (!this.existe(u.getNome())) {
                this.repositorio.cadastrar(u);
            } else {
                // Aqui não dever haver impressão de mensagem para o usuário, já
                // que essa não é a responsabildiade do Cadastro/Controlador.
                // O problema é resolvido com o uso de exceções
            }
        }        
    }
    
    public void descadastrar(String nome) {
    	Usuario u = this.repositorio.procurar(nome);
    	if (u != null) {
    		this.repositorio.remover(nome);
    		
		} else {
		    // Aqui não dever haver impressão de mensagem para o usuário, já
            // que essa não é a responsabildiade do Cadastro/Controlador.
            // O problema é resolvido com o uso de exceções
		}
    }

    public Usuario procurar(String nome) {
        return this.repositorio.procurar(nome);
    }
    
    public boolean existe(String nome) {
    	return this.repositorio.existe(nome);
    }

    public void remover(String nome) {
        this.repositorio.remover(nome);
    }
}
