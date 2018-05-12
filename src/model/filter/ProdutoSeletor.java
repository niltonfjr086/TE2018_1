package model.filter;

import java.util.Date;

/**
 * Classe que representa os filtros de um Produto
 * 
 * @author vilmar
 *
 */
public class ProdutoSeletor {

	//Atributos que servirÃ£o de filtros
	private int idProduto;
	private String nomeProduto;
	
	//TODO fazer seletores por cor e peso
	
	//Filtragem de datas por perÃƒÂ­odo (inÃƒÂ­cio, fim)
	private Date dataInicioCadastro;
	private Date dataFimCadastro;

	//Atributos para possÃƒÂ­vel paginaÃƒÂ§ÃƒÂ£o dos resultados (intervalo)
	private int limite;
	private int pagina;
	
	public ProdutoSeletor() {
		this.limite = 0;
		this.pagina = -1;
	}
	
	/**
	 * MÃƒÂ©todo que verifica se este seletor tem algum campo preenchido
	 *
	 * @return verdadeiro se existe algum campo de filtro preenchido
	 */
	public boolean temFiltro() {
		if (this.idProduto > 0) {
			return true;
		}
		if ((this.nomeProduto != null) && (this.nomeProduto.trim().length() > 0)) {
			return true;
		}
		if (this.dataInicioCadastro != null) {
			return true;
		}
		if (this.dataFimCadastro != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * MÃƒÂ©todo que verifica se os campos de paginacao estao preenchidos
	 *
	 * @return verdadeiro se os campos limite e pagina estao preenchidos
	 */
	public boolean temPaginacao() {
		return ((this.limite > 0) && (this.pagina > -1));
	}

	/**
	 * MÃƒÂ©todo que calcula o offset a partir da pagina e do limite
	 *
	 * @return offset
	 */
	public int getOffset() {
		return (this.limite * (this.pagina - 1));
	}

	//Getters e setters
	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int id) {
		this.idProduto = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nome) {
		this.nomeProduto = nome;
	}

	public Date getDataInicioCadastro() {
		return dataInicioCadastro;
	}

	public void setDataInicioCadastro(Date dataInicioCadastro) {
		this.dataInicioCadastro = dataInicioCadastro;
	}

	public Date getDataFimCadastro() {
		return dataFimCadastro;
	}

	public void setDataFimCadastro(Date dataFimCadastro) {
		this.dataFimCadastro = dataFimCadastro;
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public int getPagina() {
		return pagina;
	}

	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
}