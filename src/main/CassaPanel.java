package main;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CassaPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public CassaPanel(Controller ctrl) {
		
		setOpaque(false);
		setBackground(new Color(0, 80, 157));
		setBounds(0, 0, 765, 600);
		setLayout(null);
		
		JPanel PanelProdottiCarrello = new JPanel();
		PanelProdottiCarrello.setBackground(new Color(0, 80, 157));
		PanelProdottiCarrello.setBounds(10, 79, 745, 499);
		add(PanelProdottiCarrello);
	}
}
