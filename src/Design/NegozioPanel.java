package Design;

import java.awt.Color;
import java.awt.Cursor;
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
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import ExternalClasses.HorizontalScrollBarUI;
import ExternalClasses.RoundedCornerBorder;
import ExternalClasses.VerticalScrollBarUI;
import Main.Controller;
import Objects.Prodotto;

import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;

public class NegozioPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private ArrayList<Prodotto> prodotti;
	private String Titoli[]= {"Tipologia","IDProdotto", "Nome", "Prezzo", "Quantità","Scadenza", "Raccolta", "Produzione", "Mungitura", "Deposizione", "Confezionamento"};
	private DefaultTableModel model = new DefaultTableModel(Titoli, 0) {
	private static final long serialVersionUID = 1L;
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	private JScrollPane scrollPane;
	private JTable table;
	private JButton ButtonSearch;
	private JButton ButtonRefresh;
	private JButton ButtonAggiungi;
	private JButton ButtonStampa;
	private JButton ButtonSposta;
	private JTextField textFieldSearch;
	private JLabel LabelSfondo;

	public NegozioPanel(Controller ctrl) {
		setOpaque(false);
		setBackground(Color.BLACK);
		setBounds(77, 0, 836, 569);
		setLayout(null);

		/*SCROLLPANE*/
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0,41,82),  new Color(0,41,82)));
		scrollPane.getHorizontalScrollBar().setUI(new HorizontalScrollBarUI());
		scrollPane.getVerticalScrollBar().setUI(new VerticalScrollBarUI());
		scrollPane.getViewport().setBackground(new Color(191,215,255));
		scrollPane.setOpaque(false);
		scrollPane.setBounds(43, 88, 747, 432);
		add(scrollPane);

		/*TABLE*/
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSelectionBackground(new Color(0, 41, 82));
		table.setSelectionForeground(new Color(191, 215, 255));
		table.setAutoCreateRowSorter(true);
		table.setFont(new Font("Cambria", Font.PLAIN, 13));
		table.setForeground(new Color(0, 41, 82));
		table.setOpaque(false);
		table.setShowGrid(false);
		table.setBackground(new Color(191, 215, 255));
		table.setBounds(302, 183, 150, 150);
		scrollPane.setViewportView(table);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setBackground(new Color(191,215,255));
		table.getTableHeader().setForeground(new Color(0, 41, 82));
		table.getTableHeader().setFont(new Font("Cambria", Font.BOLD, 15));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableColumn column = null;
		for (int i = 0; i < 11; i++) {
		    column = table.getColumnModel().getColumn(i);
		    column.setPreferredWidth(110);
		}
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
		ButtonSearch.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonSearch.png")));
		ButtonSearch.setSelectedIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonSearch.png")));
		ButtonSearch.setOpaque(false);
		ButtonSearch.setBorder(null);
		ButtonSearch.setContentAreaFilled(false);
		ButtonSearch.setBounds(379, 28, 34, 34);
		add(ButtonSearch);
		
		/*BUTTON REFRESH*/
		ButtonRefresh = new JButton("");
		ButtonRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CaricaProdottiNegozio(ctrl);
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
				ctrl.ApriAggiungiAlNegozioDialog(ctrl);
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
		ButtonAggiungi.setPressedIcon(new ImageIcon(NegozioPanel.class.getResource("/scrimg/ButtonAggiungi.png")));
		ButtonAggiungi.setOpaque(false);
		ButtonAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAggiungi.setBorder(null);
		ButtonAggiungi.setContentAreaFilled(false);
		ButtonAggiungi.setIcon(new ImageIcon(NegozioPanel.class.getResource("/scrimg/ButtonAggiungi.png")));
		ButtonAggiungi.setBounds(500, 40, 90, 22);
		add(ButtonAggiungi);

		/*BUTTON STAMPA*/
		ButtonStampa = new JButton("");
		ButtonStampa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.StampaListaProdotti(table, "negozio");
			}
		});
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
		ButtonStampa.setPressedIcon(new ImageIcon(NegozioPanel.class.getResource("/scrimg/ButtonStampa.png")));
		ButtonStampa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonStampa.setIcon(new ImageIcon(NegozioPanel.class.getResource("/scrimg/ButtonStampa.png")));
		ButtonStampa.setBounds(700, 40, 90, 22);
		ButtonStampa.setOpaque(false);
		ButtonStampa.setBorder(null);
		ButtonStampa.setContentAreaFilled(false);
		add(ButtonStampa);

		/*BUTTON STAMPA*/
		ButtonSposta = new JButton("");
		ButtonSposta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectionModel().isSelectionEmpty() == false) {
					ctrl.SpostaProdotto(Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 1).toString()));
					JOptionPane.showMessageDialog(null, "PRODOTTO SPOSTATO IN DEPOSITO", "", JOptionPane.INFORMATION_MESSAGE);
					CaricaProdottiNegozio(ctrl);
				}
				else{
					JOptionPane.showMessageDialog(null, "SELEZIONARE PRIMA UNA RIGA", "", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		ButtonSposta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonSposta.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonSpostaAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonSposta.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonSposta.png")));
			}
		});
		ButtonSposta.setPressedIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonSposta.png")));
		ButtonSposta.setBounds(600, 40, 90, 22);
		ButtonSposta.setIcon(new ImageIcon(NegozioPanel.class.getResource("/scrimg/ButtonSposta.png")));
		ButtonSposta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonSposta.setOpaque(false);
		ButtonSposta.setBorder(null);
		ButtonSposta.setContentAreaFilled(false);
		add(ButtonSposta);
		
		/*LABEL SFONDO*/
		LabelSfondo = new JLabel("");
		LabelSfondo.setIcon(new ImageIcon(NegozioPanel.class.getResource("/scrimg/SfondoPanel.png")));
		LabelSfondo.setBounds(-2, -2, 836, 569);
		add(LabelSfondo);
		
		CaricaProdottiNegozio(ctrl);
	}
	
	private void CaricaProdottiNegozio(Controller ctrl) {
		model.setRowCount(0);
		prodotti=ctrl.CaricaProdottiNegozio();
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
			if((prodotti.get(i).getOrtofrutta())==true) {
				model.addRow(new Object[] {"ORTOFRUTTA", id, nome, prezzo+" €", quantita, scadenza, raccolta, produzione, mungitura, deposizione, confezionamento});
			}
			else if((prodotti.get(i).getLatticino())==true) {
				model.addRow(new Object[] {"LATTICINI", id, nome, prezzo+" €", quantita, scadenza, raccolta, produzione, mungitura, deposizione, confezionamento});
			}
			else if((prodotti.get(i).getFarinaceo())==true) {
				model.addRow(new Object[] {"FARINACEI", id, nome, prezzo+" €", quantita, scadenza, raccolta, produzione, mungitura, deposizione, confezionamento});
			}
			else if((prodotti.get(i).getUova())==true) {
				model.addRow(new Object[] {"UOVA", id, nome, prezzo+" €", quantita, scadenza, raccolta, produzione, mungitura, deposizione, confezionamento});
			}
			else if((prodotti.get(i).getConfezionato())==true) {
				model.addRow(new Object[] {"CONFEZIONATI", id, nome, prezzo+" €", quantita, scadenza, raccolta, produzione, mungitura, deposizione, confezionamento});
			}
			 
		}
	}
}
