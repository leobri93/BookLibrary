package visao;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class DialogCadastrar extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField nomeTextField;
	private JButton btnCopiar;
	private JButton btnApagar;
	private JTextArea obsTextArea;
	private final ButtonGroup sexoButtonGroup = new ButtonGroup();
	private JTextField textField;
	private JTextField textField_1;
	
	public DialogCadastrar(JFrame frame) {
		
		super(frame);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, 10, 450, 500);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 462);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Livros");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 26, 434, 23);
		panel.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(38, 95, 46, 14);
		panel.add(lblNome);
		
		JLabel lblSexo = new JLabel("Sinopse:");
		lblSexo.setBounds(38, 125, 46, 14);
		panel.add(lblSexo);
		
		JLabel lblFaixaEtria = new JLabel("Id Autor:");
		lblFaixaEtria.setBounds(38, 155, 79, 14);
		panel.add(lblFaixaEtria);
		
		nomeTextField = new JTextField();
		nomeTextField.setBounds(109, 92, 289, 20);
		panel.add(nomeTextField);
		nomeTextField.setColumns(10);
		
		btnCopiar = new JButton("Copiar");
		btnCopiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				StringBuilder ss;
				StringBuffer sb = new StringBuffer(300);
				sb.append("Nome: " + nomeTextField.getText() + '\n');
		        obsTextArea.append(sb.toString());
				obsTextArea.append("\n************** FIM **************\n");
			}
		});
		btnCopiar.setBounds(119, 192, 89, 23);
		panel.add(btnCopiar);
		
		btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nomeTextField.setText("");
				obsTextArea.setText("");
			}
		});
		btnApagar.setBounds(244, 192, 89, 23);
		panel.add(btnApagar);
		
		obsTextArea = new JTextArea();
		obsTextArea.setBounds(38, 284, 360, 150);
		panel.add(obsTextArea);
		
		textField = new JTextField();
		textField.setBounds(109, 122, 289, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(109, 152, 289, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
	}
}
