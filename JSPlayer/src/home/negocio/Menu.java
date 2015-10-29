package home.negocio;

import java.util.Scanner;
import home.negocio.Usuario;

public class Menu {
	
	public static void main(String[] args) {
		int opcao, escolha, k = 0;
		RecebimentoDados dados = new RecebimentoDados();
		System.out.println("Bem-vindo ao gerenciador de musicas JSPlayer.");
		Scanner scan = new Scanner(System.in);
		Controlador c = Controlador.getInstance();
		c.administrador();
		while (k == 0) {
			System.out.println("\nO que deseja fazer?\n1 - Cadastrar Usuario\n2 - Logar\n3 - Sair do programa!");
			
			opcao = scan.nextInt();

			switch (opcao) {

			case 1:
				c.cadastrarUsuario(new Usuario(dados.recebimentoNome(), dados.recebimentoEmail(),
						dados.recebimentoLocalizacao(), dados.recebimentoSexo(), dados.recebimentoIdade()));
				break;

			case 2:
				if(c.loginUsuario(dados.recebimentoNome(), dados.recebimentoEmail())){
					
				
				k++;
				
				System.out.println("\n1 - Criar Playlist\n2 - Tocar Playlist\n3 - Procurar outros usuarios\n4 - Deslogar e retornar ao menu!\n5 - Sair do programa!");
				escolha = scan.nextInt();
				

				switch(escolha){
				
				case 1:
					Playlist lista = new Playlist(dados.recebimentoNomeP());
					
					break;
				case 2:
					break;
				case 3:
					System.out.println("\nEscreva os dados do usuario que deseja procurar");					
					c.printarDados(c.procurarUsuario(dados.recebimentoNome(), dados.recebimentoEmail()));
					break;
				case 4:				
					k--;
					break;
				case 5:				
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
