package model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_item_produto")
public class ItemProduto extends BaseEntity {

	private static final long serialVersionUID = 428192209174017287L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH })
	@JoinColumn(name = "produto_id", nullable = false)
	private Produto produto;

	@Column(name = "vl_frete", nullable = false)
	private Float valorFrete;

	@Column(name = "vl_total", nullable = false)
	private Float valorTotal;

	@Column(name = "qtd_produtos", nullable = false)
	private Integer quantidadeProdutos;

	public ItemProduto() {
		super();
	}

	public ItemProduto(Produto produto, Float valorFrete, Float valorTotal, Integer quantidadeProdutos) {
		super();
		this.produto = produto;
		this.valorFrete = valorFrete;
		this.valorTotal = valorTotal;
		this.quantidadeProdutos = quantidadeProdutos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Float getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(Float valorFrete) {
		this.valorFrete = valorFrete;
	}

	public Float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer getQuantidadeProdutos() {
		return quantidadeProdutos;
	}

	public void setQuantidadeProdutos(Integer quantidadeProdutos) {
		this.quantidadeProdutos = quantidadeProdutos;
	}

}
