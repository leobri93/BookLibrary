package dao;

import java.util.List;
import java.util.Set;

import modelo.Autor;
import anotacao.RecuperaConjunto;
import anotacao.RecuperaLista;
import anotacao.RecuperaObjeto;
import excecao.ObjetoNaoEncontradoException;

public interface AutorDAO extends DaoGenerico<Autor, Long>
{   
	/* ****** M�todos Gen�ricos ******* */

	@RecuperaObjeto
	Autor recuperaUmAutorELivros(long numero) 
		throws ObjetoNaoEncontradoException;

	@RecuperaLista
	List<Autor> recuperaListaDeAutores();
	
	@RecuperaLista
	List<Autor> recuperaListaDeAutoresELivros();

	@RecuperaConjunto
	Set<Autor> recuperaConjuntoDeAutoresELivros();
	
	/* ****** M�todos n�o Gen�ricos ******* */

	// Um m�todo definido aqui, que n�o seja anotado, dever� ser
	// implementado como final em ProdutoDAOImpl.
}
