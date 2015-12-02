package home.dados;

import java.io.Serializable;

import home.negocio.beans.Musica;
import home.negocio.beans.Playlist;

public class RepositorioPlaylistArray implements IRepositorioPlaylist, Serializable{

		private Playlist[] playlists;
		private int prox;

		public RepositorioPlaylistArray(int tamanho) {
			this.playlists = new Playlist[tamanho];
			this.prox = 0;
		}

		public void cadastrar(Playlist list) {
			this.playlists[this.prox] = list;
			if (list.getNomeP().equals(this.playlists[this.prox].getNomeP())) {
				this.prox = this.prox + 1;
				if (this.prox == this.playlists.length) {
					this.duplicaArrayPlaylist();
				}
				System.out.println("A PLAYLIST FOI CRIADA COM SUCESSO!");
			} else {

			}
			
		}

		private void duplicaArrayPlaylist() {
			if (this.playlists != null && this.playlists.length > 0) {
				Playlist[] arrayDuplicado = new Playlist[this.playlists.length * 2];
				for (int i = 0; i < this.playlists.length; i++) {
					arrayDuplicado[i] = this.playlists[i];
				}
				this.playlists = arrayDuplicado;
			}
		}
		
		
		public int procurarIndice(String nomeP) {
			int i = 0;
			boolean achou = false;
			while ((!achou) && (i < this.prox)) {
				if (nomeP.equals(this.playlists[i].getNomeP())) {
					achou = true;
				} else {
					i++;
				}
			}
			return i;
		}
		
		public void remover(String nomeP) {
			int i = this.procurarIndice(nomeP);
			if (i != this.prox) {
				this.playlists[i] = this.playlists[this.prox - 1];
				this.playlists[this.prox - 1] = null;
				this.prox = this.prox - 1;
				System.out.println("A PLAYLIST FOI REMOVIDA!");
			} else {
				System.out.println("ERRO, A PLAYLIST NAO PODE SER REMOVIDA");
			}
		}

		public boolean existe(String nomeP) {
			boolean existe = false;
			int indice = this.procurarIndice(nomeP);
			if (indice != prox) {
				existe = true;
				System.out.println("A PLAYLIST EXISTE!");
			} else {
				System.out.println("A PLAYLIST NAO EXISTE!");
			}
			return existe;
		}
		
		public String[] retornarPlaylist() {
			int i = 0;
			String[] listaPlaylist = new String[0];
			for (Playlist p : playlists) {
				if (p != null) {
					String[] listaPlaylist2 = new String[listaPlaylist.length + 1];
					for (int h = 0; h < listaPlaylist.length; h++) {
						listaPlaylist2[h] = listaPlaylist[h];
					}
					listaPlaylist = listaPlaylist2;
					listaPlaylist[i] = p.getNomeP();
				}
				i++;
			}
			return listaPlaylist;
		}
		
		public Playlist procurar(String nomeP) {
			int psearch = this.procurarIndice(nomeP);
			Playlist resultado = null;
			if (psearch != this.prox) {
				resultado = this.playlists[psearch];
				System.out.printf("A PLAYLIST FOI ENCONTRADA: %s", nomeP);
			} else {
				System.out.println("A PLAYLIST NAO FOI ENCONTRADA.");
			}
			return resultado;
		}
		

		
	}

