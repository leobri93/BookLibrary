package excecao;

public class NomeDeLivroJaCadastrado extends AplicacaoException {
	private final static long serialVersionUID = 1;

	public NomeDeLivroJaCadastrado(String msg)
	{	super(msg);
	}
	public NomeDeLivroJaCadastrado()
	{	super();
	}
}




