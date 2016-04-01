package excecao;


public class ViolacaoDeConstraintDesconhecidaException extends AplicacaoException 
{
	private final static long serialVersionUID = 1;

	public ViolacaoDeConstraintDesconhecidaException(String msg)
	{	super(msg);
	}
}
