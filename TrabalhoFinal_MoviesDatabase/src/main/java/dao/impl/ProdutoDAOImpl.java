package dao.impl;

import modelo.Produto;
import dao.AutorDAO;

public abstract class ProdutoDAOImpl
       extends JPADaoGenerico<Produto, Long> implements AutorDAO 
{   
    public ProdutoDAOImpl()
    { 	super(Produto.class); 
    }
}
