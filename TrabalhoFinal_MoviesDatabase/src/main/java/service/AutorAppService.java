package service;

import java.util.List;

import modelo.Autor;
import modelo.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dao.AutorDAO;
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
		{	throw new ProdutoNaoEncontradoException("Produto n�o encontrado");
		}
	}

	@Transactional
	public void exclui(Autor umAutor) 
		throws ProdutoNaoEncontradoException
	{	try
		{	Autor autor = autorDAO.recuperaUmAutorELivros(umAutor.getId());

//			if(produto.getLances().size() > 0)
//			{	throw new ProdutoNaoEncontradoException("Este produto possui lances e n�o pode ser removido");
//			}

			autorDAO.exclui(autor);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new ProdutoNaoEncontradoException("Produto n�o encontrado");
		}
	}

	public Autor recuperaUmAutor(long numero) 
		throws ProdutoNaoEncontradoException
	{	try
		{	return autorDAO.getPorId(numero);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new ProdutoNaoEncontradoException("Produto n�o encontrado");
		}
	}

	public Autor recuperaUmAutorELivros(long numero) 
		throws ProdutoNaoEncontradoException
	{	try
		{	return autorDAO.recuperaUmAutorELivros(numero);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new ProdutoNaoEncontradoException("Produto n�o encontrado");
		}
	}

	public List<Autor> recuperaAutoresELivros()
	{	return autorDAO.recuperaListaDeAutoresELivros();
	}
}