package visao;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.Autor;
import modelo.Livro;
import service.AutorAppService;
import service.LivroAppService;
import util.Util;
import excecao.DataDeLanceInvalidaException;
import excecao.ProdutoNaoEncontradoException;
import excecao.ValorDeLanceInvalidoException;


public class DialogCadastrar extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField nomeTextField;
	private JButton btnSalvar;
	private JButton btnLimpar;
	private JTextField sinopseTextField;
	private JTextField idAutorTextField;
	
	/////////////////informações de livro//////////////////
	String sinopse;
	String dataCriacao;
	String nome;
	Long numeroExemplares;
	
	Autor umAutor;
	Livro umLivro;
	/////////////////informações de livro//////////////////
	
	///////////////////////////mágica de DAOs///////////////////////////////////////
	@SuppressWarnings("resource")
	ApplicationContext fabrica = new ClassPathXmlApplicationContext("beans-jpa.xml");

	AutorAppService autorAppService = 
		(AutorAppService)fabrica.getBean ("autorAppService");
	LivroAppService livroAppService = 
		(LivroAppService)fabrica.getBean ("livroAppService");
	
	///////////////////////////mágica de DAOs///////////////////////////////////////
	
	
	public DialogCadastrar(JFrame frame) {
		
		super(frame);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, 10, 450, 500);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 462);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		// ---------- Cadastro de livros ------------ // 
		JLabel lblNewLabel = new JLabel("Cadastro de Livros");
		lblNewLabel.setFont(new Font("Leelawadee UI", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 26, 434, 23);
		panel.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(38, 95, 46, 14);
		panel.add(lblNome);
		
		JLabel lblSinopse = new JLabel("Sinopse:");
		lblSinopse.setBounds(38, 125, 61, 14);
		panel.add(lblSinopse);
		
		JLabel lblIdAutor = new JLabel("Id Autor:");
		lblIdAutor.setToolTipText("");
		lblIdAutor.setBounds(38, 155, 79, 14);
		panel.add(lblIdAutor);
		
		nomeTextField = new JTextField();
		nomeTextField.setBounds(109, 92, 289, 20);
		panel.add(nomeTextField);
		nomeTextField.setColumns(10);
		
		
		sinopseTextField = new JTextField();
		sinopseTextField.setBounds(109, 122, 289, 20);
		panel.add(sinopseTextField);
		sinopseTextField.setColumns(10);
		
		
		idAutorTextField = new JTextField();
		idAutorTextField.setToolTipText("Para inserir o Id busque o autor abaixo");
		idAutorTextField.setBounds(109, 152, 289, 20);
		panel.add(idAutorTextField);
		idAutorTextField.setColumns(10);
		
		
		
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				nome=nomeTextField.getText();//pegando o conteudo do campo nome.
				sinopse=sinopseTextField.getText();//pegando o conteudo do campo sinopse.
				dataCriacao="12/02/2004";//jogando um numero aleatorio
				
				/////////////////////////////criando um objeto autor(umAutor) apartir do id colhido/////////////////
				try
				{	umAutor = autorAppService.recuperaUmAutor(1);
				}
				catch(ProdutoNaoEncontradoException e)
				{	System.out.println('\n' + e.getMessage());

				}
				/////////////////////////////criando um objeto autor(umAutor) apartir do id colhido/////////////////
				
				numeroExemplares = (long) 50;    //vou manter fixo, pq sim.
				umLivro = new Livro(nome, sinopse, numeroExemplares, Util.strToCalendar(dataCriacao), umAutor);
				
				try
				{	livroAppService.inclui(umLivro);	

					System.out.println('\n' + "Livro adicionado com sucesso");						
				}
				catch(ProdutoNaoEncontradoException |
					  DataDeLanceInvalidaException |
					  ValorDeLanceInvalidoException e)
				{	
					System.out.println(e.getMessage());
				}
			}
		});
		btnSalvar.setBounds(119, 192, 89, 23);
		panel.add(btnSalvar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				nomeTextField   .setText("");
				sinopseTextField.setText("");
				idAutorTextField.setText("");
			}
		});
		btnLimpar.setBounds(244, 192, 89, 23);
		panel.add(btnLimpar);
		
		// ------------ Fim do Cadastro ---------------- //
		
		// ------------ Busca de Autor ----------------- //
		JLabel lblBuscarAutor = new JLabel("Busca Autor");
		lblBuscarAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarAutor.setFont(new Font("Leelawadee UI", Font.BOLD, 13));
		lblBuscarAutor.setBounds(0, 246, 434, 14);
		panel.add(lblBuscarAutor);
		
		
		
	}
}
