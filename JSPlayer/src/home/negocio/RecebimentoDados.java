package home.negocio;

import java.io.FileInputStream;

import javax.swing.JOptionPane;

public class RecebimentoDados {

	public RecebimentoDados() {

	}


	public String recebimentoNome(String nome) {
		int h = 0;
		while (h == 0) {
			if (nome.length() > 0) {
				h++;
			} else {
				JOptionPane.showMessageDialog(null, "NOME INVALIDO");
			}
		}
		return nome;
	}

	public String recebimentoEmail(String email) {
		int h = 0;
		while (h == 0) {
			if (email.contains("@") && email.length() > 0) {
				h++;
			} else {
				JOptionPane.showMessageDialog(null, "EMAIL INVALIDO");
			}

		}
		return email.toLowerCase();
	}

	public String recebimentoCidade(String cidade) {
		int h = 0;
		while (h == 0) {
			if (cidade.length() > 0) {
				h++;
			} else {
				JOptionPane.showMessageDialog(null, "PARAMETRO INVALIDO");
			}
		}
		return cidade;
	}
	
	public Object recebimentoEstado(Object estado) {
		int h = 0;
		while (h == 0) {
			if (estado.equals("<Selecione>")) {
				JOptionPane.showMessageDialog(null, "PARAMETRO INVALIDO");
			} else {
				h++;
			}
		}
		return estado;
	}

	public Object recebimentoSexo(Object sexo) {
		int h = 0;
		while (h == 0) {
			if (sexo.equals("Masculino")){
						h++;
			} else if(sexo.equals("Feminino")){
				h++;
			} else {
				JOptionPane.showMessageDialog(null, "PARAMETRO INVALIDO");
			}

		}
		return sexo;
	}

	public String recebimentoIdade(String idade) {
		int h = 0;
		String result = null;
		String troll = "0123456789";
		while (h == 0) {
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
