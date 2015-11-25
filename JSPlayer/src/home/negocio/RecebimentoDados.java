package home.negocio;

import java.io.FileInputStream;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class RecebimentoDados {

	public RecebimentoDados() {

	}

	Scanner sc = new Scanner(System.in);

	public String recebimentoNome() {
		int h = 0;
		String nome = null;
		while (h == 0) {
			nome = JOptionPane.showInputDialog("\nNome: ");
			if (nome.length() > 0) {
				
				h++;
			} else {
				JOptionPane.showMessageDialog(null, "PARAMETRO INVALIDO");
			}
		}
		return nome;
	}

	public String recebimentoEmail() {
		int h = 0;
		String email = null;
		while (h == 0) {

			email = JOptionPane.showInputDialog("\nEmail: ");

			if (email.contains("@") && email.length() > 0) {
				h++;
			} else {
				JOptionPane.showMessageDialog(null, "PARAMETRO INVALIDO");
			}

		}
		return email.toLowerCase();
	}

	public String recebimentoLocalizacao() {
		int h = 0;
		String localizacao = null;
		while (h == 0) {

			localizacao = JOptionPane.showInputDialog("\nLocalizacao, no modelo(Cidade, UF): ");

			if (localizacao.length() > 0) {
				h++;
			} else {
				JOptionPane.showMessageDialog(null, "PARAMETRO INVALIDO");
			}
		}
		return localizacao;
	}

	public String recebimentoSexo() {
		int h = 0;
		String sexo = null;
		while (h == 0) {

			sexo = JOptionPane.showInputDialog("M - Masculino, F - Feminino\nSexo: ");

			if (sexo.length() == 1 || sexo.equals("Masculino") || sexo.equals("masculino") || sexo.equals("Feminino")
					|| sexo.equals("feminino")) {
				if (sexo.substring(0, 1).equals("M") || sexo.substring(0, 1).equals("m")
						|| sexo.substring(0, 1).equals("F") || sexo.substring(0, 1).equals("f")) {

					if (sexo.substring(0, 1).equals("M") || sexo.substring(0, 1).equals("m")) {
						sexo = "Masculino";
						h++;
					} else if (sexo.substring(0, 1).equals("F") || sexo.substring(0, 1).equals("f")) {
						sexo = "Feminino";
						h++;
					}
				} else {
					JOptionPane.showMessageDialog(null, "PARAMETRO INVALIDO");
				}
			} else {
				JOptionPane.showMessageDialog(null, "PARAMETRO INVALIDO");
			}

		}
		return sexo;
	}

	public String recebimentoIdade() {
		int h = 0;
		String result = null;
		String troll = "0123456789";
		while (h == 0) {

			String idade = JOptionPane.showInputDialog("\nIdade: ");

			switch (idade.length()) {
			case 1:
				if (troll.contains(idade.substring(0, 1))) {
					result = idade;
					h++;
				} else {
					JOptionPane.showMessageDialog(null, "PARAMETRO INVALIDO");
				}
				break;

			case 2:
				if (troll.contains(idade.substring(0, 1)) && (troll.contains(idade.substring(1, 2)))) {
					result = idade;
					h++;
				} else {
					JOptionPane.showMessageDialog(null, "PARAMETRO INVALIDO");
				}
				break;
			default:
				JOptionPane.showMessageDialog(null, "PARAMETRO INVALIDO");
			}

		}

		return result;

	}

	public String recebimentoTitulo() {
		int h = 0;
		String titulo = null;
		while (h == 0) {
			titulo = JOptionPane.showInputDialog("\nTitulo: ");

			if (titulo.length() > 0) {
				h++;
			} else {
				JOptionPane.showMessageDialog(null, "PARAMETRO INVALIDO");
			}
		}
		return titulo;
	}

	public String recebimentoArtista() {
		int h = 0;
		String artista = null;
		while (h == 0) {
			artista = JOptionPane.showInputDialog("\nArtista: ");

			if (artista.length() > 0) {
				h++;
			} else {
				JOptionPane.showMessageDialog(null, "PARAMETRO INVALIDO");
			}
		}
		return artista;
	}

	public String recebimentoAlbum() {
		int h = 0;
		String album = null;
		while (h == 0) {
			album = JOptionPane.showInputDialog("\nAlbum: ");

			if (album.length() > 0) {
				h++;
			} else {
				JOptionPane.showMessageDialog(null, "PARAMETRO INVALIDO");
			}
		}
		return album;
	}

	public String recebimentoAno() {
		int h = 0;
		String ano = null;
		while (h == 0) {
			ano = JOptionPane.showInputDialog("\nAno: ");
			if (ano.length() > 0 && ano.length() <= 4)
				h++;
			else
				JOptionPane.showMessageDialog(null, "PARAMETRO INVALIDO");
		}
		return ano;
	}

	public String recebimentoGenero() {
		int h = 0;
		String genero = null;
		while (h == 0) {
			genero = JOptionPane.showInputDialog("\nGenero: ");
			if (genero.length() > 0) {
				h++;
			} else {
				JOptionPane.showMessageDialog(null, "PARAMETRO INVALIDO");
			}
		}
		return genero;
	}
	
	private boolean condicaoEndereco(String endereco){
		try{
			FileInputStream fis = new FileInputStream(endereco);
			fis.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String recebimentoEndereco() {
		int h = 0;
		String endereco = null;
		while (h == 0) {
			endereco = JOptionPane.showInputDialog("\nCaminho (sem especificacoes): ");
			endereco = "Musicas\\" + endereco + ".mp3";

			if (endereco.length() > 0) {
				if(condicaoEndereco(endereco)){
					h++;
				} else {
					JOptionPane.showMessageDialog(null, "Caminho incorreto ou inexistente");
				}
			} else {
				JOptionPane.showMessageDialog(null, "PARAMETRO INVALIDO");
			}
		}
		return endereco;
	}

	public String recebimentoNomeP() {
		int h = 0;
		String nomeP = null;
		while (h == 0) {
			nomeP = JOptionPane.showInputDialog("\nNome da Playlist:");
			if (nomeP.length() > 0) {
				h++;
			} else {
				JOptionPane.showMessageDialog(null, "PARAMETRO INVALIDO");
			}
		}
		return nomeP;
	}
}
