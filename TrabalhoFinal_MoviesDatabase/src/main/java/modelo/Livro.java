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
		{	
			@NamedQuery
			(	name = "Livro.recuperaListaDeLivros",
				query = "select p from Livro p order by p.id"
			),
			@NamedQuery
			(	name = "Livro.recuperaUltimoLivro",
				query = "select l from Livro l where l.autor = ?1 order by l.id desc"
			),
			@NamedQuery
			(	name = "Livro.buscaPaginada",
				query = "select c from Livro c where c.nome like ?3	"	
			),
			@NamedQuery
			(	name = "Livro.recuperaNumeroDeRows",
				query = "select count(c) from Livro c where c.nome like ?1	"	
			)
		})

@Entity
@Table(name="LIVRO")
@SequenceGenerator(name="SEQUENCIA01",sequenceName="SEQ_LIVRO",allocationSize=1)

public class Livro
{	
	private Long id;
	private String nome;
	private String sinopse;
	private Long numeroExemplares;
	private Calendar dataCadastro;
	private Autor autor;

		
	// ********* Construtores *********

	public Livro()
	{
	}

	public Livro(String nome, 
	               String descricao, 
	               Long numeroExemplares, 
	               Calendar dataCadastro,
	               Autor autor)
	{	this.nome = nome;
		this.sinopse = descricao;
		this.numeroExemplares = numeroExemplares;
		this.dataCadastro = dataCadastro;	
		this.autor = autor;
	}

	// ********* Métodos do Tipo Get *********

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCIA01")
	//@Id 
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")

	public Long getId()
	{	return id;
	}
	
	
	@Column(name="NOME")
	public String getNome()
	{	return nome;
	}
	
	@Column(name="SINOPSE")
	public String getSinopse()
	{	return sinopse;
	}
	
	@Column(name="DATA_CADASTRO")
	@Temporal(TemporalType.DATE)
	public Calendar getDataCadastro()
	{	return dataCadastro;
	}
	
	@Transient
	public String getDataCadastroMasc()
	{	return Util.calendarToStr(dataCadastro);
	}
	
	@Column(name="NUMERO_EXEMPLARES")
	public Long getNumeroExemplares()
	{	return numeroExemplares;
	}
	

	// ********* Métodos do Tipo Set *********

	@SuppressWarnings("unused")
	private void setId(Long id)
	{	this.id = id;
	}
	
	public void setNome(String nome)
	{	this.nome = nome;
	}
	
	public void setSinopse(String sinopse)
	{	this.sinopse = sinopse;
	}
	
	public void setDataCadastro(Calendar dataCadastro)
	{	this.dataCadastro = dataCadastro;
	}
	
	public void setNumeroExemplares(Long numeroExemplares)
	{	this.numeroExemplares = numeroExemplares;
	}
	
	
	
	// ********* Métodos para Associações *********

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AUTOR_ID")
	public Autor getAutor()
	{	return autor;
	}
	
	public void setAutor(Autor autor)
	{	this.autor = autor;
	}	
	
}

