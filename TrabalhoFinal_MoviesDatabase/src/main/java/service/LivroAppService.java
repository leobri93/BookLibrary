package service;

import java.util.List;

import modelo.Livro;

import org.springframework.transaction.annotation.Transactional;

import dao.AutorDAO;
import dao.LivroDAO;
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
		// A  implementação do  método  getPorIdComLock(umProduto.getId()) 
		// impede que dois  lances  sejam  cadastrados em  paralelo, i. é, 
		// os lances  devem ser  cadastrados  obedecendo a uma fila.  Isto
		// impede que o valor do segundo lance seja  inferior  ao valor do
		// primeiro.
	
	/*	Autor umAutor = umLivro.getAutor();                    //falta fazer as exceptions
		
		try
		{	umAutor = autorDAO.getPorIdComLock(umAutor.getId());
		}
		catch(ObjetoNaoEncontradoException e)
		{	throw new ProdutoNaoEncontradoException("Produto não encontrado");
		}

		Lance ultimoLance; 
		try
		{	ultimoLance = livroDAO.recuperaUltimoLance(umProduto);
		}
		catch(ObjetoNaoEncontradoException e)
		{	ultimoLance = null;	
		}
	
		double valorUltimoLance;
		Calendar   dataUltimoLance;
		
		if (ultimoLance == null)
		{	valorUltimoLance = umProduto.getLanceMinimo() - 1;
			dataUltimoLance  = umProduto.getDataCadastro();
		}
		else
		{	valorUltimoLance = ultimoLance.getValor();
			dataUltimoLance  = ultimoLance.getDataCriacao();
		}
		
		if(umLance.getValor() <= valorUltimoLance)
		{	
			throw new ValorDeLanceInvalidoException("O valor do lance tem que ser superior a " + valorUltimoLance);
		}
	
		if(umLance.getDataCriacao().before(dataUltimoLance))
		{	
			throw new DataDeLanceInvalidaException("A data de emissão do lance não pode ser anterior a " 
					+ Util.calendarToStr(dataUltimoLance));
		}
	
		GregorianCalendar hoje = new GregorianCalendar();
		
		if(umLance.getDataCriacao().after(hoje))
		{	
			throw new DataDeLanceInvalidaException("A data de emissão do lance não pode ser posterior à data de hoje: " 
					+ Util.calendarToStr(hoje));
		}
	*/
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
}