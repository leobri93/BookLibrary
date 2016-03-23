package visao;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class DialogBuscar extends JDialog {
	private static final long serialVersionUID = 1L;
	
	public DialogBuscar(JFrame frame){
		super(frame);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
	}
}
