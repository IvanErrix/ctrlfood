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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.basic.BasicComboPopup;

import ExternalClasses.ContentPane;
import ExternalClasses.RoundedCornerBorder;
import Main.Controller;
import Objects.Prodotto;

import javax.swing.SwingConstants;
import javax.swing.JSpinner.DefaultEditor;

public class AggiungiAlCarrelloDialog extends JDialog {
	
	private ArrayList<Prodotto> prodotti;
	private JComboBox comboBoxNome;
	private JSpinner spinnerQuantita;
	private JLabel LabelID;
	private JLabel LabelPrezzo;
	private JLabel LabelDataScadenza;

	private static final long serialVersionUID = 1L;

	public AggiungiAlCarrelloDialog(Controller ctrl) {
		setUndecorated(true);
		setSize(449, 357);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		getContentPane().setLayout(null);
		ContentPane contentPane = new ContentPane();
		setContentPane(contentPane);
		getContentPane().isOpaque();
		setBackground(new Color(0, 67, 137, 0));
		contentPane.setLayout(null);
		
		JLabel LabelNome = new JLabel("Nome");
		LabelNome.setForeground(new Color(0,41,82));
		LabelNome.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelNome.setBounds(44, 41, 46, 14);
		getContentPane().add(LabelNome);
		
		JLabel LabelQuantita = new JLabel("Quantit\u00E0");
		LabelQuantita.setForeground(new Color(0,41,82));
		LabelQuantita.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelQuantita.setBounds(44, 240, 68, 14);
		getContentPane().add(LabelQuantita);
		
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
		ButtonAggiugni.setPressedIcon(new ImageIcon(AggiungiAlCarrelloDialog.class.getResource("/scrimg/ButtonAggiungi2.png")));
		ButtonAggiugni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAggiugni.setOpaque(false);
		ButtonAggiugni.setBorder(null);
		ButtonAggiugni.setContentAreaFilled(false);
		ButtonAggiugni.setIcon(new ImageIcon(AggiungiAlCarrelloDialog.class.getResource("/scrimg/ButtonAggiungi2.png")));
		ButtonAggiugni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "PRODOTTO AGGIUNTO CORRETTAMENTE", "", JOptionPane.INFORMATION_MESSAGE);
				setAlwaysOnTop(true);
			}
		});
		ButtonAggiugni.setBounds(258, 290, 110, 24);
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
		ButtonAnnulla.setPressedIcon(new ImageIcon(AggiungiAlCarrelloDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
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
		ButtonAnnulla.setBounds(44, 290, 110, 24);
		getContentPane().add(ButtonAnnulla);
		
		comboBoxNome = new JComboBox();
		comboBoxNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CaricaSpinnerELabels(ctrl);
			}
		});
		AccessibleContext ac = comboBoxNome.getAccessibleContext();
		BasicComboPopup pop = (BasicComboPopup) ac.getAccessibleChild(0);
		JList list = pop.getList();
		list.setSelectionForeground(new Color(191, 215, 255));
		list.setSelectionBackground(new Color(0, 41, 82));
		comboBoxNome.setBorder(new RoundedCornerBorder());
		comboBoxNome.setOpaque(false);
		comboBoxNome.setMaximumRowCount(3);
		comboBoxNome.setBackground(new Color(191,215,255));
		comboBoxNome.setForeground(new Color(0,41,82));
		comboBoxNome.setFont(new Font("Cambria", Font.BOLD, 16));
		comboBoxNome.setFocusable(false);
		comboBoxNome.setBounds(155, 25, 221, 30);
		getContentPane().add(comboBoxNome);
		
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
		spinnerQuantita.setBounds(193, 224, 60, 30);
		getContentPane().add(spinnerQuantita);
		
		JLabel LabelIDProdotto = new JLabel("ID Prodotto");
		LabelIDProdotto.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelIDProdotto.setBounds(44, 102, 94, 14);
		LabelIDProdotto.setForeground(new Color(0,41,82));
		contentPane.add(LabelIDProdotto);
		
		LabelID = new JLabel("");
		LabelID.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelID.setHorizontalAlignment(SwingConstants.CENTER);
		LabelID.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelID.setBounds(193, 96, 94, 24);
		LabelID.setForeground(new Color(0,41,82));
		LabelID.setBorder(new RoundedCornerBorder());
		contentPane.add(LabelID);
		
		LabelPrezzo = new JLabel("");
		LabelPrezzo.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelPrezzo.setHorizontalAlignment(SwingConstants.CENTER);
		LabelPrezzo.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelPrezzo.setBounds(193, 152, 94, 24);
		LabelPrezzo.setForeground(new Color(0,41,82));
		LabelPrezzo.setBorder(new RoundedCornerBorder());
		contentPane.add(LabelPrezzo);
		
		LabelDataScadenza = new JLabel("");
		LabelDataScadenza.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelDataScadenza.setHorizontalAlignment(SwingConstants.CENTER);
		LabelDataScadenza.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelDataScadenza.setBounds(193, 189, 124, 24);
		LabelDataScadenza.setForeground(new Color(0,41,82));
		LabelDataScadenza.setBorder(new RoundedCornerBorder());
		contentPane.add(LabelDataScadenza);
		
		JLabel LabelPrezzoProdotto = new JLabel("Prezzo");
		LabelPrezzoProdotto.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelPrezzoProdotto.setBounds(44, 162, 68, 14);
		LabelPrezzoProdotto.setForeground(new Color(0,41,82));
		contentPane.add(LabelPrezzoProdotto);
		
		JLabel LabelDataScadenzaProdotto = new JLabel("Data Scadenza");
		LabelDataScadenzaProdotto.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelDataScadenzaProdotto.setBounds(44, 203, 110, 14);
		LabelDataScadenzaProdotto.setForeground(new Color(0,41,82));
		contentPane.add(LabelDataScadenzaProdotto);
		
		JLabel LabelSfondo = new JLabel("");
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
				comboBoxNome.addItem(prodotti.get(i).getNome());
				
		}
	}
	
	public void CaricaSpinnerELabels(Controller ctrl) {
		prodotti=ctrl.CaricaProdottiNegozio();
		if (comboBoxNome.getSelectedItem()!=null) {
			for (int i = 0; i < prodotti.size(); i++) {
				if (comboBoxNome.getSelectedItem().toString().equals(prodotti.get(i).getNome())) {
					spinnerQuantita.setModel(new SpinnerNumberModel(1, 1, prodotti.get(i).getQuantita(), 1));
					((DefaultEditor) spinnerQuantita.getEditor()).getTextField().setEditable(false);
					spinnerQuantita.getEditor().getComponent(0).setBackground(new Color(191, 215, 255));
					spinnerQuantita.getEditor().getComponent(0).setForeground(new Color(0, 41, 82));
					LabelID.setText(Integer.toString(prodotti.get(i).getIdprodotto()));
					LabelPrezzo.setText(Double.toString(prodotti.get(i).getPrezzo())+"€");
					LabelDataScadenza.setText(prodotti.get(i).getData_scadenza().toString());
				}
			} 
		}
		else {
			LabelID.setText("");
			LabelPrezzo.setText("");
		}
	}
}
