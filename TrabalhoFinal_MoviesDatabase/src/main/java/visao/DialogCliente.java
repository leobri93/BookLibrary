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


public class DialogCliente extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField nomeTextField;
	private JRadioButton sexoMascRdbtn;
	private JRadioButton sexoFemRdbtn;
	private JComboBox<String> faixaEtariaComboBox;
	private JCheckBox chckbxDesejaReceber;
	private JButton btnCopiar;
	private JButton btnApagar;
	private JTextArea obsTextArea;
	private final ButtonGroup sexoButtonGroup = new ButtonGroup();
	
	public DialogCliente(JFrame frame) {
		
		super(frame);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, 10, 450, 500);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 462);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 26, 434, 23);
		panel.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(38, 95, 46, 14);
		panel.add(lblNome);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(38, 125, 46, 14);
		panel.add(lblSexo);
		
		JLabel lblFaixaEtria = new JLabel("Faixa Et\u00E1ria:");
		lblFaixaEtria.setBounds(38, 155, 79, 14);
		panel.add(lblFaixaEtria);
		
		JLabel lblNewsLetter = new JLabel("News Letter:");
		lblNewsLetter.setBounds(38, 185, 79, 14);
		panel.add(lblNewsLetter);
		
		nomeTextField = new JTextField();
		nomeTextField.setBounds(109, 92, 289, 20);
		panel.add(nomeTextField);
		nomeTextField.setColumns(10);
		
		sexoMascRdbtn = new JRadioButton("Masculino");
		sexoButtonGroup.add(sexoMascRdbtn);
		sexoMascRdbtn.setBounds(109, 121, 87, 23);
		panel.add(sexoMascRdbtn);
		
		sexoFemRdbtn = new JRadioButton("Feminino");
		sexoButtonGroup.add(sexoFemRdbtn);
		sexoFemRdbtn.setBounds(198, 121, 109, 23);
		panel.add(sexoFemRdbtn);
		
		faixaEtariaComboBox = new JComboBox<String>();
		faixaEtariaComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "At\u00E9 30 Anos", "De 31 a 40 Anos", "De 41 a 50 Anos", "Acima de 50 Anos"}));
		faixaEtariaComboBox.setBounds(109, 152, 224, 20);
		panel.add(faixaEtariaComboBox);
		
		chckbxDesejaReceber = new JCheckBox("Deseja receber?");
		chckbxDesejaReceber.setBounds(109, 181, 165, 23);
		panel.add(chckbxDesejaReceber);
		
		btnCopiar = new JButton("Copiar");
		btnCopiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				StringBuilder ss;
				StringBuffer sb = new StringBuffer(300);
				sb.append("Nome: " + nomeTextField.getText() + '\n');
				String sexo;
				if (sexoMascRdbtn.isSelected())
					sexo = "Masculino";
				else if (sexoFemRdbtn.isSelected())
					sexo = "Feminino";
				else
					sexo = "";
				sb.append("Sexo = " + sexo + '\n');
				sb.append("Faixa Etária: " + faixaEtariaComboBox.getSelectedItem() + '\n');
				sb.append("News Letter: " + (chckbxDesejaReceber.isSelected() ? "Sim" : "Não"));
				obsTextArea.append(sb.toString());
				obsTextArea.append("\n************** FIM **************\n");
			}
		});
		btnCopiar.setBounds(129, 237, 89, 23);
		panel.add(btnCopiar);
		
		btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nomeTextField.setText("");
				sexoButtonGroup.clearSelection();
				faixaEtariaComboBox.setSelectedIndex(0);
				chckbxDesejaReceber.setSelected(false);
				obsTextArea.setText("");
			}
		});
		btnApagar.setBounds(248, 237, 89, 23);
		panel.add(btnApagar);
		
		obsTextArea = new JTextArea();
		obsTextArea.setBounds(38, 284, 360, 150);
		panel.add(obsTextArea);
	}
}
