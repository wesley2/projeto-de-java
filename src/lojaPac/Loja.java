package lojaPac;

public class Loja {
	private Cliente[] clientes;
	private Roupa[] roupas;
	private Caixa caixa;
	
	
	public Loja(int qtdClientes, int qtdRoupas) {
		clientes = new Cliente[qtdClientes];
		roupas = new Roupa[qtdRoupas];
		caixa = new Caixa();
	}
	
	public void feharCompra(String cpf, double dinheiro) throws BuscaInvalidaException{
		Cliente cliente = buscarCliente(cpf);
		this.caixa.fecharPagamento(cliente, dinheiro);
	}
	
	public void retirarItem(String cpf, int codigoDaRoupa,int quantidade) throws BuscaInvalidaException{
		Cliente c = buscarCliente(cpf);
		c.getCarrinho().apagarItem(buscarRoupa(codigoDaRoupa), quantidade);
	}
	
	public void adicionarCompra(String cpf, int codigoDaRoupa, int quantidade) throws BuscaInvalidaException{
		Cliente c = buscarCliente(cpf);
		c.getCarrinho().adicionarItem(buscarRoupa(codigoDaRoupa), quantidade);
	}
	
	public Roupa buscarRoupa(String nome, String marca) throws BuscaInvalidaException{
		int i = 0;
		while(i < roupas.length){
			if(roupas[i] != null && roupas[i].getNome().equalsIgnoreCase(nome) && roupas[i].getMarca().equalsIgnoreCase(marca)){
				return roupas[i];
			}i++;
		}
		throw new BuscaInvalidaException("Roupa não existente no estoque!");
	}
	
	public Roupa buscarRoupa(int codigo) throws BuscaInvalidaException{
		int i = 0;
		while(i < roupas.length){
			if(roupas[i] != null && roupas[i].getCodigo() == codigo){
				return roupas[i];
			}i++;
		}
		throw new BuscaInvalidaException("Roupa não existente no estoque!");
	}
	
	public Cliente buscarCliente(String cpf) throws BuscaInvalidaException{
		int i = 0;
		while(i < clientes.length){
			if(clientes[i] != null && clientes[i].getCpf().equalsIgnoreCase(cpf)){
				return clientes[i];
			}i++;
		}
		throw new BuscaInvalidaException("Cliente não existente!");
	}
	
	public void cadastrarRoupas(Roupa roupa){
		int i = 0;
		while(i < roupas.length){
			if(roupas[i] == null){
				roupas[i] = roupa;
				return;
			}i++;
		}
		
	}
	public void removerRoupa(int id){
		int i = 0;
		while(i < roupas.length){
			if(roupas[i].getCodigo() == id){
				roupas[i] = null;
				return;
			}
			i++;
		}
	}
	public void removerCliente(String cpf){
		int i = 0;
		while(i < clientes.length){
			if(clientes[i].getCpf().equals(cpf)){
				clientes[i] = null;
				return;
			}
			i++;
		}
	}
	
	public Cliente[] getClientes() {
		return clientes;
	}

	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}

	public Roupa[] getRoupas() {
		return roupas;
	}

	public void setRoupas(Roupa[] roupas) {
		this.roupas = roupas;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public void cadastrarCliente(Cliente cliente){
		int i = 0;
		while(i < clientes.length){
			if(clientes[i] == null){
				clientes[i] = cliente;
				return;
			}i++;
		}
	}
	
}
