package model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa extends BaseEntity {

	private static final long serialVersionUID = 8610118473501970665L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String nome;
	private Date datanascimento;

	@Column(length = 14)
	private String cpf;

	private Boolean funcionario;

//	@ManyToMany
//	@JoinTable(name="membros", 
//				joinColumns= {@JoinColumn(name="idpessoa")}, 
//					inverseJoinColumns= {@JoinColumn(name="idprojeto")}
//	)
//	private List<Projeto> projetos;

	public Pessoa() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Boolean getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Boolean funcionario) {
		this.funcionario = funcionario;
	}

//	public List<Projeto> getProjetos() {
//		return projetos;
//	}
//
//	public void setProjetos(List<Projeto> projetos) {
//		this.projetos = projetos;
//	}

}