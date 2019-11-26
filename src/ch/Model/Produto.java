package ch.Model;

public class Produto {
	private int idProduto;
	private String nome;
	private String descricao;
	private double preco;
	
	public Produto() {

	}
	
	public Produto(String nome) {
		this.nome = nome;
	}

	public Produto(int idProduto, String nome, String descricao, double preco) {
		this.idProduto = idProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return this.getNome();
	}
	
	
}
