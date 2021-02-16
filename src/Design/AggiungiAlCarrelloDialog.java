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
	private JButton ButtonAggiungi;
	private JButton ButtonAnnulla;
	
	private static final long serialVersionUID = 1L;

	public AggiungiAlCarrelloDialog(Controller ctrl) {
		setAlwaysOnTop(true);
		setUndecorated(true);
		setSize(467, 376);
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
		LabelNome.setBounds(44, 41, 46, 14);
		contentPane.add(LabelNome);
		
		/*LABEL QUANTITA*/
		LabelQuantita = new JLabel("Quantit\u00E0");
		LabelQuantita.setForeground(new Color(0,41,82));
		LabelQuantita.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelQuantita.setBounds(44, 240, 68, 14);
		contentPane.add(LabelQuantita);
		
		/*BUTTON AGGIUNGI*/
		ButtonAggiungi = new JButton("");
		ButtonAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAlwaysOnTop(false);
				String valore = comboBoxNome.getSelectedItem().toString();
				valore = valore.replaceAll("\\s+","");
				String[] parts = valore.split("-");
				String idprodotto = parts[0];
				ctrl.AggiungiProdottoAlCarrello(ctrl.RecuperaCarrello(), Integer.parseInt(idprodotto), Integer.parseInt(spinnerQuantita.getValue().toString()));
				JOptionPane.showMessageDialog(null, "PRODOTTO AGGIUNTO CORRETTAMENTE", "", JOptionPane.INFORMATION_MESSAGE);
				setAlwaysOnTop(true);
				CaricaComboBoxNome(ctrl);
				CaricaSpinnerELabels(ctrl);
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
		ButtonAggiungi.setBounds(258, 290, 110, 24);
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
		ButtonAnnulla.setBounds(44, 290, 110, 24);
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
		comboBoxNome.setBorder(new RoundedCornerBorder());
		comboBoxNome.setOpaque(false);
		comboBoxNome.setMaximumRowCount(3);
		comboBoxNome.setBackground(new Color(191,215,255));
		comboBoxNome.setForeground(new Color(0,41,82));
		comboBoxNome.setFont(new Font("Cambria", Font.BOLD, 16));
		comboBoxNome.setFocusable(false);
		comboBoxNome.setBounds(167, 25, 221, 30);
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
		spinnerQuantita.setBounds(227, 224, 100, 30);
		contentPane.add(spinnerQuantita);
		
		/*LABEL PREZZO*/
		LabelPrezzo = new JLabel("");
		LabelPrezzo.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelPrezzo.setHorizontalAlignment(SwingConstants.CENTER);
		LabelPrezzo.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelPrezzo.setBounds(216, 103, 124, 24);
		LabelPrezzo.setForeground(new Color(0,41,82));
		LabelPrezzo.setBorder(new RoundedCornerBorder());
		contentPane.add(LabelPrezzo);
		
		/*LABEL DATA SCADENZA*/
		LabelDataScadenza = new JLabel("");
		LabelDataScadenza.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelDataScadenza.setHorizontalAlignment(SwingConstants.CENTER);
		LabelDataScadenza.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelDataScadenza.setBounds(216, 167, 124, 24);
		LabelDataScadenza.setForeground(new Color(0,41,82));
		LabelDataScadenza.setBorder(new RoundedCornerBorder());
		contentPane.add(LabelDataScadenza);
		
		/*LABEL PREZZO PRODOTTO*/
		LabelPrezzoProdotto = new JLabel("Prezzo");
		LabelPrezzoProdotto.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelPrezzoProdotto.setBounds(44, 113, 68, 14);
		LabelPrezzoProdotto.setForeground(new Color(0,41,82));
		contentPane.add(LabelPrezzoProdotto);
		
		/*LABEL DATA SCADENZA PRODOTTO*/
		LabelDataScadenzaProdotto = new JLabel("Data Scadenza");
		LabelDataScadenzaProdotto.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelDataScadenzaProdotto.setBounds(44, 177, 110, 14);
		LabelDataScadenzaProdotto.setForeground(new Color(0,41,82));
		contentPane.add(LabelDataScadenzaProdotto);
		
		/*LABEL SFONDO*/
		LabelSfondo = new JLabel("");
		LabelSfondo.setIcon(new ImageIcon(AggiungiAlCarrelloDialog.class.getResource("/scrimg/SfondoAggiungiAlnegozio.png")));
		LabelSfondo.setBounds(-9, -9, 467, 376);
		contentPane.add(LabelSfondo);
		
		CaricaComboBoxNome(ctrl);
		CaricaSpinnerELabels(ctrl);
	}
	
	public void CaricaComboBoxNome(Controller ctrl) {
		prodotti=ctrl.CaricaProdottiNegozio();
		comboBoxNome.removeAllItems();
		for(int i=0; i<prodotti.size(); i++) {
				comboBoxNome.addItem(prodotti.get(i).getIdprodotto()+" - "+prodotti.get(i).getNome());
				
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
}
