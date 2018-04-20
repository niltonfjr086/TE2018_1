package model.dao;

import static model.FactoryDAO.sessionInstance;

import java.util.List;

import model.entity.Pessoa;

public class PessoaDAO extends GenericDAO<Pessoa, Long>{
	
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> findAllFuncionarios() {
		return sessionInstance().createQuery(("FROM " + this.manipulada.getName()) + " WHERE funcionario=true ").getResultList();
	}
	

}