package excecao;
import anotacao.ExcecaoDeAplicacao;

@ExcecaoDeAplicacao
public class LivroNaoEncontradoException extends AplicacaoException 
{
	private final static long serialVersionUID = 1;
	
	public LivroNaoEncontradoException(String msg)
	{	super(msg);
	}
}
