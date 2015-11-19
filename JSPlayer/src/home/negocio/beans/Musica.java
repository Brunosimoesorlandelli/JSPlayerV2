package home.negocio.beans;

public class Musica {

	private String titulo, artista, album, ano, genero, endereco;
	
	public Musica(String titulo,String artista,String endereco){
		
		this.titulo = titulo;
		this.artista = artista;
		this.endereco = endereco;
		
	}
	public Musica(String titulo,String artista,String album, String ano, String genero, String endereco){
		
		this.titulo = titulo;
		this.artista = artista;
		this.album = album;
		this.ano = ano;
		this.genero = genero;
		this.endereco = endereco;
		
	}

	@Override
	public String toString() {
		return "\nTitulo:" + titulo + "\nArtista:" + artista;
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
	
	
}
