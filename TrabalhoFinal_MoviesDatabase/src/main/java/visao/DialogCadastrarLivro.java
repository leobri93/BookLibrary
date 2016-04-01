package visao;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import modelo.Autor;
import modelo.Livro;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.AutorAppService;
import service.LivroAppService;
import util.DatabaseDateFormat;
import util.Util;
import excecao.AutorNaoEncontradoException;
import excecao.NomeDeLivroJaCadastrado;


public class DialogCadastrarLivro extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField nomeTextField;
	private JButton btnSalvar;
	private JButton btnLimpar;
	private JTextField sinopseTextField;
	private JTextField idAutorTextField;
	private JTextField numeroExemplaresTextField;
	private JLabel lblLivroCadastradoCom;
	
	// Informações de livro
	private String sinopse;
	private Calendar dataCriacao;
	private String nome;
	private long numeroExemplares;
	
	private Autor umAutor;
	private Livro umLivro;
	
	
	
	// ----------------------- Fabrica de DAOs --------------------------- //
	ApplicationContext fabrica = new ClassPathXmlApplicationContext("beans-jpa.xml");

	AutorAppService autorAppService = 
		(AutorAppService)fabrica.getBean ("autorAppService");
	LivroAppService livroAppService = 
		(LivroAppService)fabrica.getBean ("livroAppService");
	private final JSeparator separator = new JSeparator();
	// ----------------------- Fim da fabrica de DAOs -------------------- //
	
	public DialogCadastrarLivro(JFrame frame) {
		
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
		lblNome.setBounds(20, 80, 64, 14);
		panel.add(lblNome);
		
		JLabel lblSinopse = new JLabel("Sinopse:");
		lblSinopse.setBounds(20, 111, 79, 14);
		panel.add(lblSinopse);
		
		JLabel lblIdAutor = new JLabel("Id Autor:");
		lblIdAutor.setBounds(20, 142, 97, 14);
		panel.add(lblIdAutor);
		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DatabaseDateFormat());
		datePicker.getJFormattedTextField().setToolTipText("Selecione a data de emiss\u00E3o");
		SpringLayout springLayout = (SpringLayout) datePicker.getLayout();
		springLayout.putConstraint(SpringLayout.SOUTH, datePicker.getJFormattedTextField(), 0, SpringLayout.SOUTH, datePicker);
		datePicker.setBounds(109, 198, 165, 36);
		panel.add(datePicker);
		
		nomeTextField = new JTextField();
		nomeTextField.setBounds(109, 77, 289, 20);
		panel.add(nomeTextField);
		nomeTextField.setColumns(10);
		
		
		sinopseTextField = new JTextField();
		sinopseTextField.setBounds(109, 108, 289, 20);
		panel.add(sinopseTextField);
		sinopseTextField.setColumns(10);
		
		
		idAutorTextField = new JTextField();
		idAutorTextField.setToolTipText("Para inserir o Id busque o autor abaixo");
		idAutorTextField.setBounds(109, 139, 289, 20);
		panel.add(idAutorTextField);
		idAutorTextField.setColumns(10);
		
		JLabel lblDataDeEmissao = new JLabel("Data de Emiss\u00E3o:");
		lblDataDeEmissao.setBounds(20, 201, 96, 14);
		panel.add(lblDataDeEmissao);
		
		JLabel lblNumExemplares = new JLabel("N. Exemplares:");
		lblNumExemplares.setBounds(20, 170, 87, 14);
		panel.add(lblNumExemplares);
		
		numeroExemplaresTextField = new JTextField();
		numeroExemplaresTextField.setBounds(109, 167, 289, 20);
		panel.add(numeroExemplaresTextField);
		numeroExemplaresTextField.setColumns(10);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Pegando o conteudo do campo nome
				nome = nomeTextField.getText();
				
				//Pegando o conteudo do campo sinopse
				sinopse = sinopseTextField.getText();
				
				//Pegando o campo data de criacao
				Date selectedDate = (Date) datePicker.getModel().getValue();
			    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			    String formattedDate = df.format(selectedDate);
				dataCriacao = Util.strToCalendar(formattedDate) ;
				
				//Pegando numero de exemplares
				numeroExemplares = Long.parseLong(numeroExemplaresTextField.getText());
				
				// -------------------- Criando um objeto autor com o id colhido ------------------- // 
				try
				{	
					umAutor = autorAppService.recuperaUmAutor(Long.parseLong(idAutorTextField.getText()));
				
				}
				catch(AutorNaoEncontradoException e)
				{	
					System.out.println(e.getMessage());
					
				}
				// -------------------- Fim da criacao do autor ------------------------------------ //
				
				
				//Instanciando objeto livro
				umLivro = new Livro(nome, sinopse, numeroExemplares, dataCriacao, umAutor);
				
				try
				{	livroAppService.inclui(umLivro);
					lblLivroCadastradoCom.setVisible(true);
										
				}
				catch(NomeDeLivroJaCadastrado e)
				{	
					System.out.println(e.getMessage());
					
				}
			}
		});
		btnSalvar.setBounds(119, 245, 89, 23);
		panel.add(btnSalvar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				nomeTextField            .setText("");
				sinopseTextField         .setText("");
				idAutorTextField         .setText("");
				numeroExemplaresTextField.setText("");
				lblLivroCadastradoCom.setVisible(false);
			}
		});
		btnLimpar.setBounds(239, 245, 89, 23);
		panel.add(btnLimpar);
		
		// ------------ Fim do Cadastro ---------------- //
		
		separator.setBounds(0, 317, 434, 31);
		panel.add(separator);
		
		// ------------ Busca de Autor ----------------- //
		JLabel lblBuscarAutor = new JLabel("Busca Autor");
		lblBuscarAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarAutor.setFont(new Font("Leelawadee UI", Font.BOLD, 13));
		lblBuscarAutor.setBounds(0, 334, 434, 14);
		panel.add(lblBuscarAutor);
		
		JButton btnBuscarAutor = new JButton("Ir para Busca de Autor");
		btnBuscarAutor.setBounds(119, 380, 209, 23);
		btnBuscarAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			DialogTabelAutor dialog = new DialogTabelAutor(frame);
			dialog.setVisible(true);
			}
		});
		panel.add(btnBuscarAutor);
		
		lblLivroCadastradoCom = new JLabel("Livro cadastrado com sucesso!");
		lblLivroCadastradoCom.setHorizontalAlignment(SwingConstants.CENTER);
		lblLivroCadastradoCom.setFont(new Font("Leelawadee UI", Font.ITALIC, 13));
		lblLivroCadastradoCom.setBounds(0, 283, 434, 14);
		panel.add(lblLivroCadastradoCom);
		lblLivroCadastradoCom.setVisible(false);
		// ----------- Fim da busca de autor ---------- //
	}
}
