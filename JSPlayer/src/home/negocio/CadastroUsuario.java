package home.negocio;
import home.dados.RepositorioUsuarioArray;

public class CadastroUsuario {

private RepositorioUsuarioArray repositorio;
    
    public CadastroUsuario() {
        this.repositorio = new RepositorioUsuarioArray(100); 
    }
    
    public void cadastrar(Usuario u) {
        if (u == null) {
            throw new IllegalArgumentException("Par�metro inv�lido");
        } else {
            if (!this.existe(u.getNome())) {
                this.repositorio.cadastrar(u);
            } else {
                // Aqui n�o dever haver impress�o de mensagem para o usu�rio, j�
                // que essa n�o � a responsabildiade do Cadastro/Controlador.
                // O problema � resolvido com o uso de exce��es
            }
        }        
    }
    
    public void descadastrar(String nome) {
    	Usuario u = this.repositorio.procurar(nome);
    	if (u != null) {
    		this.repositorio.remover(nome);
    		
		} else {
		    // Aqui n�o dever haver impress�o de mensagem para o usu�rio, j�
            // que essa n�o � a responsabildiade do Cadastro/Controlador.
            // O problema � resolvido com o uso de exce��es
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
