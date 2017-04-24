import java.util.*;
public class Banco {
	private String nome_banco;
	private List<ContaCorrente> corrente;
	private List<Poupanca> poupanca;
	
	public Banco(String nome_banco, List<ContaCorrente> corrente, List<Poupanca> poupanca) {
		super();
		this.nome_banco = nome_banco;
		this.corrente = corrente;
		this.poupanca = poupanca;
	}
	public String getNome_banco() {
		return nome_banco;
	}
	public void setNome_banco(String nome_banco) {
		this.nome_banco = nome_banco;
	}
	public List<ContaCorrente> getCorrente() {
		return corrente;
	}
	public void setCorrente(List<ContaCorrente> corrente) {
		this.corrente = corrente;
	}
	public List<Poupanca> getPoupanca() {
		return poupanca;
	}
	public void setPoupanca(List<Poupanca> poupanca) {
		this.poupanca = poupanca;
	}
}
