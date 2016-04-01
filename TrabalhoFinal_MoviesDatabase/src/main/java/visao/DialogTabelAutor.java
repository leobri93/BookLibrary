package visao;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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
	
	public DialogTabelAutor(JFrame frame) {
		super(frame);
		setBounds(10, 10, 450, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 169);
		contentPanel.add(panel);
		panel.setLayout(null);
		

		JLabel lblPesquisaDeAutores = new JLabel("Buscar Autor");
		lblPesquisaDeAutores.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesquisaDeAutores.setFont(new Font("Leelawadee UI", Font.BOLD, 13));
		lblPesquisaDeAutores.setBounds(0, 11, 434, 14);

		panel.add(lblPesquisaDeAutores);
		
		JLabel lblAutores = new JLabel("Autor:");
		lblAutores.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAutores.setBounds(34, 74, 45, 14);
		panel.add(lblAutores);
		
		fatorTextField = new JTextField();
		fatorTextField.setBounds(89, 72, 276, 20);
		panel.add(fatorTextField);
		fatorTextField.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String log = fatorTextField.getText();
				AutorModel model = new AutorModel();
	
				model.setFatorDeBusca(log);
				table.setModel(model);
				scrollPane.setVisible(true);
			}
		});
		btnPesquisar.setBounds(168, 122, 110, 23);
		panel.add(btnPesquisar);
		
	    scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 214, 434, 247);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(new Font("Leelawadee UI", Font.BOLD, 13));
		lblResultado.setBounds(0, 180, 434, 14);
		contentPanel.add(lblResultado);
		
	}
}
