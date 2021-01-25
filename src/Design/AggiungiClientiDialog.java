package Design;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import main.Controller;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

public class AggiungiClientiDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	public AggiungiClientiDialog(Controller ctrl) {
		
		setUndecorated(true);
		setSize(623, 463);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		getContentPane().setBackground(new Color(0, 67, 137));
		getContentPane().setLayout(null);
		((JComponent) getContentPane()).setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		
		JLabel LabelNome = new JLabel("Nome");
		LabelNome.setForeground(new Color(255, 213, 0));
		LabelNome.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelNome.setBounds(10, 33, 46, 14);
		getContentPane().add(LabelNome);
		
		JLabel LabelCognome = new JLabel("Cognome");
		LabelCognome.setForeground(new Color(255, 213, 0));
		LabelCognome.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelCognome.setBounds(10, 102, 68, 14);
		getContentPane().add(LabelCognome);
		
		JLabel LabelCodiceFiscale = new JLabel("Codice Fiscale");
		LabelCodiceFiscale.setForeground(new Color(255, 213, 0));
		LabelCodiceFiscale.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelCodiceFiscale.setBounds(10, 165, 118, 14);
		getContentPane().add(LabelCodiceFiscale);
		
		JTextField textFieldNome = new JTextField();
		textFieldNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textFieldNome.getText().length()<15) {
					char c=e.getKeyChar();
					if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE ))
						e.consume();
				}
				else {
					char c=e.getKeyChar();
					if(!((c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE ))
						e.consume();
				}

			}
		});
		textFieldNome.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldNome.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldNome.setForeground(new Color(255, 213, 0));
		textFieldNome.setOpaque(false);
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(220, 17, 267, 30);
		textFieldNome.setCaretColor(new Color(255, 213, 0));
		getContentPane().add(textFieldNome);
		
		JTextField textFieldCognome = new JTextField();
		textFieldCognome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textFieldCognome.getText().length()<15) {
					char c=e.getKeyChar();
					if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE ))
						e.consume();
				}
				else {
					char c=e.getKeyChar();
					if(!((c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE ))
						e.consume();
				}
			}
		});
		textFieldCognome.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldCognome.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldCognome.setOpaque(false);
		textFieldCognome.setForeground(new Color(255, 213, 0));
		textFieldCognome.setColumns(10);
		textFieldCognome.setBounds(220, 86, 267, 30);
		textFieldCognome.setCaretColor(new Color(255, 213, 0));
		getContentPane().add(textFieldCognome);
		
		JTextField textFieldCodiceFiscale = new JTextField();
		textFieldCodiceFiscale.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textFieldCodiceFiscale.getText().length()<16) {
					char c=e.getKeyChar();
					if(!(Character.isAlphabetic(c) || Character.isDigit(c) ||  (c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE ))
						e.consume();
				}
				else {
					char c=e.getKeyChar();
					if(!((c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE ))
						e.consume();
				}
			}
		});
		textFieldCodiceFiscale.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldCodiceFiscale.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldCodiceFiscale.setOpaque(false);
		textFieldCodiceFiscale.setForeground(new Color(255, 213, 0));
		textFieldCodiceFiscale.setColumns(10);
		textFieldCodiceFiscale.setBounds(220, 155, 267, 30);
		textFieldCodiceFiscale.setCaretColor(new Color(255, 213, 0));
		getContentPane().add(textFieldCodiceFiscale);
		
		JButton ButtonAggiugni = new JButton("");
		ButtonAggiugni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonAggiugni.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAggiungiYellow.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonAggiugni.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAggiungi.png")));
			}
		});
		ButtonAggiugni.setPressedIcon(new ImageIcon(AggiungiClientiDialog.class.getResource("/scrimg/ButtonAggiungiYellow.png")));
		ButtonAggiugni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAggiugni.setOpaque(false);
		ButtonAggiugni.setBorder(null);
		ButtonAggiugni.setContentAreaFilled(false);
		ButtonAggiugni.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAggiungi.png")));
		ButtonAggiugni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldNome.getText().length()==0 || textFieldCognome.getText().length()==0 || textFieldCodiceFiscale.getText().length()==0 ) {
					JOptionPane.showMessageDialog(null, "COMPLETARE TUTTE I CAMPI", "", JOptionPane.WARNING_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "CLIENTE AGGIUNTO CORRETTAMENTE", "", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		ButtonAggiugni.setBounds(446, 344, 141, 30);
		getContentPane().add(ButtonAggiugni);
		
		JButton ButtonAnnulla = new JButton("");
		ButtonAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonAnnulla.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAnnullaYellow.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonAnnulla.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
			}
		});
		ButtonAnnulla.setPressedIcon(new ImageIcon(AggiungiClientiDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
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
		ButtonAnnulla.setBounds(39, 344, 141, 30);
		getContentPane().add(ButtonAnnulla);
		
		JCheckBox CheckBoxCartaFedelta = new JCheckBox("");
		CheckBoxCartaFedelta.setForeground(new Color(255, 213, 0));
		CheckBoxCartaFedelta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		CheckBoxCartaFedelta.setBackground(new Color(0, 67, 137));
		CheckBoxCartaFedelta.setBounds(220, 246, 21, 23);
		getContentPane().add(CheckBoxCartaFedelta);
		
		JLabel LabelCartaFedelta = new JLabel("Carta Fedelt\u00E0");
		LabelCartaFedelta.setForeground(new Color(255, 213, 0));
		LabelCartaFedelta.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelCartaFedelta.setBounds(10, 246, 93, 23);
		getContentPane().add(LabelCartaFedelta);
		
		JButton ButtonCancellaTutto = new JButton("");
		ButtonCancellaTutto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonCancellaTutto.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonRimuoviTuttoYellow.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonCancellaTutto.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonRimuoviTutto.png")));
			}
		});
		ButtonCancellaTutto.setPressedIcon(new ImageIcon(AggiungiClientiDialog.class.getResource("/scrimg/ButtonRimuoviTutto.png")));
		ButtonCancellaTutto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "TUTTI I CAMPI VERRANNO CANCELLATI", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);
				textFieldNome.setText("");
				textFieldCognome.setText("");
				textFieldCodiceFiscale.setText("");
				CheckBoxCartaFedelta.setSelected(false);
			}
		});
		ButtonCancellaTutto.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonRimuoviTutto.png")));
		ButtonCancellaTutto.setOpaque(false);
		ButtonCancellaTutto.setBorder(null);
		ButtonCancellaTutto.setContentAreaFilled(false);
		ButtonCancellaTutto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonCancellaTutto.setBounds(268, 344, 168, 30);
		getContentPane().add(ButtonCancellaTutto);
	}
}
