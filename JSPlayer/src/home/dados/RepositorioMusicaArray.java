package home.dados;

import home.negocio.CustomPlayer;
import home.negocio.IRepositorio;
import home.negocio.Musica;

public class RepositorioMusicaArray implements IRepositorio{

	private Musica[] musicas;
	private int prox;

	public RepositorioMusicaArray(int tamanho) {
		this.musicas = new Musica[tamanho];
		this.prox = 0;
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

	public boolean existe(String titulo,String artista) {
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
	
	public void musicas(){
		Musica mus = new Musica("Hey Brother", "Avicii", "True", "2013", "EDM", "res/"+ "Avicii   Hey Brother (Lyric).mp3");
		musicas[0] = mus;
	}

	public void call(){
		CustomPlayer player = new CustomPlayer();
		System.out.println(musicas[0].toString());
		player.Play(musicas[0]);
		
	}
	
}
