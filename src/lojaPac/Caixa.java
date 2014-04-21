package lojaPac;

public class Caixa {
	private double saldo;
	
	public Caixa() {
		saldo = 0.0;
	}
	
	public void fecharPagamento(Cliente cliente, double dinheiro){
		cliente.getCarrinho().setValorTotal(cliente.getCarrinho().getValorTotal() - dinheiro);
		cliente.getCarrinho().setRoupas(new Roupa[100]);
		saldo += dinheiro;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
