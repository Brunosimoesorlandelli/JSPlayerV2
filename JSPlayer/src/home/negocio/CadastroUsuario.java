package home.negocio;
import javax.swing.JOptionPane;

import home.dados.RepositorioUsuarioArray;
import home.negocio.beans.Usuario;

public class CadastroUsuario implements ICadastroUsuario{

private RepositorioUsuarioArray repositorio;
    
    public CadastroUsuario() {
        this.repositorio = new RepositorioUsuarioArray(100); 
    }
    
    
    
    public void cadastrar (Usuario u) {
        if (u == null) {
        	JOptionPane.showMessageDialog(null,"PARAMETRO INVALIDO");
        } else {
            if (!this.existe(u.getNome(), u.getEmail())) {
                this.repositorio.cadastrar(u);
                
            }else{
            	JOptionPane.showMessageDialog(null,"ERRO! EMAIL J� CADASTRADO!");
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
    
    public boolean login(String nome, String email) {
		boolean login = false;
		if(repositorio.existe(nome, email)){
			login = true;
			JOptionPane.showMessageDialog(null,"LOGIN REALIZADO COM SUCESSO");
			repositorio.printar(repositorio.procurar(nome, email));
		}else{
			JOptionPane.showMessageDialog(null,"LOGIN N�O REALIZADO");
		}
			return login;			
	}
    
    public void printar(Usuario u) {
    	this.repositorio.printar(u);
    }
}