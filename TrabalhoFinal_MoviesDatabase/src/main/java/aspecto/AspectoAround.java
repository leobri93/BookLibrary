package aspecto;
import java.sql.SQLException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.dao.DataIntegrityViolationException;

//Para utilizar este aspecto � preciso:
// 1. Sempre que for definida uma nova constraint no CREATE TABLE ser� necess�rio acrescentar 
//    esta nova constraint nesta classe.
// 2. Criar uma classe de exce��o nova para esta constraint acrescentada ao CREATE TABLE.
// 3. Acrescentar c�digo referente a esta nova constraint nos m�todos afetados do managedbean.

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
				{	throw new Exception();						//fazer as altera��es nece�rias no banco.
				}
				else
				{	throw new Exception
						("A opera��o n�o foi realizada em fun��o da viola��o de uma restri��o no banco da dados.");
				}
			}
			else
			{	throw e;
			}
		}
	}
}