package home.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JOptionPane;

import home.negocio.CustomPlayer;
import home.negocio.beans.Musica;

public class RepositorioMusicaArray implements IRepositorioMusica, Serializable {

	private static RepositorioMusicaArray instanceMusic;
	private Musica[] musicas;
	private int prox;

	private RepositorioMusicaArray(int tamanho) {
		this.musicas = new Musica[tamanho];
		this.prox = 0;
	}

	public static synchronized RepositorioMusicaArray getInstance() {
		if (instanceMusic == null) {
			if (ler() == null) {
				instanceMusic = new RepositorioMusicaArray(100);
			} else {
				instanceMusic = (RepositorioMusicaArray) ler();
			}
		}
		return instanceMusic;
	}

	public void salvar() {
		try {
			File f2 = new File("BancoDeMusicas\\RepositorioMusicaArray.db");
			FileOutputStream fos = new FileOutputStream(f2);
			ObjectOutputStream oms = new ObjectOutputStream(fos);
			oms.writeObject(instanceMusic);
			oms.close();
			System.out.println("Objeto serializado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static IRepositorioMusica ler() {
		IRepositorioMusica repo = null;
		try {
			File f = new File("BancoDeMusicas\\RepositorioMusicaArray.db");

			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream mis = new ObjectInputStream(fis);
			Object mo = mis.readObject();
			if (mo != null) {
				repo = (RepositorioMusicaArray) mo;
				System.out.println("MUSICA agora ele foi des-serializado com sucesso");
			}
			mis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return repo;
	}

	public void cadastrar(Musica mus) {
		this.musicas[this.prox] = mus;
		if (mus.getTitulo().equals(this.musicas[this.prox].getTitulo())
				&& mus.getArtista().equals(this.musicas[this.prox].getArtista())) {

			this.prox = this.prox + 1;
			if (this.prox == this.musicas.length) {
				this.duplicaArrayMusica();
			}
			System.out.println("A MUSICA FOI ADICIONADA");
		} else {

		}
		salvar();
	}

	private void duplicaArrayMusica() {
		if (this.musicas != null && this.musicas.length > 0) {
			Musica[] arrayDuplicado = new Musica[this.musicas.length * 2];
			for (int i = 0; i < this.musicas.length; i++) {
				arrayDuplicado[i] = this.musicas[i];
			}
			this.musicas = arrayDuplicado;
		}
	}

	public int procurarIndice(String titulo, String artista) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < this.prox)) {
			if (titulo.equals(this.musicas[i].getTitulo()) && artista.equals(this.musicas[i].getArtista())) {
				achou = true;
			} else {
				i++;
			}
		}
		return i;
	}

	public void remover(String titulo, String artista) {
		int i = this.procurarIndice(titulo, artista);
		if (i != this.prox) {
			this.musicas[i] = this.musicas[this.prox - 1];
			this.musicas[this.prox - 1] = null;
			this.prox = this.prox - 1;
			System.out.println("A MUSICA FOI REMOVIDA!");
		} else {
			System.out.println("ERRO, A MUSICA NAO PODE SER REMOVIDA");
		}
	}

	public boolean existe(String titulo, String artista) {
		boolean existe = false;
		int indice = this.procurarIndice(titulo, artista);
		if (indice != prox) {
			existe = true;
			System.out.println("A MUSICA EXISTE!");
		} else {
			System.out.println("A MUSICA NAO EXISTE!");
		}
		return existe;
	}

	public Musica procurar(String titulo, String artista) {
		int msearch = this.procurarIndice(titulo, artista);
		Musica resultado = null;
		if (msearch != this.prox) {
			resultado = this.musicas[msearch];
			System.out.printf("A MUSICA FOI ENCONTRADA: %s - %s", titulo, artista);
		} else {
			System.out.println("A MUSICA NAO FOI ENCONTRADA.");
		}
		return resultado;
	}

	public String retornarMusicas() {
		String resultado0 = "";
		String resultado1 = "";
		String resultado2 = "";
		String resultado3 = "";
		String resultadofinal = "";
		int i;
		for (i = 0; i < prox; i++) {
			if (resultado0 == "") {
				resultado0 = "\nMusica 1: " + musicas[i].toString();
			} else if (resultado1 == "") {
				resultado1 = "\nMusica 2: " + musicas[i].toString();
			} else if (resultado2 == "") {
				resultado2 = "\nMusica 3: " + musicas[i].toString();
			} else if (resultado3 == "") {
				resultado3 = "\nMusica 4: " + musicas[i].toString();
			}

		}
		resultadofinal = resultado0 + resultado1 + resultado2 + resultado3;
		return resultadofinal;
	}

	public void call() {
		int i = 0;
		CustomPlayer player = new CustomPlayer();
		String escolhaMusica;
		escolhaMusica = JOptionPane.showInputDialog(retornarMusicas());

		switch (escolhaMusica) {
		case "1":
			player.Play(musicas[i]);
			break;
		case "2":
			player.Play(musicas[1]);
			break;
		case "3":
			player.Play(musicas[2]);
			break;
		case "4":
			player.Play(musicas[3]);
			break;
		default:
			System.out.println("A MUSICA NAO EXISTE!");
		}

	}

	public void printar(Musica m) {
		try {
			JOptionPane.showMessageDialog(null, m.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
