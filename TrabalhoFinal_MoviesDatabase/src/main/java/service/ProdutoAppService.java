package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dao.AutorDAO;
import excecao.ObjetoNaoEncontradoException;
import excecao.ProdutoNaoEncontradoException;
import modelo.Produto;

public class ProdutoAppService
{	
	private AutorDAO produtoDAO = null;

	@Autowired
	public void setProdutoDAO(AutorDAO produtoDAO)
	{	this.produtoDAO = produtoDAO;
	}
	
	public long inclui(Produto umProduto) 
	{	return produtoDAO.inclui(umProduto).getId();
	}

	@Transactional
	public void altera(Produto umProduto)
		throws ProdutoNaoEncontradoException
	{	try
		{	produtoDAO.getPorIdComLock(umProduto.getId());
			produtoDAO.altera(umProduto);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new ProdutoNaoEncontradoException("Produto n�o encontrado");
		}
	}

	@Transactional
	public void exclui(Produto umProduto) 
		throws ProdutoNaoEncontradoException
	{	try
		{	Produto produto = produtoDAO.recuperaUmProdutoELances(umProduto.getId());

//			if(produto.getLances().size() > 0)
//			{	throw new ProdutoNaoEncontradoException("Este produto possui lances e n�o pode ser removido");
//			}

			produtoDAO.exclui(produto);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new ProdutoNaoEncontradoException("Produto n�o encontrado");
		}
	}

	public Produto recuperaUmProduto(long numero) 
		throws ProdutoNaoEncontradoException
	{	try
		{	return produtoDAO.getPorId(numero);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new ProdutoNaoEncontradoException("Produto n�o encontrado");
		}
	}

	public Produto recuperaUmProdutoELances(long numero) 
		throws ProdutoNaoEncontradoException
	{	try
		{	return produtoDAO.recuperaUmProdutoELances(numero);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new ProdutoNaoEncontradoException("Produto n�o encontrado");
		}
	}

	public List<Produto> recuperaProdutosELances()
	{	return produtoDAO.recuperaListaDeProdutosELances();
	}
}