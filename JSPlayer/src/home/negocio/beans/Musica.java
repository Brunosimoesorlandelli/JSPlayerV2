package home.negocio.beans;

import java.io.Serializable;

public class Musica implements Serializable, Comparable<Musica> {

	private String titulo;
	private String artista;
	private String album;
	private String ano;
	private String genero;
	private String endereco;
	private int minutos;
	private int segundos;

	public Musica(String titulo, String artista, String endereco) {
		this.titulo = titulo;
		this.artista = artista;
		this.endereco = endereco;
	}

	public Musica(String titulo, String artista, int minutos, int segundos) {
		this.titulo = titulo;
		this.artista = artista;
		this.minutos = minutos;
		this.segundos = segundos;
	}
	/*
	 * public Musica(String titulo, String artista, String album, String ano,
	 * String genero, String endereco) {
	 * 
	 * this.titulo = titulo; this.artista = artista; this.album = album;
	 * this.ano = ano; this.genero = genero; this.endereco = endereco;
	 * 
	 * }
	 */

	@Override
	public String toString() {
		return "\nTitulo:" + titulo + "\nArtista:" + artista + "\nEndereco:" + endereco;
	}

	public int getMinutos() {
		return minutos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getArtista() {
		return artista;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getAlbum() {
		return album;
	}

	public String getAno() {
		return ano;
	}

	public String getGenero() {
		return genero;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public boolean equals(Object o) {
		if (o instanceof Musica) {
			Musica s = (Musica) o;
			if ((this.titulo.equals(s.titulo)) && (this.artista.equals(s.artista)) && (this.endereco.equals(s.endereco))){
				return true;
			} 
		}  return false;
			
	}
	
	@Override
	public int compareTo(Musica s) {
		int artistaCmp = artista.compareTo(s.artista);
		int tituloCmp = titulo.compareTo(s.titulo);
		int minutosCmp = (this.minutos - s.minutos > 0 ? 1 : 0);
		int segundosCmp = (this.segundos - s.segundos > 0 ? 1 : 0);

		if (artistaCmp == 0) {
			if (tituloCmp == 0) {
				if (minutosCmp == 0) {
					if (segundosCmp == 0) {
						return 0;
					} else
						return segundosCmp;
				} else
					return minutosCmp;
			} else
				return tituloCmp;

		} else
			return artistaCmp;

	}
}
