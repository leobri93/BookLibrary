package modelo;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import util.Util;

@NamedQueries(
		{	@NamedQuery
			(	name = "Lance.recuperaListaDeLances",
				query = "select l from Lance l order by l.id"
			),
			@NamedQuery
			(	name = "Lance.recuperaUltimoLance",
				query = "select l from Lance l where l.produto = ?1 order by l.id desc"
			),
			@NamedQuery
			(	name = "Lance.recuperaUmLanceComProduto",
				query = "select l from Lance l left outer join fetch l.produto where l.id = ?1"
			)
		})

/* ==>  Falta acrescentar a busca Lance.recuperaUmLanceComProduto */

		
@Entity
@Table(name="LANCE")
@SequenceGenerator(name="SEQUENCIA01", 
		           sequenceName="SEQ_LANCE",
		           allocationSize=1)

public class Lance
{	private Long id;
	private double valor;
	private Calendar dataCriacao;

	// Um lance se refere a um �nico produto

	private Produto produto;

	// ********* Construtores *********

	public Lance()
	{
	}

	public Lance(double valor, Calendar dataCriacao)
	{	this.valor = valor;
		this.dataCriacao = dataCriacao;
	}

	public Lance(double valor, Calendar dataCriacao, Produto produto)
	{	this.valor = valor;
		this.dataCriacao = dataCriacao;
		this.produto = produto;
	}

	// ********* M�todos do Tipo Get *********

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCIA01")
	@Column(name="ID")

	public Long getId()
	{	return id;
	}

	public double getValor()
	{	return valor;
	}
	
	@Column(name="DATA_CRIACAO")
	@Temporal(TemporalType.DATE)
	public Calendar getDataCriacao()
	{	return dataCriacao;
	}
	
	@Transient
	public String getDataCriacaoMasc()
	{	return Util.calendarToStr(dataCriacao);
	}
	
	// ********* M�todos do Tipo Set *********

	@SuppressWarnings("unused")
	private void setId(Long id)
	{	this.id = id;
	}

	public void setValor(double valor)
	{	this.valor = valor;
	}

	public void setDataCriacao(Calendar dataCriacao)
	{	this.dataCriacao = dataCriacao;
	}

	// ********* M�todos para Associa��es *********

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PRODUTO_ID")
	public Produto getProduto()
	{	return produto;
	}
	
	public void setProduto(Produto produto)
	{	this.produto = produto;
	}
}	