package lojaPac;
import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class LojaRoupasTeste {
	private Loja loja;
	private Caixa caixa;
	private Carrinho carrinho;
	private Roupa roupa1;
	private Roupa roupa2;
	private Roupa roupa3;
	private Cliente cliente1;
	private Cliente cliente2;
	private Cliente cliente3;
	
	@Before
	public void iniciarTestes(){
		loja = new Loja(150, 150);
		caixa = new Caixa();	
		carrinho = new Carrinho(150);
		Roupa.setGeradorDeCodigo(0);
		roupa1 = new Roupa("Blusa", "hollinter", 3, 30.80, "azul");
		roupa2 = new Roupa("calça", "calvin klein", 20, 70.00, "preta");
		roupa3 = new Roupa("short", "must", 4, 65.90, "rosa");
		cliente1 = new Cliente("camila", "08822381327");
		cliente2 = new Cliente("marcelo", "66151888642");
		cliente3 = new Cliente("adriana", "20747825513");		
	}
	@Test
	public void testCriarLoja(){
		Assert.assertTrue(loja.getCaixa() != null);
		Assert.assertTrue(loja.getClientes() != null);
		Assert.assertTrue(loja.getRoupas() != null);
		Assert.assertEquals(loja.getClientes().length, 150);
		Assert.assertEquals(loja.getRoupas().length, 150);
	}
	
	@Test
	public void criarCaixa(){
		Assert.assertTrue(caixa != null);
		Assert.assertEquals(caixa.getSaldo(), 0.0);
	}
	
	@Test
	public void criarCarrinho(){
		Assert.assertTrue(carrinho != null);
		Assert.assertEquals(carrinho.getValorTotal(), 0.0);
		Assert.assertTrue(carrinho.getRoupas() != null);
	}
	@Test
	public void testarEqualsCarrinho(){
		Carrinho c = new Carrinho(12);
		Assert.assertTrue(carrinho.equals(carrinho));
		Assert.assertFalse(carrinho.equals(c));
	}
	@Test
	public void criarRoupa(){
		Assert.assertTrue(roupa1.getNome().equalsIgnoreCase("Blusa"));
		Assert.assertTrue(roupa1.getCor().equalsIgnoreCase("azul"));
		Assert.assertEquals(roupa1.getQuantidade(), 3);
		Assert.assertEquals(roupa1.getValor(), 30.80);
		Assert.assertEquals(roupa1.getCodigo(), 0);
		
		Assert.assertTrue(roupa2.getNome().equalsIgnoreCase("calça"));
		Assert.assertTrue(roupa2.getCor().equalsIgnoreCase("preta"));
		Assert.assertEquals(roupa2.getQuantidade(), 20);
		Assert.assertEquals(roupa2.getValor(), 70.00);
		Assert.assertEquals(roupa2.getCodigo(), 1);
		
		Assert.assertTrue(roupa3.getNome().equalsIgnoreCase("short"));
		Assert.assertTrue(roupa3.getCor().equalsIgnoreCase("rosa"));
		Assert.assertEquals(roupa3.getQuantidade(), 4);
		Assert.assertEquals(roupa3.getValor(), 65.90);
		Assert.assertEquals(roupa3.getCodigo(), 2);
	}
	@Test
	public void testarEqualsRoupa(){
		Assert.assertTrue(roupa1.equals(roupa1));
		Assert.assertTrue(roupa2.equals(roupa2));
		Assert.assertTrue(roupa3.equals(roupa3));
		Assert.assertFalse(roupa1.equals(roupa2));
		Assert.assertFalse(roupa2.equals(roupa3));
		Assert.assertFalse(roupa1.equals(roupa3));
	}
	
	@Test
	public void cliarCliente(){
		Assert.assertTrue(cliente1 != null);
		Assert.assertTrue(cliente1.getNome().equalsIgnoreCase("camila"));
		Assert.assertTrue(cliente1.getCpf().equalsIgnoreCase("08822381327"));
		Assert.assertTrue(cliente1.getCarrinho() != null);
		Assert.assertTrue(cliente2 != null);
		Assert.assertTrue(cliente2.getNome().equalsIgnoreCase("marcelo"));
		Assert.assertTrue(cliente2.getCpf().equalsIgnoreCase("66151888642"));
		Assert.assertTrue(cliente2.getCarrinho() != null);
		Assert.assertTrue(cliente3 != null);
		Assert.assertTrue(cliente3.getNome().equalsIgnoreCase("adriana"));
		Assert.assertTrue(cliente3.getCpf().equalsIgnoreCase("20747825513"));
		Assert.assertTrue(cliente3.getCarrinho() != null);
	}
	@Test
	public void testarEqualsCliente(){
		Assert.assertTrue(cliente1.equals(cliente1));
		Assert.assertTrue(cliente2.equals(cliente2));
		Assert.assertTrue(cliente3.equals(cliente3));
		Assert.assertFalse(cliente1.equals(cliente2));
		Assert.assertFalse(cliente1.equals(cliente3));
		Assert.assertFalse(cliente2.equals(cliente3));
	}
	
	@Test
	public void cadastrarRoupa(){
		loja.cadastrarRoupas(roupa1);
		loja.cadastrarRoupas(roupa2);
		loja.cadastrarRoupas(roupa3);
		Assert.assertTrue(loja.getRoupas()[0].equals(roupa1));
		Assert.assertTrue(loja.getRoupas()[1].equals(roupa2));
		Assert.assertTrue(loja.getRoupas()[2].equals(roupa3));
	}
	@Test
	public void removerRoupa(){
		loja.cadastrarRoupas(roupa1);
		loja.cadastrarRoupas(roupa2);
		loja.cadastrarRoupas(roupa3);
		loja.removerRoupa(1);
		Assert.assertTrue(loja.getRoupas()[0].equals(roupa1));
		Assert.assertEquals(loja.getRoupas()[1], null);
		Assert.assertTrue(loja.getRoupas()[2].equals(roupa3));
	}
	@Test
	public void cadastroAposRemocao(){
		loja.cadastrarRoupas(roupa1);
		loja.cadastrarRoupas(roupa2);
		loja.removerRoupa(0);
		Assert.assertEquals(loja.getRoupas()[0], null);
		loja.cadastrarRoupas(roupa1);
		Assert.assertTrue(loja.getRoupas()[0].equals(roupa1));
	}
	
	@Test
	public void cadastrarCliente(){
		loja.cadastrarCliente(cliente1);
		loja.cadastrarCliente(cliente2);
		loja.cadastrarCliente(cliente3);
		Assert.assertTrue(loja.getClientes()[0].equals(cliente1));
		Assert.assertTrue(loja.getClientes()[0].getCarrinho() != null);
		Assert.assertTrue(loja.getClientes()[1].equals(cliente2));
		Assert.assertTrue(loja.getClientes()[1].getCarrinho() != null);
		Assert.assertTrue(loja.getClientes()[2].equals(cliente3));
		Assert.assertTrue(loja.getClientes()[2].getCarrinho() != null);
	}
	@Test
	public void removerCliente(){
		loja.cadastrarCliente(cliente1);
		loja.cadastrarCliente(cliente2);
		loja.cadastrarCliente(cliente3);
		loja.removerCliente(cliente2.getCpf());
		Assert.assertEquals(loja.getClientes()[0], cliente1);
		Assert.assertEquals(loja.getClientes()[1], null);
		Assert.assertEquals(loja.getClientes()[2], cliente3);
	}
	@Test
	public void cadastrarClienteAposRemocao(){
		loja.cadastrarCliente(cliente1);
		loja.cadastrarCliente(cliente2);
		loja.removerCliente(cliente1.getCpf());
		Assert.assertEquals(loja.getClientes()[0], null);
		loja.cadastrarCliente(cliente1);
		Assert.assertEquals(loja.getClientes()[0], cliente1);
	}
	
	@Test
	public void buscarCliente() throws BuscaInvalidaException{
		loja.cadastrarCliente(cliente1);
		loja.cadastrarCliente(cliente2);
		loja.cadastrarCliente(cliente3);
		Assert.assertTrue(loja.buscarCliente("08822381327").equals(cliente1));
		Assert.assertTrue(loja.buscarCliente("66151888642").equals(cliente2));
		Assert.assertTrue(loja.buscarCliente("20747825513").equals(cliente3));
	}
	@Test(expected = BuscaInvalidaException.class)
	public void buscarClienteExeception() throws BuscaInvalidaException{
		loja.cadastrarCliente(cliente1);
		loja.buscarCliente("00000000000");
	}
	@Test
	public void buscarRoupa() throws BuscaInvalidaException{
		loja.cadastrarRoupas(roupa2);
		loja.cadastrarRoupas(roupa3);
		loja.cadastrarRoupas(roupa1);
		Assert.assertTrue(loja.buscarRoupa(1).equals(roupa2));
		Assert.assertTrue(loja.buscarRoupa(2).equals(roupa3));
		Assert.assertTrue(loja.buscarRoupa(0).equals(roupa1));
	}
	@Test
	public void buscarRoupaPNomeMarca() throws BuscaInvalidaException{
		loja.cadastrarRoupas(roupa2);
		loja.cadastrarRoupas(roupa3);
		loja.cadastrarRoupas(roupa1);
		Assert.assertTrue(loja.buscarRoupa("calça", "calvin klein").equals(roupa2));
		Assert.assertTrue(loja.buscarRoupa("short", "must").equals(roupa3));
		Assert.assertTrue(loja.buscarRoupa("Blusa","hollinter").equals(roupa1));
	}
	@Test(expected = BuscaInvalidaException.class)
	public void buscarRoupaException() throws BuscaInvalidaException{
		loja.cadastrarRoupas(roupa1);
		loja.buscarRoupa(4);
		loja.buscarRoupa("short", "must");
	}
	
	@Test
	public void adicionarCompra() throws BuscaInvalidaException{
		loja.cadastrarCliente(cliente1);
		loja.cadastrarCliente(cliente2);
		loja.cadastrarCliente(cliente3);
		loja.cadastrarRoupas(roupa2);
		loja.cadastrarRoupas(roupa3);
		loja.cadastrarRoupas(roupa1);
		loja.adicionarCompra(cliente1.getCpf(), 1, 2);
		Assert.assertEquals(loja.getClientes()[0].getCarrinho().getValorTotal(),roupa2.getValor()*2 );
		Assert.assertEquals(loja.getClientes()[0].getCarrinho().getRoupas()[0],roupa2);
		Assert.assertEquals(loja.getRoupas()[0].getQuantidade(),18);
		loja.adicionarCompra(cliente2.getCpf(), 0, 1);
		Assert.assertEquals(loja.getClientes()[1].getCarrinho().getValorTotal(),roupa1.getValor() );
		Assert.assertEquals(loja.getClientes()[1].getCarrinho().getRoupas()[0],roupa1);
		Assert.assertEquals(loja.getRoupas()[2].getQuantidade(),2);
		loja.adicionarCompra(cliente2.getCpf(), 1, 1);
		Assert.assertEquals(loja.getClientes()[1].getCarrinho().getValorTotal(),roupa2.getValor()+roupa1.getValor());
		Assert.assertEquals(loja.getClientes()[1].getCarrinho().getRoupas()[1],roupa2);
		Assert.assertEquals(loja.getRoupas()[0].getQuantidade(),17);
		loja.adicionarCompra(cliente3.getCpf(), 2, 4);
		Assert.assertEquals(loja.getClientes()[2].getCarrinho().getValorTotal(),roupa3.getValor()*4);
		Assert.assertEquals(loja.getClientes()[2].getCarrinho().getRoupas()[0],roupa3);
		Assert.assertEquals(loja.getRoupas()[1].getQuantidade(),0);
	}
	
	@Test
	public void retirarDoCarrinho() throws BuscaInvalidaException{
		loja.cadastrarCliente(cliente3);
		loja.cadastrarRoupas(roupa2);
		loja.cadastrarRoupas(roupa3);
		loja.adicionarCompra(cliente3.getCpf(), 1, 10);
		Assert.assertEquals(loja.getRoupas()[0].getQuantidade(), 10);
		loja.adicionarCompra(cliente3.getCpf(), 2, 4);
		Assert.assertEquals(loja.getRoupas()[1].getQuantidade(), 0);
		loja.retirarItem(cliente3.getCpf(), 1, 5);
		Assert.assertEquals(loja.getClientes()[0].getCarrinho().getRoupas()[0], null);
		Assert.assertEquals(loja.getRoupas()[0].getQuantidade(), 15);
		loja.retirarItem(cliente3.getCpf(), 2, 4);
		Assert.assertEquals(loja.getClientes()[0].getCarrinho().getRoupas()[1], null);
		Assert.assertEquals(loja.getRoupas()[1].getQuantidade(), 4);
	}
	@Test
	public void adicionarDesconto(){
		Assert.assertEquals(roupa1.getDesconto(), 0);
		Assert.assertEquals(roupa2.getDesconto(), 0);
		Assert.assertEquals(roupa3.getDesconto(), 0);
		roupa1.adicionarDesconto(10);
		roupa2.adicionarDesconto(20);
		roupa3.adicionarDesconto(50);
		Assert.assertEquals(roupa1.getDesconto(), 10);
		Assert.assertEquals(roupa2.getDesconto(), 20);
		Assert.assertEquals(roupa3.getDesconto(), 50);
	}
	@Test
	public void removerDesconto(){
		roupa1.adicionarDesconto(10);
		roupa2.adicionarDesconto(20);
		roupa3.adicionarDesconto(50);
		roupa1.removerDesconto();
		roupa2.removerDesconto();
		roupa3.removerDesconto();
		Assert.assertEquals(roupa1.getDesconto(), 0);
		Assert.assertEquals(roupa2.getDesconto(), 0);
		Assert.assertEquals(roupa3.getDesconto(), 0);
	}
	@Test
	public void compraComDesconto() throws BuscaInvalidaException{
		loja.cadastrarCliente(cliente1);
		loja.cadastrarCliente(cliente2);
		loja.cadastrarCliente(cliente3);
		roupa1.adicionarDesconto(10);
		roupa2.adicionarDesconto(20);
		roupa3.adicionarDesconto(50);
		loja.cadastrarRoupas(roupa1);
		loja.cadastrarRoupas(roupa2);
		loja.cadastrarRoupas(roupa3);
		loja.adicionarCompra(cliente1.getCpf(), 2, 1);
		loja.adicionarCompra(cliente2.getCpf(), 1, 2);
		loja.adicionarCompra(cliente3.getCpf(), 0, 3);
		Assert.assertEquals(cliente1.getCarrinho().getValorTotal(), (roupa3.getValor())-((50/100)*roupa3.getValor()));
		Assert.assertEquals(cliente2.getCarrinho().getValorTotal(), (2*roupa2.getValor())-(2*((20/100)*roupa2.getValor())));
		Assert.assertEquals(cliente3.getCarrinho().getValorTotal(), (3*roupa1.getValor())-(3*((10/100)*roupa1.getValor())));
	}
	
	@Test
	public void feharCompra() throws BuscaInvalidaException{
		loja.cadastrarCliente(cliente3);
		loja.cadastrarRoupas(roupa2);
		loja.cadastrarRoupas(roupa3);
		loja.adicionarCompra(cliente3.getCpf(), 1, 10);
		loja.adicionarCompra(cliente3.getCpf(), 2, 4);
		loja.getCaixa().fecharPagamento(cliente3, 700.00);
		Assert.assertEquals(loja.getClientes()[0].getCarrinho().getValorTotal(), 4*roupa3.getValor());
		Assert.assertEquals(loja.getCaixa().getSaldo(), 700.00);
	}
	@Test
	public void fecharCompraComDesconto() throws BuscaInvalidaException{
		double valor = 5*(roupa2.getValor() - ((20/100)*roupa2.getValor()));
		loja.cadastrarCliente(cliente2);
		roupa2.adicionarDesconto(20);
		loja.cadastrarRoupas(roupa2);
		loja.adicionarCompra(cliente2.getCpf(), 1, 5);
		loja.getCaixa().fecharPagamento(cliente2, valor);
		Assert.assertEquals(loja.getCaixa().getSaldo(), valor);
		Assert.assertEquals(loja.getClientes()[0].getCarrinho().getValorTotal(), 0.0);
	}
}