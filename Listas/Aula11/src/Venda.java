import java.util.*;
public class Venda {
	private int intSell_ID;
	private float floatValor;	
	private List<Produto> produto;
	private Comprador comprador;
	private Vendedor vendedor;
	public Venda(int intSell_ID, List<Produto> produto, Comprador comprador, Vendedor vendedor) {
		this.intSell_ID = intSell_ID;
		this.comprador = comprador;
		this.vendedor = vendedor;
		this.produto = new ArrayList<>();
		this.produto = produto;
	}
	public int getIntSell_ID() {
		return intSell_ID;
	}
	public void setIntSell_ID(int intSell_ID) {
		this.intSell_ID = intSell_ID;
	}
	public float getFloatValor() {
		return floatValor;
	}
	public void setFloatValor(float floatValor) {
		this.floatValor = floatValor;
	}
	public List<Produto> getProduto() {
		return produto;
	}
	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	public Comprador getComprador() {
		return comprador;
	}
	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
}
