package Model;

public class Funcionario {
	private int ID;
	private double salario;
	private String nome;
	private String Usuario;
	private String Senha;
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getUsuario() {
		return Usuario;
	}
	
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	
	public String getSenha() {
		return Senha;
	}
	
	public void setSenha(String senha) {
		Senha = senha;
	}
	
}
