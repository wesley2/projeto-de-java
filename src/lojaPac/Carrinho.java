package lojaPac;

public class Carrinho {
	private Roupa[] roupas;
	private double valorTotal;
	
	public Carrinho(int qtdRoupas) {
		roupas = new Roupa[qtdRoupas];
		valorTotal = 0.0;
	}
	
	
	public Roupa[] getRoupas() {
		return roupas;
	}

	public void setRoupas(Roupa[] roupas) {
		this.roupas = roupas;
	}
	
	public boolean equals(Carrinho carrinho){//------------------------------testar
		if(
				this.roupas.equals(carrinho.getRoupas()) &&
				this.valorTotal == carrinho.getValorTotal()){
			return true;
		}
		return false;
	}


	public void adicionarItem(Roupa roupa, int quantidade){
		int i = 0;
		while(i < roupas.length){
			if(roupas[i] == null){
				roupas[i] = roupa;
				valorTotal += quantidade * roupa.getValor();
				roupa.setQuantidade(roupa.getQuantidade()-quantidade);
				return;
			}
			i++;
		}
	}
	
	public void apagarItem(Roupa roupa, int quantidade){
		int i = 0;
		while(i < roupas.length){
			if(roupas[i] != null){
				if(roupas[i].getCodigo() == roupa.getCodigo()){
					roupas[i] = null;
					valorTotal -= quantidade * roupa.getValor();
					roupa.setQuantidade(roupa.getQuantidade() + quantidade);
					return;
				}
			}
			i++;
		}
	}


	public double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
}
