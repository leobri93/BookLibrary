package visao;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class DialogBuscar extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField txtNomeLivro;
	
	public DialogBuscar(JFrame frame){
		super(frame);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, 10, 450, 500);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 152);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblBuscarLivros = new JLabel("Buscar Livros");
		lblBuscarLivros.setFont(new Font("Leelawadee UI", Font.BOLD, 13));
		lblBuscarLivros.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarLivros.setBounds(0, 24, 434, 14);
		panel.add(lblBuscarLivros);
		
		JLabel lblNomeDoLivro = new JLabel("Nome do Livro:");
		lblNomeDoLivro.setBounds(30, 63, 83, 14);
		panel.add(lblNomeDoLivro);
		
		txtNomeLivro = new JTextField();
		txtNomeLivro.setToolTipText("Digite aqui o nome do livro");
		txtNomeLivro.setBounds(108, 60, 267, 20);
		panel.add(txtNomeLivro);
		txtNomeLivro.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(166, 116, 101, 23);
		panel.add(btnBuscar);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(0, 181, 434, 14);
		getContentPane().add(lblResultado);
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(new Font("Leelawadee UI", Font.BOLD, 13));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 210, 434, 251);
		getContentPane().add(scrollPane);
	}
}
