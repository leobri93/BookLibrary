package dao;

import java.util.List;

import modelo.Autor;
import modelo.Livro;
import anotacao.BuscaPaginada;
import anotacao.RecuperaLista;
import anotacao.RecuperaObjeto;

public interface LivroDAO extends DaoGenerico<Livro, Long>
{	
	@RecuperaLista
	List<Livro> recuperaListaDeLivros();
	
	@BuscaPaginada
	List<Livro> buscaPaginada(int inicio, int linhasPorPagina, String fator);
	
	@RecuperaObjeto
	int recuperaNumeroDeRows(String fator);
}
