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
	private String localização;
	private String sexo;
	private String idade;

	public Usuario(String nome, String email, String localização, String sexo, String idade) {

		this.nome = nome;
		this.email = email;
		this.localização = localização;
		this.sexo = sexo;
		this.idade = idade;

	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getLocalização() {
		return localização;
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

	public void setLocalização(String localização) {
		this.localização = localização;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String toString() {
		return "\nUsuário: " + nome + "\nEmail: " + email + "\nLocalização: " + localização + "\nSexo: " + sexo
				+ "\nIdade: " + idade;
	}

	public static void main(String[] args) throws IOException {
		String inteiros = "0123456789";
		int u = 0;
		int i;
		int proxima = 0;
		proxima = proxima + 1;

		System.out.println("Bem-vindo ao gerenciador de músicas JSPlayer, registre-se no nosso programa. AVISO: JSPlayer é recomendado para maiores de 10 anos.");

		Scanner sc = new Scanner(System.in);

		System.out.print("Digite seu nome: ");
		String nome = sc.nextLine();

		System.out.print("\nDigite seu email: ");
		String email = sc.nextLine();

		System.out.print("\nDigite sua localização, no modelo(Cidade, UF): ");
		String localização = sc.nextLine();

		System.out.print("\nDigite seu sexo: ");
		String sexo = sc.nextLine();

		System.out.print("\nDigite sua idade: ");
		String idade = sc.nextLine();

		

		while (u == 0) {

			if (inteiros.contains(idade.substring(0, 1)) && inteiros.contains(idade.substring(1, 2)) && idade.length() == 2) {

				Usuario u1 = new Usuario(nome, email, localização, sexo, idade);
				FileWriter arq = new FileWriter("res\\Usuários.txt");
				PrintWriter gravarArq = new PrintWriter(arq);
				gravarArq.printf("+--Usuários--+%n");

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

		System.out.println("Qual música deseja tocar?\n Digite o número da faixa:\n1. Imagine Dragons - Radioactive\n2. O Rappa - Pescador de Ilusões\n3. Onime - Tenro(Sprtn Remix)\n4. Phil Collins - Another Day in Paradise\n5. Above & Beyond - Counting Down The Days");

		new Play();
	}

}
