package home.negocio;

import java.util.Scanner;

public class RecebimentoDados {
	
	public RecebimentoDados(){
		
	}
	
	Scanner sc = new Scanner(System.in);
	
	public String recebimentoNome(){
		System.out.print("Digite seu nome: ");
		String nome = sc.nextLine();
		return nome;
	}
	
	public String recebimentoEmail(){
		System.out.print("\nDigite seu email: ");
		String email = sc.nextLine();
		return email;
	}
	
	public String recebimentoLocalizacao(){
		System.out.print("\nDigite sua localizacao, no modelo(Cidade, UF): ");
		String localizacao = sc.nextLine();
		return localizacao;
	}
	
	public String recebimentoSexo(){
		System.out.print("\nDigite seu sexo: ");
		String sexo = sc.nextLine();
		return sexo;
	}
	
	public String recebimentoIdade(){
		System.out.print("\nDigite sua idade: ");
		String idade = sc.nextLine();
		return idade;
	}

}
