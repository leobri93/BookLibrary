package service;

import java.util.List;

import modelo.Autor;
import modelo.Livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dao.AutorDAO;
import excecao.InfraestruturaException;
import excecao.ObjetoNaoEncontradoException;
import excecao.ProdutoNaoEncontradoException;

public class AutorAppService
{	
	private AutorDAO autorDAO = null;

	@Autowired
	public void setAutorDAO(AutorDAO produtoDAO)
	{	this.autorDAO = produtoDAO;
	}
	
	public long inclui(Autor umProduto) 
	{	return autorDAO.inclui(umProduto).getId();
	}

	@Transactional
	public void altera(Autor umAutor)
		throws ProdutoNaoEncontradoException
	{	try
		{	autorDAO.getPorIdComLock(umAutor.getId());
			autorDAO.altera(umAutor);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new ProdutoNaoEncontradoException("Produto não encontrado");
		}
	}

	@Transactional
	public void exclui(Autor umAutor) 
		throws ProdutoNaoEncontradoException
	{	try
		{	Autor autor = autorDAO.recuperaUmAutorELivros(umAutor.getId());

//			if(produto.getLances().size() > 0)
//			{	throw new ProdutoNaoEncontradoException("Este produto possui lances e não pode ser removido");
//			}

			autorDAO.exclui(autor);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new ProdutoNaoEncontradoException("Produto não encontrado");
		}
	}

	public Autor recuperaUmAutor(long numero) 
		throws ProdutoNaoEncontradoException
	{	try
		{	return autorDAO.getPorId(numero);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new ProdutoNaoEncontradoException("Produto não encontrado");
		}
	}

	public Autor recuperaUmAutorELivros(long numero) 
		throws ProdutoNaoEncontradoException
	{	try
		{	return autorDAO.recuperaUmAutorELivros(numero);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new ProdutoNaoEncontradoException("Produto não encontrado");
		}
	}

	public List<Autor> recuperaListaDeAutores()
	{	return autorDAO.recuperaListaDeAutores();
	}
	
	public List<Livro> recuperaLivros(long numero) 
			throws ProdutoNaoEncontradoException
		{	try
			{	return autorDAO.recuperaLivros(numero);
			} 
			catch(ObjetoNaoEncontradoException e)
			{	throw new ProdutoNaoEncontradoException("Produto não encontrado");
			}
		}
	
	public int recuperaNumeroDeRows(String fator)
	{	
		int qtd = autorDAO.recuperaNumeroDeRows(fator + '%');
		return qtd;
	}
	
	@SuppressWarnings("unchecked")
	public List<Autor> buscaPaginada(String fator, 
            							 int inicio, 
            							 int linhasPorPagina)
	{	try
		{	
			// order by c.nome asc
		
			return autorDAO.buscaPaginada(fator + "%",inicio,linhasPorPagina);

			
		} 
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	}
	
	
}