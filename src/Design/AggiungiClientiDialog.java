package Design;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

import ExternalClasses.ContentPane;
import ExternalClasses.RoundedCornerBorder;
import Main.Controller;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AggiungiClientiDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	public AggiungiClientiDialog(Controller ctrl) {
		
		setUndecorated(true);
		setSize(563, 411);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		getContentPane().setLayout(null);
		ContentPane contentPane = new ContentPane();
		setContentPane(contentPane);
		getContentPane().isOpaque();
		setBackground(new Color(0, 67, 137, 0));
		contentPane.setLayout(null);

		JLabel LabelNome = new JLabel("Nome");
		LabelNome.setForeground(new Color(0, 41, 82));
		LabelNome.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelNome.setBounds(64, 59, 46, 14);
		getContentPane().add(LabelNome);

		JLabel LabelCognome = new JLabel("Cognome");
		LabelCognome.setForeground(new Color(0, 41, 82));
		LabelCognome.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelCognome.setBounds(64, 130, 68, 14);
		getContentPane().add(LabelCognome);

		JLabel LabelCodiceFiscale = new JLabel("Codice Fiscale");
		LabelCodiceFiscale.setForeground(new Color(0, 41, 82));
		LabelCodiceFiscale.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelCodiceFiscale.setBounds(64, 204, 118, 14);
		getContentPane().add(LabelCodiceFiscale);


		JTextField textFieldNome = new JTextField() ;
		textFieldNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				textFieldNome.setText(textFieldNome.getText().toUpperCase());
			}
		});
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
		textFieldNome.setBorder(new RoundedCornerBorder());
		textFieldNome.setFont(new Font("Impact", Font.PLAIN, 16));
		textFieldNome.setForeground(new Color(0, 41, 82));
		textFieldNome.setColumns(10);
		textFieldNome.setBackground(new Color(191,215,255));
		textFieldNome.setSelectedTextColor(new Color (191,215,255));
		textFieldNome.setSelectionColor(new Color (0,41,82));
		textFieldNome.setBounds(244, 43, 249, 30);
		textFieldNome.setCaretColor(new Color(0,41,82));
		getContentPane().add(textFieldNome);

		JTextField textFieldCognome = new JTextField();
		textFieldCognome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				textFieldCognome.setText(textFieldCognome.getText().toUpperCase());
			}
		});
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
		textFieldCognome.setBorder(new RoundedCornerBorder());
		textFieldCognome.setFont(new Font("Impact", Font.PLAIN, 16));
		textFieldCognome.setForeground(new Color(0, 41, 82));
		textFieldCognome.setBackground(new Color(191,215,255));
		textFieldCognome.setSelectedTextColor(new Color (191,215,255));
		textFieldCognome.setSelectionColor(new Color (0,41,82));
		textFieldCognome.setColumns(10);
		textFieldCognome.setBounds(244, 114, 249, 30);
		textFieldCognome.setCaretColor(new Color(0, 41, 82));
		getContentPane().add(textFieldCognome);

		JTextField textFieldCodiceFiscale = new JTextField() ;
		textFieldCodiceFiscale.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				textFieldCodiceFiscale.setText(textFieldCodiceFiscale.getText().toUpperCase());
			}
		});
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
		textFieldCodiceFiscale.setBorder(new RoundedCornerBorder());
		textFieldCodiceFiscale.setFont(new Font("Impact", Font.PLAIN, 16));
		textFieldCodiceFiscale.setForeground(new Color(0, 41, 82));
		textFieldCodiceFiscale.setBackground(new Color(191, 215, 255));
		textFieldCodiceFiscale.setSelectedTextColor(new Color (191,215,255));
		textFieldCodiceFiscale.setSelectionColor(new Color (0,41,82));
		textFieldCodiceFiscale.setColumns(10);
		textFieldCodiceFiscale.setBounds(244, 188, 249, 30);
		textFieldCodiceFiscale.setCaretColor(new Color(0, 41, 82));
		getContentPane().add(textFieldCodiceFiscale);

		JButton ButtonAggiugni = new JButton("");
		ButtonAggiugni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonAggiugni.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAggiungi2Azzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonAggiugni.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAggiungi2.png")));
			}
		});
		ButtonAggiugni.setPressedIcon(new ImageIcon(AggiungiClientiDialog.class.getResource("/scrimg/ButtonAggiungi2.png")));
		ButtonAggiugni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAggiugni.setOpaque(false);
		ButtonAggiugni.setBorder(null);
		ButtonAggiugni.setContentAreaFilled(false);
		ButtonAggiugni.setIcon(new ImageIcon(AggiungiClientiDialog.class.getResource("/scrimg/ButtonAggiungi2.png")));
		ButtonAggiugni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldNome.getText().length()==0 || textFieldCognome.getText().length()==0 || textFieldCodiceFiscale.getText().length()==0 || textFieldCodiceFiscale.getText().length()<16 ) {
					setAlwaysOnTop(false);
					JOptionPane.showMessageDialog(null, "COMPLETARE TUTTE I CAMPI", "", JOptionPane.WARNING_MESSAGE);
					setAlwaysOnTop(true);
				}
				else {
					setAlwaysOnTop(false);
					ctrl.AggiungiCliente(textFieldNome.getText(), textFieldCognome.getText(), textFieldCodiceFiscale.getText());
					JOptionPane.showMessageDialog(null, "CLIENTE AGGIUNTO CORRETTAMENTE", "", JOptionPane.INFORMATION_MESSAGE);
					setAlwaysOnTop(true);
					ctrl.RimuoviTutto(textFieldNome, textFieldCognome, textFieldCodiceFiscale);
				}
			}
		});
		ButtonAggiugni.setBounds(401, 344, 110, 24);
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
		ButtonAnnulla.setBounds(64, 344, 110, 24);
		getContentPane().add(ButtonAnnulla);

		JButton ButtonCancellaTutto = new JButton("");
		ButtonCancellaTutto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonCancellaTutto.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonRimuoviTuttoAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonCancellaTutto.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonRimuoviTutto.png")));
			}
		});
		ButtonCancellaTutto.setPressedIcon(new ImageIcon(AggiungiClientiDialog.class.getResource("/scrimg/ButtonRimuoviTutto.png")));
		ButtonCancellaTutto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "TUTTI I CAMPI VERRANNO CANCELLATI", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);
				setAlwaysOnTop(true);
				ctrl.RimuoviTutto(textFieldNome, textFieldCognome, textFieldCodiceFiscale);
			}
		});
		ButtonCancellaTutto.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonRimuoviTutto.png")));
		ButtonCancellaTutto.setOpaque(false);
		ButtonCancellaTutto.setBorder(null);
		ButtonCancellaTutto.setContentAreaFilled(false);
		ButtonCancellaTutto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonCancellaTutto.setBounds(241, 344, 150, 24);
		getContentPane().add(ButtonCancellaTutto);

		JLabel LabelSfondo = new JLabel("");
		LabelSfondo.setIcon(new ImageIcon(AggiungiClientiDialog.class.getResource("/scrimg/SfondoClienti.png")));
		LabelSfondo.setBounds(-8, -8, 580, 429);
		getContentPane().add(LabelSfondo);
	}
}
