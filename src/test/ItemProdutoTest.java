package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import model.FactoryDAO;
import model.dao.ProdutoDAO;
import model.entity.ItemProduto;
import model.dao.ItemProdutoDAO;
import model.entity.Produto;

public class ItemProdutoTest {

	private ProdutoDAO produtoDAO = new ProdutoDAO();
	private Produto produto = new Produto();
	private List<Produto> produtos;

	private ItemProdutoDAO itemDAO = new ItemProdutoDAO();
	private ItemProduto item;
	private List<ItemProduto> itens;

	@Test
	public void test() {
		System.out.println("STARTED");

//		this.testSelector();

		 this.testFindAll();

		FactoryDAO.closeInstance();
	}

	private void testFindAll() {

		produtos = produtoDAO.findAll();
		if (produtos != null && produtos.size() <= 0) {
			adicionarProdutos();
			System.out.println("Adicionou Produtos");
			produtos = produtoDAO.findAll();
		}
		// assertNotNull("Produtos Adicionados", produtos);
		assertNotEquals(0, produtos.size());

		System.out.println("Todos os produtos cadastrados: \n" + produtos);

		System.out.println("--------------------------------------------");
		System.out.println("--------------------------------------------");

		itens = itemDAO.findAll();
		if (itens != null && itens.size() <= 0) {
			adicionarItens();
			System.out.println("Adicionou Itens");
			itens = itemDAO.findAll();
		}
		// assertNotNull("Itens Adicionados", itens);
		assertNotEquals(0, itens.size());

		this.testUpdateProduto();

		this.testDeleteItem();

		this.testUpdateItem();

		System.out.println("Todos os itens cadastrados: \n" + itens);

		System.out.println("--------------------------------------------");
		System.out.println("--------------------------------------------");

		// System.out.println(itens.get(0).get);
		produtos = null;
		produtos = produtoDAO.findAll();
		System.out.println("Após haver itens. Todos os produtos cadastrados: \n" + produtos);

		System.out.println("--------------------------------------------");
		System.out.println("--------------------------------------------");

	}

	private void adicionarProdutos() {
		Calendar c;

		c = Calendar.getInstance();
		c.set(2015, 0, 1);
		produto = new Produto("Milho", c);
		produtoDAO.save(produto);

		c = Calendar.getInstance();
		c.set(2017, 11, 31);
		produto = new Produto("Tapete", c);
		produtoDAO.save(produto);

		c = Calendar.getInstance();
		c.set(2018, 6, 15);
		produto = new Produto("Televisor", c);
		produtoDAO.save(produto);

	}

	private void testUpdateProduto() {

		Produto p = produtoDAO.findById(1L);
		p.setNome("Milho Verde");
		produtoDAO.update(p);
		assertEquals("Atualizou Produto", "Milho Verde", produtoDAO.findById(1L).getNome());
	}

	private void adicionarItens() {

		// item = new ItemProduto(produtoDAO.findById(1L), 30.00f, 500.00f, 3);
		item = new ItemProduto(produtos.get(0), 30.00f, 500.00f, 3);
		itemDAO.save(item);

		// item = new ItemProduto(produtoDAO.findById(3L), 20.00f, 350.00f, 5);
		item = new ItemProduto(produtos.get(2), 20.00f, 350.00f, 5);
		itemDAO.save(item);

		// item = new ItemProduto(produtoDAO.findById(2L), 10.00f, 188.99f, 2);
		item = new ItemProduto(produtos.get(1), 10.00f, 188.99f, 2);
		itemDAO.save(item);

		item = new ItemProduto();

	}

	private void testUpdateItem() {

		ItemProduto item = itemDAO.findById(1L);
		item.setQuantidadeProdutos(8888);
		itemDAO.update(item);

		assertEquals("Atualizou Item", String.valueOf(8888), itemDAO.findById(1L).getQuantidadeProdutos().toString());
	}

	private void testDeleteItem() {

		if (itemDAO.findById(2L) != null)
			itemDAO.delete(2L);
		// System.out.println(itemDAO.findById(2L).toString());;
		assertNull("Apagou Item", itemDAO.findById(2L));

	}

	private void testSelector() {
		// new StringBuilder("SELECT p FROM Produto p ")
		System.out.println("SELECTOR DEV WAS STARTED");

		Produto p1 = new Produto();
		p1.setNome("Milho Verde");
		Calendar c1 = Calendar.getInstance();
		c1.set(2010, 0, 10);
		p1.setDtCadastro(c1);
		// produtoDAO.criarFiltro(p, new StringBuilder("SELECT p FROM Produto p "));

		Produto p2 = new Produto();
		p2.setNome("z");
		Calendar c2 = Calendar.getInstance();
		c2.set(2010, 0, 10);
		p2.setDtCadastro(c2);
		
		System.out.println(produtoDAO.buildSQLCommand(p1,p2).toString());

	}

}
