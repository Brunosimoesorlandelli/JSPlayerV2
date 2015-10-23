package home.dados;

import home.negocio.Usuario;

public class RepositorioUsuarioArray {

	private Usuario[] usuarios;
	private int next;
	
	public RepositorioUsuarioArray(int tamanho) {
        this.usuarios = new Usuario[tamanho];
        this.next = 0;
    }

	public void cadastrar(Usuario u) {
        this.usuarios[this.next] = u;
        this.next = this.next + 1;
        if (this.next == this.usuarios.length) {
            this.duplicaArrayUsuario();
        }
    }
	
	public void cadastrar(String nome, String email, String localizacao, String sexo, String idade) {
        Usuario u = new Usuario(nome, email, localizacao, sexo, idade);
        this.cadastrar(u);
        }
	
    private void duplicaArrayUsuario() {
        if (this.usuarios != null && this.usuarios.length > 0) {
            Usuario[] arrayDuplicado = new Usuario[this.usuarios.length * 2];
            for (int i = 0; i < this.usuarios.length; i++) {
                arrayDuplicado[i] = this.usuarios[i];
            }
            this.usuarios = arrayDuplicado;
        }
    }
    
    private int procurarIndice(String nome) {
        int i = 0;
        boolean achou = false;
        while ((!achou) && (i < this.next)) {
            if (nome.equals(this.usuarios[i].getNome())) {
                achou = true;
            } else {
                i = i + 1;
            }
        }
        return i;
    }
    
    public void remover(String nome) {
        int i = this.procurarIndice(nome);
        if (i != this.next) {
            this.usuarios[i] = this.usuarios[this.next - 1];
            this.usuarios[this.next - 1] = null;
            this.next = this.next - 1;
        } else {
            System.out.println("ERRO, O USUARIO NAO EXISTE!");
        }
    }
    
    public boolean existe(String nome) {
        boolean existe = false;
        int indice = this.procurarIndice(nome);
        if (indice != next) {
            existe = true;
        }
        return existe;
    }
    
    public Usuario procurar(String nome) {
        int i = this.procurarIndice(nome);
        Usuario resultado = null;
        if (i != this.next) {
            resultado = this.usuarios[i];
        }
        return resultado;
    }

}
