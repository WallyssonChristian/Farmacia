package farmacia.model;

public class Cosmetico extends Produto {

	private String fragancia;
	
	public Cosmetico(int id, int tipo, String nome, float preco, String fragancia) {
		super(id, tipo, nome, preco);
		this.fragancia = fragancia;
	}

	public String getFragancia() {
		return fragancia;
	}

	public void setFragancia(String fragancia) {
		this.fragancia = fragancia;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Fragancia: " + this.fragancia);
	}

}
