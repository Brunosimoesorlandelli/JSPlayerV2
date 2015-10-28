package home.negocio;

public interface IRepositorio {

	public boolean existe(String x, String y);

	public void remover(String x, String y);

	public int procurarIndice(String x, String y);
}
