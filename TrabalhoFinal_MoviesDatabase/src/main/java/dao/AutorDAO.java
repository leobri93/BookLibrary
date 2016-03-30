package dao;

import java.util.List;
import java.util.Set;

import modelo.Autor;
import modelo.Livro;
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
	List<Livro> recuperaLivros(long numero)
	throws ObjetoNaoEncontradoException;
	
	@RecuperaObjeto
	int recuperaNumeroDeRows(String fator);
	
	@RecuperaConjunto
	Set<Autor> recuperaConjuntoDeAutoresELivros();
	
	@RecuperaObjeto
	List<Autor> buscaPaginada(String fator, int inicio, int linhasPorPagina);
	
	/* ****** M�todos n�o Gen�ricos ******* */

	// Um m�todo definido aqui, que n�o seja anotado, dever� ser
	// implementado como final em ProdutoDAOImpl.
}
