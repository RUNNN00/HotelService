package entities;

public class Hospede {
	String nome;
	String email;
	byte numQuarto;

	public Hospede(String nome, String email, byte numQuarto) {
		super();
		this.nome = nome;
		this.email = email;
		this.numQuarto = numQuarto;
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

	public byte getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(byte numQuarto) {
		this.numQuarto = numQuarto;
	}

	public String toString() {
		return "Nome: " + nome + "\nE-mail: " + email + "\nApto. " + numQuarto;
	}
}
