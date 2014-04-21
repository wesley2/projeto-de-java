package lojaPac;
public class Cliente{
	private String nome;
	private String cpf;
	protected Carrinho carrinho;
	
	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		carrinho = new Carrinho(150);
	}
	
	public boolean equals(Cliente cliente){
		if(
				this.cpf.equalsIgnoreCase(cliente.getCpf()) &&
				this.nome.equalsIgnoreCase(cliente.getNome()) &&
				this.carrinho.equals(cliente.getCarrinho())){
			return true;
			
		}
		return false;
	}

	
	
	public Carrinho getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
