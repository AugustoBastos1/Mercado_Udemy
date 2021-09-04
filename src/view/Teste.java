package view;

import model.Produto;

public class Teste {

	public static void main(String[] args) {
		Produto prod = new Produto("GTA V", 79.99);
		Produto prod2 = new Produto("RDR 2", 99.99);
		
		System.out.println(prod);
		System.out.println(prod2);

	}

}
