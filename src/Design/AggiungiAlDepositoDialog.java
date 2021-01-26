package Design;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;

import main.Controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class AggiungiAlDepositoDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	public AggiungiAlDepositoDialog(Controller ctrl) {
		setUndecorated(true);
		setSize(726, 553);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		getContentPane().setBackground(new Color(0, 67, 137));
		getContentPane().setLayout(null);
		((JComponent) getContentPane()).setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		
		JLabel LabelFormatoData = new JLabel(" Data : AAAA-MM-GG");
		LabelFormatoData.setVisible(false);
		LabelFormatoData.setOpaque(true);
		LabelFormatoData.setForeground(new Color(0, 67, 137));
		LabelFormatoData.setFont(new Font("Impact", Font.PLAIN, 12));
		LabelFormatoData.setBackground(new Color(255, 213, 0));
		LabelFormatoData.setBounds(561, 170, 97, 39);
		getContentPane().add(LabelFormatoData);
		
		JLabel LabelFormatoData2 = new JLabel(" Data : AAAA-MM-GG");
		LabelFormatoData2.setVisible(false);
		LabelFormatoData2.setOpaque(true);
		LabelFormatoData2.setForeground(new Color(0, 67, 137));
		LabelFormatoData2.setFont(new Font("Impact", Font.PLAIN, 12));
		LabelFormatoData2.setBackground(new Color(255, 213, 0));
		LabelFormatoData2.setBounds(561, 353, 97, 39);
		getContentPane().add(LabelFormatoData2);
		
		JLabel LabelFormatoData3 = new JLabel(" Data : AAAA-MM-GG");
		LabelFormatoData3.setVisible(false);
		LabelFormatoData3.setOpaque(true);
		LabelFormatoData3.setForeground(new Color(0, 67, 137));
		LabelFormatoData3.setFont(new Font("Impact", Font.PLAIN, 12));
		LabelFormatoData3.setBackground(new Color(255, 213, 0));
		LabelFormatoData3.setBounds(561, 407, 97, 39);
		getContentPane().add(LabelFormatoData3);
		
		JLabel LabelInfo = new JLabel("");
		LabelInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		LabelInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LabelFormatoData.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LabelFormatoData.setVisible(false);
			}
		});
		LabelInfo.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ICOinfoYellow.png")));
		LabelInfo.setBounds(561, 220, 20, 20);
		getContentPane().add(LabelInfo);
		
		JLabel LabelInfo2 = new JLabel("");
		LabelInfo2.setVisible(true);
		LabelInfo2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		LabelInfo2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LabelFormatoData2.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LabelFormatoData2.setVisible(false);
			}
		});
		LabelInfo2.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ICOinfoYellow.png")));
		LabelInfo2.setBounds(561, 406, 20, 20);
		getContentPane().add(LabelInfo2);
		
		JLabel LabelInfo3 = new JLabel("");
		LabelInfo3.setVisible(false);
		LabelInfo3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		LabelInfo3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LabelFormatoData3.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LabelFormatoData3.setVisible(false);
			}
		});
		LabelInfo3.setIcon(new ImageIcon(PagamentoConCartaDialog.class.getResource("/scrimg/ICOinfoYellow.png")));
		LabelInfo3.setBounds(561, 459, 20, 20);
		getContentPane().add(LabelInfo3);
		
		JLabel LabelTipologia = new JLabel("Tipologia");
		LabelTipologia.setForeground(new Color(255, 213, 0));
		LabelTipologia.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelTipologia.setBounds(107, 37, 92, 21);
		getContentPane().add(LabelTipologia);
		
		JLabel LabelNome = new JLabel("Nome");
		LabelNome.setForeground(new Color(255, 213, 0));
		LabelNome.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelNome.setBounds(107, 101, 46, 14);
		getContentPane().add(LabelNome);
		
		JLabel LabelPrezzo = new JLabel("Prezzo");
		LabelPrezzo.setForeground(new Color(255, 213, 0));
		LabelPrezzo.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelPrezzo.setBounds(107, 170, 46, 14);
		getContentPane().add(LabelPrezzo);
		
		JLabel LabelDataScadenza = new JLabel("Data Scadenza");
		LabelDataScadenza.setForeground(new Color(255, 213, 0));
		LabelDataScadenza.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelDataScadenza.setBounds(107, 233, 118, 14);
		getContentPane().add(LabelDataScadenza);
		
		JLabel LabelQuantita = new JLabel("Quantit\u00E0");
		LabelQuantita.setForeground(new Color(255, 213, 0));
		LabelQuantita.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelQuantita.setBounds(107, 296, 68, 14);
		getContentPane().add(LabelQuantita);
		
		JLabel LabelDataRaccolta = new JLabel("Data Raccolto");
		LabelDataRaccolta.setVisible(true);
		LabelDataRaccolta.setForeground(new Color(255, 213, 0));
		LabelDataRaccolta.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelDataRaccolta.setBounds(107, 415, 118, 14);
		getContentPane().add(LabelDataRaccolta);
		
		JLabel LabelDataProduzione = new JLabel("Data Produzione");
		LabelDataProduzione.setVisible(false);
		LabelDataProduzione.setForeground(new Color(255, 213, 0));
		LabelDataProduzione.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelDataProduzione.setBounds(107, 415, 118, 14);
		getContentPane().add(LabelDataProduzione);
		
		JLabel LabelDataMungitura = new JLabel("Data Mungitura");
		LabelDataMungitura.setVisible(false);
		LabelDataMungitura.setForeground(new Color(255, 213, 0));
		LabelDataMungitura.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelDataMungitura.setBounds(107, 465, 118, 14);
		getContentPane().add(LabelDataMungitura);
		
		JLabel LabelDataConfezionamento = new JLabel("Data Confezionamento");
		LabelDataConfezionamento.setVisible(false);
		LabelDataConfezionamento.setForeground(new Color(255, 213, 0));
		LabelDataConfezionamento.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelDataConfezionamento.setBounds(107, 415, 118, 14);
		getContentPane().add(LabelDataConfezionamento);
		
		JLabel LabelFoto = new JLabel("Foto");
		LabelFoto.setForeground(new Color(255, 213, 0));
		LabelFoto.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelFoto.setBounds(107, 361, 46, 14);
		getContentPane().add(LabelFoto);
		
		JTextField textFieldNome = new JTextField();
		textFieldNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
			    if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE ))
			        e.consume();
			}
		});
		
		
		textFieldNome.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldNome.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldNome.setForeground(new Color(255, 213, 0));
		textFieldNome.setOpaque(false);
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(317, 85, 267, 30);
		textFieldNome.setCaretColor(new Color(255, 213, 0));
		getContentPane().add(textFieldNome);
		
		
		JTextField textFieldPrezzo = new JTextField();
		textFieldPrezzo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
			    if(!(Character.isDigit(c) ||  (c==KeyEvent.VK_BACK_SPACE) ||  c==KeyEvent.VK_DELETE || c==KeyEvent.VK_PERIOD))
			        e.consume();
			}
		});
		textFieldPrezzo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldPrezzo.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldPrezzo.setOpaque(false);
		textFieldPrezzo.setForeground(new Color(255, 213, 0));
		textFieldPrezzo.setColumns(10);
		textFieldPrezzo.setBounds(317, 150, 267, 30);
		textFieldPrezzo.setCaretColor(new Color(255, 213, 0));
		getContentPane().add(textFieldPrezzo);
		
		MaskFormatter mf = null;
		try {
			mf = new MaskFormatter("####-##-##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		JFormattedTextField textFieldDataScadenza = new JFormattedTextField(mf);
		textFieldDataScadenza.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldDataScadenza.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldDataScadenza.setOpaque(false);
		textFieldDataScadenza.setForeground(new Color(255, 213, 0));
		textFieldDataScadenza.setColumns(10);
		textFieldDataScadenza.setBounds(317, 215, 267, 30);
		textFieldDataScadenza.setCaretColor(new Color(255, 213, 0));
		getContentPane().add(textFieldDataScadenza);
		
		JFormattedTextField textFieldDataRaccolta = new JFormattedTextField(mf);
		textFieldDataRaccolta.setVisible(true);
		textFieldDataRaccolta.setBounds(317, 399, 267, 30);
		textFieldDataRaccolta.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldDataRaccolta.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldDataRaccolta.setOpaque(false);
		textFieldDataRaccolta.setForeground(new Color(255, 213, 0));
		textFieldDataRaccolta.setCaretColor(new Color(255, 213, 0));
		textFieldDataRaccolta.setColumns(10);
		getContentPane().add(textFieldDataRaccolta);
		
		JFormattedTextField textFieldDataProduzione = new JFormattedTextField(mf);
		textFieldDataProduzione.setVisible(false);
		textFieldDataProduzione.setBounds(317, 399, 267, 30);
		textFieldDataProduzione.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldDataProduzione.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldDataProduzione.setOpaque(false);
		textFieldDataProduzione.setForeground(new Color(255, 213, 0));
		textFieldDataProduzione.setCaretColor(new Color(255, 213, 0));
		textFieldDataProduzione.setColumns(10);
		getContentPane().add(textFieldDataProduzione);
		
		JFormattedTextField textFieldDataConfezionamento = new JFormattedTextField(mf);
		textFieldDataConfezionamento.setVisible(false);
		textFieldDataConfezionamento.setBounds(317, 399, 267, 30);
		textFieldDataConfezionamento.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldDataConfezionamento.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldDataConfezionamento.setOpaque(false);
		textFieldDataConfezionamento.setForeground(new Color(255, 213, 0));
		textFieldDataConfezionamento.setCaretColor(new Color(255, 213, 0));
		textFieldDataConfezionamento.setColumns(10);
		getContentPane().add(textFieldDataConfezionamento);
		
		JFormattedTextField textFieldDataMungitura = new JFormattedTextField(mf);
		textFieldDataMungitura.setVisible(false);
		textFieldDataMungitura.setBounds(317, 453, 267, 30);
		textFieldDataMungitura.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldDataMungitura.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldDataMungitura.setOpaque(false);
		textFieldDataMungitura.setForeground(new Color(255, 213, 0));
		textFieldDataMungitura.setCaretColor(new Color(255, 213, 0));
		textFieldDataMungitura.setColumns(10);
		getContentPane().add(textFieldDataMungitura);
		
		SpinnerNumberModel model = new SpinnerNumberModel(1, null, 50, 1);
		JSpinner spinnerQuantita = new JSpinner(model);
		spinnerQuantita.setOpaque(false);
		spinnerQuantita.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color (255, 213, 0)));
		spinnerQuantita.getComponent(0).setBackground(new Color(0, 67, 137));
		spinnerQuantita.getComponent(1).setBackground(new Color(0, 67, 137));
		spinnerQuantita.getEditor().getComponent(0).setBackground(new Color(0, 67, 137));
		spinnerQuantita.getEditor().getComponent(0).setForeground(new Color(255, 213, 0));
		spinnerQuantita.setRequestFocusEnabled(false);
		spinnerQuantita.setFont(new Font("Impact", Font.PLAIN, 14));
		spinnerQuantita.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		spinnerQuantita.setBounds(317, 280, 59, 30);
		getContentPane().add(spinnerQuantita);
		
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
		ButtonAggiugni.setPressedIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAggiungi.png")));
		ButtonAggiugni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAggiugni.setOpaque(false);
		ButtonAggiugni.setBorder(null);
		ButtonAggiugni.setContentAreaFilled(false);
		ButtonAggiugni.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAggiungi.png")));
		ButtonAggiugni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldNome.getText().length()==0 || textFieldPrezzo.getText().length()==0 ) {
					JOptionPane.showMessageDialog(null, "COMPLETARE TUTTI I CAMPI", "", JOptionPane.WARNING_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null, "PRODOTTO AGGIUNTO CORRETTAMENTE", "", JOptionPane.INFORMATION_MESSAGE);
					
				}
				
			}
		});
		ButtonAggiugni.setBounds(532, 512, 141, 30);
		getContentPane().add(ButtonAggiugni);
		
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
		ButtonCancellaTutto.setPressedIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonRimuoviTutto.png")));
		ButtonCancellaTutto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "TUTTI I CAMPI VERRANNO CANCELLATI", "ATTENZIONE", JOptionPane.WARNING_MESSAGE);
				textFieldNome.setText("");
				textFieldPrezzo.setText("");
				spinnerQuantita.setValue(1);
				textFieldDataScadenza.setValue("");
				textFieldDataConfezionamento.setValue("");
				textFieldDataMungitura.setValue("");
				textFieldDataProduzione.setValue("");
				textFieldDataRaccolta.setValue("");
			}
		});
		ButtonCancellaTutto.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonRimuoviTutto.png")));
		ButtonCancellaTutto.setOpaque(false);
		ButtonCancellaTutto.setBorder(null);
		ButtonCancellaTutto.setContentAreaFilled(false);
		ButtonCancellaTutto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonCancellaTutto.setBounds(354, 512, 168, 30);
		getContentPane().add(ButtonCancellaTutto);
		
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
		ButtonAnnulla.setPressedIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
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
		ButtonAnnulla.setBounds(43, 512, 141, 30);
		getContentPane().add(ButtonAnnulla);
		
		JComboBox comboBoxTipologia = new JComboBox();
		comboBoxTipologia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxTipologia.getSelectedItem()=="Ortofrutta") {
					LabelDataConfezionamento.setVisible(false);
					LabelDataRaccolta.setVisible(true);
					LabelDataMungitura.setVisible(false);
					LabelDataProduzione.setVisible(false);
					textFieldDataConfezionamento.setVisible(false);
					textFieldDataRaccolta.setVisible(true);
					textFieldDataMungitura.setVisible(false);
					textFieldDataProduzione.setVisible(false);
					LabelInfo2.setVisible(true);
					LabelFormatoData2.setVisible(false);
					LabelInfo3.setVisible(false);
					LabelFormatoData3.setVisible(false);
				}
				else if(comboBoxTipologia.getSelectedItem()=="Latticini") {
					LabelDataConfezionamento.setVisible(false);
					LabelDataRaccolta.setVisible(false);
					LabelDataMungitura.setVisible(true);
					LabelDataProduzione.setVisible(true);
					textFieldDataConfezionamento.setVisible(false);
					textFieldDataRaccolta.setVisible(false);
					textFieldDataMungitura.setVisible(true);
					textFieldDataProduzione.setVisible(true);
					LabelInfo2.setVisible(true);
					LabelFormatoData2.setVisible(false);
					LabelInfo3.setVisible(true);
					LabelFormatoData3.setVisible(false);
				}
				else if(comboBoxTipologia.getSelectedItem()=="Confezionati") {
					LabelDataConfezionamento.setVisible(true);
					LabelDataRaccolta.setVisible(false);
					LabelDataMungitura.setVisible(false);
					LabelDataProduzione.setVisible(false);
					textFieldDataConfezionamento.setVisible(true);
					textFieldDataRaccolta.setVisible(false);
					textFieldDataMungitura.setVisible(false);
					textFieldDataProduzione.setVisible(false);
					LabelInfo2.setVisible(true);
					LabelFormatoData2.setVisible(false);
					LabelInfo3.setVisible(false);
					LabelFormatoData3.setVisible(false);
				}
			}
		});
		comboBoxTipologia.setFocusable(false);
		comboBoxTipologia.setOpaque(false);
		comboBoxTipologia.setModel(new DefaultComboBoxModel(new String[] {"Ortofrutta", "Latticini", "Confezionati"}));
		comboBoxTipologia.setBackground(new Color(10, 67, 137));
		comboBoxTipologia.setForeground(new Color(255, 213, 0));
		comboBoxTipologia.setFont(new Font("Impact", Font.PLAIN, 11));
		comboBoxTipologia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxTipologia.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 213, 0), new Color(255, 213, 0)));
		comboBoxTipologia.setMaximumRowCount(3);
		comboBoxTipologia.setBounds(317, 25, 267, 30);
		getContentPane().add(comboBoxTipologia);
		
		JTextField textFieldFoto = new JTextField();
		textFieldFoto.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldFoto.setFont(new Font("Impact", Font.PLAIN, 11));
		textFieldFoto.setForeground(new Color(255, 213, 0));
		textFieldFoto.setOpaque(false);
		textFieldFoto.setColumns(10);
		textFieldFoto.setBounds(317, 345, 267, 30);
		textFieldFoto.setCaretColor(new Color(255, 213, 0));
		getContentPane().add(textFieldFoto);
		
		JButton ButtonAggiungiFoto = new JButton("New button");
		ButtonAggiungiFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.CaricaFileJPGDaPC(textFieldFoto);
			}
		});
		ButtonAggiungiFoto.setBounds(594, 330, 89, 23);
		getContentPane().add(ButtonAggiungiFoto);
	
	}
}
