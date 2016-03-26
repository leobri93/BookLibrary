package visao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

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

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.AutorAppService;
import util.DatabaseDateFormat;
import excecao.DataDeLanceInvalidaException;
import excecao.ProdutoNaoEncontradoException;
import excecao.ValorDeLanceInvalidoException;

public class DialogCadastrarAutor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nomeTextField;

	// Informa��es do autor
	private String nome;
	private Calendar dataNascimento;

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
		datePicker.setBounds(88, 123, 165, 36);
		panel.add(datePicker);

		JLabel lblNascimento = new JLabel("Nascimento:");
		lblNascimento.setBounds(10, 125, 79, 14);
		panel.add(lblNascimento);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(89, 200, 89, 23);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Pegando o conteudo do campo nome
				nome = nomeTextField.getText();

				// Pegando o campo data de nascimento
				dataNascimento = (Calendar) datePicker.getModel().getValue();

				// Instancia um objeto autor
				umAutor = new Autor(nome, dataNascimento);

				/**
				try {
					autorAppService.inclui(umAutor);

					System.out.println('\n' + "Autor adicionado com sucesso");
				} catch (ProdutoNaoEncontradoException
						| DataDeLanceInvalidaException
						| ValorDeLanceInvalidoException e) {
					System.out.println(e.getMessage());
				}
				**/
			}
		});
		panel.add(btnSalvar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(223, 200, 89, 23);
		panel.add(btnLimpar);
	}
}