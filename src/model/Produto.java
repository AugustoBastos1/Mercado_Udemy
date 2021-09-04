package model;

import helper.Utils;

/**
 * Classe Produto e seus atributos
 */
public class Produto {
	private static int contador = 1;
	private int id;
	private String nome;
	private Double preco;
	
	
	
	/**
	 * Metodo construtor da classe Produto
	 */
	public Produto(String nome, Double preco) {
		this.id = contador;
		this.nome = nome;
		this.preco = preco;
		contador ++;
	}
	
	/*
	 * Getters e Setters dos atributos
	 */
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	/**
	 * Sobrescrita do metodo "To String" de um objeto do tipo Produto
	 */
	public String toString() {
		return "ID: " + this.getId() + "\nNome: " + this.getNome() + "\nPreço: " + Utils.double_string(this.getPreco());
	}
	

}
