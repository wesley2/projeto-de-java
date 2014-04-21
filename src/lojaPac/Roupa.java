package lojaPac;

public class Roupa {
	private String nome;
	private String marca;
	private int quantidade;
	private double valor;
	private String cor;
	private int codigo;
	private int desconto;
	private static int geradorDeCodigo=0;
	
	public Roupa(String nome, String marca,int quantidade, double valor, String cor) {
		this.nome = nome;
		this.marca = marca;
		this.quantidade = quantidade;
		this.valor = valor;
		this.cor = cor;
		codigo = geradorDeCodigo;
		geradorDeCodigo++;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public boolean equals(Roupa roupa){//----------------------testar
		if(
				this.codigo == roupa.getCodigo() &&
				this.marca.equalsIgnoreCase(roupa.getMarca()) &&
				this.cor.equalsIgnoreCase(roupa.getCor()) &&
				this.nome.equalsIgnoreCase(roupa.getNome()) &&
				this.quantidade == roupa.getQuantidade() &&
				this.valor == roupa.getValor() &&
				this.desconto == roupa.getDesconto()
				){
			return true;
		}
		return false;
	}
	public void adicionarDesconto(int desconto){
		this.desconto = desconto;
	}
	public void removerDesconto(){
		desconto = 0;
	}

	public int getDesconto() {
		return desconto;
	}

	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValor() {
		return valor - ((desconto/100)*valor);
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public static void setGeradorDeCodigo(int geradorDeCodigo) {
		Roupa.geradorDeCodigo = geradorDeCodigo;
	}
}
