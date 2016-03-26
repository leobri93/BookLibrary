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
	/* ****** Métodos Genéricos ******* */

	@RecuperaObjeto
	Autor recuperaUmAutorELivros(long numero) 
		throws ObjetoNaoEncontradoException;

	@RecuperaLista
	List<Autor> recuperaListaDeAutores();
	
	@RecuperaLista
	List<Autor> recuperaListaDeAutoresELivros();

	@RecuperaConjunto
	Set<Autor> recuperaConjuntoDeAutoresELivros();
	
	/* ****** Métodos não Genéricos ******* */

	// Um método definido aqui, que não seja anotado, deverá ser
	// implementado como final em ProdutoDAOImpl.
}
