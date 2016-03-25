package dao.impl;

import modelo.Autor;
import dao.AutorDAO;

public abstract class AutorDAOImpl
       extends JPADaoGenerico<Autor, Long> implements AutorDAO 
{   
    public AutorDAOImpl()
    { 	super(Autor.class); 
    }
}
