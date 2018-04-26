package model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario extends BaseEntity {

	private static final long serialVersionUID = 4725235486064613203L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 50)
	private String login;

	// private Pessoa pessoa;

	@Column(nullable = false, length = 200)
	private String observacao;

	@Column(nullable = false, name = "dt_cadastro")
	private Date dtCadastro;

	public Usuario() {
		super();
	}

	public Usuario(String login, String observacao, Date dtCadastro) {
		super();
		this.login = login;
		this.observacao = observacao;
		this.dtCadastro = dtCadastro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

}
