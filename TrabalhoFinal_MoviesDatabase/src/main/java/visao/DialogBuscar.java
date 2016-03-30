package visao;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import util.LivroModel;

public class DialogBuscar extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField txtNomeLivro;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JScrollPane scrollPane;
	
	public DialogBuscar(JFrame frame){
		super(frame);
		
		setBounds(10, 10, 450, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 152);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblBuscarLivros = new JLabel("Buscar Livros");
		lblBuscarLivros.setFont(new Font("Leelawadee UI", Font.BOLD, 13));
		lblBuscarLivros.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarLivros.setBounds(0, 24, 434, 14);
		panel.add(lblBuscarLivros);
		
		JLabel lblNomeDoLivro = new JLabel("Nome do Livro:");
		lblNomeDoLivro.setBounds(10, 63, 88, 14);
		panel.add(lblNomeDoLivro);
		
		txtNomeLivro = new JTextField();
		txtNomeLivro.setToolTipText("Digite aqui o nome do livro");
		txtNomeLivro.setBounds(92, 60, 283, 20);
		panel.add(txtNomeLivro);
		txtNomeLivro.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(166, 116, 101, 23);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String log = txtNomeLivro.getText();
				LivroModel model = new LivroModel();
	
				model.setFatorDeBusca(log);
				table.setModel(model);
				scrollPane.setVisible(true);
			}
		});
		panel.add(btnBuscar);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(0, 181, 434, 14);
		contentPanel.add(lblResultado);
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(new Font("Leelawadee UI", Font.BOLD, 13));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 210, 434, 251);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
