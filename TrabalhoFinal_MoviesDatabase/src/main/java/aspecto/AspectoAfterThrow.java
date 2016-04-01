package aspecto;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import excecao.AplicacaoException;
@Aspect
public class AspectoAfterThrow {
	
	

	// -----------------------Log4j--------------------------------------- //
		final static Logger logger = Logger.getLogger(AspectoAfterThrow.class);
	// -----------------------Log4j--------------------------------------- //

	
	  @AfterThrowing(
		      pointcut = "execution(* visao.*.*(..))",
		      throwing= "error")
		    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		  	
		  	if(!(error instanceof AplicacaoException) ){
		  		logger.error(error.getMessage());
		  	}
		    }
}
