package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.FactoryDAO;
import model.dao.ProdutoDAO;
import model.entity.ItemProduto;
import model.entity.Pessoa;
import model.dao.ItemProdutoDAO;
import model.entity.PessoaJuridica;
import model.entity.Produto;

public class ItemProdutoTest {

	private ProdutoDAO produtoDAO = new ProdutoDAO();
	private Produto produto = new Produto();

	private ItemProdutoDAO itemDAO = new ItemProdutoDAO();
	private ItemProduto item;

	@Test
	public void test() {
		this.testFindAll();

		FactoryDAO.closeInstance();
	}

	private void testFindAll() {

		List<Produto> produtos = produtoDAO.findAll();
		if (produtos != null && produtos.size() <= 0) {
			adicionarProdutos();
			System.out.println("Adicionou Produtos");
			produtos = produtoDAO.findAll();
		}
		assertNotNull("Adicionou Produtos", produtos);

		this.testUpdateProduto();

		System.out.println("Todos os produto cadastrados: \n" + produtos);

		System.out.println("--------------------------------------------");
		System.out.println("--------------------------------------------");

		List<ItemProduto> itens = itemDAO.findAll();
		if (itens != null && itens.size() <= 0) {
			adicionarItens();
			System.out.println("Adicionou Itens");
			itens = itemDAO.findAll();
		}
		assertNotNull("Adicionou Itens", itens);

		this.testDeleteItem();
		
		this.testUpdateItem();

		System.out.println("Todos os itens cadastrados: \n" + itens);

		System.out.println("--------------------------------------------");
		System.out.println("--------------------------------------------");

	}

	private void adicionarProdutos() {

		produto = new Produto("Milho");
		produtoDAO.save(produto);

		produto = new Produto("Tapete");
		produtoDAO.save(produto);

		produto = new Produto("Televisor");
		produtoDAO.save(produto);

	}

	private void testUpdateProduto() {

		Produto p = produtoDAO.findById(1L);
		p.setNome("Milho Verde");
		produtoDAO.update(p);
		assertEquals("Atualizou Produto", "Milho Verde", produtoDAO.findById(1L).getNome());
	}

	private void adicionarItens() {

		item = new ItemProduto(produtoDAO.findById(1L), 30.00f, 500.00f, 3);
		itemDAO.save(item);

		item = new ItemProduto(produtoDAO.findById(3L), 20.00f, 350.00f, 5);
		itemDAO.save(item);

		item = new ItemProduto(produtoDAO.findById(2L), 10.00f, 188.99f, 2);
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

		itemDAO.delete(2L);
		// System.out.println(itemDAO.findById(2L).toString());;
		assertNull("Apagou Item", itemDAO.findById(2L));

	}

}
