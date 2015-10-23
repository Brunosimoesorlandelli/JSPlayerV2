import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import home.negocio.Play;
import home.negocio.Usuario;

public class Teste {

	public static void main(String[] args) throws IOException {
		String inteiros = "0123456789";
		int controle = 0;
		int proxima = 0;

		System.out.println("Bem-vindo ao gerenciador de musicas JSPlayer, registre-se no nosso programa. AVISO: JSPlayer e recomendado para maiores de 10 anos.");

		Scanner sc = new Scanner(System.in);

		System.out.print("Digite seu nome: ");
		String nome = sc.nextLine();

		System.out.print("\nDigite seu email: ");
		String email = sc.nextLine();

		System.out.print("\nDigite sua localizacao, no modelo(Cidade, UF): ");
		String localizacao = sc.nextLine();

		System.out.print("\nDigite seu sexo: ");
		String sexo = sc.nextLine();

		System.out.print("\nDigite sua idade: ");
		String idade = sc.nextLine();

		

		while (controle == 0) {

			if (inteiros.contains(idade.substring(0, 1)) && inteiros.contains(idade.substring(1, 2)) && idade.length() == 2) {

				Usuario u = new Usuario(nome, email, localizacao, sexo, idade);
				FileWriter arq = new FileWriter("res\\Usuarios.txt");
				PrintWriter gravarArq = new PrintWriter(arq);
				gravarArq.printf("+--Usuarios--+%n");

				for (int i = 0; i <= proxima; i++) {

					gravarArq.print(u.toString());

				}
				gravarArq.printf("%n+-------------+");
				arq.close();
				System.out.print(u.toString());
				controle++;
				
			} else {
				System.out.println("ERRO");
				System.out.print("Digite sua idade: ");
				idade = sc.nextLine();
			}

			

		}
		
		System.out.println("\n");

		System.out.println("Qual musica deseja tocar?\n Digite o numero da faixa:\n1. Imagine Dragons - Radioactive\n2. O Rappa - Pescador de Ilusoes\n3. Onime - Tenro(Sprtn Remix)\n4. Phil Collins - Another Day in Paradise\n5. Above and Beyond - Counting Down The Days");

		new Play();
	}
}
