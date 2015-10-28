package home.negocio;

import java.util.Scanner;
import home.negocio.Usuario;
import home.dados.RepositorioMusicaArray;
import home.dados.RepositorioUsuarioArray;

public class Menu {

	
         
    
	
	public static void main(String[] args) {
		RepositorioMusicaArray repositorio = new RepositorioMusicaArray(100);
		int opcao, escolha, k = 0;
		RecebimentoDados dados = new RecebimentoDados();
		System.out.println("Bem-vindo ao gerenciador de musicas JSPlayer.");
		Scanner scan = new Scanner(System.in);
		Controlador c = Controlador.getInstance();
		c.administrador();
		while (k == 0) {
			System.out.println("\nO que deseja fazer?\n1 - Cadastrar Usuario\n2 - Logar\n3 - Sair");
			
			opcao = scan.nextInt();

			switch (opcao) {

			case 1:
				c.cadastrarUsuario(new Usuario(dados.recebimentoNome(), dados.recebimentoEmail(),
						dados.recebimentoLocalizacao(), dados.recebimentoSexo(), dados.recebimentoIdade()));
				break;

			case 2:
				c.loginUsuario(dados.recebimentoNome(), dados.recebimentoEmail());
				k++;
				
				System.out.println("\n1 - Criar Playlist\n2 - Tocar Playlist\n3 - Procurar outros usuarios");
				escolha = scan.nextInt();
				switch(escolha){
				
				case 1:
					break;
				case 2:
					repositorio.musicas();
					repositorio.call();
					break;
				case 3:
					break;
				default:
					System.out.println("NAO EXISTE ESSA ESCOLHA");
					break;		
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
