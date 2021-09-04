package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import helper.Utils;
import model.Produto;

public class Mercado {
	private static Scanner teclado = new Scanner(System.in);
	private static ArrayList<Produto> produtos;
	private static Map<Produto, Integer> carrinho;

	/**
	 * Inicia o sistema, e inicializa as duas listas de Produtos e Carrinho que serão usados
	 */
	public static void main(String[] args) {
		produtos = new ArrayList<Produto>();
		carrinho = new HashMap<Produto, Integer>();
		menu();

	}
	
	/**
	 * Menu inicial, apresenta as opções e chama a função conforme a opção desejada pelo usuario
	 */
	private static void menu() {
		System.out.println("==============================");
		System.out.println("=========Bem vindo(a)=========");
		System.out.println("========= Shop =========");
		System.out.println("==============================");
		System.out.println("Selecione uma opção abaixo: ");
		System.out.println("1-Cadastrar Produto");
		System.out.println("2-Listar Produtos");
		System.out.println("3-Comprar Produto");
		System.out.println("4-Visualizar Carrinho");
		System.out.println("5-Sair");
		int opcao = 0;
		try {
			opcao = Integer.parseInt(teclado.nextLine());
		}catch(InputMismatchException e) {
			menu();
		}catch(NumberFormatException f) {
			menu();
		}
		
		switch (opcao) {
		case 1:
			cadastrar_produto();
			break;
		case 2:
			listar_produtos();
			break;
		case 3:
			comprar_produtos();
			break;
		case 4:
			visualizar_carrinho();
			break;
		case 5:
			System.out.println("Volte sempre");
			Utils.pausar(2);
			System.exit(0);
		default:
			System.out.println("Opção invalida");
			Utils.pausar(2);
			menu();
			break;
		}
	}
	
	/**
	 * Função para cadastrar um produto, instancia um objeto do tipo Produto 
	 * e adiciona na lista de produtos
	 */
	private static void cadastrar_produto() {
		System.out.println("Cadastro de produto: ");
		System.out.println("---------------------");
		System.out.println("Digite o nome do produto: ");
		String nome = teclado.nextLine();
		System.out.println("Digite o preço do produto: ");
		Double preco = teclado.nextDouble();
		
		Produto produto = new Produto(nome, preco);
		produtos.add(produto);
		System.out.println("O produto " + produto.getNome() + " foi cadastrado com sucesso");
		Utils.pausar(2);
		menu();
	}
	
	/**
	 * Função para listar todos os produtos cadastrados na lista de produtos
	 */
	private static void listar_produtos() {
		if(produtos.size() > 0) {
			System.out.println("Listando produtos");
			System.out.println();
			
			for(Produto p : produtos) {
				System.out.println(p);
				System.out.println("---------------------");
			}
		}else {
			System.out.println("Ainda não existem produtos cadastrados");
		}
		Utils.pausar(2);
		menu();
	}
	
	/**
	 * Função para fazer uma compra de um produto, recebe o codigo do produto e adiciona 
	 * este produto ao carrinho
	 */
	private static void comprar_produtos() {
		if(produtos.size() > 0) {
			System.out.println("Digite o ID do produto desejado: ");
			System.out.println();
			System.out.println("========Produtos Disponiveis=========");
			for(Produto p : produtos) {
				System.out.println(p);
				System.out.println("---------------------");
			}
			
			int id = Integer.parseInt(teclado.nextLine());
			
			boolean contem = false;
			for(Produto p : produtos) {
				if (p.getId() == id) {
					int qtd = 0;
					try {
						qtd = carrinho.get(p);
						carrinho.put(p, qtd + 1);
					}catch(NullPointerException e) {
						carrinho.put(p, 1);
					}
					System.out.println("O Produto " + p.getNome() + " foi adicionado ao carrinho");
					contem = true;
				}else {
					System.out.println("Não foi encontrado o produto com ID " + id);
				}
				if (contem) {
					System.out.println("Deseja adicionar outro produto no carrinho (1-sim 0-não)");
					int opcao = Integer.parseInt(teclado.nextLine());
					if (opcao == 1) {
						comprar_produtos();
					}else {
						System.out.println("Aguarde enquanto fechamos seu pedido");
						Utils.pausar(2);
						fechar_pedido();
					}
				}
			}
			
		}else {
			System.out.println("Ainda não existem produtos cadastrados");
		}
		Utils.pausar(2);
		menu();
	}
	
	/**
	 * Função para finalizar um pedido, e esvaziar o carrinho
	 */
	private static void fechar_pedido() {
		Double valor_total = 0.0;
		System.out.println("Produtos no carrinho: ");
		System.out.println("----------------------");
		
		for(Produto p : carrinho.keySet()) {
			int qtd = carrinho.get(p);
			valor_total += p.getPreco() * qtd;
			System.out.println(p);
			System.out.println("Quantidade: " + qtd);
			System.out.println("----------------------");
		}
		System.out.println("Sua fatura é " + Utils.double_string(valor_total));
		carrinho.clear();
		System.out.println("Obrigado pela sua preferencia");
		Utils.pausar(3);
		menu();
	}
	
	/**
	 * Função para visualizar todos os produtos no carrinho e sua quantidade
	 */
	private static void visualizar_carrinho() {
		if(carrinho.size() > 0) {
			System.out.println("Produtos no carrinho");
			
			for(Produto p : carrinho.keySet()) {
				System.out.println("Produto: " + p + "\nQuantidade: " + carrinho.get(p));
			}
		}else {
			System.out.println("Ainda não existem produtos no carrinho");
		}
		Utils.pausar(2);
		menu();
	}
	
}
