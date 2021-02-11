package Design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.accessibility.AccessibleContext;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboPopup;

import ExternalClasses.ContentPane;
import ExternalClasses.RoundedCornerBorder;
import Main.Controller;
import Objects.Cliente;

import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ModificaClienteDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Cliente> clienti;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNome;
	private JTextField textFieldCognome;
	private JTextField textFieldCodiceFiscale;
	private JComboBox comboBoxCliente;

	public ModificaClienteDialog(Controller ctrl) {
		setUndecorated(true);
		setSize(453, 364);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		getContentPane().setLayout(null);
		ContentPane contentPane = new ContentPane();
		setContentPane(contentPane);
		getContentPane().isOpaque();
		setBackground(new Color(0, 67, 137, 0));
		contentPane.setLayout(null);
		
		JButton ButtonAnnulla = new JButton("Annulla");
		ButtonAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		ButtonAnnulla.setBounds(105, 270, 89, 23);
		contentPane.add(ButtonAnnulla);
		
		JButton ButtonAggiorna = new JButton("Aggiorna");
		ButtonAggiorna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valore = comboBoxCliente.getSelectedItem().toString();
				valore = valore.replaceAll("\\s+","");
				String[] parts = valore.split("-");
				String part1 = parts[0];
				if (textFieldNome.getText().length()!=0 && textFieldCognome.getText().length()!=0 && textFieldCodiceFiscale.getText().length()!=0 && textFieldCodiceFiscale.getText().length()==16) {
					setAlwaysOnTop(false);
					ctrl.AggiornaDatiCliente(Integer.parseInt(part1), textFieldNome.getText(), textFieldCognome.getText(), textFieldCodiceFiscale.getText());
					JOptionPane.showMessageDialog(null, "DATI AGGIORNATI", "", JOptionPane.INFORMATION_MESSAGE);
					setAlwaysOnTop(true);
					CaricaClienti(ctrl);
					CaricaTextFields(ctrl);
				}
				else {
					setAlwaysOnTop(false);
					JOptionPane.showMessageDialog(null, "INSERIRE VALORI CORRETTI", "", JOptionPane.WARNING_MESSAGE);
					setAlwaysOnTop(true);
				}
			}
		});
		ButtonAggiorna.setBounds(270, 271, 89, 23);
		contentPane.add(ButtonAggiorna);
		
		textFieldCodiceFiscale = new JTextField();
		textFieldCodiceFiscale.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				textFieldCodiceFiscale.setText(textFieldCodiceFiscale.getText().toUpperCase());
			}
		});
		textFieldCodiceFiscale.setBounds(153, 199, 234, 20);
		contentPane.add(textFieldCodiceFiscale);
		textFieldCodiceFiscale.setColumns(10);
		
		textFieldCognome = new JTextField();
		textFieldCognome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				textFieldCognome.setText(textFieldCognome.getText().toUpperCase());
			}
		});
		textFieldCognome.setBounds(154, 146, 231, 20);
		contentPane.add(textFieldCognome);
		textFieldCognome.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				textFieldNome.setText(textFieldNome.getText().toUpperCase());
			}
		});
		textFieldNome.setBounds(150, 97, 234, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		comboBoxCliente = new JComboBox();
		comboBoxCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CaricaTextFields(ctrl);
			}
		});
		comboBoxCliente.setBounds(151, 48, 233, 22);
		contentPane.add(comboBoxCliente);
		
		JLabel LabelCodiceFiscale = new JLabel("Codice Fiscale");
		LabelCodiceFiscale.setBounds(42, 197, 67, 24);
		contentPane.add(LabelCodiceFiscale);
		
		JLabel LabelCognome = new JLabel("Cognome");
		LabelCognome.setBounds(41, 142, 62, 29);
		contentPane.add(LabelCognome);
		
		JLabel LabelNome = new JLabel("Nome");
		LabelNome.setBounds(42, 96, 57, 22);
		contentPane.add(LabelNome);
		
		JLabel LabelCliente = new JLabel("Cliente");
		LabelCliente.setBounds(41, 46, 62, 26);
		contentPane.add(LabelCliente);
		
		JLabel LabelSfondo = new JLabel("");
		LabelSfondo.setIcon(new ImageIcon(AggiungiAlNegozioDialog.class.getResource("/scrimg/SfondoAggiungiAlnegozio.png")));
		LabelSfondo.setBounds(-8, -8, 467, 376);
		getContentPane().add(LabelSfondo);
		
		CaricaClienti(ctrl);
		CaricaTextFields(ctrl);
	}
	
	public void CaricaClienti(Controller ctrl) {
		clienti=ctrl.CaricaClienti();
		comboBoxCliente.removeAllItems();
		
		for(int i=0; i<clienti.size(); i++) {
			comboBoxCliente.addItem(clienti.get(i).getIdcliente()+" - "+clienti.get(i).getNome()+" - "+clienti.get(i).getCognome());
		}
	}
	
	public void CaricaTextFields(Controller ctrl) {
		clienti=ctrl.CaricaClienti();
		if (comboBoxCliente.getSelectedItem()!=null) {
			for (int i = 0; i < clienti.size(); i++) {
				String valore = comboBoxCliente.getSelectedItem().toString();
				valore = valore.replaceAll("\\s+","");
				String[] parts = valore.split("-");
				String part1 = parts[0];
				if(part1.equals(Integer.toString(clienti.get(i).getIdcliente()))) {
					textFieldNome.setText(clienti.get(i).getNome());
					textFieldCognome.setText(clienti.get(i).getCognome());
					textFieldCodiceFiscale.setText(clienti.get(i).getCodice_fiscale());
				}
			} 
		}
		else {
			textFieldNome.setText("");
			textFieldCognome.setText("");
			textFieldCodiceFiscale.setText("");
		}
	}
}
