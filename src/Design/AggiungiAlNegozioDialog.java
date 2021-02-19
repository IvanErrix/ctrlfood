package Design;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.accessibility.AccessibleContext;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.SpinnerNumberModel;
import javax.swing.plaf.basic.BasicComboPopup;

import ExternalClasses.ContentPane;
import ExternalClasses.RoundedCornerBorder;
import Main.Controller;
import Objects.Prodotto;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class AggiungiAlNegozioDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Prodotto> prodotti;
	private ContentPane contentPane;
	private JLabel LabelNome;
	private JLabel LabelQuantita;
	private JLabel LabelIDProdotto;
	private String nome = "ORTOFRUTTA";
	private JButton ButtonOrtofrutta;
	private JButton ButtonFarinacei;
	private JButton ButtonConfezionati;
	private JButton ButtonLatticini;
	private JButton ButtonUova;
	private JButton ButtonAggiungi;
	private JButton ButtonAnnulla;
	private JList<?> list;
	private JComboBox<String> comboBoxNome;
	private SpinnerNumberModel model;
	private JSpinner spinnerQuantita;
	private JLabel LabelID;
	private JLabel LabelSfondo;

	public AggiungiAlNegozioDialog(Controller ctrl) {
		
		setUndecorated(true);
		setSize(568, 429);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		getContentPane().setLayout(null);
		
		/*CONTENTPANE*/
		contentPane = new ContentPane();
		setContentPane(contentPane);
		getContentPane().isOpaque();
		setBackground(new Color(0, 67, 137, 0));
		contentPane.setLayout(null);
		
		/*LABEL NOME*/
		LabelNome = new JLabel("Nome");
		LabelNome.setForeground(new Color(0,41,82));
		LabelNome.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelNome.setBounds(107, 151, 46, 24);
		contentPane.add(LabelNome);
		
		/*LABEL QUANTITA*/
		LabelQuantita = new JLabel("Quantit\u00E0");
		LabelQuantita.setForeground(new Color(0,41,82));
		LabelQuantita.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelQuantita.setBounds(107, 264, 68, 14);
		contentPane.add(LabelQuantita);
		
		/*LABEL ID PRODOTTO*/
		LabelIDProdotto = new JLabel("ID Prodotto");
		LabelIDProdotto.setForeground(new Color(0,41,82));
		LabelIDProdotto.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelIDProdotto.setBounds(107, 213, 92, 21);
		contentPane.add(LabelIDProdotto);
		
		/*BUTTON ORTOFRUTTA*/
		ButtonOrtofrutta = new JButton("");
		ButtonOrtofrutta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nome = "ORTOFRUTTA";
				VisibilitaLabel(nome);
				CaricaComboBoxNome(ctrl);
			}
		});
		ButtonOrtofrutta.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonOrtofruttaBlue.png")));
		ButtonOrtofrutta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonOrtofrutta.setOpaque(false);
		ButtonOrtofrutta.setBorder(null);
		ButtonOrtofrutta.setContentAreaFilled(false);
		ButtonOrtofrutta.setBounds(31, 13, 78, 83);
		contentPane.add(ButtonOrtofrutta);
		
		/*BUTTON FARINACEI*/
		ButtonFarinacei = new JButton("");
		ButtonFarinacei.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			nome = "FARINACEO";
			VisibilitaLabel(nome);
			CaricaComboBoxNome(ctrl);
			}
		});
		ButtonFarinacei.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonFarinacei.png")));
		ButtonFarinacei.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonFarinacei.setOpaque(false);
		ButtonFarinacei.setBorder(null);
		ButtonFarinacei.setContentAreaFilled(false);
		ButtonFarinacei.setBounds(130, 13, 78, 83);
		contentPane.add(ButtonFarinacei);
		
		/*BUTTON CONFEZIONATI*/
		ButtonConfezionati = new JButton("");
		ButtonConfezionati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			nome = "CONFEZIONATO";
			VisibilitaLabel(nome);
			CaricaComboBoxNome(ctrl);
			}
		});
		ButtonConfezionati.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonConfezionati.png")));
		ButtonConfezionati.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonConfezionati.setOpaque(false);
		ButtonConfezionati.setBorder(null);
		ButtonConfezionati.setContentAreaFilled(false);
		ButtonConfezionati.setBounds(229, 13, 78, 83);
		contentPane.add(ButtonConfezionati);
		
		/*BUTTON LATTICINI*/
		ButtonLatticini = new JButton("");
		ButtonLatticini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			nome = "LATTICINO";
			VisibilitaLabel(nome);
			CaricaComboBoxNome(ctrl);
			}
		});
		ButtonLatticini.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonLatticini.png")));
		ButtonLatticini.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonLatticini.setOpaque(false);
		ButtonLatticini.setBorder(null);
		ButtonLatticini.setContentAreaFilled(false);
		ButtonLatticini.setBounds(330, 13, 78, 83);
		contentPane.add(ButtonLatticini);
		
		/*BUTTON UOVA*/
		ButtonUova = new JButton("");
		ButtonUova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			nome = "UOVA";
			VisibilitaLabel(nome);
			CaricaComboBoxNome(ctrl);
			}
		});
		ButtonUova.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonUova.png")));
		ButtonUova.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonUova.setOpaque(false);
		ButtonUova.setBorder(null);
		ButtonUova.setContentAreaFilled(false);
		ButtonUova.setBounds(436, 13, 78, 83);
		contentPane.add(ButtonUova);
		
		/*BUTTON AGGIUNGI*/
		ButtonAggiungi = new JButton("");
		ButtonAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlloAggiungiProdotto(ctrl);
			}
		});
		ButtonAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonAggiungi.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAggiungi2Azzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonAggiungi.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAggiungi2.png")));
			}
		});
		ButtonAggiungi.setPressedIcon(new ImageIcon(AggiungiAlNegozioDialog.class.getResource("/scrimg/ButtonAggiungi2.png")));
		ButtonAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAggiungi.setOpaque(false);
		ButtonAggiungi.setBorder(null);
		ButtonAggiungi.setContentAreaFilled(false);
		ButtonAggiungi.setIcon(new ImageIcon(AggiungiAlNegozioDialog.class.getResource("/scrimg/ButtonAggiungi2.png")));
		ButtonAggiungi.setBounds(354, 340, 110, 24);
		contentPane.add(ButtonAggiungi);
		
		/*BUTTON ANNULLA*/
		ButtonAnnulla = new JButton("");
		ButtonAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
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
		ButtonAnnulla.setOpaque(false);
		ButtonAnnulla.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
		ButtonAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAnnulla.setBorder(null);
		ButtonAnnulla.setContentAreaFilled(false);
		ButtonAnnulla.setBounds(107, 340, 110, 24);
		contentPane.add(ButtonAnnulla);
		
		/*COMBOBOX NOME*/
		comboBoxNome = new JComboBox<String>();
		comboBoxNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CaricaSpinnerQuantita(ctrl);
			}
		});
		AccessibleContext ac = comboBoxNome.getAccessibleContext();
		BasicComboPopup pop = (BasicComboPopup) ac.getAccessibleChild(0);
		list = pop.getList();
		list.setSelectionForeground(new Color(191, 215, 255));
		list.setSelectionBackground(new Color(0, 41, 82));
		comboBoxNome.setBorder(new RoundedCornerBorder());
		comboBoxNome.setFont(new Font("Cambria", Font.BOLD, 14));
		comboBoxNome.setFocusable(false);
		comboBoxNome.setMaximumRowCount(3);
		comboBoxNome.setForeground(new Color(0,41,82));
		comboBoxNome.setBackground(new Color(191,215,255));
		comboBoxNome.setBounds(274, 151, 190, 25);
		contentPane.add(comboBoxNome);
		
		/*SPINNER QUANTITA*/
		model = new SpinnerNumberModel(1, 1, 50, 1);
		spinnerQuantita = new JSpinner(model);
		spinnerQuantita.setFocusable(false);
		spinnerQuantita.setOpaque(false);
		spinnerQuantita.setBorder(new RoundedCornerBorder());
		spinnerQuantita.getComponent(0).setBackground(new Color(191,215,255));
		spinnerQuantita.getComponent(1).setBackground(new Color(191,215,255));
		spinnerQuantita.getEditor().getComponent(0).setBackground(new Color(191,215,255));
		spinnerQuantita.getEditor().getComponent(0).setForeground(new Color(0,41,82));
		spinnerQuantita.setRequestFocusEnabled(false);
		spinnerQuantita.setFont(new Font("Cambria", Font.BOLD, 14));
		spinnerQuantita.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		spinnerQuantita.setBounds(274, 260, 60, 24);
		((DefaultEditor) spinnerQuantita.getEditor()).getTextField().setEditable(false);
		contentPane.add(spinnerQuantita);
		
		/*LABEL ID*/
		LabelID = new JLabel("");
		LabelID.setHorizontalAlignment(SwingConstants.CENTER);
		LabelID.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelID.setForeground(new Color(0,41,82));
		LabelID.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelID.setBorder(new RoundedCornerBorder());
		LabelID.setBounds(274, 210, 68, 24);
		contentPane.add(LabelID);
		
		/*LABEL SFONDO*/
		LabelSfondo = new JLabel("");
		LabelSfondo.setIcon(new ImageIcon(AggiungiAlNegozioDialog.class.getResource("/scrimg/SfondoClienti.png")));
		LabelSfondo.setBounds(-8, -8, 580, 429);
		contentPane.add(LabelSfondo);
		
		CaricaComboBoxNome(ctrl);
		CaricaSpinnerQuantita(ctrl);
	}
	
	public void CaricaComboBoxNome(Controller ctrl) {
		prodotti=ctrl.CaricaProdottiDeposito(ctrl);
		comboBoxNome.removeAllItems();
		for(int i=0; i<prodotti.size(); i++) {
			if(prodotti.get(i).getOrtofrutta()==true && nome.equals("ORTOFRUTTA")) {
				comboBoxNome.addItem(prodotti.get(i).getNome());
			}
			else if(prodotti.get(i).getLatticino()==true && nome.equals("LATTICINO")) {
				comboBoxNome.addItem(prodotti.get(i).getNome());
			}
			else if(prodotti.get(i).getFarinaceo()==true && nome.equals("FARINACEO")) {
				comboBoxNome.addItem(prodotti.get(i).getNome());
			}
			else if(prodotti.get(i).getUova()==true && nome.equals("UOVA")) {
				comboBoxNome.addItem(prodotti.get(i).getNome());
			}
			else if(prodotti.get(i).getConfezionato()==true &&nome.equals("CONFEZIONATO")) {
				comboBoxNome.addItem(prodotti.get(i).getNome());
			}
		}
	}
	
	public void CaricaSpinnerQuantita(Controller ctrl) {
		prodotti=ctrl.CaricaProdottiDeposito(ctrl);
		if (comboBoxNome.getSelectedItem()!=null) {
			for (int i = 0; i < prodotti.size(); i++) {
				if (comboBoxNome.getSelectedItem().toString().equals(prodotti.get(i).getNome())) {
					spinnerQuantita.setModel(new SpinnerNumberModel(1, 1, prodotti.get(i).getQuantita(), 1));
					((DefaultEditor) spinnerQuantita.getEditor()).getTextField().setEditable(false);
					spinnerQuantita.getEditor().getComponent(0).setBackground(new Color(191, 215, 255));
					spinnerQuantita.getEditor().getComponent(0).setForeground(new Color(0, 41, 82));
					LabelID.setText(Integer.toString(prodotti.get(i).getIdprodotto()));
				}
			} 
		}
		else {
			LabelID.setText("");
		}
	}
	
	public void VisibilitaLabel(String nome) {
		if(nome.equals("ORTOFRUTTA")) {
			ButtonOrtofrutta.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonOrtofruttaBlue.png")));
			ButtonFarinacei.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonFarinacei.png")));
			ButtonConfezionati.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonConfezionati.png")));
			ButtonLatticini.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonLatticini.png")));
			ButtonUova.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonUova.png")));
		}
		else if(nome.equals("LATTICINO")) {
			ButtonOrtofrutta.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonOrtofrutta.png")));
			ButtonFarinacei.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonFarinacei.png")));
			ButtonConfezionati.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonConfezionati.png")));
			ButtonLatticini.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonLatticiniBlue.png")));
			ButtonUova.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonUova.png")));
		}
		else if(nome.equals("CONFEZIONATO")) {
			ButtonOrtofrutta.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonOrtofrutta.png")));
			ButtonFarinacei.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonFarinacei.png")));
			ButtonConfezionati.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonConfezionatiBlue.png")));
			ButtonLatticini.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonLatticini.png")));
			ButtonUova.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonUova.png")));
		
		}
		else if(nome.equals("FARINACEO")) {
			ButtonOrtofrutta.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonOrtofrutta.png")));
			ButtonFarinacei.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonFarinaceiBlue.png")));
			ButtonConfezionati.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonConfezionati.png")));
			ButtonLatticini.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonLatticini.png")));
			ButtonUova.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonUova.png")));
			
		}
		else if(nome.equals("UOVA")) {
			ButtonOrtofrutta.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonOrtofrutta.png")));
			ButtonFarinacei.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonFarinacei.png")));
			ButtonConfezionati.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonConfezionati.png")));
			ButtonLatticini.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonLatticini.png")));
			ButtonUova.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonUovaBlue.png")));
		}
	}
	
	public void ControlloAggiungiProdotto(Controller ctrl) {
		if (comboBoxNome.getSelectedItem()!=null) {
			setAlwaysOnTop(false);
			ctrl.AggiungiProdottoAlNegozio(Integer.parseInt(LabelID.getText()),Integer.parseInt(spinnerQuantita.getValue().toString()));
			JOptionPane.showMessageDialog(null, "PRODOTTO AGGIUNTO CORRETTAMENTE \nAGGIORNARE LA TABELLA PER VISUALIZZARE IL PRODOTTO", "",JOptionPane.INFORMATION_MESSAGE);
			setAlwaysOnTop(true);
			CaricaComboBoxNome(ctrl);
			CaricaSpinnerQuantita(ctrl);
		}
		else {
			setAlwaysOnTop(false);
			JOptionPane.showMessageDialog(null, "TIPOLOGIA DI PRODOTTI TERMINATA IN DEPOSITO", "",JOptionPane.WARNING_MESSAGE);
			setAlwaysOnTop(true);
		}
	}
}
