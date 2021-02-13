package Design;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import ExternalClasses.ContentPane;
import Main.Controller;

import javax.swing.JLabel;

public class LoadingDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private ContentPane contentPane;
	private JLabel LabelLoading;

	public LoadingDialog(Controller ctrl) {
		setAlwaysOnTop(true);
		setUndecorated(true);
		setSize(64, 64);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		getContentPane().setLayout(null);
		
		/*CONTENTPANE*/
		contentPane = new ContentPane();
		setContentPane(contentPane);
		getContentPane().isOpaque();
		setBackground(new Color(0, 67, 137, 0));
		contentPane.setLayout(null);
		
		/*LABEL LOADING*/
		LabelLoading = new JLabel("");
		LabelLoading.setIcon(new ImageIcon(LoadingDialog.class.getResource("/scrimg/GIFCaricamentoBlue.gif")));
		LabelLoading.setBounds(0, 0, 64, 64);
		getContentPane().add(LabelLoading);
		
	}
}
