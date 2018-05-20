package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pessoa_fisica")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PessoaFisica extends Pessoa {
	
	private static final long serialVersionUID = -1868396699486777720L;
	
	@Column(nullable = false, length = 14)
	private String cpf;

	@Column(nullable = false)
	private String rg;

	public PessoaFisica() {
		super();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

}