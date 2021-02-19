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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.plaf.basic.BasicComboPopup;

import ExternalClasses.ContentPane;
import ExternalClasses.RoundedCornerBorder;
import Main.Controller;
import Objects.Prodotto;

import javax.swing.SwingConstants;
import javax.swing.JSpinner.DefaultEditor;

public class AggiungiAlCarrelloDialog extends JDialog {
	
	private ArrayList<Prodotto> prodotti;
	private JList<?> list;
	private JComboBox<String> comboBoxNome;
	private ContentPane contentPane;
	private JSpinner spinnerQuantita;
	private JLabel LabelNome;
	private JLabel LabelQuantita;
	private JLabel LabelPrezzoProdotto; //Label fissa
	private JLabel LabelPrezzo; //Label caricamento del prezzo del prodotto
	private JLabel LabelDataScadenzaProdotto; //Label fissa
	private JLabel LabelDataScadenza; //Label caricamento della data di scadelza del prodotto
	private JLabel LabelSfondo;
	private String nome = "ORTOFRUTTA";
	private JButton ButtonOrtofrutta;
	private JButton ButtonFarinacei;
	private JButton ButtonConfezionati;
	private JButton ButtonLatticini;
	private JButton ButtonUova;
	private JButton ButtonAggiungi;
	private JButton ButtonAnnulla;
	
	private static final long serialVersionUID = 1L;

	public AggiungiAlCarrelloDialog(Controller ctrl) {
		setAlwaysOnTop(true);
		setUndecorated(true);
		setSize(570, 417);
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
		LabelNome.setBounds(96, 162, 46, 14);
		contentPane.add(LabelNome);
		
		/*LABEL QUANTITA*/
		LabelQuantita = new JLabel("Quantit\u00E0");
		LabelQuantita.setForeground(new Color(0,41,82));
		LabelQuantita.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelQuantita.setBounds(96, 282, 68, 14);
		contentPane.add(LabelQuantita);
		
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
		ButtonOrtofrutta.setBounds(31, 27, 78, 83);
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
		ButtonFarinacei.setBounds(130, 27, 78, 83);
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
		ButtonConfezionati.setBounds(229, 27, 78, 83);
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
		ButtonLatticini.setBounds(330, 27, 78, 83);
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
		ButtonUova.setBounds(436, 27, 78, 83);
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
		ButtonAggiungi.setPressedIcon(new ImageIcon(AggiungiAlCarrelloDialog.class.getResource("/scrimg/ButtonAggiungi2.png")));
		ButtonAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAggiungi.setOpaque(false);
		ButtonAggiungi.setBorder(null);
		ButtonAggiungi.setContentAreaFilled(false);
		ButtonAggiungi.setIcon(new ImageIcon(AggiungiAlCarrelloDialog.class.getResource("/scrimg/ButtonAggiungi2.png")));
		ButtonAggiungi.setBounds(330, 341, 110, 24);
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
		ButtonAnnulla.setOpaque(false);
		ButtonAnnulla.setPressedIcon(new ImageIcon(AggiungiAlCarrelloDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
		ButtonAnnulla.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
		ButtonAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAnnulla.setBorder(null);
		ButtonAnnulla.setContentAreaFilled(false);
		ButtonAnnulla.setBounds(96, 341, 110, 24);
		contentPane.add(ButtonAnnulla);
		
		/*COMBOBOX NOME*/
		comboBoxNome = new JComboBox<String>();
		comboBoxNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CaricaSpinnerELabels(ctrl);
			}
		});
		AccessibleContext ac = comboBoxNome.getAccessibleContext();
		BasicComboPopup pop = (BasicComboPopup) ac.getAccessibleChild(0);
		list = pop.getList();
		list.setSelectionForeground(new Color(191, 215, 255));
		list.setSelectionBackground(new Color(0, 41, 82));
		list.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxNome.setBorder(new RoundedCornerBorder());
		comboBoxNome.setOpaque(false);
		comboBoxNome.setMaximumRowCount(3);
		comboBoxNome.setBackground(new Color(191,215,255));
		comboBoxNome.setForeground(new Color(0,41,82));
		comboBoxNome.setFont(new Font("Cambria", Font.BOLD, 16));
		comboBoxNome.setFocusable(false);
		comboBoxNome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxNome.setBounds(219, 146, 221, 30);
		contentPane.add(comboBoxNome);
		
		/*SPINNER QUANTITA*/
		SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 50, 1);
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
		spinnerQuantita.setBounds(279, 266, 100, 30);
		contentPane.add(spinnerQuantita);
		
		/*LABEL PREZZO*/
		LabelPrezzo = new JLabel("");
		LabelPrezzo.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelPrezzo.setHorizontalAlignment(SwingConstants.CENTER);
		LabelPrezzo.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelPrezzo.setBounds(268, 196, 124, 24);
		LabelPrezzo.setForeground(new Color(0,41,82));
		LabelPrezzo.setBorder(new RoundedCornerBorder());
		contentPane.add(LabelPrezzo);
		
		/*LABEL DATA SCADENZA*/
		LabelDataScadenza = new JLabel("");
		LabelDataScadenza.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelDataScadenza.setHorizontalAlignment(SwingConstants.CENTER);
		LabelDataScadenza.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelDataScadenza.setBounds(268, 231, 124, 24);
		LabelDataScadenza.setForeground(new Color(0,41,82));
		LabelDataScadenza.setBorder(new RoundedCornerBorder());
		contentPane.add(LabelDataScadenza);
		
		/*LABEL PREZZO PRODOTTO*/
		LabelPrezzoProdotto = new JLabel("Prezzo");
		LabelPrezzoProdotto.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelPrezzoProdotto.setBounds(96, 206, 68, 14);
		LabelPrezzoProdotto.setForeground(new Color(0,41,82));
		contentPane.add(LabelPrezzoProdotto);
		
		/*LABEL DATA SCADENZA PRODOTTO*/
		LabelDataScadenzaProdotto = new JLabel("Data Scadenza");
		LabelDataScadenzaProdotto.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelDataScadenzaProdotto.setBounds(96, 241, 110, 14);
		LabelDataScadenzaProdotto.setForeground(new Color(0,41,82));
		contentPane.add(LabelDataScadenzaProdotto);
		
		/*LABEL SFONDO*/
		LabelSfondo = new JLabel("");
		LabelSfondo.setIcon(new ImageIcon(AggiungiAlNegozioDialog.class.getResource("/scrimg/SfondoClienti.png")));
		LabelSfondo.setBounds(-8, -8, 580, 429);
		contentPane.add(LabelSfondo);
		
		CaricaComboBoxNome(ctrl);
		CaricaSpinnerELabels(ctrl);
	}
	
	public void CaricaComboBoxNome(Controller ctrl) {
		prodotti=ctrl.CaricaProdottiNegozio();
		comboBoxNome.removeAllItems();
		for(int i=0; i<prodotti.size(); i++) {
			if(prodotti.get(i).getOrtofrutta()==true && nome.equals("ORTOFRUTTA")) {
				comboBoxNome.addItem(prodotti.get(i).getIdprodotto()+" - "+prodotti.get(i).getNome());
			}
			else if(prodotti.get(i).getLatticino()==true && nome.equals("LATTICINO")) {
				comboBoxNome.addItem(prodotti.get(i).getIdprodotto()+" - "+prodotti.get(i).getNome());
			}
			else if(prodotti.get(i).getFarinaceo()==true && nome.equals("FARINACEO")) {
				comboBoxNome.addItem(prodotti.get(i).getIdprodotto()+" - "+prodotti.get(i).getNome());
			}
			else if(prodotti.get(i).getUova()==true && nome.equals("UOVA")) {
				comboBoxNome.addItem(prodotti.get(i).getIdprodotto()+" - "+prodotti.get(i).getNome());
			}
			else if(prodotti.get(i).getConfezionato()==true &&nome.equals("CONFEZIONATO")) {
				comboBoxNome.addItem(prodotti.get(i).getIdprodotto()+" - "+prodotti.get(i).getNome());
			}
		}
	}
	
	public void CaricaSpinnerELabels(Controller ctrl) {
		prodotti=ctrl.CaricaProdottiNegozio();
		if (comboBoxNome.getSelectedItem()!=null) {
			for (int i = 0; i < prodotti.size(); i++) {
				String valore = comboBoxNome.getSelectedItem().toString();
				valore = valore.replaceAll("\\s+","");
				String[] parts = valore.split("-");
				String part1 = parts[0];
				if (part1.equals(Integer.toString(prodotti.get(i).getIdprodotto()))) {
					spinnerQuantita.setModel(new SpinnerNumberModel(1, 1, prodotti.get(i).getQuantita(), 1));
					((DefaultEditor) spinnerQuantita.getEditor()).getTextField().setEditable(false);
					spinnerQuantita.getEditor().getComponent(0).setBackground(new Color(191, 215, 255));
					spinnerQuantita.getEditor().getComponent(0).setForeground(new Color(0, 41, 82));
					LabelPrezzo.setText(Double.toString(prodotti.get(i).getPrezzo())+"€");
					LabelDataScadenza.setText(prodotti.get(i).getData_scadenza().toString());
				}
			} 
		}
		else {
			LabelPrezzo.setText("");
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
		if(comboBoxNome.getSelectedItem()!=null) {
			String valore = comboBoxNome.getSelectedItem().toString();
			valore = valore.replaceAll("\\s+","");
			String[] parts = valore.split("-");
			String idprodotto = parts[0];
			ctrl.AggiungiProdottoAlCarrello(ctrl.RecuperaCarrello(), Integer.parseInt(idprodotto), Integer.parseInt(spinnerQuantita.getValue().toString()));
			setAlwaysOnTop(false);
			JOptionPane.showMessageDialog(null, "PRODOTTO AGGIUNTO CORRETTAMENTE \nAGGIORNARE LA TABELLA PER VISUALIZZARE IL PRODOTTO", "", JOptionPane.INFORMATION_MESSAGE);
			setAlwaysOnTop(true);
			CaricaComboBoxNome(ctrl);
			CaricaSpinnerELabels(ctrl);
		}
		else {
			setAlwaysOnTop(false);
			JOptionPane.showMessageDialog(null, "QUESTA TIPOLOGIA DI PRODOTTI È TERMINATA NEL NEGOZIO", "", JOptionPane.WARNING_MESSAGE);
			setAlwaysOnTop(true);
		}
	}
}
