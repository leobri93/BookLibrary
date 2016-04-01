package excecao;
import anotacao.ExcecaoDeAplicacao;

@ExcecaoDeAplicacao
public class AplicacaoException extends RuntimeException
{
	private final static long serialVersionUID = 1;
		
		public AplicacaoException()
		{	super();
		}
		public AplicacaoException(String msg)
		{	super(msg);
		}
		
}
