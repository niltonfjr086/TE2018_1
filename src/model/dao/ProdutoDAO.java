package model.dao;

import java.util.List;

import javax.persistence.Query;

import model.entity.Produto;
import model.filter.ProdutoSeletor;

//import static model.FactoryDAO.sessionInstance;

public class ProdutoDAO extends GenericDAO<Produto, Long> {
	
	
	public void teste() {
		String query="";
		Object[] params = {"lala"};
		
		executeQuery(query, params);
	}

//	public List<Produto> listar(ProdutoSeletor seletor) {
//		Query q = null;
//
//		// "p" Ã© um alias, ou pode tambÃ©m ser visto como um objeto
//		StringBuilder jpql = new StringBuilder("SELECT p FROM Produto p ");
//
//		if (seletor.temFiltro()) {
//			criarFiltro(seletor, jpql);
//			q = this.em.createQuery(jpql.toString());
//			preencherParametrosConsulta(q, seletor);
//		} else {
//			q = sessionInstance().createQuery(jpql.toString());
//		}
//
//		if (seletor.temPaginacao()) {
//			q.setFirstResult(seletor.getOffset());
//			q.setMaxResults(seletor.getLimite());
//		}
//
//		return q.getResultList();
//	}

	/**
	 * Cria os filtros de consulta (clÃ¡usulas WHERE/AND) de acordo com o que foi
	 * preeenchido no seletor
	 * 
	 * @param seletor
	 *            o seletor de produtos
	 * @param jpql
	 *            a consulta que serÃ¡ preenchida
	 */
	public void criarFiltro(ProdutoSeletor seletor, StringBuilder jpql) {

		
		
//		jpql.append(" WHERE ");
//		boolean primeiro = true;
//
//		if (seletor.getIdProduto() > 0) {
//			if (!primeiro) {
//				jpql.append(" AND ");
//			}
//			// AtenÃ§Ã£o: p.id Ã© da entidade Produto, :idProduto Ã© apenas um parÃ¢metro
//			// que serÃ¡ preenchido
//			jpql.append("p.id = :idProduto");
//			primeiro = false;
//		}
//
//		if ((seletor.getNomeProduto() != null) && (seletor.getNomeProduto().trim().length() > 0)) {
//			if (!primeiro) {
//				jpql.append(" AND ");
//			}
//			jpql.append("p.nome LIKE :nomeProduto");
//			primeiro = false;
//		}
//
//		if ((seletor.getDataInicioCadastro() != null) && (seletor.getDataFimCadastro() != null)) {
//			if (!primeiro) {
//				jpql.append(" AND ");
//			}
//			jpql.append("p.dataCadastro BETWEEN :dataInicioCadastro AND :dataFimCadastro ");
//			primeiro = false;
//		} else if (seletor.getDataInicioCadastro() != null) {
//			if (!primeiro) {
//				jpql.append(" AND ");
//			}
//			jpql.append("p.dataCadastro >= :dataInicioCadastro ");
//			primeiro = false;
//		} else if (seletor.getDataFimCadastro() != null) {
//			if (!primeiro) {
//				jpql.append(" AND ");
//			}
//			jpql.append("p.dataCadastro <= :dataFimCadastro ");
//			primeiro = false;
//		}
		
		System.out.println(jpql);

	}

	/**
	 * Preenche os parÃ¢metros da consulta, de acordo com os atributos do seletor e
	 * os nomes definidos em criarFiltro (geralmente iguais aos dos atributos do
	 * seletor)
	 * 
	 * @param seletor
	 *            o seletor de produtos
	 * @param jpql
	 *            a consulta que serÃ¡ preenchida
	 */
	private void preencherParametrosConsulta(Query q, ProdutoSeletor seletor) {
		if (seletor.getIdProduto() > 0) {
			q.setParameter("idProduto", seletor.getIdProduto());
		}

		if ((seletor.getNomeProduto() != null) && (seletor.getNomeProduto().trim().length() > 0)) {
			q.setParameter("nomeProduto", "%" + seletor.getNomeProduto() + "%");
		}

		if ((seletor.getDataInicioCadastro() != null) && (seletor.getDataFimCadastro() != null)) {
			q.setParameter("dataInicioCadastro", seletor.getDataInicioCadastro());
			q.setParameter("dataFimCadastro", seletor.getDataFimCadastro());
		} else if (seletor.getDataInicioCadastro() != null) {
			q.setParameter("dataInicioCadastro", seletor.getDataInicioCadastro());
		} else if (seletor.getDataFimCadastro() != null) {
			q.setParameter("dataFimCadastro", seletor.getDataFimCadastro());
		}
	}

}