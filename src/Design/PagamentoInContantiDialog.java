package Design;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import ExternalClasses.ContentPane;
import ExternalClasses.RoundedCornerBorder;
import Main.Controller;

public class PagamentoInContantiDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private ContentPane contentPane;
	private JLabel LabelTotaleStampato; //LABEL FISSA
	private JLabel LabelTotale; //LABEL CARICAMENTO DEL TOTALE
	private JLabel LabelRestoStampato; //LABEL FISSA
	private JLabel LabelResto; //LABEL CALCOLO RESTO
	private JLabel LabelContanti;
	private JButton ButtonPaga;
	private JButton ButtonAnnulla;
	private JLabel LabelNumeroCartaFedelta;
	private JTextField textFieldNumeroCartaFedelta;
	private JTextField textFieldContanti;
	private JLabel LabelSfondo;

	public PagamentoInContantiDialog(Controller ctrl) {
		
		setAlwaysOnTop(true);
		getContentPane().setBackground(new Color(0, 67, 137));
		setUndecorated(true);
		setSize(563, 414);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		getContentPane().setLayout(null);
		
		/*CONTENTPANE*/
		contentPane = new ContentPane();
		setContentPane(contentPane);
		getContentPane().isOpaque();
		setBackground(new Color(0, 67, 137, 0));
		contentPane.setLayout(null);
		getContentPane().setLayout(null);
		
		/*LABEL TOTALE STAMPATO*/
		LabelTotaleStampato = new JLabel("");
		LabelTotaleStampato.setBounds(205, 98, 269, 30);
		LabelTotaleStampato.setForeground(new Color(0,41,82));
		LabelTotaleStampato.setBorder(new RoundedCornerBorder());
		LabelTotaleStampato.setFont(new Font("Cambria", Font.BOLD, 18));
		contentPane.add(LabelTotaleStampato);

		/*LABEL TOTALE*/
		LabelTotale = new JLabel("Totale");
		LabelTotale.setBounds(50, 108, 70, 20);
		LabelTotale.setForeground(new Color(0,41,82));
		LabelTotale.setFont(new Font("Cambria", Font.BOLD, 18));
		contentPane.add(LabelTotale);
		
		/*LABEL RESTO STAMPATO*/
		LabelRestoStampato = new JLabel("");
		LabelRestoStampato.setBounds(205, 224, 269, 30);
		LabelRestoStampato.setForeground(new Color(0,41,82));
		LabelRestoStampato.setBorder(new RoundedCornerBorder());
		LabelRestoStampato.setFont(new Font("Cambria", Font.BOLD, 18));
		contentPane.add(LabelRestoStampato);
		
		/*LABEL RESTO*/
		LabelResto = new JLabel("Resto");
		LabelResto.setBounds(50, 226, 76, 20);
		LabelResto.setForeground(new Color(0,41,82));
		LabelResto.setFont(new Font("Cambria", Font.BOLD, 18));
		contentPane.add(LabelResto);

		/*LABEL CONTANTI*/
		LabelContanti = new JLabel("Contanti");
		LabelContanti.setBounds(50, 164, 97, 20);
		LabelContanti.setForeground(new Color(0,41,82));
		LabelContanti.setFont(new Font("Cambria", Font.BOLD, 18));
		contentPane.add(LabelContanti);
		
		/*LABEL NUMERO CARTA FEDELTA*/
		LabelNumeroCartaFedelta = new JLabel("N° Carta Fedeltà");
		LabelNumeroCartaFedelta.setBounds(50, 50, 145, 20);
		LabelNumeroCartaFedelta.setForeground(new Color(0,41,82));
		LabelNumeroCartaFedelta.setFont(new Font("Cambria", Font.BOLD, 18));
		contentPane.add(LabelNumeroCartaFedelta);	

		/*BUTTON PAGA*/
		ButtonPaga = new JButton("");
		ButtonPaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldContanti.getText().length()!=0) {
					setAlwaysOnTop(false);
					JOptionPane.showMessageDialog(null, "PAGAMENTO AVVENUTO CON SUCCESSO", "", JOptionPane.INFORMATION_MESSAGE);
					setAlwaysOnTop(true);
				}
				else {
					setAlwaysOnTop(false);
					JOptionPane.showMessageDialog(null, "INSERIRE CONTANTI", "", JOptionPane.WARNING_MESSAGE);
					setAlwaysOnTop(true);
				}
			}
		});
		ButtonPaga.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonPaga.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonPagaAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonPaga.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonPaga.png")));
			}
		});
		ButtonPaga.setPressedIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonPaga.png")));
		ButtonPaga.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonPaga.setOpaque(false);
		ButtonPaga.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonPaga.png")));
		ButtonPaga.setBorder(null);
		ButtonPaga.setContentAreaFilled(false);
		ButtonPaga.setBounds(366, 321, 110, 24);
		contentPane.add(ButtonPaga);

		/*BUTTON ANNULLA*/
		ButtonAnnulla = new JButton("");
		ButtonAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonAnnulla.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonAnnullaAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonAnnulla.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
			}
		});
		ButtonAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		ButtonAnnulla.setOpaque(false);
		ButtonAnnulla.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
		ButtonAnnulla.setPressedIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
		ButtonAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAnnulla.setBorder(null);
		ButtonAnnulla.setContentAreaFilled(false);
		ButtonAnnulla.setBounds(50, 321, 110, 24);
		contentPane.add(ButtonAnnulla);

		/*TEXTFIELD NUMERO CARTA FEDELTA*/
		textFieldNumeroCartaFedelta = new JTextField() ;
		textFieldNumeroCartaFedelta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textFieldNumeroCartaFedelta.getText().length()<4) {
					char c=e.getKeyChar();
					if(!(Character.isDigit(c) ||  (c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE ))
						e.consume();
				}
				else {
					char c=e.getKeyChar();
					if(!((c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE ))
						e.consume();
				}

			}
		});
		textFieldNumeroCartaFedelta.setForeground(new Color(0,41,82));
		textFieldNumeroCartaFedelta.setBorder(new RoundedCornerBorder());
		textFieldNumeroCartaFedelta.setFont(new Font("Cambria", Font.BOLD, 15));
		textFieldNumeroCartaFedelta.setColumns(10);
		textFieldNumeroCartaFedelta.setCaretColor(new Color(0, 41, 82));
		textFieldNumeroCartaFedelta.setBackground(new Color(191,215,255));
		textFieldNumeroCartaFedelta.setSelectedTextColor(new Color (191,215,255));
		textFieldNumeroCartaFedelta.setSelectionColor(new Color (0,41,82));
		textFieldNumeroCartaFedelta.setBounds(205, 40, 269, 30);
		contentPane.add(textFieldNumeroCartaFedelta);
		
		/*TEXTFIELD CONTANTI*/
		textFieldContanti = new JTextField();
		textFieldContanti.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isDigit(c) ||  (c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE ))
					e.consume();
			}
		});
		textFieldContanti.setSelectionColor(new Color(0, 41, 82));
		textFieldContanti.setSelectedTextColor(new Color(191, 215, 255));
		textFieldContanti.setForeground(new Color(0, 41, 82));
		textFieldContanti.setFont(new Font("Cambria", Font.BOLD, 15));
		textFieldContanti.setColumns(10);
		textFieldContanti.setCaretColor(new Color(0, 41, 82));
		textFieldContanti.setBorder(new RoundedCornerBorder());
		textFieldContanti.setBackground(new Color(191, 215, 255));
		textFieldContanti.setBounds(205, 154, 269, 30);
		contentPane.add(textFieldContanti);
		
		/*LABEL SFONDO*/
		LabelSfondo = new JLabel("");
		LabelSfondo.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/SfondoClienti.png")));
		LabelSfondo.setBounds(-9, -9, 580, 429);
		contentPane.add(LabelSfondo);
	}
}
