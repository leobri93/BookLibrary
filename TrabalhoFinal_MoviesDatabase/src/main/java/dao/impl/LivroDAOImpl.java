package dao.impl;

import modelo.Livro;
import dao.LivroDAO;

public abstract class LivroDAOImpl 
	extends JPADaoGenerico<Livro, Long> implements LivroDAO
{
	public LivroDAOImpl() 
	{	super(Livro.class);		
	}
}
