package aspecto;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DataIntegrityViolationException;

import excecao.NomeDeLivroJaCadastrado;
import excecao.ViolacaoDeConstraintDesconhecidaException;

//Para utilizar este aspecto � preciso:
// 1. Sempre que for definida uma nova constraint no CREATE TABLE ser� necess�rio acrescentar 
//    esta nova constraint nesta classe.
// 2. Criar uma classe de exce��o nova para esta constraint acrescentada ao CREATE TABLE.
// 3. Acrescentar c�digo referente a esta nova constraint nos m�todos afetados do managedbean.

@Aspect
public class AspectoAround 
{
	
	
	// -----------------------Log4j--------------------------------------- //
		final static Logger logger = Logger.getLogger(AspectoAround.class);
	// -----------------------Log4j--------------------------------------- //


	
	
	@Around("call(* service.*.*(..))")
	public Object traduzExcecaoAround(ProceedingJoinPoint joinPoint) throws Throwable 
	{	try
		{	return joinPoint.proceed();
		}
		catch(org.springframework.dao.DataAccessException e)
		{	
			Throwable t = e;
			
			if( t instanceof DataIntegrityViolationException)
			{	
				t = t.getCause();
				while (t != null && !(t instanceof SQLException))
				{
					t = t.getCause();
				}
				
				String msg = (t.getMessage() != null) ? t.getMessage() : "";
				
				if(msg.indexOf("LIVRO_NOME_UNIQUE") != -1)
				{	
					
					throw new NomeDeLivroJaCadastrado("O nome do livro j� consta no banco.");
				}
				else
				{
					
					throw new ViolacaoDeConstraintDesconhecidaException
						("A opera��o n�o foi realizada em fun��o da viola��o de uma restri��o no banco da dados.");
					
					
					
				}
			}
			else
			{	throw e;
			}
		}
	}
}

