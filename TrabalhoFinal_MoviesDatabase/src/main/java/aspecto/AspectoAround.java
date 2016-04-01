package aspecto;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DataIntegrityViolationException;

import excecao.NomeDeLivroJaCadastrado;
import excecao.ViolacaoDeConstraintDesconhecidaException;

//Para utilizar este aspecto é preciso:
// 1. Sempre que for definida uma nova constraint no CREATE TABLE será necessário acrescentar 
//    esta nova constraint nesta classe.
// 2. Criar uma classe de exceção nova para esta constraint acrescentada ao CREATE TABLE.
// 3. Acrescentar código referente a esta nova constraint nos métodos afetados do managedbean.

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
					
					throw new NomeDeLivroJaCadastrado("O nome do livro já consta no banco.");
				}
				else
				{
					
					throw new ViolacaoDeConstraintDesconhecidaException
						("A operação não foi realizada em função da violação de uma restrição no banco da dados.");
					
					
					
				}
			}
			else
			{	throw e;
			}
		}
	}
}

