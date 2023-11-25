package farmacia;

import java.io.IOException;
import java.util.Scanner;

import farmacia.controller.ProdutoController;
import farmacia.model.*;

public class Menu {

	final static String line = ("=================================");
	
	public static Scanner read = new Scanner(System.in);
	public static void main(String[] args) {
		
		ProdutoController produtos = new ProdutoController();
		int op, id, tipo;
		String nome, generico, fragancia, confirm;
		float preco;
		
		do {
			System.out.println(line);
			System.out.println("Farmacia Pau Brasil");
			System.out.println(line);
			System.out.println("1- Cadastrar Produto");
			System.out.println("2- Listar Todos os Produtos");
			System.out.println("3- Consultar Produto por ID");
			System.out.println("4- Atualizar Produto");
			System.out.println("5- Deletar Produto");
			System.out.println("0- Sair");
			System.out.println(line);
			System.out.print("Entre com a opção desejada: ");
			op = read.nextInt();
			
			switch(op) {
			case 1:
				System.out.println("\n Cadastrar Produto\n");
				
				System.out.print("Digite o tipo do produto(1-Medicamento | 2-Cosmético): ");
				tipo = read.nextInt();
				
				System.out.print("Digite o nome do produto: ");
				read.skip("\\R?");
				nome = read.nextLine();
				
				System.out.print("Digite o preço do produto: ");
				preco = read.nextFloat();
				
				switch(tipo) {
				case 1:
					System.out.print("Digite o nome do generico do medicamento: ");
					read.skip("\\R?");
					generico = read.nextLine();
					produtos.cadastrarProduto(new Medicamento(produtos.gerarId(), tipo, nome, preco, generico));
					break;
				case 2:
					System.out.print("Digite o nome da fragancia do cosmetico: ");
					read.skip("\\R?");
					fragancia = read.nextLine();
					produtos.cadastrarProduto(new Cosmetico(produtos.gerarId(), tipo, nome, preco, fragancia));
					break;
				}
				keyPress();
				break;
				
				
			case 2:
				System.out.println("\n Listar Todos os Produtos\n");
				produtos.listarTodosProdutos();
				keyPress();
				break;
				
				
			case 3:
				System.out.println("\n Consultar Produto por ID\n");
				System.out.print("Digite o ID do produto: ");
				id = read.nextInt();
				produtos.consultarProduto(id);
				keyPress();
				break;
				
				
			case 4:
				System.out.println("\n Atualizar Produto\n");
				System.out.print("Digite o ID do produto: ");
				id = read.nextInt();
				
				if (produtos.buscarNaCollection(id).isPresent()) {
					System.out.println("Digite os novos dados do produto: \n");
					
					System.out.print("Digite o nome do produto: ");
					read.skip("\\R?");
					nome = read.nextLine();
					
					System.out.print("Digite o preço do produto: ");
					preco = read.nextFloat();
					
					tipo = produtos.retornaTipo(id);
					
					switch(tipo){
					case 1:
						System.out.print("Digite o nome do generico do medicamento: ");
						read.skip("\\R?");
						generico = read.nextLine();
						produtos.atualizarProduto(new Medicamento(id, tipo, nome, preco, generico));
						break;
					case 2:
						System.out.print("Digite o nome da fragancia do cosmetico: ");
						read.skip("\\R?");
						fragancia = read.nextLine();
						produtos.cadastrarProduto(new Cosmetico(id, tipo, nome, preco, fragancia));
						break;
						
					}
				}
				
				keyPress();
				break;
				
				
			case 5:
				System.out.println("\n Deletar Produto\n");
				System.out.print("Digite o ID do produto: ");
				id = read.nextInt();
				produtos.consultarProduto(id);
				System.out.println("\nAVISO");
				System.out.println("Tem certeza que deseja deletar o produto?");
				System.out.print("Esse processo não pode ser desfeito(S/N): ");
				read.skip("\\R?");
				confirm = read.nextLine();
				if (confirm.equalsIgnoreCase("S"))
					produtos.deletarProduto(id);
				else 
					System.out.println("Produto não deletada");
				keyPress();
				break;
			case 0:
				about();
				keyPress();
				break;
			default:
				System.out.println("Opção Inválida");
				
				keyPress();
				break;
			}
			
			
		} while (op != 0);
		
		
	}
	
	public static void keyPress() {
		try {
			System.out.println("\nPressione Enter para Continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
	
	public static void about() {
		System.out.println("\nVolte sempre !!");
		System.out.println("Projeto Desenvolvido por: Wallysson Araujo          ");
		System.out.println("wallysson.christian@outlook.com                     ");
		System.out.println("github.com/WallyssonChristian                       ");
	}

}
