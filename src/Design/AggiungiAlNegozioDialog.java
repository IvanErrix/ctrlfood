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
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class AggiungiAlNegozioDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Prodotto> prodotti;
	private JComboBox comboBoxTipologia;
	private JComboBox comboBoxNome;
	private JSpinner spinnerQuantita;
	private JLabel LabelID;

	@SuppressWarnings("unchecked")
	public AggiungiAlNegozioDialog(Controller ctrl) {
		setUndecorated(true);
		setSize(453, 364);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		getContentPane().setLayout(null);
		ContentPane contentPane = new ContentPane();
		setContentPane(contentPane);
		getContentPane().isOpaque();
		setBackground(new Color(0, 67, 137, 0));
		contentPane.setLayout(null);
		
		JLabel LabelTipologia = new JLabel("Tipologia");
		LabelTipologia.setForeground(new Color(0,41,82));
		LabelTipologia.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelTipologia.setBounds(41, 57, 92, 21);
		getContentPane().add(LabelTipologia);
		
		JLabel LabelNome = new JLabel("Nome");
		LabelNome.setForeground(new Color(0,41,82));
		LabelNome.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelNome.setBounds(41, 107, 46, 24);
		getContentPane().add(LabelNome);
		
		JLabel LabelQuantita = new JLabel("Quantit\u00E0");
		LabelQuantita.setForeground(new Color(0,41,82));
		LabelQuantita.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelQuantita.setBounds(41, 220, 68, 14);
		getContentPane().add(LabelQuantita);
		
		JLabel LabelIDProdotto = new JLabel("ID Prodotto");
		LabelIDProdotto.setForeground(new Color(0,41,82));
		LabelIDProdotto.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelIDProdotto.setBounds(41, 169, 92, 21);
		contentPane.add(LabelIDProdotto);
		
		JButton ButtonAggiungi = new JButton("");
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
		ButtonAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAlwaysOnTop(false);
				ctrl.AggiungiProdottoAlNegozio(Integer.parseInt(LabelID.getText()), Integer.parseInt(spinnerQuantita.getValue().toString()));
				JOptionPane.showMessageDialog(null, "PRODOTTO AGGIUNTO CORRETTAMENTE", "", JOptionPane.INFORMATION_MESSAGE);
				setAlwaysOnTop(true);
				CaricaComboBoxNome(ctrl);
				CaricaSpinnerQuantita(ctrl);
			}
		});
		ButtonAggiungi.setBounds(288, 300, 110, 24);
		getContentPane().add(ButtonAggiungi);
		
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
		ButtonAnnulla.setBounds(41, 300, 110, 24);
		getContentPane().add(ButtonAnnulla);
		
		comboBoxNome = new JComboBox();
		comboBoxNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CaricaSpinnerQuantita(ctrl);
			}
		});
		AccessibleContext ac = comboBoxNome.getAccessibleContext();
		BasicComboPopup pop = (BasicComboPopup) ac.getAccessibleChild(0);
		JList list = pop.getList();
		list.setSelectionForeground(new Color(191, 215, 255));
		list.setSelectionBackground(new Color(0, 41, 82));
		comboBoxNome.setBorder(new RoundedCornerBorder());
		comboBoxNome.setFont(new Font("Cambria", Font.BOLD, 14));
		comboBoxNome.setFocusable(false);
		comboBoxNome.setMaximumRowCount(3);
		comboBoxNome.setForeground(new Color(0,41,82));
		comboBoxNome.setBackground(new Color(191,215,255));
		comboBoxNome.setBounds(208, 107, 190, 25);
		getContentPane().add(comboBoxNome);
		
		comboBoxTipologia = new JComboBox();
		comboBoxTipologia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CaricaComboBoxNome(ctrl);
				CaricaSpinnerQuantita(ctrl);
			}
		});
		AccessibleContext ac2 = comboBoxTipologia.getAccessibleContext();
		BasicComboPopup pop2 = (BasicComboPopup) ac2.getAccessibleChild(0);
		JList list2 = pop2.getList();
		list2.setSelectionForeground(new Color(191, 215, 255));
		list2.setSelectionBackground(new Color(0, 41, 82));
		comboBoxTipologia.setModel(new DefaultComboBoxModel(new String[] {"ORTOFRUTTA", "LATTICINI", "FARINACEI", "UOVA", "CONFEZIONATI"}));
		comboBoxNome.setMaximumRowCount(5);
		comboBoxTipologia.setForeground(new Color(0,41,82));
		comboBoxTipologia.setFont(new Font("Cambria", Font.BOLD, 14));
		comboBoxTipologia.setFocusable(false);
		comboBoxTipologia.setBorder(new RoundedCornerBorder());
		comboBoxTipologia.setBackground(new Color(191,215,255));
		comboBoxTipologia.setBounds(208, 56, 190, 25);
		getContentPane().add(comboBoxTipologia);
		
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
		spinnerQuantita.setBounds(208, 216, 60, 24);
		((DefaultEditor) spinnerQuantita.getEditor()).getTextField().setEditable(false);
		getContentPane().add(spinnerQuantita);
		
		LabelID = new JLabel("");
		LabelID.setHorizontalAlignment(SwingConstants.CENTER);
		LabelID.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelID.setForeground(new Color(0,41,82));
		LabelID.setFont(new Font("Cambria", Font.BOLD, 16));
		LabelID.setBorder(new RoundedCornerBorder());
		LabelID.setBounds(208, 166, 68, 24);
		contentPane.add(LabelID);
		
		JLabel LabelSfondo = new JLabel("");
		LabelSfondo.setIcon(new ImageIcon(AggiungiAlNegozioDialog.class.getResource("/scrimg/SfondoAggiungiAlnegozio.png")));
		LabelSfondo.setBounds(-8, -8, 467, 376);
		getContentPane().add(LabelSfondo);
		
		
		
		CaricaComboBoxNome(ctrl);
		CaricaSpinnerQuantita(ctrl);
	}
	
	public void CaricaComboBoxNome(Controller ctrl) {
		prodotti=ctrl.CaricaProdottiDeposito(ctrl);
		comboBoxNome.removeAllItems();
		for(int i=0; i<prodotti.size(); i++) {
			if(prodotti.get(i).getOrtofrutta()==true && comboBoxTipologia.getSelectedItem()=="ORTOFRUTTA") {
				comboBoxNome.addItem(prodotti.get(i).getNome());
			}
			else if(prodotti.get(i).getLatticino()==true && comboBoxTipologia.getSelectedItem()=="LATTICINI") {
				comboBoxNome.addItem(prodotti.get(i).getNome());
			}
			else if(prodotti.get(i).getFarinaceo()==true && comboBoxTipologia.getSelectedItem()=="FARINACEI") {
				comboBoxNome.addItem(prodotti.get(i).getNome());
			}
			else if(prodotti.get(i).getUova()==true && comboBoxTipologia.getSelectedItem()=="UOVA") {
				comboBoxNome.addItem(prodotti.get(i).getNome());
			}
			else if(prodotti.get(i).getConfezionato()==true && comboBoxTipologia.getSelectedItem()=="CONFEZIONATI") {
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
}
