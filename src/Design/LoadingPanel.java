package Design;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import main.Controller;

import javax.swing.JLabel;

public class LoadingPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public LoadingPanel(Controller ctrl) {
		setLayout(null);
		setSize(64, 64);
		
		JLabel LabelLoading = new JLabel("");
		LabelLoading.setIcon(new ImageIcon(LoadingPanel.class.getResource("/scrimg/GIFCaricamentoYellow.gif")));
		LabelLoading.setBounds(0, 0, 64, 64);
		add(LabelLoading);
		
	}
}
