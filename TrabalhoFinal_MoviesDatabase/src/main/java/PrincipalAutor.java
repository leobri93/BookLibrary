import java.util.List;

import modelo.Autor;
import modelo.Livro;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.AutorAppService;
import util.Util;
import corejava.Console;
import excecao.ProdutoNaoEncontradoException;

public class PrincipalAutor
{	public static void main (String[] args) throws ProdutoNaoEncontradoException 
	{	
		String nome;
		
		String dataCadastro;
		Autor umAutor;

        @SuppressWarnings("resource")
		ApplicationContext fabrica = new ClassPathXmlApplicationContext("beans-jpa.xml");

		AutorAppService autorAppService = 
			(AutorAppService)fabrica.getBean ("autorAppService");

		boolean continua = true;
		while (continua)
		{	System.out.println('\n' + "O que você deseja fazer?");
			System.out.println('\n' + "1. Cadastrar um autor");
			System.out.println("2. Alterar um autor");
			System.out.println("3. Remover um autor");
			System.out.println("4. Listar um autor e seus livros");
			//System.out.println("5. Listar todos os autores e seus livros"); // nao funciona
			System.out.println("6. Sair");
						
			int opcao = Console.readInt('\n' + 
							"Digite um número entre 1 e 6:");
					
			switch (opcao)
			{	case 1:
				{
					nome = Console.readLine('\n' + 
						"Informe o nome do produto: ");
				
					dataCadastro = Console.readLine(
						"Informe a data de cadastramento do produto: ");
						
					Autor autor = new Autor(nome, Util.strToCalendar(dataCadastro));

					long numero = autorAppService.inclui(autor);
					
					System.out.println('\n' + "Produto número " + 
					    numero + " incluído com sucesso!");	

					break;
				}

				case 2:
				{	int resposta = Console.readInt('\n' + 
						"Digite o número do produtoo que você deseja alterar: ");
										
					try
					{	
						umAutor = autorAppService.recuperaUmAutor(resposta);
					}
					catch(ProdutoNaoEncontradoException e)
					{	System.out.println('\n' + e.getMessage());
						break;
					}
										
					System.out.println('\n' + 
						"Número = " + umAutor.getId() + 
						"    Nome = " + umAutor.getNome());
												
					System.out.println('\n' + "O que você deseja alterar?");
					System.out.println('\n' + "1. Nome");
					

					int opcaoAlteracao = Console.readInt('\n' + 
											"Digite um número de 1 a 1: :P");
					
					switch (opcaoAlteracao)
					{	case 1:
							String novoNome = Console.
										readLine("Digite o novo nome: ");
							umAutor.setNome(novoNome);

							try
							{	autorAppService.altera(umAutor);

								System.out.println('\n' + 
									"Alteração de nome efetuada com sucesso!");
							}
							catch(ProdutoNaoEncontradoException e)
							{	System.out.println('\n' + e.getMessage());
							}
								
							break;

						default:
							System.out.println('\n' + "Opção inválida!");
					}

					break;
				}

				case 3:
				{	int resposta = Console.readInt('\n' + 
						"Digite o número do produto que você deseja remover: ");
									
					try
					{	umAutor = autorAppService.
										recuperaUmAutor(resposta);
					}
					catch(ProdutoNaoEncontradoException e)
					{	System.out.println('\n' + e.getMessage());
						break;
					}
										
					System.out.println('\n' + 
						"Número = " + umAutor.getId() + 
						"    Nome = " + umAutor.getNome());
														
					String resp = Console.readLine('\n' + 
						"Confirma a remoção do produto?");

					if(resp.equals("s"))
					{	try
						{	autorAppService.exclui (umAutor);
							System.out.println('\n' + 
								"Autor removido com sucesso!");
						}
						catch(ProdutoNaoEncontradoException e)
						{	System.out.println('\n' + e.getMessage());
						}
					}
					else
					{	System.out.println('\n' + 
							"Autor não removido.");
					}
					
					break;
				}

				case 4:
				{	
					long numero = Console.readInt('\n' + 
						"Informe o número do produto: ");
				
					try
					{	umAutor = autorAppService.
										recuperaUmAutorELivros(numero);
					}
					catch(ProdutoNaoEncontradoException e)
					{	System.out.println('\n' + e.getMessage());
						break;
					}
									
					System.out.println('\n' + 
						"Id = " + umAutor.getId() +
					    "  Nome = " + umAutor.getNome() +
					    "  Data Cadastro = " + umAutor.getDataCriacaoMasc());
					
					List<Livro> livros = umAutor.getLivros();
					
					for (Livro livro : livros)
					{	System.out.println(	'\n' + 
							"      Livro número = "  + livro.getId() + 
							"  nome = "  + livro.getNome() +
							"  sinopse = "  + livro.getSinopse());
					}	
										
					break;
				}

				case 5:
				{
					List<Autor> autores = autorAppService.recuperaListaDeAutores();
						
					if (autores.size() != 0)
					{	System.out.println("");

						for (Autor autor : autores)
						{	System.out.println('\n' + 
								"Autor numero = " + autor.getId() + 
								"  Nome = " + autor.getNome() +
								"  Data Cadastro = " + autor.getDataCriacaoMasc());

							List<Livro> livros = autorAppService.recuperaLivros(autor.getId());
							
							for (Livro livro : livros)
							{	System.out.println(	'\n' + 
									"      Livro número = "  + livro.getId() + 
									"  nome = "  + livro.getNome() +
									"  sinopse = "  + livro.getSinopse());
							}	
                    	} 
					}
					else
					{	System.out.println('\n' + 
						  "Não há produtos cadastrados com esta descrição.");
					}

					break;
				}

				case 6:
				{	continua = false;
					break;
				}

				default:
					System.out.println('\n' + "Opção inválida!");
			}
		}		
	}
}
