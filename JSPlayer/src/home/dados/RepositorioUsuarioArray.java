package home.dados;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import home.negocio.beans.Usuario;

public class RepositorioUsuarioArray implements IRepositorioUsuarios{

	private Usuario[] usuarios;
	private int next;
	
	
	public RepositorioUsuarioArray(int tamanho) {
		this.usuarios = new Usuario[tamanho];
		this.next = 0;
	}

	
	public void cadastrar(Usuario u) {
		this.usuarios[this.next] = u;
		if (u.getEmail().equals(this.usuarios[this.next].getEmail())) {
			File usuario = new File("Usuarios\\" + u.getEmail() + ".txt");
			try{
				FileWriter fw = new FileWriter(usuario);
				BufferedWriter dados = new BufferedWriter(fw);
				dados.write("Nome: " + u.getNome() + "\nEmail: " + u.getEmail() + "\nLocalizacao: " + u.getLocalizacao() + "\nSexo: " + u.getSexo() + "\nIdade: " + u.getIdade());
				dados.close();
				fw.close();
			}catch(IOException ex){
				
			}
			
			this.next = this.next + 1;
			if (this.next == this.usuarios.length) {
				this.duplicaArrayUsuario();
			}
			JOptionPane.showMessageDialog(null,"O USUARIO FOI CADASTRADO!");
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

	public int procurarIndice(String nome, String email) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < this.next)) {
			if (nome.equals(this.usuarios[i].getNome()) && email.equals(this.usuarios[i].getEmail())) {
				achou = true;
			} else {
				i++;
			}
		}
		return i;
	}

	public void remover(String nome, String email) {
		int i = this.procurarIndice(nome, email);
		if (i != this.next) {
			this.usuarios[i] = this.usuarios[this.next - 1];
			this.usuarios[this.next - 1] = null;
			this.next = this.next - 1;
			JOptionPane.showMessageDialog(null,"O USUARIO FOI REMOVIDO!");
		} else {
			JOptionPane.showMessageDialog(null,"ERRO, O USUARIO NAO PODE SER REMOVIDO");
		}
	}

	public boolean existe(String nome, String email) {
		boolean existe = false;
		int indice = this.procurarIndice(nome, email);
		if (indice != next) {
			existe = true;
			System.out.println("O USUARIO EXISTE!" );
		} else {
			JOptionPane.showMessageDialog(null,"O USUARIO NAO EXISTE!");
		}
		return existe;
	}

	public Usuario procurar(String nome, String email) {
		int usearch = this.procurarIndice(nome, email);
		Usuario resultado = null;
		if (usearch != this.next) {
			resultado = this.usuarios[usearch];
		} else {
			JOptionPane.showMessageDialog(null,"O USUARIO NAO FOI ENCONTRADO.");
		}
		return resultado;
	}
	
	public void printar(Usuario u){
		JOptionPane.showMessageDialog(null,u.toString());
	}
		
	


}
