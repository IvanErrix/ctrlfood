package Design;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;

import main.Controller;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;

public class AggiungiAlNegozioDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	public AggiungiAlNegozioDialog(Controller ctrl) {
		setUndecorated(true);
		setSize(680, 490);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		getContentPane().setBackground(new Color(0, 67, 137));
		getContentPane().setLayout(null);
		((JComponent) getContentPane()).setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		
		JLabel LabelTipologia = new JLabel("Tipologia");
		LabelTipologia.setForeground(new Color(0,41,82));
		LabelTipologia.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelTipologia.setBounds(220, 101, 92, 21);
		getContentPane().add(LabelTipologia);
		
		JLabel LabelNome = new JLabel("Nome");
		LabelNome.setForeground(new Color(0,41,82));
		LabelNome.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelNome.setBounds(220, 162, 46, 14);
		getContentPane().add(LabelNome);
		
		JLabel lblQuantita = new JLabel("Quantit\u00E0");
		lblQuantita.setForeground(new Color(0,41,82));
		lblQuantita.setFont(new Font("Impact", Font.PLAIN, 16));
		lblQuantita.setBounds(220, 222, 68, 14);
		getContentPane().add(lblQuantita);
		
		JButton ButtonAggiugni = new JButton("");
		ButtonAggiugni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonAggiugni.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAggiungi2Azzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonAggiugni.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAggiungi2Azzurro.png")));
			}
		});
		ButtonAggiugni.setPressedIcon(new ImageIcon(AggiungiAlNegozioDialog.class.getResource("/scrimg/ButtonAggiungi2.png")));
		ButtonAggiugni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAggiugni.setOpaque(false);
		ButtonAggiugni.setBorder(null);
		ButtonAggiugni.setContentAreaFilled(false);
		ButtonAggiugni.setIcon(new ImageIcon(AggiungiAlNegozioDialog.class.getResource("/scrimg/ButtonAggiungi2.png")));
		ButtonAggiugni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "PRODOTTO AGGIUNTO CORRETTAMENTE", "", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		ButtonAggiugni.setBounds(467, 344, 110, 24);
		getContentPane().add(ButtonAggiugni);
		
		JButton ButtonAnnulla = new JButton("");
		ButtonAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonAnnulla.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAnnullaAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonAnnulla.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
			}
		});
		ButtonAnnulla.setPressedIcon(new ImageIcon(AggiungiAlNegozioDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
		ButtonAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		ButtonAnnulla.setOpaque(false);
		ButtonAnnulla.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
		ButtonAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAnnulla.setBorder(null);
		ButtonAnnulla.setContentAreaFilled(false);
		ButtonAnnulla.setBounds(220, 344, 110, 24);
		getContentPane().add(ButtonAnnulla);
		
		JComboBox comboBoxNome = new JComboBox();
		comboBoxNome.setBorder(null);
		comboBoxNome.setFocusable(false);
		comboBoxNome.setForeground(new Color(0,41,82));
		comboBoxNome.setBackground(new Color(191,215,255));
		comboBoxNome.setBounds(387, 152, 190, 24);
		getContentPane().add(comboBoxNome);
		
		JComboBox comboBoxTipologia = new JComboBox();
		comboBoxTipologia.setModel(new DefaultComboBoxModel(new String[] {"Ortofrutta", "Latticini", "Confezionati"}));
		comboBoxTipologia.setMaximumRowCount(3);
		comboBoxTipologia.setForeground(new Color(0,41,82));
		comboBoxTipologia.setFont(new Font("Impact", Font.PLAIN, 11));
		comboBoxTipologia.setFocusable(false);
		comboBoxTipologia.setBorder(null);
		comboBoxTipologia.setBackground(new Color(191,215,255));
		comboBoxTipologia.setBounds(387, 101, 190, 24);
		getContentPane().add(comboBoxTipologia);
		
		SpinnerNumberModel model = new SpinnerNumberModel(1, null, 50, 1);
		JSpinner spinnerQuantita = new JSpinner(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		spinnerQuantita.setOpaque(false);
		spinnerQuantita.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0,41,82), new Color (0,41,82)));
		spinnerQuantita.getComponent(0).setBackground(new Color(191,215,255));
		spinnerQuantita.getComponent(1).setBackground(new Color(191,215,255));
		spinnerQuantita.getEditor().getComponent(0).setBackground(new Color(191,215,255));
		spinnerQuantita.getEditor().getComponent(0).setForeground(new Color(0,41,82));
		spinnerQuantita.setRequestFocusEnabled(false);
		spinnerQuantita.setFont(new Font("Impact", Font.PLAIN, 14));
		spinnerQuantita.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		spinnerQuantita.setBounds(387, 218, 60, 24);
		getContentPane().add(spinnerQuantita);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AggiungiAlNegozioDialog.class.getResource("/scrimg/SfondoAggiungiAlnegozio.png")));
		lblNewLabel.setBounds(158, 47, 467, 376);
		getContentPane().add(lblNewLabel);
		

		JLabel LabelSfondo = new JLabel("");
		LabelSfondo.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/Group 4.png")));
		LabelSfondo.setBounds(0, 0, 680, 490);
		getContentPane().add(LabelSfondo);
	}
}
