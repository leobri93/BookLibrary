package visao;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Autor;
import service.AutorAppService;
import util.AutorModel;

public class DialogTabelAutor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField fatorTextField;
	private JTable table;
	private JScrollPane scrollPane;
	private static AutorAppService autorAppService = new AutorAppService();
	
	public DialogTabelAutor(JFrame frame) {
		super(frame);
		setBounds(100, 100, 550, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 534, 169);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblPesquisaDeAutores = new JLabel("Pesquisa de autores");
		lblPesquisaDeAutores.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPesquisaDeAutores.setBounds(205, 11, 139, 14);
		panel.add(lblPesquisaDeAutores);
		
		JLabel lblAutores = new JLabel("Autor:");
		lblAutores.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAutores.setBounds(93, 74, 45, 14);
		panel.add(lblAutores);
		
		fatorTextField = new JTextField();
		fatorTextField.setBounds(148, 72, 276, 20);
		panel.add(fatorTextField);
		fatorTextField.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String log = fatorTextField.getText();
				AutorModel model = new AutorModel();
				
				int qtd = (int)autorAppService.recuperaQtd(log.toUpperCase());
				System.out.println("resultados = " + qtd);
				List<Autor> resultados = autorAppService
						.recuperaListaDeAutoresLimitado(log.toUpperCase(), 1, 2);
					
				System.out.println("resultados = " + resultados.size());
				model.setFatorDeBusca(log);
				table.setModel(model);
				scrollPane.setVisible(true);
			}
		});
		btnPesquisar.setBounds(230, 122, 89, 23);
		panel.add(btnPesquisar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 180, 534, 381);
		contentPanel.add(scrollPane);
		
	}
}
