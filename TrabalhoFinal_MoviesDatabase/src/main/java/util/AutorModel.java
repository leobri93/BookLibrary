package util;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.Autor;
import service.AutorAppService;

public class AutorModel extends AbstractTableModel 
{
	private static final long serialVersionUID = 1L;
	public static final int COLUNA_ID = 0;
	public static final int COLUNA_NOME = 1;
	public static final int COLUNA_DATA_NASCIMENTO = 2;
	
	private final static int NUMERO_DE_LINHAS_POR_PAGINA = 5;
    
	private static AutorAppService autorAppService; 

	static
	{
        @SuppressWarnings("resource")
		ApplicationContext fabrica = new ClassPathXmlApplicationContext("beans-jpa.xml");

        autorAppService = 
			(AutorAppService)fabrica.getBean ("autorAppService");
	}

    private Map<Integer, Autor> cache;
    private int rowIndexAnterior = 0;
    private Integer qtd; // saber quantas rows tem para o logradouro pesquisado, serve para sabermos o tamanho da barra de rolagem.
    private String fator;
    
    public AutorModel()
	{	
    	this.qtd = null;
		this.cache = new HashMap<Integer, Autor>(170);
	}

    public void setFatorDeBusca(String fator)
    {
    	this.fator = fator;
    }
    
	public String getColumnName(int c)
	{
		if(c == COLUNA_ID) return "id";
		if(c == COLUNA_NOME) return "Nome";
		if(c == COLUNA_DATA_NASCIMENTO) return "Data Nasc";
		return null;
	}
	
	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		if(qtd == null)

			qtd = (int)autorAppService.recuperaNumeroDeRows(fator.toUpperCase());


		{
			
			cache = new HashMap<Integer, Autor>(NUMERO_DE_LINHAS_POR_PAGINA * 4 / 75 /100 + 2);
		}

		return qtd;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{   
		if (!cache.containsKey(rowIndex))  // cache=hashmap
		{	
			System.out.println(">>>>>>>>>>>> cache não tem rowIndex = " + rowIndex);
			System.out.println(">>>>>>>>>>>> tamanho = " + this.cache.size());
				
			if(cache.size() > 80)// o cache aqui vai ter 120 linhas
			{	
				System.out.println(">>>>>>>>>>>>>>>>>...... Vai limpar .......");
				
				cache.clear();
				
				if(rowIndex >= rowIndexAnterior) 
				{
					// O cache é maior do que 80 e estamos navegando para baixo
					
					// Se, por exemplo, rowindex = 120 queremos recuperar 2 páginas:
					
					// de 101 a 120 (página atual)
					// de 121 a 140 (próxima página - para baixo)

					System.out.println("Como estamos navegando para baixo e como a linha " + rowIndex + " não foi encontrada no cache (que foi apagado), vamos recuperar do banco 40 linhas com deslocamento de " + (rowIndex - 19));
					
					// A tabela não pode ter mais de 20 linhas
					List<Autor> resultados = autorAppService.buscaPaginada(rowIndex - 19, 40,fator.toUpperCase());
				
					for (int j = 0; j < resultados.size(); j++) 
					{	Autor autor = resultados.get(j);
						cache.put(rowIndex - 19 + j, autor);
						
					}
				}
				else
				{
					int inicio = rowIndex - 20;
					if (inicio < 0) inicio = 0;
				
					// O cache é maior do que 80 e estamos navegando para cima
					
					// Se, por exemplo, rowindex = 121 então queremos recuperar 2 páginas:
					
					// de 101 a 120 (página anterior - para cima)
					// de 121 a 140 (página atual)
					
					System.out.println("Como estamos navegando para cima e como a linha " + rowIndex + " não foi encontrada no cache (que foi apagado), vamos recuperar do banco 40 linhas com deslocamento de " + inicio);
					
					List<Autor> resultados = autorAppService
						.buscaPaginada(inicio, 40,fator.toUpperCase());
					
					System.out.println("resultados = " + resultados.size());
					
					for (int j = 0; j < resultados.size(); j++) 
					{	Autor autor = resultados.get(j);
						cache.put(inicio + j, autor);
					}
				}
				
				System.out.println(">>>>>>>>>>>>>>>>>...... Tamanho = " + this.cache.size());
			}
			else
			{
				if(rowIndex >= rowIndexAnterior) //está vendo se vc está "subindo" ou "descendo" a barra de rolagem.
				{
					// O cache não é maior do que 80 e estamos navegando para baixo
					
					// Se, por exemplo, rowindex = 121 vamos recuperar 2 páginas (além das entradas que estão no cache):
					
					// de 121 a 160 (a linha atual (121) e mais 39 linhas (quase duas páginas - supondo cada página com 20 linhas))

					System.out.println("Como estamos navegando para baixo e a linha " + rowIndex + " não foi encontrada, vamos recuperar do banco 40 linhas com um deslocamento de " + rowIndex);
					
					List<Autor> resultados = autorAppService
						.buscaPaginada( rowIndex, 40, fator.toUpperCase());//ele quer pegar, a partir da linha rowIndex,
					                                                                 //40 linhas no banco para o cache.
					for (int j = 0; j < resultados.size(); j++) 
					{	Autor autor = resultados.get(j);
						cache.put(rowIndex + j, autor);
					}
				}
				else
				{
					int inicio = rowIndex - 39;
					if (inicio < 0) inicio = 0;
				
					// O cache não é maior do que 80 e estamos navegando para cima
					
					// Se, por exemplo, rowindex = 139 vamos recuperar 2 páginas (além das entradas que estão no cache):
					
					// de 100 a 139 (a linha atual (139) e mais 39 linhas anteriores (quase duas páginas - supondo cada página com 20 linhas))

					System.out.println("Como estamos navegando para cima e a linha " 
							+ rowIndex + " não foi encontrada, vamos recuperar do banco "
									+ "40 linhas com inicio a partir de " + inicio);
					
					List<Autor> resultados = autorAppService
						.buscaPaginada(inicio, 40, fator.toUpperCase());
					
					System.out.println("resultados = " + resultados.size());
					
					for (int j = 0; j < resultados.size(); j++) 
					{	Autor autor = resultados.get(j);
						cache.put(inicio + j, autor);
					}
				}
			}
        }

		rowIndexAnterior = rowIndex;
        
		Autor autor = cache.get(rowIndex);

		if(columnIndex == COLUNA_ID)
			return autor.getId();
		else if (columnIndex == COLUNA_NOME)
			return autor.getNome();
		else if (columnIndex == COLUNA_DATA_NASCIMENTO)
			return autor.getDataCriacaoMasc();
		
		else
			return null;
	}
	
	// Para que os campos booleanos sejam renderizados como check box.
	// Neste caso, não há campo boleano.
	public Class<?> getColumnClass(int c)
	{
		Class<?> classe = null;
		if(c == COLUNA_ID) classe = String.class;
		if(c == COLUNA_NOME) classe = String.class;
		if(c == COLUNA_DATA_NASCIMENTO) classe = String.class;
		return classe;
	}
	
	// Para que as células referentes às colunas 1 em diante possam ser editadas
	public boolean isCellEditable(int r, int c)
	{
		return true;
	}

	@Override
	public void setValueAt(Object obj, int r, int c) 
	{
		Autor umAutor = cache.get(r);

		if(c == COLUNA_NOME) umAutor.setNome((String)obj);
		if(c == COLUNA_DATA_NASCIMENTO) umAutor.setDataCriacao(Util.strToCalendar((String)obj));
		

		try 
		{	autorAppService.altera(umAutor);
		} 
		catch (Exception e) 
		{	e.printStackTrace();
		}
	}
}
