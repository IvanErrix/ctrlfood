package main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ClientiPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private String Titoli[]= {"Nome", "Cognome", "Codice Fiscale", "ID Carta","Punti"};
	private String Elementi[][]= {};
	public DefaultTableModel model = new DefaultTableModel(Elementi, Titoli) {
		private static final long serialVersionUID = 1L;

			@Override
			   public boolean isCellEditable(int row, int column) {
			       //Only the third column
			       return false;
			   }
			};
	private JTable table;
	private JTextField textField;

	public ClientiPanel(Controller ctrl) {
		setOpaque(false);
		setBackground(Color.BLACK);
		setBounds(0, 0, 765, 600);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(0, 67, 137));
		scrollPane.setOpaque(false);
		scrollPane.setBounds(10, 78, 745, 511);
		add(scrollPane);
		
		table = new JTable(model);
		table.setForeground(new Color(255, 213, 0));
		table.setOpaque(false);
		table.setBackground(new Color(0, 67, 137));
		table.setBounds(302, 183, 150, 150);
		scrollPane.setViewportView(table);
		model.isCellEditable(0, 0);
		model.addRow(new Object[] {"Giovanni", "Erricis", "RRCVNI99B11F839C", "001", "110"});
	
		JButton ButtonSearch = new JButton("");
		ButtonSearch.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonSearch.png")));
		ButtonSearch.setOpaque(false);
		ButtonSearch.setBorder(null);
		ButtonSearch.setContentAreaFilled(false);
		ButtonSearch.setBounds(435, 11, 42, 42);
		add(ButtonSearch);
		
		textField = new JTextField();
		textField.setForeground(new Color(255, 213, 0));
		textField.setBackground(new Color(0, 80, 157));
		textField.setBorder(null);
		textField.setBounds(10, 11, 415, 42);
		textField.setColumns(10);
		add(textField);
		
		JButton ButtonAggiungi = new JButton("");
		ButtonAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAggiungi.setOpaque(false);
		ButtonAggiungi.setBorder(null);
		ButtonAggiungi.setContentAreaFilled(false);
		ButtonAggiungi.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/IcoButtonAggiungi.png")));
		ButtonAggiungi.setBounds(690, 11, 50, 56);
		add(ButtonAggiungi);
	}

}
