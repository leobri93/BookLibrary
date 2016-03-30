import java.util.List;

import modelo.Autor;
import modelo.Livro;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.AutorAppService;
import service.LivroAppService;
import util.Util;
import corejava.Console;
import excecao.AutorNaoEncontradoException;
import excecao.LivroNaoEncontradoException;

public class PrincipalLivro
{	public static void main (String[] args) 
	{	
		String sinopse;
		String dataCriacao;
		String nome;
		Long numeroExemplares;
		
		Autor umAutor;
		Livro umLivro;

        @SuppressWarnings("resource")
		ApplicationContext fabrica = new ClassPathXmlApplicationContext("beans-jpa.xml");

		AutorAppService autorAppService = 
			(AutorAppService)fabrica.getBean ("autorAppService");
		LivroAppService livroAppService = 
			(LivroAppService)fabrica.getBean ("livroAppService");

		boolean continua = true;
		while (continua)
		{	System.out.println('\n' + "O que voc� deseja fazer?");
			System.out.println('\n' + "1. Cadastrar um livro de um autor");
			System.out.println("2. Remover um livro");
			System.out.println("3. Recuperar todos os livros");
			System.out.println("4. Sair");
						
			int opcao = Console.readInt('\n' + 
							"Digite um n�mero entre 1 e 4:");			
					
			switch (opcao)
			{	case 1:
				{
					long idAutor = Console.readInt('\n' + "Informe o n�mero do autor: ");
					
					try
					{	umAutor = autorAppService.recuperaUmAutor(idAutor);
					}
					catch(AutorNaoEncontradoException e)
					{	System.out.println('\n' + e.getMessage());
						break;
					}
					
					nome = Console.readLine('\n' + 
							"Informe o nome do livro: ");
					
					sinopse = Console.readLine('\n' + 
									"Informe a sinopse do livro: ");
					
					dataCriacao = Console.readLine(
									"Informe a data de emiss�o do livro: ");
					
					numeroExemplares = (long) 50;    //vou manter fixo, pq sim.
					umLivro = new Livro(nome, sinopse, numeroExemplares, Util.strToCalendar(dataCriacao), umAutor);
					
					try
					{	livroAppService.inclui(umLivro);	

						System.out.println('\n' + "Livro adicionado com sucesso");						
					}
					catch(Exception e)
					{	
						System.out.println(e.getMessage());
					}
						
					break;
				}

				case 2:
				{	int resposta = Console.readInt('\n' + 
						"Digite o n�mero do livro que voc� deseja remover: ");
									
					try
					{	umLivro = livroAppService.recuperaUmLivro(resposta);
					}
					catch(LivroNaoEncontradoException e)
					{	System.out.println('\n' + e.getMessage());
						break;
					}
										
					
					System.out.println(	
							"N�mero = " + umLivro.getId() + 
							"  Nome = " + umLivro.getNome() +
							"  Sinopse = " + umLivro.getSinopse());
					
																						
					String resp = Console.readLine('\n' + 
						"Confirma a remo��o do lance?");

					if(resp.equals("s"))
					{	try
						{	livroAppService.exclui (umLivro);
							System.out.println('\n' + 
								"Livro removido com sucesso!");
						}
						catch(LivroNaoEncontradoException e)
						{	System.out.println(e.getMessage());
						}
					}
					else
					{	System.out.println('\n' + 
							"Livro n�o removido.");
					}
					
					break;
				}

				case 3:
				{	List<Livro> arrayLivros = livroAppService.recuperaLivros();
									
					if (arrayLivros.size() == 0)
					{	System.out.println('\n' + 
							"Nao h� livros cadastrados.");
						break;
					}
										
					System.out.println("");
					for (Livro livro : arrayLivros)
					{	System.out.println(	
							"N�mero = " + livro.getId() + 
							"  Nome = " + livro.getNome() +
							"  Sinopse = " + livro.getSinopse());
					}
										
					break;
				}

				case 4:
				{	continua = false;
					break;
				}

				default:
					System.out.println('\n' + "Op��o inv�lida!");						
			}
		}		
	}
}
