package farmacia.repository;

import farmacia.model.Produto;

public interface ProdutoRepository {
	
	// CRUD da Farmacia
	public void cadastrarProduto(Produto produto);
	public void listarTodosProdutos();
	public void consultarProduto(int id);
	public void atualizarProduto(Produto produto);
	public void deletarProduto(int id);
}
