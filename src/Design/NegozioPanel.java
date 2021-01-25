package Design;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import main.Controller;

import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.DebugGraphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NegozioPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private String Titoli[]= {"Tipologia","Nome", "Codice", "Prezzo", "Quantità","Data acquisto"};
	private Object Elementi[][]= {};
	public DefaultTableModel model = new DefaultTableModel(Elementi, Titoli) {
		private static final long serialVersionUID = 1L;

		@Override
		public boolean isCellEditable(int row, int column) {
			//Only the third column
			return false;
		}
	};
	private JTable table;
	private JTextField textFieldSearch;

	public NegozioPanel(Controller ctrl) {
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
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoCreateRowSorter(true);
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
		model.addRow(new Object[] {"Ortofrutta","Mela", "001", "0.5", "2", "10/01/2021"});
		model.addRow(new Object[] {"Ortofrutta","PERA", "002", "1.0", "1", "15/12/2021"});
		model.addRow(new Object[] {"Ortofrutta","BANANA", "003", "1.5", "4", "05/8/2021"});
		model.addRow(new Object[] {"Confezionati","CAFFE", "004", "4.0", "3", "03/6/2021"});

		TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);

		JButton ButtonSearch = new JButton("");
		ButtonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(textFieldSearch.getText());
				String text = textFieldSearch.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}
		});
		ButtonSearch.setSelectedIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonSearchYellow.png")));
		ButtonSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonSearch.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonSearch.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonSearch.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonSearchYellow.png")));
			}
		});
		ButtonSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonSearch.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonSearchYellow.png")));
		ButtonSearch.setOpaque(false);
		ButtonSearch.setBorder(null);
		ButtonSearch.setContentAreaFilled(false);
		ButtonSearch.setBounds(435, 11, 42, 42);
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
		textFieldSearch.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 213, 0), new Color(255, 213, 0)));
		textFieldSearch.setFont(new Font("Impact", Font.PLAIN, 20));
		textFieldSearch.setForeground(new Color(255, 213, 0));
		textFieldSearch.setBackground(new Color(0, 80, 157));
		textFieldSearch.setBounds(10, 11, 415, 42);
		textFieldSearch.setCaretColor(new Color(255, 213, 0));
		textFieldSearch.setColumns(10);
		add(textFieldSearch);


		JButton ButtonAggiungi = new JButton("");
		ButtonAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonAggiungi.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonAggiungi2Yellow.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonAggiungi.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonAggiungi2.png")));
			}
		});
		ButtonAggiungi.setPressedIcon(new ImageIcon(NegozioPanel.class.getResource("/scrimg/ButtonAggiungi2Yellow.png")));
		ButtonAggiungi.setOpaque(false);
		ButtonAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriAggiungiAlNegozioDialog(ctrl);
			}
		});
		ButtonAggiungi.setBorder(null);
		ButtonAggiungi.setContentAreaFilled(false);
		ButtonAggiungi.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonAggiungi2.png")));
		ButtonAggiungi.setBounds(539, 42, 105, 25);
		add(ButtonAggiungi);

		JButton ButtonStampa = new JButton("");
		ButtonStampa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonStampa.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonStampaYellow.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonStampa.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonStampa.png")));
			}
		});
		ButtonStampa.setPressedIcon(new ImageIcon(NegozioPanel.class.getResource("/scrimg/ButtonStampaYellow.png")));
		ButtonStampa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.StampaListaProdotti(table, "negozio");
			}
		});
		ButtonStampa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonStampa.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonStampa.png")));
		ButtonStampa.setBounds(539, 11, 105, 25);
		ButtonStampa.setOpaque(false);
		ButtonStampa.setBorder(null);
		ButtonStampa.setContentAreaFilled(false);
		add(ButtonStampa);

		JButton ButtonSposta = new JButton("");
		ButtonSposta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonSposta.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonEliminaYellow.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonSposta.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonElimina.png")));
			}
		});
		ButtonSposta.setPressedIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonElimina.png")));
		ButtonSposta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					model.removeRow(table.getSelectedRow());
					JOptionPane.showMessageDialog(null, "PRODOTTO SPOSTANTO IN DEPOSITO", "", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "SELEZIONARE PRIMA UNA RIGA", "", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		ButtonSposta.setBounds(651, 11, 105, 25);
		ButtonSposta.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonElimina.png")));
		ButtonSposta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonSposta.setOpaque(false);
		ButtonSposta.setBorder(null);
		ButtonSposta.setContentAreaFilled(false);
		add(ButtonSposta);
	}
}
