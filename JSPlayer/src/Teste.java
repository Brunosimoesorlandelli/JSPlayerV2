import java.util.Scanner;

import home.negocio.Controlador;
import home.negocio.Playlist;
import home.negocio.RecebimentoDados;
import home.negocio.Usuario;

public class Teste {

	public static void main(String[] args) {
		int opcao, escolha, k = 0; // variaveis que iniciam as estruturas de controle, while e switchs 
		RecebimentoDados dados = new RecebimentoDados(); 
		System.out.println("Bem-vindo ao gerenciador de musicas JSPlayer.");
		Scanner scan = new Scanner(System.in);
		Controlador c = Controlador.getInstance();
		c.administrador(); // implementação de um usuario padrao, do adiministrador, criamos para facilitar os testes.
		while (k == 0) {
			System.out.println("\nO que deseja fazer?\n1 - Cadastrar Usuario\n2 - Logar\n3 - Sair do programa!");

			opcao = scan.nextInt();

			switch (opcao) {

			case 1:
				c.cadastrarUsuario(new Usuario(dados.recebimentoNome(), dados.recebimentoEmail(),
						dados.recebimentoLocalizacao(), dados.recebimentoSexo(), dados.recebimentoIdade()));
				// Neste case, usamos os metodos de recebimento para passar as variaveis corretas do usuario para cadastra-lo no fim da operação.
				break;

			case 2:
				if (c.loginUsuario(dados.recebimentoNome(), dados.recebimentoEmail())) {
					// neste case, logamos o usuario para ele acessar o proximo menu, com mais opções.
					k++;

					System.out.println(
							"\n1 - Criar Playlist\n2 - Tocar Playlist\n3 - Procurar outros usuarios\n4 - Deslogar e retornar ao menu!\n5 - Sair do programa!");
					escolha = scan.nextInt();

					switch (escolha) {

					case 1:
						System.out.println("FUNÇÃO EM DESENVOLVIMENTO, FAVOR ESPERAR PROXIMO UPDATE");
						// Estamos trabalhando na criação e manipulação das playlists						
						break;
					case 2:
						System.out.println("FUNÇÃO EM DESENVOLVIMENTO, FAVOR ESPERAR PROXIMO UPDATE");
						// Estamos trabalhando na criação e manipulação das playlists
						break;
					case 3:
						System.out.println("\nEscreva os dados do usuario que deseja procurar");
						c.printarDados(c.procurarUsuario(dados.recebimentoNome(), dados.recebimentoEmail()));
						// Neste case, usamos os metodos procurarUsuario, com os metodos recebimentoNome e recebimentoEmail como parametros
						// para o usuario, interagir com outros usuarios. Futuramente, implementaremos funçoes que disponibilizam as playlists 
						// do usuario procurado.
						break;
					case 4:
						k--;
						// Neste case, usamos um decremento da variavel k, para assim, voltar ao while, que seria o menu principal.
						break;
					case 5:
						// Neste case, fechamos o programa, simplesmete saindo do while
						break;

					default:
						System.out.println("NAO EXISTE ESSA ESCOLHA");
						break;
					}
				} else {
					System.out.println("REALIZE O CADASTRO DESSE USUARIO ANTES DE LOGAR!");
				}
				break;

			case 3:
				System.out.println("PROGRAMA ENCERRADO!");
				k++;
				break;

			default:
				System.out.println("NAO EXISTE ESSA ESCOLHA");
				break;

			}
		}
		scan.close();
	}

}
