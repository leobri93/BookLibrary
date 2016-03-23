package dao.impl;

import modelo.Lance;
import dao.LivroDAO;

public abstract class LanceDAOImpl 
	extends JPADaoGenerico<Lance, Long> implements LivroDAO
{
	public LanceDAOImpl() 
	{	super(Lance.class);		
	}
}
