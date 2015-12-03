package home.negocio.beans;

import java.io.Serializable;

public class Musica implements Serializable {

	private String titulo;
	private String artista;
	private String album;
	private Object ano;
	private String genero;
	private String endereco;

	public Musica(String titulo, String artista, String endereco) {
		this.titulo = titulo;
		this.artista = artista;
		this.endereco = endereco;
	}

	public Musica(String titulo, String artista, String album, Object ano, String genero, String endereco) {
		this.titulo = titulo;
		this.artista = artista;
		this.album = album;
		this.ano = ano;
		this.genero = genero;
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "\nTitulo: " + titulo + "\nArtista: " + artista + "\nAlbum: " + album + "\nAno: " + ano + "\nGenero: "
			    + genero + "\nEndereco: " + endereco;
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

	public Object getAno() {
		return ano;
