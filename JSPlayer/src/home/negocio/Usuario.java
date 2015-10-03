package home.negocio;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import home.negocio.Play;

public class Usuario {

	private String nome;
	private String email;
	private String localiza��o;
	private String sexo;
	private String idade;

	public Usuario(String nome, String email, String localiza��o, String sexo, String idade) {

		this.nome = nome;
		this.email = email;
		this.localiza��o = localiza��o;
		this.sexo = sexo;
		this.idade = idade;

	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getLocaliza��o() {
		return localiza��o;
	}

	public String getSexo() {
		return sexo;
	}

	public String getIdade() {
		return idade;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLocaliza��o(String localiza��o) {
		this.localiza��o = localiza��o;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String toString() {
		return "\nUsu�rio: " + nome + "\nEmail: " + email + "\nLocaliza��o: " + localiza��o + "\nSexo: " + sexo
				+ "\nIdade: " + idade;
	}

	public static void main(String[] args) throws IOException {
		String inteiros = "0123456789";
		int u = 0;
		int i;
		int proxima = 0;
		proxima = proxima + 1;

		System.out.println("Bem-vindo ao gerenciador de m�sicas JSPlayer, registre-se no nosso programa. AVISO: JSPlayer � recomendado para maiores de 10 anos.");

		Scanner sc = new Scanner(System.in);

		System.out.print("Digite seu nome: ");
		String nome = sc.nextLine();

		System.out.print("\nDigite seu email: ");
		String email = sc.nextLine();

		System.out.print("\nDigite sua localiza��o, no modelo(Cidade, UF): ");
		String localiza��o = sc.nextLine();

		System.out.print("\nDigite seu sexo: ");
		String sexo = sc.nextLine();

		System.out.print("\nDigite sua idade: ");
		String idade = sc.nextLine();

		

		while (u == 0) {

			if (inteiros.contains(idade.substring(0, 1)) && inteiros.contains(idade.substring(1, 2)) && idade.length() == 2) {

				Usuario u1 = new Usuario(nome, email, localiza��o, sexo, idade);
				FileWriter arq = new FileWriter("res\\Usu�rios.txt");
				PrintWriter gravarArq = new PrintWriter(arq);
				gravarArq.printf("+--Usu�rios--+%n");

				for (i = 0; i <= proxima; i++) {

					gravarArq.print(u1.toString());

				}
				gravarArq.printf("%n+-------------+");
				arq.close();
				System.out.print(u1.toString());
				u++;
			} else {
				System.out.println("ERRO");
				System.out.print("Digite sua idade: ");
				idade = sc.nextLine();
			}

			

		}
		
		System.out.println("\n");

		System.out.println("Qual m�sica deseja tocar?\n Digite o n�mero da faixa:\n1. Imagine Dragons - Radioactive\n2. O Rappa - Pescador de Ilus�es\n3. Onime - Tenro(Sprtn Remix)\n4. Phil Collins - Another Day in Paradise\n5. Above & Beyond - Counting Down The Days");

		new Play();
	}

}
