package visao;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JList;

public class DialogBuscar extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField txtDigiteONome;
	
	public DialogBuscar(JFrame frame){
		super(frame);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, 10, 450, 500);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 462);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblBuscarLivros = new JLabel("Buscar Livros");
		lblBuscarLivros.setFont(new Font("Leelawadee UI", Font.BOLD, 13));
		lblBuscarLivros.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarLivros.setBounds(0, 35, 434, 14);
		panel.add(lblBuscarLivros);
		
		JLabel lblNomeDoLivro = new JLabel("Nome do Livro:");
		lblNomeDoLivro.setBounds(33, 107, 83, 14);
		panel.add(lblNomeDoLivro);
		
		txtDigiteONome = new JTextField();
		txtDigiteONome.setToolTipText("Digite aqui o nome do livro");
		txtDigiteONome.setBounds(112, 104, 267, 20);
		panel.add(txtDigiteONome);
		txtDigiteONome.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(164, 159, 101, 23);
		panel.add(btnBuscar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 203, 434, 8);
		panel.add(separator);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(new Font("Leelawadee UI", Font.BOLD, 13));
		lblResultado.setBounds(0, 222, 434, 14);
		panel.add(lblResultado);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(33, 262, 374, 157);
		panel.add(textArea);
	}
}
