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

//		if (itemDAO.findAll().size() <= 0) {
//			adicionarItens();
//			System.out.println("Adicionou Itens");
//		}
//
//		// List<PessoaFisica> pessoas = pessoaDAO.findAll();
//		List<ItemProduto> itens = FactoryDAO.sessionInstance().createQuery(("FROM " + item.getClass().getSimpleName()))
//				.getResultList();
//
//		System.out.println("Todos os itens cadastrados: \n" + itens);
//
//		System.out.println("--------------------------------------------");
//		System.out.println("--------------------------------------------");

		FactoryDAO.closeInstance();

	}

	private void adicionarItens() {

		item = new ItemProduto();

		// pessoaDAO.save(pf);
		// FactoryDAO.sessionInstance().saveOrUpdate(itemDAO);

		// produto = new PessoaJuridica();
		// produto.setNome("Comunicandus");
		// produto.setCnpj("30.301.301/3000-20");
		// produto.setBairro("Centro");
		// produto.setCidade("São José");
		// produto.setEmail("jdweoi@jieo.com");
		// produto.setEstado("SC");
		// produto.setInscricaoEstadual("34343434");
		// produto.setRua("Avenida Ivo Silveira");
		// produto.setTelefone("48 3232-3232");
		//// pessoaDAO.save(pj);
		// FactoryDAO.sessionInstance().saveOrUpdate(produto);

		// pf = new PessoaFisica();
		// pf.setNome("João Matos");
		// pf.setCpf("435.215.585-90");
		// pf.setBairro("Centro");
		// pf.setCidade("São José");
		// pf.setEmail("jdweoi@jieo.com");
		// pf.setEstado("SC");
		// pf.setRg("34343434");
		// pf.setRua("Avenida Ivo Silveira");
		// pf.setTelefone("48 3232-3232");
		// pessoaDAO.save(pf);

		// itemDAO = new ItemProdutoDAO();

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
