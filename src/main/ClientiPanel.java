package main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class ClientiPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private String Titoli[]= {"Nome", "Cognome", "Codice Fiscale", "ID Carta","Punti"};
	private Object Elementi[][]= {};
	boolean editable = false;
	public DefaultTableModel model = new DefaultTableModel(Elementi, Titoli) {
		
		private static final long serialVersionUID = 1L;

			@Override
			   public boolean isCellEditable(int row, int column) {
				return editable;
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
		
		table = new JTable(model) {
            private static final long serialVersionUID = 1L;

            @Override
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return Boolean.class;
                    case 4:
                    	return Integer.class;
                }
				return null;
            }
        };
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Impact", Font.PLAIN, 13));
		table.setForeground(new Color(255, 213, 0));
		table.setOpaque(false);
		table.setBackground(new Color(0, 67, 137));
		table.setBounds(302, 183, 150, 150);
		scrollPane.setViewportView(table);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setBackground(new Color(0,67,137));
		table.getTableHeader().setForeground(new Color(255, 213, 0));
		table.getTableHeader().setFont(new Font("Impact", Font.PLAIN, 15));
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getDefaultRenderer(Object.class);
	    renderer.setHorizontalAlignment( SwingConstants.CENTER );
		model.addRow(new Object[] {"Giovanni", "Erricis", "RRCVNI99B11F839C", false, 110});
		model.addRow(new Object[] {"Carlo", "Spazio", "CRVNNWEPB387VISV", true, 0});
	
		JButton ButtonSearch = new JButton("");
		ButtonSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonSearch.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonSearch.png")));
		ButtonSearch.setOpaque(false);
		ButtonSearch.setBorder(null);
		ButtonSearch.setContentAreaFilled(false);
		ButtonSearch.setBounds(435, 11, 42, 42);
		add(ButtonSearch);
		
		JTextField textFieldSearch = new JTextField();
		textFieldSearch.setFont(new Font("Impact", Font.PLAIN, 20));
		textFieldSearch.setForeground(new Color(255, 213, 0));
		textFieldSearch.setBackground(new Color(0, 80, 157));
		textFieldSearch.setBorder(null);
		textFieldSearch.setBounds(10, 11, 415, 42);
		textFieldSearch.setCaretColor(new Color(255, 213, 0));
		textFieldSearch.setColumns(10);
		add(textFieldSearch);
		
		JButton ButtonAggiungi = new JButton("");
		ButtonAggiungi.setOpaque(false);
		ButtonAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriAggiungiClientiDialog(ctrl);
			}
		});
		ButtonAggiungi.setBorder(null);
		ButtonAggiungi.setContentAreaFilled(false);
		ButtonAggiungi.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonAggiungi2.png")));
		ButtonAggiungi.setBounds(539, 42, 105, 25);
		add(ButtonAggiungi);
		
		JButton ButtonModifica = new JButton("");
		ButtonModifica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(editable==false) {
					editable=true;
					JOptionPane.showMessageDialog(null, "LA TABELLA È ORA MODIFICABILE", "", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					editable=false;
					JOptionPane.showMessageDialog(null, "LA TABELLA NON È MODIFICABILE", "", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		ButtonModifica.setBounds(654, 42, 105, 25);
		ButtonModifica.setIcon(new ImageIcon(ClientiPanel.class.getResource("/scrimg/ButtonModifica.png")));
		ButtonModifica.setOpaque(false);
		ButtonModifica.setBorder(null);
		ButtonModifica.setContentAreaFilled(false);
		add(ButtonModifica);
		
		JButton ButtonStampa = new JButton("");
		ButtonStampa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.StampaListaProdotti(table, "clienti");
			}
		});
		ButtonStampa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonStampa.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonStampa.png")));
		ButtonStampa.setBounds(539, 11, 105, 25);
		ButtonStampa.setOpaque(false);
		ButtonStampa.setBorder(null);
		ButtonStampa.setContentAreaFilled(false);
		add(ButtonStampa);
	}
}
