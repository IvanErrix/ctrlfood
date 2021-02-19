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
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import ExternalClasses.ContentPane;
import ExternalClasses.RoundedCornerBorder;
import Main.Controller;
import Objects.Prodotto;

public class PagamentoInContantiDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private ArrayList<Prodotto> prodotti;
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
		setModalityType(DEFAULT_MODALITY_TYPE);
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
				if(textFieldContanti.getText().length()!=0 || LabelRestoStampato.getText().length()!=0) {
					setAlwaysOnTop(false);
					try {
						ctrl.AggiungiPagamento(ctrl.RecuperaCarrello(), Integer.parseInt(textFieldNumeroCartaFedelta.getText()));
						CalcoloPunti(ctrl);
						ctrl.AggiornaCarrello(ctrl.RecuperaCarrello());
					} catch (NumberFormatException e1) {
						ctrl.AggiungiPagamento(ctrl.RecuperaCarrello(), 0);
						CalcoloPunti(ctrl);
						ctrl.AggiornaCarrello(ctrl.RecuperaCarrello());
					}
					JOptionPane.showMessageDialog(null, "PAGAMENTO AVVENUTO CON SUCCESSO", "", JOptionPane.INFORMATION_MESSAGE);
					setAlwaysOnTop(true);
					dispose();
				}
				else {
					setAlwaysOnTop(false);
					JOptionPane.showMessageDialog(null, "INSERIRE CONTANTI O INSERIRNE DI PIÙ", "", JOptionPane.WARNING_MESSAGE);
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
		textFieldNumeroCartaFedelta.setFont(new Font("Cambria", Font.BOLD, 18));
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
				if (textFieldContanti.getText().length()<8) {
					char c = e.getKeyChar();
					if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE
							|| c == KeyEvent.VK_PERIOD))
						e.consume();
				}
				else {
					char c=e.getKeyChar();
					if(!((c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE ))
						e.consume();
				}
			}
			
		});
		textFieldContanti.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
				  TotaleSpesa(ctrl);
			  }
			  public void removeUpdate(DocumentEvent e) {
				  TotaleSpesa(ctrl);
			  }
			  public void insertUpdate(DocumentEvent e) {
				  TotaleSpesa(ctrl);
			  }
			});
		textFieldContanti.setSelectionColor(new Color(0, 41, 82));
		textFieldContanti.setSelectedTextColor(new Color(191, 215, 255));
		textFieldContanti.setForeground(new Color(0, 41, 82));
		textFieldContanti.setFont(new Font("Cambria", Font.BOLD, 18));
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
		
		CalcoloTotale(ctrl);
		TotaleSpesa(ctrl);
	}
	
	public void CalcoloTotale(Controller ctrl) {
		prodotti=ctrl.CaricaProdottiCarrello();
		Double totale = 0.0;
		for(int i=0; i<prodotti.size(); i++) {
			totale = totale + (prodotti.get(i).getPrezzo() * prodotti.get(i).getQuantita());
		}
		LabelTotaleStampato.setText(ctrl.Arrotonda(totale,2)+"");
	}
	
	public void TotaleSpesa(Controller ctrl) {
		Double resto = 0.0;
		if(textFieldContanti.getText().length()!=0) {
			resto = Double.parseDouble(textFieldContanti.getText()) - Double.parseDouble(LabelTotaleStampato.getText()) ;
			if(resto<0) {
				LabelRestoStampato.setText("");
			}
			else {
				LabelRestoStampato.setText(ctrl.Arrotonda(resto,2)+"");
			}
		}
		else{
			LabelRestoStampato.setText("");
		}
	}
	
	public void CalcoloPunti(Controller ctrl) {
		prodotti=ctrl.CaricaProdottiCarrello();
		Double totalepunti = 0.0;
		Double puntiortofrutta = 0.0;
		Double puntilatticini = 0.0;
		Double puntifarinacei = 0.0;
		Double puntiuova = 0.0;
		Double punticonfezionati = 0.0;
		for(int i=0; i<prodotti.size(); i++) {
			if(prodotti.get(i).getOrtofrutta()==true) {
				puntiortofrutta=puntiortofrutta+(prodotti.get(i).getPrezzo()*prodotti.get(i).getQuantita())*10/100;
				System.out.println(puntiortofrutta);
			}
			else if(prodotti.get(i).getLatticino()==true){
				puntilatticini=puntilatticini+(prodotti.get(i).getPrezzo()*prodotti.get(i).getQuantita())*10/100;
			}
			else if(prodotti.get(i).getFarinaceo()==true) {
				puntifarinacei=puntifarinacei+(prodotti.get(i).getPrezzo()*prodotti.get(i).getQuantita())*10/100;
			}
			else if(prodotti.get(i).getUova()==true){
				puntiuova=puntiuova+(prodotti.get(i).getPrezzo()*prodotti.get(i).getQuantita())*10/100;
			}
			else if(prodotti.get(i).getConfezionato()==true) {
				punticonfezionati=punticonfezionati+(prodotti.get(i).getPrezzo()*prodotti.get(i).getQuantita())*10/100;
			}
		}
		totalepunti =puntiortofrutta + puntilatticini + puntifarinacei + puntiuova + punticonfezionati;
		try {
			ctrl.AggiornaPunti(ctrl.Arrotonda(puntiortofrutta, 2), ctrl.Arrotonda(puntilatticini, 2), ctrl.Arrotonda(puntifarinacei, 2), ctrl.Arrotonda(puntiuova, 2), 
					ctrl.Arrotonda(punticonfezionati, 2), ctrl.Arrotonda(totalepunti, 2), Integer.parseInt(textFieldNumeroCartaFedelta.getText()));
		} catch (NumberFormatException e) {
		}
	}
	
}
