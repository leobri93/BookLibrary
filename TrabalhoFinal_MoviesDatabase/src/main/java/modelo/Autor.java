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
import javax.persistence.SequenceGenerator;
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
			),
			@NamedQuery
			(	name = "Autor.recuperaUmAutorELivros",
				query = "select p from Autor p left outer join fetch p.livros where p.id = ?1"
			),
			@NamedQuery
			(	name = "Autor.recuperaLivros",
				query = "select l from Livro l where l.autor = ?1 order by l.id asc"
			),
			@NamedQuery
			(	name = "Autor.buscaPaginada",
				query = "select c from Autor c where c.nome like ?1	"	
			),
			@NamedQuery
			(	name = "Autor.recuperaNumeroDeRows",
				query = "select count(c) from Autor c where c.nome like ?1	"	
			),
			/*	
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
@SequenceGenerator(name="SEQUENCIA02", 
				sequenceName="SEQ_AUTOR",
		           allocationSize=1)
			
		
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

	// ********* Métodos do Tipo Get *********

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCIA02")
	@Column(name="ID")
	public Long getId()
	{	return id;
	}
	
	@Column(name="NOME")
	public String getNome()
	{	return nome;
	}
	
	@Column(name="DATA_NASCIMENTO")
	@Temporal(TemporalType.DATE)
	public Calendar getDataCriacao()
	{	return dataNascimento;
	}
	
	@Transient
	public String getDataCriacaoMasc()
	{	return Util.calendarToStr(dataNascimento);
	}
	
	// ********* Métodos do Tipo Set *********

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
	
	

	// ********* Métodos para Associações *********


	@OneToMany(mappedBy = "autor")//mapeia q há uma associação entre produto e lances.
	@OrderBy
	public List<Livro> getLivros(){
		return livros;
		
		
	}
	public void setLivros(List<Livro> livros)
	{	this.livros = livros;	
	}
	
}	