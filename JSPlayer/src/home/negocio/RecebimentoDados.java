package home.negocio;

import java.util.Scanner;

public class RecebimentoDados {

	public RecebimentoDados() {

	}

	Scanner sc = new Scanner(System.in);

	public String recebimentoNome() {
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		return nome;
	}

	public String recebimentoEmail() {
		System.out.print("\nEmail: ");
		String email = sc.nextLine();
		return email;
	}

	public String recebimentoLocalizacao() {
		System.out.print("\nLocalizacao, no modelo(Cidade, UF): ");
		String localizacao = sc.nextLine();
		return localizacao;
	}

	public String recebimentoSexo() {
		System.out.print("\nSexo: ");
		String sexo = sc.nextLine();
		return sexo;
	}

	public String recebimentoIdade() {
		int h = 0;
		String result = null;
		String troll = "0123456789";
		while (h == 0) {
			System.out.print("\nIdade: ");
			String idade = sc.nextLine();
			if (idade.length() < 3) {
				if (idade.length() < 2) {
					if (troll.contains(idade.substring(0, 1))) {
						result = idade;
						h++;
					} else {
						System.out.println("PARAMETRO INVALIDO");
					}
				} else {

					if (troll.contains(idade.substring(0, 2))) {
						result = idade;
						h++;
					} else {
						System.out.println("PARAMETRO INVALIDO");
					}
				}
			} else {
				System.out.println("PARAMETRO INVALIDO");
			}
		}

		return result;

	}

	public String recebimentoTitulo() {
		System.out.print("Titulo: ");
		String titulo = sc.nextLine();
		return titulo;
	}

	public String recebimentoArtista() {
		System.out.print("Artista: ");
		String artista = sc.nextLine();
		return artista;
	}

	public String recebimentoNomeP() {
		System.out.print("Nome da Playlist: ");
		String nomeP = sc.nextLine();
		return nomeP;
	}
}
