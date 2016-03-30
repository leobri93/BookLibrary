package service;

import java.util.List;

import modelo.Autor;
import modelo.Livro;

import org.springframework.transaction.annotation.Transactional;

import dao.AutorDAO;
import dao.LivroDAO;
import excecao.AutorNaoEncontradoException;
import excecao.InfraestruturaException;
import excecao.LivroNaoEncontradoException;
import excecao.ObjetoNaoEncontradoException;

public class LivroAppService
{	
	private AutorDAO autorDAO = null;
	private LivroDAO livroDAO = null;
	
	public void setAutorDAO(AutorDAO produtoDAO)
	{	this.autorDAO = produtoDAO;
	}

	public void setLivroDAO(LivroDAO livroDAO)
	{	this.livroDAO = livroDAO;
	}

	@Transactional
	public long inclui(Livro umLivro)  
	{

		Livro livro = livroDAO.inclui(umLivro);

		return livro.getId();
	}	

	@Transactional
	public void exclui(Livro umLivro) 
		throws LivroNaoEncontradoException 
	{	try
		{	umLivro = livroDAO.getPorId(umLivro.getId());
			livroDAO.exclui(umLivro);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new LivroNaoEncontradoException("Lance não encontrado.");
		}
	}

	public Livro recuperaUmLivro(long numero) 
		throws LivroNaoEncontradoException
	{	try
		{	return livroDAO.getPorId(numero);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new LivroNaoEncontradoException("Lance não encontrado");
		}
	}

	public List<Livro> recuperaLivros()
	{	return livroDAO.recuperaListaDeLivros();
	}
	
	@Transactional
	public void altera(Livro umLivro)
		throws LivroNaoEncontradoException
	{	try
		{	livroDAO.getPorIdComLock(umLivro.getId());
			livroDAO.altera(umLivro);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new LivroNaoEncontradoException("Autor não encontrado");
		}
	}
	
	public List<Livro> buscaPaginada(int inicio, 
			int linhasPorPagina,String fator)
	{	
		try
			{	

				return livroDAO.buscaPaginada(inicio,linhasPorPagina, fator + "%");

			} 
			catch(RuntimeException e)
			{
				throw new InfraestruturaException(e);
			}
	}
	
	public int recuperaNumeroDeRows(String fator)
	{	
		if(livroDAO==null){System.out.println("autorDAO = null");}
		int qtd = livroDAO.recuperaNumeroDeRows(fator + '%');
		return qtd;
	}
	
}