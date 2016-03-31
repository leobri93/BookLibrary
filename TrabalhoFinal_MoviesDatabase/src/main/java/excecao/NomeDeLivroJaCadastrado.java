package excecao;

public class NomeDeLivroJaCadastrado extends RuntimeException{
	private final static long serialVersionUID = 1;

	public NomeDeLivroJaCadastrado(String msg)
	{	super(msg);
	}
	public NomeDeLivroJaCadastrado()
	{	super();
	}
}




