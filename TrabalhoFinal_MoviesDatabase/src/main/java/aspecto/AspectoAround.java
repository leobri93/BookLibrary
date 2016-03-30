package aspecto;
import java.sql.SQLException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.dao.DataIntegrityViolationException;

//Para utilizar este aspecto é preciso:
// 1. Sempre que for definida uma nova constraint no CREATE TABLE será necessário acrescentar 
//    esta nova constraint nesta classe.
// 2. Criar uma classe de exceção nova para esta constraint acrescentada ao CREATE TABLE.
// 3. Acrescentar código referente a esta nova constraint nos métodos afetados do managedbean.

@Aspect
public class AspectoAround 
{
	@Pointcut("call(* servico.*.*(..))")
	public void traduzExcecaoAround() {}

	@Around("traduzExcecaoAround()")
	public Object traduzExcecaoAround(ProceedingJoinPoint joinPoint) throws Throwable 
	{	try
		{	return joinPoint.proceed();
		}
		catch(org.springframework.dao.DataAccessException e)
		{	
			Throwable t = e;
			
			if( t instanceof Exception)
			{	
				t = t.getCause();
				while (t != null && !(t instanceof SQLException))
				{
					t = t.getCause();
				}
				
				String msg = (t.getMessage() != null) ? t.getMessage() : "";
				
				if(msg.indexOf("PESSOA_FISICA_CPF_UN") != -1) //criar talvez uma exception para nome de livro e autor unique
				{	throw new Exception();						//fazer as alterações neceárias no banco.
				}
				else
				{	throw new Exception
						("A operação não foi realizada em função da violação de uma restrição no banco da dados.");
				}
			}
			else
			{	throw e;
			}
		}
	}
}