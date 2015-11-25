package home.negocio;

import java.util.Scanner;

import javax.swing.JOptionPane;

import home.negocio.beans.Musica;
import home.negocio.beans.Usuario;

public class Menu {

	public Menu() {

		String opcao;
		String escolha;
		int k = 0;
		int retorno = 0; // variaveis que iniciam as estruturas de
							// controle, while e switchs
		RecebimentoDados dados = new RecebimentoDados();
		JOptionPane.showMessageDialog(null, "Bem-vindo ao gerenciador de musicas JSPlayer.");
		Scanner scan = new Scanner(System.in);
		IFachada f = Fachada.getInstance();
		while (k == 0) {
			retorno = 0;

			opcao = JOptionPane
					.showInputDialog("\nO que deseja fazer?\n1 - Cadastrar Usuario\n2 - Logar\n3 - Sair do programa!");

			switch (opcao) {

			case "1":
				f.cadastrarUsuario(new Usuario(dados.recebimentoNome(), dados.recebimentoEmail(),
						dados.recebimentoLocalizacao(), dados.recebimentoSexo(), dados.recebimentoIdade()));
				// Neste case, usamos os metodos de recebimento para passar as
				// variaveis corretas do usuario para cadastra-lo no fim da
				// operação.
				break;

			case "2":
				if (f.loginUsuario(dados.recebimentoNome(), dados.recebimentoEmail())) {
					// neste case, logamos o usuario para ele acessar o proximo
					// menu, com mais opções.
					k++;
					while (retorno == 0) {

						escolha = JOptionPane.showInputDialog(
								"\n1 - Tocar Playlist\n2 - Cadastrar música\n3 - Procurar outros usuarios\n4 - Procurar informacoes da musica\n5 - Deslogar e retornar ao menu!\n6 - Sair do programa!");

						switch (escolha) {

						case "1":
							f.callMusica();
							break;
						case "2":
							f.cadastrarMusica(new Musica(dados.recebimentoTitulo(), dados.recebimentoArtista(),
									dados.recebimentoEndereco()));

							break;
						case "4":
							System.out.println("\nEscreva os dados da musica que deseja procurar");
							f.printarDadosMusica(
									f.procurarMusica(dados.recebimentoTitulo(), dados.recebimentoArtista()));
							break;
						case "3":
							System.out.println("\nEscreva os dados do usuario que deseja procurar");
							f.printarDadosUsuario(f.procurarUsuario(dados.recebimentoNome(), dados.recebimentoEmail()));
							// Neste case, usamos os metodos procurarUsuario,
							// com os metodos recebimentoNome e recebimentoEmail
							// como parametros
							// para o usuario, interagir com outros usuarios.
							// Futuramente, implementaremos funçoes que
							// disponibilizam as playlists
							// do usuario procurado.
							break;
						case "5":
							retorno++;
							k--;
							// Neste case, usamos um decremento da variavel k,
							// para assim, voltar ao while, que seria o menu
							// principal.
							break;
						case "6":
							retorno++;
							// Neste case, fechamos o programa, simplesmente
							// saindo do while
							break;

						default:
							System.out.println("NAO EXISTE ESSA ESCOLHA");
							break;
						}
					}
				} else {
					System.out.println("REALIZE O CADASTRO DESSE USUARIO ANTES DE LOGAR!");
				}
				break;

			case "3":
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
