package model.entities;

public class Hospede {
	String nome;
	String email;

	public Hospede(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return "Nome: " + nome + "\n"
				+ "E-mail: " + email;
	}
}
