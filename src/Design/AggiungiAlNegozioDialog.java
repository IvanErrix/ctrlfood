package Design;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.accessibility.AccessibleContext;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.basic.BasicComboPopup;

import ExternalClasses.RoundedCornerBorder;
import Main.Controller;
import Objects.Prodotto;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;

public class AggiungiAlNegozioDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Prodotto> prodotti;
	private JComboBox comboBoxTipologia;
	private JComboBox comboBoxNome;
	private JSpinner spinnerQuantita;

	public AggiungiAlNegozioDialog(Controller ctrl) throws SQLException {
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
		LabelTipologia.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelTipologia.setBounds(41, 57, 92, 21);
		getContentPane().add(LabelTipologia);
		
		JLabel LabelNome = new JLabel("Nome");
		LabelNome.setForeground(new Color(0,41,82));
		LabelNome.setFont(new Font("Impact", Font.PLAIN, 16));
		LabelNome.setBounds(41, 118, 46, 14);
		getContentPane().add(LabelNome);
		
		JLabel lblQuantita = new JLabel("Quantit\u00E0");
		lblQuantita.setForeground(new Color(0,41,82));
		lblQuantita.setFont(new Font("Impact", Font.PLAIN, 16));
		lblQuantita.setBounds(41, 178, 68, 14);
		getContentPane().add(lblQuantita);
		
		JButton ButtonAggiugni = new JButton("");
		ButtonAggiugni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonAggiugni.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAggiungi2Azzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonAggiugni.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/ButtonAggiungi2Azzurro.png")));
			}
		});
		ButtonAggiugni.setPressedIcon(new ImageIcon(AggiungiAlNegozioDialog.class.getResource("/scrimg/ButtonAggiungi2.png")));
		ButtonAggiugni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAggiugni.setOpaque(false);
		ButtonAggiugni.setBorder(null);
		ButtonAggiugni.setContentAreaFilled(false);
		ButtonAggiugni.setIcon(new ImageIcon(AggiungiAlNegozioDialog.class.getResource("/scrimg/ButtonAggiungi2.png")));
		ButtonAggiugni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "PRODOTTO AGGIUNTO CORRETTAMENTE", "", JOptionPane.INFORMATION_MESSAGE);
				setAlwaysOnTop(true);
			}
		});
		ButtonAggiugni.setBounds(288, 300, 110, 24);
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
			}
		});
		AccessibleContext ac = comboBoxNome.getAccessibleContext();
		BasicComboPopup pop = (BasicComboPopup) ac.getAccessibleChild(0);
		JList list = pop.getList();
		list.setSelectionForeground(new Color(191, 215, 255));
		list.setSelectionBackground(new Color(0, 41, 82));
		comboBoxNome.setBorder(new RoundedCornerBorder());
		comboBoxNome.setFocusable(false);
		comboBoxNome.setForeground(new Color(0,41,82));
		comboBoxNome.setBackground(new Color(191,215,255));
		comboBoxNome.setBounds(208, 108, 190, 24);
		getContentPane().add(comboBoxNome);
		
		comboBoxTipologia = new JComboBox();
		comboBoxTipologia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CaricaComboBoxNome(ctrl);
//					CaricaSpinnerQuantita(ctrl);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		AccessibleContext ac2 = comboBoxTipologia.getAccessibleContext();
		BasicComboPopup pop2 = (BasicComboPopup) ac2.getAccessibleChild(0);
		JList list2 = pop2.getList();
		list2.setSelectionForeground(new Color(191, 215, 255));
		list2.setSelectionBackground(new Color(0, 41, 82));
		comboBoxTipologia.setModel(new DefaultComboBoxModel(new String[] {"Ortofrutta", "Latticini", "Farinacei", "Uova", "Confezionati"}));
		comboBoxTipologia.setMaximumRowCount(3);
		comboBoxTipologia.setForeground(new Color(0,41,82));
		comboBoxTipologia.setFont(new Font("Impact", Font.PLAIN, 11));
		comboBoxTipologia.setFocusable(false);
		comboBoxTipologia.setBorder(new RoundedCornerBorder());
		comboBoxTipologia.setBackground(new Color(191,215,255));
		comboBoxTipologia.setBounds(208, 57, 190, 24);
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
		spinnerQuantita.setFont(new Font("Impact", Font.PLAIN, 14));
		spinnerQuantita.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		spinnerQuantita.setBounds(208, 174, 60, 24);
		getContentPane().add(spinnerQuantita);
		
		JLabel LabelSfondo = new JLabel("");
		LabelSfondo.setIcon(new ImageIcon(AggiungiAlNegozioDialog.class.getResource("/scrimg/SfondoAggiungiAlnegozio.png")));
		LabelSfondo.setBounds(-8, -8, 467, 376);
		getContentPane().add(LabelSfondo);
		
		CaricaComboBoxNome(ctrl);
//		CaricaSpinnerQuantita(ctrl);
	}
	
	public void CaricaComboBoxNome(Controller ctrl) throws SQLException {
		prodotti=ctrl.CaricaProdottiDeposito(ctrl);
		comboBoxNome.removeAllItems();
		for(int i=0; i<prodotti.size(); i++) {
			if(prodotti.get(i).getOrtofrutta()==true && comboBoxTipologia.getSelectedItem()=="Ortofrutta") {
				comboBoxNome.addItem(prodotti.get(i).getNome());
			}
			else if(prodotti.get(i).getLatticino()==true && comboBoxTipologia.getSelectedItem()=="Latticini") {
				comboBoxNome.addItem(prodotti.get(i).getNome());
			}
			else if(prodotti.get(i).getFarinaceo()==true && comboBoxTipologia.getSelectedItem()=="Farinacei") {
				comboBoxNome.addItem(prodotti.get(i).getNome());
			}
			else if(prodotti.get(i).getUova()==true && comboBoxTipologia.getSelectedItem()=="Uova") {
				comboBoxNome.addItem(prodotti.get(i).getNome());
			}
			else if(prodotti.get(i).getConfezionato()==true && comboBoxTipologia.getSelectedItem()=="Confezionati") {
				comboBoxNome.addItem(prodotti.get(i).getNome());
			}
		}
	}
	
	public void CaricaSpinnerQuantita(Controller ctrl) throws SQLException {
		prodotti=ctrl.CaricaProdottiDeposito(ctrl);
		for(int i=0; i<prodotti.size(); i++) {
			if(comboBoxNome.getSelectedItem().toString().equals(prodotti.get(i).getNome())) {
				spinnerQuantita.setValue(prodotti.get(i).getQuantita());
			}
		}
	}
}
