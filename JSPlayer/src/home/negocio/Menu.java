package home.negocio;

import java.util.Scanner;
import home.negocio.Usuario;
import home.dados.RepositorioUsuarioArray;

public class Menu {

	
	
	public static void main(String[] args) {
		int opcao, k = 0;
		RecebimentoDados dados = new RecebimentoDados();
		System.out.println("Bem-vindo ao gerenciador de musicas JSPlayer.\nO que deseja fazer?\n1 - Cadastrar Usuario\n2 - Logar");
		
		Controlador c = Controlador.getInstance();	
		while(k == 0){
			Scanner scan = new Scanner(System.in);
			opcao = scan.nextInt();
		
		switch(opcao){
		
		case 1:
		c.cadastrarUsuario(new Usuario(dados.recebimentoNome(), dados.recebimentoEmail(), dados.recebimentoLocalizacao(), dados.recebimentoSexo(), dados.recebimentoIdade()));
		break;
		
		case 2:
			c.procurarUsuario(dados.recebimentoEmail());

		break;
		
		default: System.out.println("Nao existe essa escolha");
		break;
		
		}
		System.out.println("\nO que deseja fazer agora? \n1 - Cadastrar Usuario\n2 - Logar");
		}
	}
}
