package farmacia.model;

public class Medicamento extends Produto {

	private String generico;
	
	public Medicamento(int id, int tipo, String nome, float preco, String generico) {
		super(id, tipo, nome, preco);
		this.generico = generico;
	}

	public String getGenerico() {
		return generico;
	}

	public void setGenerico(String generico) {
		this.generico = generico;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Generico: " + this.generico);
	}

}
