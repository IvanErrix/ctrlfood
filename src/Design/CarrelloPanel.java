package Design;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;

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
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import ExternalClasses.RoundedCornerBorder;
import Main.Controller;
import Objects.Prodotto;

import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;

public class CarrelloPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private ArrayList<Prodotto> prodotti;
	private String Titoli[]= {"Tipologia","IDProdotto", "Nome", "Prezzo", "Quantità","Scadenza", "Raccolta", "Produzione", "Mungitura", "Deposizione", "Confezionamento"};
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
	private JButton ButtonSearch;
	private JButton ButtonRefresh;
	private JTextField textFieldSearch;
	private JButton ButtonAggiungi;
	private JButton ButtonElimina;
	private JLabel LabelSfondo;
	
	public CarrelloPanel(Controller ctrl) {

		setOpaque(false);
		setBackground(Color.BLACK);
		setBounds(77, 0, 836, 569);
		setLayout(null);
		
		/*SCROLLPANE*/
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(20,69,123),  new Color(20,69,123)));
		scrollPane.getViewport().setBackground(new Color(191, 215, 255));
		scrollPane.setOpaque(false);
		scrollPane.setBounds(43, 88, 747, 432);
		add(scrollPane);
		
		/*TABLE PRODOTTI*/
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSelectionBackground(new Color(0, 41, 82));
		table.setSelectionForeground(new Color(191, 215, 255));
		table.setFont(new Font("Cambria", Font.PLAIN, 13));
		table.setForeground(new Color(0,41,82));
		table.setOpaque(false);
		table.setShowGrid(false);
		table.setBackground(new Color(191, 215, 255));
		table.setBounds(302, 183, 150, 150);
		scrollPane.setViewportView(table);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setBackground(new Color(191, 215, 255));
		table.getTableHeader().setForeground(new Color(0,41,82));
		table.getTableHeader().setFont(new Font("Cambria", Font.BOLD, 15));
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getDefaultRenderer(Object.class);
	    renderer.setHorizontalAlignment( SwingConstants.CENTER );
		TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);
		
		/*BUTTON SEARCH*/
		ButtonSearch = new JButton("");
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
		ButtonSearch.setSelectedIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonSearch.png")));
		ButtonSearch.setIcon(new ImageIcon(CarrelloPanel.class.getResource("/scrimg/ButtonSearch.png")));
		ButtonSearch.setOpaque(false);
		ButtonSearch.setBorder(null);
		ButtonSearch.setContentAreaFilled(false);
		ButtonSearch.setBounds(379, 28, 34, 34);
		add(ButtonSearch);
		
		/*BUTTON REFRESH*/
		ButtonRefresh = new JButton("");
		ButtonRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CaricaProdottiCarrello(ctrl);
				
			}
		});
		ButtonRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonRefresh.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonRefreshAzzurro.png")));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonRefresh.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonRefresh.png")));

			}
		});
		ButtonRefresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonRefresh.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonRefresh.png")));
		ButtonRefresh.setPressedIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonRefresh.png")));
		ButtonRefresh.setOpaque(false);
		ButtonRefresh.setBorder(null);
		ButtonRefresh.setContentAreaFilled(false);
		ButtonRefresh.setBounds(423, 28, 34, 34);
		add(ButtonRefresh);
		
		/*TEXTFIELD SEARCH*/
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
			@Override
			public void keyTyped(KeyEvent e) {
				if (textFieldSearch.getText().length()>=25 ) {
					e.consume();
				}
			}
		});
		textFieldSearch.setFont(new Font("Cambria", Font.BOLD, 20));
		textFieldSearch.setForeground(new Color(0, 41, 82));
		textFieldSearch.setSelectedTextColor(new Color (191,215,255));
		textFieldSearch.setSelectionColor(new Color (0,41,82));
		textFieldSearch.setBorder(new RoundedCornerBorder());
		textFieldSearch.setOpaque(false);
		textFieldSearch.setBounds(43, 28, 326, 34);
		textFieldSearch.setCaretColor(new Color(0, 41, 82));
		textFieldSearch.setColumns(10);
		add(textFieldSearch);
		
		/*BUTTON AGGIUNGI*/
		ButtonAggiungi = new JButton("");
		ButtonAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriAggiungiAlCarrelloDialog(ctrl);
			}
		});
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
		ButtonAggiungi.setPressedIcon(new ImageIcon(CarrelloPanel.class.getResource("/scrimg/ButtonAggiungi.png")));
		ButtonAggiungi.setOpaque(false);
		ButtonAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAggiungi.setBorder(null);
		ButtonAggiungi.setContentAreaFilled(false);
		ButtonAggiungi.setIcon(new ImageIcon(CarrelloPanel.class.getResource("/scrimg/ButtonAggiungi.png")));
		ButtonAggiungi.setBounds(518, 40, 90, 22);
		add(ButtonAggiungi);
		
		/*BUTTON ELIMINA*/
		ButtonElimina = new JButton("");
		ButtonElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ctrl.EliminaProdottoCarrello(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 1).toString()));
					JOptionPane.showMessageDialog(null, "PRODOTTO ELIMINATO CORRETTAMENTE", "", JOptionPane.INFORMATION_MESSAGE);
					CaricaProdottiCarrello(ctrl);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "SELEZIONARE PRIMA UNA RIGA", "", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
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
		ButtonElimina.setBounds(618, 40, 90, 22);
		ButtonElimina.setIcon(new ImageIcon(CarrelloPanel.class.getResource("/scrimg/ButtonElimina.png")));
		ButtonElimina.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonElimina.setOpaque(false);
		ButtonElimina.setBorder(null);
		ButtonElimina.setContentAreaFilled(false);
		add(ButtonElimina);
		
		/*LABEL SFONDO*/
		LabelSfondo = new JLabel("New label");
		LabelSfondo.setIcon(new ImageIcon(CarrelloPanel.class.getResource("/scrimg/SfondoPanel.png")));
		LabelSfondo.setBounds(-2, -2, 836, 569);
		add(LabelSfondo);
		
		CaricaProdottiCarrello(ctrl);
	}
	public void CaricaProdottiCarrello(Controller ctrl) {
		model.setRowCount(0);
		prodotti=ctrl.CaricaProdottiCarrello();
		for(int i=0; i<prodotti.size(); i++) {
			 int id = prodotti.get(i).getIdprodotto();
			 String nome = prodotti.get(i).getNome();
			 double prezzo = prodotti.get(i).getPrezzo();
			 int quantita = prodotti.get(i).getQuantita();
			 Date scadenza = (Date) prodotti.get(i).getData_scadenza();
			 Date raccolta = (Date) prodotti.get(i).getData_raccolta();
			 Date produzione = (Date) prodotti.get(i).getData_produzione();
			 Date mungitura = (Date) prodotti.get(i).getData_mungitura();
			 Date deposizione = (Date) prodotti.get(i).getData_deposizione();
			 Date confezionamento = (Date) prodotti.get(i).getData_confezionamento();
			 Boolean valore;
			if((valore=prodotti.get(i).getOrtofrutta())==true) {
				model.addRow(new Object[] {"ORTOFRUTTA", id, nome, prezzo+" €", quantita, scadenza, raccolta, produzione, mungitura, deposizione, confezionamento});
			}
			else if((valore=prodotti.get(i).getLatticino())==true) {
				model.addRow(new Object[] {"LATTICINI", id, nome, prezzo+" €", quantita, scadenza, raccolta, produzione, mungitura, deposizione, confezionamento});
			}
			else if((valore=prodotti.get(i).getFarinaceo())==true) {
				model.addRow(new Object[] {"FARINACEI", id, nome, prezzo+" €", quantita, scadenza, raccolta, produzione, mungitura, deposizione, confezionamento});
			}
			else if((valore=prodotti.get(i).getUova())==true) {
				model.addRow(new Object[] {"UOVA", id, nome, prezzo+" €", quantita, scadenza, raccolta, produzione, mungitura, deposizione, confezionamento});
			}
			else if((valore=prodotti.get(i).getConfezionato())==true) {
				model.addRow(new Object[] {"CONFEZIONATI", id, nome, prezzo+" €", quantita, scadenza, raccolta, produzione, mungitura, deposizione, confezionamento});
			}
			 
		}
	}

}
