package ExternalClasses;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicScrollBarUI;

import Design.AggiungiAlDepositoDialog;

public class HorizontalScrollBarUI  extends BasicScrollBarUI {
	@Override
	protected JButton createDecreaseButton(int orientation) {
		JButton button = new JButton();
		button.setBorder(null);
		button.setContentAreaFilled(false);
		button.setOpaque(false);
		button.setSize(16,16);
		button.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/FrecciaSx.png")));
		return  button ;
	};


	@Override
	protected JButton createIncreaseButton(int orientation) {
		JButton button = new JButton();
		button.setBorder(null);
		button.setBackground(new Color(191,215,255));
		button.setContentAreaFilled(false);
		button.setOpaque(false);
		button.setSize(16,16);
		button.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/FrecciaDx.png")));
		return  button ;
	};
}
