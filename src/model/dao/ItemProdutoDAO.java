package model.dao;

import static model.FactoryDAO.sessionInstance;

import model.entity.ItemProduto;
import model.entity.Produto;

public class ItemProdutoDAO extends GenericDAO<ItemProduto, Long>{

	@Override
	public void delete(Long pk) {

		ItemProduto i = findById(pk);
		Produto p = i.getProduto();
		
		super.delete(pk);

		p.getItens().remove(i);
		
	}
	
}