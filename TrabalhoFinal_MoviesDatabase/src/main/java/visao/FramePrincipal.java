package visao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class FramePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel panel;
	
	public FramePrincipal() {
		
		frame = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 600);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 534, 562);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastrar = new JMenu("Cadastrar");
		menuBar.add(mnCadastrar);
		
		JMenuItem mntmLivroCadastrar = new JMenuItem("Livro");
		mntmLivroCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DialogCadastrarLivro dialog = new DialogCadastrarLivro(frame);
				dialog.setVisible(true);
			}
		});
		mnCadastrar.add(mntmLivroCadastrar);
		
		JMenuItem mntmAutor = new JMenuItem("Autor");
		mntmAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogCadastrarAutor dialog = new DialogCadastrarAutor(frame);
				dialog.setVisible(true);
			}
		});
		mnCadastrar.add(mntmAutor);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Sair");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JMenu mnBuscar = new JMenu("Buscar");
		menuBar.add(mnBuscar);
		
		JMenuItem mntmLivroBuscar = new JMenuItem("Livro");
		mntmLivroBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DialogBuscar dialog = new DialogBuscar(frame);
				dialog.setVisible(true);
			}
		});
		mnBuscar.add(mntmLivroBuscar);
		
		JMenuItem mntmAutorBuscar = new JMenuItem("Autor");
		mntmAutorBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			DialogTabelAutor dialog = new DialogTabelAutor(frame);
			dialog.setVisible(true);
			}
		});
		mnBuscar.add(mntmAutorBuscar);
		
		menuBar.add(mntmNewMenuItem);
	}
}
