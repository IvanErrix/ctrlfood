package Design;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

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
import Objects.CartaFedelta;
import Objects.Cliente;

import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;

public class ClientiPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Cliente> clienti;
	private ArrayList<CartaFedelta> carte;
	private String Titoli[]= {"IDCliente", "Nome", "Cognome", "Codice Fiscale", "ID Carta", "Punti Ortofrutta", "Punti Latticini", "Punti Farinacei", "Punti Uova", "Punti Confezionati", "Punti Totali"};
	private DefaultTableModel model = new DefaultTableModel(Titoli, 0) {
		
		private static final long serialVersionUID = 1L;

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField textFieldSearch;
	private JButton ButtonSearch;
	private JButton ButtonRefresh;
	private JButton ButtonAggiungi;
	private JButton ButtonModifica;
	private JButton ButtonStampa;
	private JButton ButtonElimina;
	private JLabel LabelSfondo;
	

	public ClientiPanel(Controller ctrl) {
		
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
		scrollPane.getViewport().setBackground(new Color(191, 215, 255));
		scrollPane.setOpaque(false);
		scrollPane.setBounds(43, 88, 747, 432);
		add(scrollPane);
		
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSelectionBackground(new Color(0, 41, 82));
		table.setSelectionForeground(new Color(191, 215, 255));
		table.setAutoCreateRowSorter(true);
		/*Metodo per ordinare per colonna*/
		table.setFont(new Font("Cambria", Font.PLAIN, 13));
		table.setForeground(new Color(0,41,82));
		table.setOpaque(false);
		table.setShowGrid(false);
		table.setBackground(new Color(191, 215, 255));
		table.setBounds(302, 183, 150, 150);
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableColumn column = null;
		for (int i = 0; i < 11; i++) {
		    column = table.getColumnModel().getColumn(i);
		    column.setPreferredWidth(130);
		}
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setBackground(new Color(191, 215, 255));
		table.getTableHeader().setForeground(new Color(0,41,82));
		table.getTableHeader().setFont(new Font("Cambria", Font.BOLD, 15));
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getDefaultRenderer(Object.class);
	    renderer.setHorizontalAlignment( SwingConstants.CENTER );
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(sorter);
		List<RowSorter.SortKey> sortKeys = new ArrayList<>(); 
		sorter.setSortKeys(sortKeys);sorter.sort();
		sorter.setSortable(2, false);
		sorter.setSortable(3, false);
		
		/*TEXTFIELD SEARCH*/
		textFieldSearch = new JTextField();
		textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					String text = textFieldSearch.getText();
					if (text.trim().length() == 0) {
						sorter.setRowFilter(null);
					} else {
						sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
					} 
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
				if (textFieldSearch.getText().length()>=25) {
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
	
		/*BUTTON SEARCH*/
		ButtonSearch = new JButton("");
		ButtonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textFieldSearch.getText();
				if (text.trim().length() == 0) {
					sorter.setRowFilter(null);
				} else {
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
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
		ButtonSearch.setIcon(new ImageIcon(ClientiPanel.class.getResource("/scrimg/ButtonSearch.png")));
		ButtonSearch.setOpaque(false);
		ButtonSearch.setBorder(null);
		ButtonSearch.setContentAreaFilled(false);
		ButtonSearch.setBounds(379, 28, 34, 34);
		add(ButtonSearch);
		
		/*BUTTON REFRESH*/
		ButtonRefresh = new JButton("");
		ButtonRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CaricaClientiInTabella(ctrl);
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
		
		/*BUTTON AGGIUNGI*/
		ButtonAggiungi = new JButton("");
		ButtonAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriAggiungiClientiDialog(ctrl);
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
		ButtonAggiungi.setPressedIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonAggiungi.png")));
		ButtonAggiungi.setOpaque(false);
		ButtonAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAggiungi.setBorder(null);
		ButtonAggiungi.setContentAreaFilled(false);
		ButtonAggiungi.setIcon(new ImageIcon(ClientiPanel.class.getResource("/scrimg/ButtonAggiungi.png")));
		ButtonAggiungi.setBounds(495, 55, 90, 22);
		add(ButtonAggiungi);
		
		/*BUTTON MODIFICA*/
		ButtonModifica = new JButton("");
		ButtonModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.ApriModificaClienteDialog(ctrl);
			}
		});
		ButtonModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonModifica.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonModificaAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonModifica.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonModifica.png")));
			}
		});
		ButtonModifica.setPressedIcon(new ImageIcon(ClientiPanel.class.getResource("/scrimg/ButtonModifica.png")));
		ButtonModifica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonModifica.setBounds(495, 26, 90, 22);
		ButtonModifica.setIcon(new ImageIcon(ClientiPanel.class.getResource("/scrimg/ButtonModifica.png")));
		ButtonModifica.setOpaque(false);
		ButtonModifica.setBorder(null);
		ButtonModifica.setContentAreaFilled(false);
		add(ButtonModifica);
		
		/*BUTTON STAMPA*/
		ButtonStampa = new JButton("");
		ButtonStampa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.StampaListaProdotti(table, "clienti");
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
		ButtonStampa.setPressedIcon(new ImageIcon(ClientiPanel.class.getResource("/scrimg/ButtonStampa.png")));
		ButtonStampa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonStampa.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonStampa.png")));
		ButtonStampa.setBounds(700, 55, 90, 22);
		ButtonStampa.setOpaque(false);
		ButtonStampa.setBorder(null);
		ButtonStampa.setContentAreaFilled(false);
		add(ButtonStampa);
		
		/*BUTTON ELIMINA*/
		ButtonElimina = new JButton("");
		ButtonElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ctrl.EliminaCliente(Integer.parseInt(model.getValueAt(table.getSelectedRow(), 0).toString()));
					JOptionPane.showMessageDialog(null, "CLIENTE ELIMINATO", "", JOptionPane.INFORMATION_MESSAGE);
					CaricaClientiInTabella(ctrl);
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
		ButtonElimina.setBounds(595, 55, 90, 22);
		ButtonElimina.setIcon(new ImageIcon(DepositoPanel.class.getResource("/scrimg/ButtonElimina.png")));
		ButtonElimina.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonElimina.setOpaque(false);
		ButtonElimina.setBorder(null);
		ButtonElimina.setContentAreaFilled(false);
		add(ButtonElimina);
		
		/*LABEL SFONDO*/
		LabelSfondo = new JLabel("New label");
		LabelSfondo.setIcon(new ImageIcon(ClientiPanel.class.getResource("/scrimg/SfondoPanel.png")));
		LabelSfondo.setBounds(-2, -2, 836, 569);
		add(LabelSfondo);
		
		CaricaClientiInTabella(ctrl);
	}
	
	private void CaricaClientiInTabella(Controller ctrl) {
		model.setRowCount(0);
		clienti=ctrl.CaricaClienti();
		carte=ctrl.CaricaCartaFedelta();
		
		for(int i=0; i<clienti.size(); i++) {
			int id = clienti.get(i).getIdcliente();
			String nome = clienti.get(i).getNome();
			String cognome = clienti.get(i).getCognome();
			String codice_fiscale = clienti.get(i).getCodice_fiscale();
			int idcarta = carte.get(i).getIdcartafedelta();
			double punti = carte.get(i).getPunti();
			double punti_ortofrutta = carte.get(i).getPuntiortofrutta();
			double punti_latticini = carte.get(i).getPuntilatticini();
			double punti_farinacei = carte.get(i).getPuntifarinacei();
			double punti_uova = carte.get(i).getPuntiuova();
			double punti_confezionati = carte.get(i).getPunticonfezionati();
			
			
			model.addRow(new Object [] {id, nome, cognome, codice_fiscale, idcarta, punti_ortofrutta, punti_latticini, punti_farinacei, punti_uova, punti_confezionati, punti});
		}
		
	}
}
