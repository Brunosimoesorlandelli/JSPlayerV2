package home.negocio;

import home.negocio.Usuario;

public class Controlador {


	private CadastroUsuario usuarios;

	private static Controlador instance;

	private Controlador() {
		this.usuarios = new CadastroUsuario();
	}

	/**
	 * Implementando padrão Singleton
	 * 
	 * @return A instância da desta fachada
	 */
	public static Controlador getInstance() {
		if (instance == null) {
			instance = new Controlador();
		}
		return instance;
	}

	public void cadastrarUsuario(Usuario u) {
        usuarios.cadastrar(u);
    }

    /**
     * @param num
     * @return
     * @see br.ufrpe.sistema_bancario.negocio.CadastroContas#procurar(java.lang.String)
     */
    public Usuario procurarUsuario(String nome) {
        return usuarios.procurar(nome);
    }

    /**
     * @param numConta
     * @return
     * @see br.ufrpe.sistema_bancario.negocio.CadastroContas#existe(java.lang.String)
     */
    public boolean existeUsuario(String nome) {
        return usuarios.existe(nome);
    }

    /**
     * @param num
     * @see br.ufrpe.sistema_bancario.negocio.CadastroContas#remover(java.lang.String)
     */
    public void removerUsuario(String nome) {
        usuarios.remover(nome);
    }
}
