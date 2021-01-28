package Design;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import main.Controller;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import javax.swing.JLabel;

public class DepositoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private String Titoli[]= {"Tipologia","Nome", "Codice", "Prezzo", "Quantità","Data acquisto"};
	private Object Elementi[][]= {};
	public DefaultTableModel model = new DefaultTableModel(Elementi, Titoli) {
		
		private static final long serialVersionUID = 1L;

			@Override
			   public boolean isCellEditable(int row, int column) {
			       return false;
			   }
			};
			
	private JTable table;
	private JTextField textFieldSearch;

	public DepositoPanel(Controller ctrl) {
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setOpaque(false);
		setBackground(Color.BLACK);
		setBounds(0, 0, 754, 553);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(20,69,123),  new Color(20,69,123)));
		scrollPane.getViewport().setBackground(new Color(191, 215, 255, 230));
		scrollPane.getViewport().setOpaque(true);
		scrollPane.setOpaque(false);
		scrollPane.setBounds(55, 88, 630, 419);
		add(scrollPane);
		
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoCreateRowSorter(true);
		table.setFont(new Font("Impact", Font.PLAIN, 13));
		table.setForeground(new Color(0,41,82));
		table.setShowGrid(false);
		table.setOpaque(false);
		table.setBackground(new Color(191, 215, 255, 0));
		table.setBounds(302, 183, 150, 150);
		scrollPane.setViewportView(table);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setBackground(new Color(191, 215, 255));
		table.getTableHeader().setForeground(new Color(0,41,82));
		table.getTableHeader().setFont(new Font("Impact", Font.PLAIN, 15));
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getDefaultRenderer(Object.class);
	    renderer.setHorizontalAlignment( SwingConstants.CENTER );
		model.addRow(new Object[] {"Ortofrutta","MELA", "001", "0.5", "2", "10/01/2021"});
		model.addRow(new Object[] {"Ortofrutta","PERA", "002", "1.0", "1", "15/12/2021"});
		model.addRow(new Object[] {"Ortofrutta","BANANA", "003", "1.5", "4", "05/8/2021"});
		model.addRow(new Object[] {"Confezionati","CAFFE", "004", "4.0", "3", "03/6/2021"});
		model.addRow(new Object[] {"Latticini","MOZZARELLA", "005", "10.0", "4", "10/6/2021"});
		model.addRow(new Object[] {"Latticini","RICOTTA", "006", "5.0", "1", "18/6/2021"});
		
		TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);
	
		JButton ButtonSearch = new JButton("");
		ButtonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textFieldSearch.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}
		});
		ButtonSearch.setSelectedIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonSearch.png")));
		ButtonSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonSearch.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonSearchAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonSearch.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonSearch.png")));
			}
		});
		ButtonSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonSearch.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonSearch.png")));
		ButtonSearch.setOpaque(false);
		ButtonSearch.setBorder(null);
		ButtonSearch.setContentAreaFilled(false);
		ButtonSearch.setBounds(379, 28, 34, 34);
		add(ButtonSearch);
		
		textFieldSearch = new JTextField();
		textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					String text = textFieldSearch.getText();
					if (text.trim().length() == 0) {
						rowSorter.setRowFilter(null);
					} else {
						rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
					} 
				}
			}
		});
		textFieldSearch.setFont(new Font("Impact", Font.PLAIN, 20));
		textFieldSearch.setForeground(new Color(191, 215, 255));
		textFieldSearch.setOpaque(false);
		textFieldSearch.setBorder(null);
		textFieldSearch.setBounds(78, 28, 291, 34);
		textFieldSearch.setCaretColor(new Color(0, 41, 82));
		textFieldSearch.setColumns(10);
		add(textFieldSearch);
		
		JButton ButtonAggiungi = new JButton("");
		ButtonAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonAggiungi.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonAggiungiAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonAggiungi.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonAggiungi.png")));
			}
		});
		ButtonAggiungi.setPressedIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonAggiungi.png")));
		ButtonAggiungi.setOpaque(false);
		ButtonAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriAggiungiAlDepositoDialog(ctrl);
			}
		});
		ButtonAggiungi.setBorder(null);
		ButtonAggiungi.setContentAreaFilled(false);
		ButtonAggiungi.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonAggiungi.png")));
		ButtonAggiungi.setBounds(450, 55, 90, 22);
		add(ButtonAggiungi);
		
		JButton ButtonStampa = new JButton("");
		ButtonStampa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonStampa.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonStampaAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonStampa.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonStampa.png")));
			}
		});
		ButtonStampa.setPressedIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonStampa.png")));
		ButtonStampa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.StampaListaProdotti(table, "deposito");
			}
		});
		ButtonStampa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonStampa.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonStampa.png")));
		ButtonStampa.setBounds(450, 28, 90, 22);
		ButtonStampa.setOpaque(false);
		ButtonStampa.setBorder(null);
		ButtonStampa.setContentAreaFilled(false);
		add(ButtonStampa);
		
		JButton ButtonElimina = new JButton("");
		ButtonElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonElimina.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonEliminaAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonElimina.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonElimina.png")));
			}
		});
		ButtonElimina.setPressedIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonElimina.png")));
		ButtonElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					model.removeRow(table.getSelectedRow());
					JOptionPane.showMessageDialog(null, "RIGA ELIMINATA CORRETTAMENTE", "", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "SELEZIONARE PRIMA UNA RIGA", "", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		ButtonElimina.setBounds(550, 55, 90, 22);
		ButtonElimina.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonElimina.png")));
		ButtonElimina.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonElimina.setOpaque(false);
		ButtonElimina.setBorder(null);
		ButtonElimina.setContentAreaFilled(false);
		add(ButtonElimina);
		
		JLabel LabelSfondo = new JLabel("");
		LabelSfondo.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/SfondoPanel.png")));
		LabelSfondo.setBounds(0, 0, 748, 552);
		add(LabelSfondo);
	}
}
