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
		if (u.getEmail().equals(this.usuarios[this.next].getEmail())) {
			
			this.next = this.next + 1;
			if (this.next == this.usuarios.length) {
				this.duplicaArrayUsuario();
			}
			System.out.println("O USUARIO FOI CADASTRADO!");
		} else {
			

		}
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

	private int procurarIndice(String email) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < this.next)) {
			if (email.equals(this.usuarios[i].getEmail())) {
				achou = true;
			} else {
				i++;
			}
		}
		return i;
	}

	public void remover(String email) {
		int i = this.procurarIndice(email);
		if (i != this.next) {
			this.usuarios[i] = this.usuarios[this.next - 1];
			this.usuarios[this.next - 1] = null;
			this.next = this.next - 1;
			System.out.println("O USUARIO FOI REMOVIDO!");
		} else {
			System.out.println("ERRO, O USUARIO NAO PODE SER REMOVIDO");
		}
	}

	public boolean existe(String email) {
		boolean existe = false;
		int indice = this.procurarIndice(email);
		if (indice != next) {
			existe = true;
			System.out.println("O USUARIO EXISTE!");
		} else {
			System.out.println("O USUARIO NAO EXISTE!");
		}
		return existe;
	}

	public Usuario procurar(String email) {
		int isearch = this.procurarIndice(email);
		Usuario resultado = null;
		if (isearch != this.next) {
			resultado = this.usuarios[isearch];
			System.out.printf("O USUARIO FOI ENCONTRADO: %s", email);
		} else {
			System.out.println("O USUARIO NAO FOI ENCONTRADO.");
		}
		return resultado;
	}

}
