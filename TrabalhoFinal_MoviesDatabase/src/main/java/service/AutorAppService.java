package service;

import java.util.List;

import modelo.Autor;
import modelo.Livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dao.AutorDAO;
import excecao.InfraestruturaException;
import excecao.ObjetoNaoEncontradoException;
import excecao.AutorNaoEncontradoException;

public class AutorAppService
{	
	private AutorDAO autorDAO;

	
	public void setAutorDAO(AutorDAO autorDAO)
	{	this.autorDAO = autorDAO;
	}
	
	@Transactional
	public long inclui(Autor umAutor) 
	{	return autorDAO.inclui(umAutor).getId();
	}

	@Transactional
	public void altera(Autor umAutor)
		throws AutorNaoEncontradoException
	{	try
		{	autorDAO.getPorIdComLock(umAutor.getId());
			autorDAO.altera(umAutor);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new AutorNaoEncontradoException("Autor n�o encontrado");
		}
	}

	@Transactional
	public void exclui(Autor umAutor) 
		throws AutorNaoEncontradoException
	{	try
		{	Autor autor = autorDAO.recuperaUmAutorELivros(umAutor.getId());

			autorDAO.exclui(autor);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new AutorNaoEncontradoException("Autor n�o encontrado");
		}
	}

	public Autor recuperaUmAutor(long numero) 
		throws AutorNaoEncontradoException
	{	try
		{	return autorDAO.getPorId(numero);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new AutorNaoEncontradoException("Autor n�o encontrado");
		}
	}

	public Autor recuperaUmAutorELivros(long numero) 
		throws AutorNaoEncontradoException
	{	try
		{	return autorDAO.recuperaUmAutorELivros(numero);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new AutorNaoEncontradoException("Autor n�o encontrado");
		}
	}

	public List<Autor> recuperaListaDeAutores()
	{	return autorDAO.recuperaListaDeAutores();
	}
	
	public List<Livro> recuperaLivros(long numero) 
			throws AutorNaoEncontradoException
		{	try
			{	return autorDAO.recuperaLivros(numero);
			} 
			catch(ObjetoNaoEncontradoException e)
			{	throw new AutorNaoEncontradoException("Autor n�o encontrado");
			}
		}
	
	public int recuperaNumeroDeRows(String fator)
	{	
		
		int qtd = autorDAO.recuperaNumeroDeRows(fator + '%');
		return qtd;
	}
	
	public List<Autor> buscaPaginada(int inicio, 
            							 int linhasPorPagina,String fator)
	{	try
		{	
			
			return autorDAO.buscaPaginada(inicio,linhasPorPagina, fator + "%");

		} 
		catch(RuntimeException e)
		{	throw new InfraestruturaException(e);
		}
	}
	
	
}