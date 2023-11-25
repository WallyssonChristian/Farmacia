package farmacia;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

	final static String line = ("=================================");
	
	public static Scanner read = new Scanner(System.in);
	public static void main(String[] args) {
		
		int op;
		
		do {
			System.out.println(line);
			System.out.println("Farmacia Pau Brasil");
			System.out.println(line);
			System.out.println("1- Criar Produto");
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
				System.out.println("\n Criar Produto");
				keyPress();
				break;
			case 2:
				System.out.println("\n Listar Todos os Produtos");
				keyPress();
				break;
			case 3:
				System.out.println("\n Consultar Produto por ID");
				keyPress();
				break;
			case 4:
				System.out.println("\n Atualizar Produto");
				keyPress();
				break;
			case 5:
				System.out.println("\n Deletar Produto");
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
		System.out.println("Volte sempre !!");
		System.out.println("Projeto Desenvolvido por: Wallysson Araujo          ");
		System.out.println("wallysson.christian@outlook.com                     ");
		System.out.println("github.com/WallyssonChristian                       ");
	}

}
