package dao.controle;

import net.sf.cglib.proxy.Enhancer;

public class FabricaDeDao
{
    
	@SuppressWarnings("unchecked")  
    public static <T> T getDao(String classeDoDaoComoString) 
        throws Exception 
    {        
		System.out.println("classeDoDaoComoString = " + classeDoDaoComoString);
		
		Class<T> classeDoDao = (Class<T>)Class.forName(classeDoDaoComoString);
		
		return (T)Enhancer.create (classeDoDao, new InterceptadorDeDAO());

      
    }
}