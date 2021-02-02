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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Main.Controller;

import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;

public class ClientiPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private String Titoli[]= {"Nome", "Cognome", "Codice Fiscale", "Carta", "ID Carta","Punti"};
	private Object Elementi[][]= {};
	private boolean editable = false;
	public DefaultTableModel model = new DefaultTableModel(Elementi, Titoli) {
		
		private static final long serialVersionUID = 1L;

			@Override
			   public boolean isCellEditable(int row, int column) {
				
				return editable;
			   }
	};
			
	private JTable table;
	private JTextField textFieldSearch;

	public ClientiPanel(Controller ctrl) {
		
		setOpaque(false);
		setBackground(Color.BLACK);
		setBounds(0, 0, 754, 553);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(20,69,123),  new Color(20,69,123)));
		scrollPane.getViewport().setBackground(new Color(191, 215, 255));
		scrollPane.setOpaque(false);
		scrollPane.setBounds(55, 88, 630, 419);
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
                    case 5:
                    	return Integer.class;
                }
				return null;
            }
        };
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSelectionBackground(new Color(0, 41, 82));
		table.setSelectionForeground(new Color(191, 215, 255));
		table.setAutoCreateRowSorter(true);
		/*Metodo per ordinare per colonna*/
		table.setFont(new Font("Impact", Font.PLAIN, 13));
		table.setForeground(new Color(0,41,82));
		table.setOpaque(false);
		table.setShowGrid(false);
		table.setBackground(new Color(191, 215, 255));
		table.setBounds(302, 183, 150, 150);
		scrollPane.setViewportView(table);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setBackground(new Color(191, 215, 255));
		table.getTableHeader().setForeground(new Color(0,41,82));
		table.getTableHeader().setFont(new Font("Impact", Font.PLAIN, 15));
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getDefaultRenderer(Object.class);
	    renderer.setHorizontalAlignment( SwingConstants.CENTER );
		model.addRow(new Object[] {"Giovanni", "Erricis", "RRCVNI99B11F839C", false,1, 110});
		model.addRow(new Object[] {"Carlo", "Spazio", "CRVNNWEPB387VISV", true,2, 0});
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(sorter);
		List<RowSorter.SortKey> sortKeys = new ArrayList<>(); 
		sorter.setSortKeys(sortKeys);sorter.sort();
		sorter.setSortable(2, false);
		sorter.setSortable(3, false);
	
		JButton ButtonSearch = new JButton("");
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
		ButtonSearch.setIcon(new ImageIcon(ClientiPanel.class.getResource("/scrimg/ButtonSearch.png")));
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
		textFieldSearch.setFont(new Font("Impact", Font.PLAIN, 20));
		textFieldSearch.setForeground(new Color(191, 215, 255));
		textFieldSearch.setOpaque(false);
		textFieldSearch.setBorder(null);
		textFieldSearch.setBounds(85, 28, 276, 34);
		textFieldSearch.setCaretColor(new Color(191, 215, 255));
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
				ctrl.ApriAggiungiClientiDialog(ctrl);
			}
		});
		ButtonAggiungi.setBorder(null);
		ButtonAggiungi.setContentAreaFilled(false);
		ButtonAggiungi.setIcon(new ImageIcon(ClientiPanel.class.getResource("/scrimg/ButtonAggiungi.png")));
		ButtonAggiungi.setBounds(450, 55, 90, 22);
		add(ButtonAggiungi);
		
		JButton ButtonModifica = new JButton("");
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
		ButtonModifica.setBounds(550, 28, 90, 22);
		ButtonModifica.setIcon(new ImageIcon(ClientiPanel.class.getResource("/scrimg/ButtonModifica.png")));
		ButtonModifica.setOpaque(false);
		ButtonModifica.setBorder(null);
		ButtonModifica.setContentAreaFilled(false);
		add(ButtonModifica);
		
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
		ButtonStampa.setPressedIcon(new ImageIcon(ClientiPanel.class.getResource("/scrimg/ButtonStampa.png")));
		ButtonStampa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.StampaListaProdotti(table, "clienti");
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
		
		JLabel LabelSfondo = new JLabel("New label");
		LabelSfondo.setIcon(new ImageIcon(ClientiPanel.class.getResource("/scrimg/SfondoPanel.png")));
		LabelSfondo.setBounds(0, 0, 748, 552);
		add(LabelSfondo);
	}
}
