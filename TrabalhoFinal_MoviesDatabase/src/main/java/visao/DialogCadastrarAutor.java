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
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import modelo.Autor;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.AutorAppService;
import util.DatabaseDateFormat;
import util.Util;

public class DialogCadastrarAutor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nomeTextField;
	private JLabel lblAtenoCampoNome;

	// Informa��es do autor
	private String nome;
	private Calendar dataNascimento;
	private JLabel lblAutorCadastrado;
	private Autor umAutor;
	
	

	// ----------------------- Fabrica de DAOs --------------------------- //
	ApplicationContext fabrica = new ClassPathXmlApplicationContext(
			"beans-jpa.xml");

	AutorAppService autorAppService = (AutorAppService) fabrica
			.getBean("autorAppService");

	// ----------------------- Fim da fabrica de DAOs -------------------- //

	public DialogCadastrarAutor(JFrame frame) {
		super(frame);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, 10, 450, 500);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 462);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCadastroDeAutor = new JLabel("Cadastro de Autor");
		lblCadastroDeAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeAutor.setFont(new Font("Leelawadee UI", Font.BOLD, 13));
		lblCadastroDeAutor.setBounds(0, 30, 434, 14);
		panel.add(lblCadastroDeAutor);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 82, 59, 14);
		panel.add(lblNome);

		nomeTextField = new JTextField();
		nomeTextField.setBounds(79, 79, 295, 20);
		panel.add(nomeTextField);
		nomeTextField.setColumns(10);

		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel,
				new DatabaseDateFormat());
		datePicker.getJFormattedTextField().setToolTipText(
				"Selecione a data de emiss\u00E3o");
		SpringLayout springLayout = (SpringLayout) datePicker.getLayout();
		springLayout.putConstraint(SpringLayout.SOUTH,
				datePicker.getJFormattedTextField(), 0, SpringLayout.SOUTH,
				datePicker);
		datePicker.setBounds(79, 139, 165, 36);
		panel.add(datePicker);

		JLabel lblNascimento = new JLabel("Nascimento:");
		lblNascimento.setBounds(10, 143, 79, 14);
		panel.add(lblNascimento);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(89, 200, 89, 23);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Pegando o conteudo do campo nome
				nome = nomeTextField.getText();

				// Pegando o campo data de nascimento
				Date selectedDate = (Date) datePicker.getModel().getValue();
			    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			    String formattedDate = df.format(selectedDate);
			    dataNascimento = Util.strToCalendar(formattedDate) ;

				// Instancia um objeto autor
				umAutor = new Autor(nome, dataNascimento);

				try 
				{	
					
					
					if (!nome.isEmpty()) {
						autorAppService.inclui(umAutor);
						lblAutorCadastrado.setVisible(true);
						lblAtenoCampoNome.setVisible(false);
					}else{
						
						lblAtenoCampoNome.setVisible(true);
					}					
				}
				catch(Exception  b)
				{	
					System.out.println(b.getMessage());
				}
				
			}
		});
		panel.add(btnSalvar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(223, 200, 89, 23);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nomeTextField.setText("");
				lblAutorCadastrado.setVisible(false);
			}
		});
		panel.add(btnLimpar);
		
		lblAutorCadastrado = new JLabel("Autor cadastrado!");
		lblAutorCadastrado.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutorCadastrado.setFont(new Font("Leelawadee UI", Font.ITALIC, 13));
		lblAutorCadastrado.setBounds(0, 283, 424, 14);
		panel.add(lblAutorCadastrado);
		lblAutorCadastrado.setVisible(false);
		
		lblAtenoCampoNome = new JLabel("Aten\u00E7\u00E3o: Campo nome n\u00E3o preenchido");
		lblAtenoCampoNome.setFont(new Font("Leelawadee UI", Font.ITALIC, 13));
		lblAtenoCampoNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtenoCampoNome.setBounds(0, 110, 434, 14);
		panel.add(lblAtenoCampoNome);
		lblAtenoCampoNome.setVisible(false);
	}
}
