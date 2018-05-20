package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pessoa_juridica")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PessoaJuridica extends Pessoa {

	private static final long serialVersionUID = -4620123394486400862L;

	@Column(nullable = false, length = 18)
	private String cnpj;

	@Column(nullable = false, length = 10, name = "inscricao_estadual")
	private String inscricaoEstadual;

	public PessoaJuridica() {
		super();
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

}
