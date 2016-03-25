package dao;

import java.util.List;

import modelo.Livro;
import anotacao.RecuperaLista;

public interface LivroDAO extends DaoGenerico<Livro, Long>
{	
	@RecuperaLista
	List<Livro> recuperaListaDeLivros();
	
/*	@RecuperaUltimoOuPrimeiro
	Lance recuperaUltimoLance(Produto produto)
		throws ObjetoNaoEncontradoException;
*/		 
}
