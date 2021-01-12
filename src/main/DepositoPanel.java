package main;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;

public class DepositoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private String Titoli[]= {"Nome", "Codice", "Prezzo", "Quantità","Data acquisto"};
	private String Elementi[][]= {};
	public DefaultTableModel model = new DefaultTableModel(Elementi, Titoli);
	private JTable table;
	private JTextField textField;

	public DepositoPanel(Controller ctrl) {
		setVisible(false);
		setBounds(386, 0, 765, 600);
		setOpaque(false);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 745, 511);
		add(scrollPane);
		
		table = new JTable(model);
		table.setBackground(Color.BLUE);
		table.setBounds(302, 183, 150, 150);
		scrollPane.setViewportView(table);
		model.addRow(new Object[] {"Mela", "001", "0.5", "2", "10/01/2021"});
	
		
		
		JButton ButtonSearch = new JButton("");
		ButtonSearch.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonSearch.png")));
		ButtonSearch.setOpaque(false);
		ButtonSearch.setContentAreaFilled(false);
		ButtonSearch.setBounds(498, 11, 42, 42);
		add(ButtonSearch);
		
		textField = new JTextField();
		textField.setForeground(new Color(255, 213, 0));
		textField.setBackground(new Color(0, 80, 157));
		textField.setBounds(133, 11, 350, 42);
		textField.setColumns(10);
		add(textField);
		
		
		
	
		
	}
}
