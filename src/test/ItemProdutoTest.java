package test;

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
	public void testFindAll() {

		if (produtoDAO.findAll().size() <= 0) {
			adicionarProdutos();
			System.out.println("Adicionou Produtos");
		}

		if (itemDAO.findAll().size() <= 0) {
			adicionarItens();
			System.out.println("Adicionou Itens");
		}

		
		 List<ItemProduto> itens = itemDAO.findAll();
//		List<ItemProduto> itens = FactoryDAO.sessionInstance().createQuery(("FROM " + item.getClass().getSimpleName()))
//				.getResultList();

		System.out.println("Todos os itens cadastrados: \n" + itens);

		System.out.println("--------------------------------------------");
		System.out.println("--------------------------------------------");

		FactoryDAO.closeInstance();

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

	private void adicionarProdutos() {

//		String[] nomes = { "Milho", "Tapete", "Televisor" };

//		for (int i = 0; i < nomes.length; i++) {
//			FactoryDAO.sessionInstance().saveOrUpdate(new Produto(nomes[i]));
//			produtoDAO.save(new Produto(nomes[i]));
//		}

		produto = new Produto("Milho");
		produtoDAO.save(produto);
		
		produto = new Produto("Tapete");
		produtoDAO.save(produto);
		
		produto = new Produto("Televisor");
		produtoDAO.save(produto);
		
		
//		FactoryDAO.sessionInstance().find(Produto.class, new Produto());
		List<Produto> produtos = produtoDAO.findAll();

		System.out.println("Todos os produto cadastrados: \n" + produtos);

		System.out.println("--------------------------------------------");
		System.out.println("--------------------------------------------");

	}

}
