package excecao;
import anotacao.ExcecaoDeAplicacao;

@ExcecaoDeAplicacao
public class AutorNaoEncontradoException extends AplicacaoException 
{
	private final static long serialVersionUID = 1;
		
		public AutorNaoEncontradoException(String msg)
		{	super(msg);
		}
}
