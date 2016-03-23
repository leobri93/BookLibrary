package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import util.Util;

@NamedQueries(
		{
			@NamedQuery
			(	name = "Autor.recuperaListaDeAutores",
				query = "select a from Autor a order by a.id"
			)
	/*		@NamedQuery
			(	name = "Autor.recuperaUltimoLivro",
				query = "select l from Livro l where l.Autor = ?1 order by l.id desc"
			),
			@NamedQuery
			(	name = "Autor.recuperaUmAutorComLivro",
				query = "select l from Livro l left outer join fetch l.autor where Autor.id = ?1"
			)//retorna todos os lances com ou sem produtos(o q nao faz muito sentido, pq todos os lances sao relacionados a um produto).
		})
*/
/* ==>  Falta acrescentar a busca Lance.recuperaUmLanceComProduto */
		})
				
@Entity
@Table(name="AUTOR")
//@SequenceGenerator(name="SEQUENCIA01", 
//				sequenceName="SEQ_AUTOR",
//		           allocationSize=1)
			
		
public class Autor
{	private Long id;
	private String nome;
	private Calendar dataNascimento;
	
//  Um autor possui livros

	private List<Livro> livros = new ArrayList<Livro>();



	// ********* Construtores *********

	public Autor()
	{
	}

	public Autor(String nome, Calendar dataCriacao)
	{	this.nome = nome;
		this.dataNascimento = dataCriacao;
	}

	public Autor(String nome, Calendar dataCriacao, Livro livro)
	{	this.nome = nome;
		this.dataNascimento = dataCriacao;
		livros.add(livro);
	}

	// ********* M�todos do Tipo Get *********

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCIA01")
	@Column(name="ID")

	public Long getId()
	{	return id;
	}

	public String getNome()
	{	return nome;
	}
	
	@Column(name="DATA_CRIACAO")
	@Temporal(TemporalType.DATE)
	public Calendar getDataCriacao()
	{	return dataNascimento;
	}
	
	@Transient
	public String getDataCriacaoMasc()
	{	return Util.calendarToStr(dataNascimento);
	}
	
	// ********* M�todos do Tipo Set *********

	@SuppressWarnings("unused")
	private void setId(Long id)
	{	this.id = id;
	}

	public void setNome(String nome)
	{	this.nome = nome;
	}

	public void setDataCriacao(Calendar dataCriacao)
	{	this.dataNascimento = dataCriacao;
	}
	
	

	// ********* M�todos para Associa��es *********


	@OneToMany(mappedBy = "autor")//mapeia q h� uma associa��o entre produto e lances.
	@OrderBy
	public List<Livro> getLivros(){
		return livros;
		
		
	}
	
}	