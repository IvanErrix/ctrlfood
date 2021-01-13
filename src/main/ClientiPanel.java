package main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
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

	public ClientiPanel(Controller ctrl) {
		setOpaque(false);
		setBackground(Color.BLACK);
		setBounds(0, 0, 765, 600);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), null));
		scrollPane.getViewport().setBackground(new Color(0,67,137));
		scrollPane.setOpaque(false);
		scrollPane.setBounds(10, 78, 730, 470);
		add(scrollPane);
		
		table = new JTable(model);
		table.setForeground(new Color(255, 213, 0));
		table.setOpaque(false);
		table.setBackground(new Color(0, 67, 137));
		table.setBounds(302, 183, 150, 150);
		scrollPane.setViewportView(table);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setBackground(new Color(0,67,137));
		table.getTableHeader().setForeground(new Color(255, 213, 0));
		model.isCellEditable(0, 0);
		model.addRow(new Object[] {"Giovanni", "Erricis", "RRCVNI99B11F839C", "001", "110"});
	
		JButton ButtonSearch = new JButton("");
		ButtonSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonSearch.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonSearch.png")));
		ButtonSearch.setOpaque(false);
		ButtonSearch.setBorder(null);
		ButtonSearch.setContentAreaFilled(false);
		ButtonSearch.setBounds(435, 11, 42, 42);
		add(ButtonSearch);
		
		JTextField textFieldSearch = new JTextField();
		textFieldSearch.setForeground(new Color(255, 213, 0));
		textFieldSearch.setBackground(new Color(0, 80, 157));
		textFieldSearch.setBorder(null);
		textFieldSearch.setBounds(10, 11, 415, 42);
		textFieldSearch.setCaretColor(new Color(255, 213, 0));
		textFieldSearch.setColumns(10);
		add(textFieldSearch);
		
		JButton ButtonAggiungi = new JButton("");
		ButtonAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriAggiungiClientiDialog(ctrl);
			}
		});
		ButtonAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAggiungi.setOpaque(false);
		ButtonAggiungi.setBorder(null);
		ButtonAggiungi.setContentAreaFilled(false);
		ButtonAggiungi.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/IcoButtonAggiungi.png")));
		ButtonAggiungi.setBounds(690, 11, 50, 56);
		add(ButtonAggiungi);
	}

}
