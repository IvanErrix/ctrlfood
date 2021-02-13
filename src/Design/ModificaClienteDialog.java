package Design;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import ExternalClasses.ContentPane;
import ExternalClasses.RoundedCornerBorder;
import Main.Controller;
import Objects.Cliente;

import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Cursor;

public class ModificaClienteDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Cliente> clienti;
	private ContentPane contentPane;
	private JButton ButtonAnnulla;
	private JButton ButtonAggiorna;
	private JTextField textFieldNome;
	private JTextField textFieldCognome;
	private JTextField textFieldCodiceFiscale;
	private JComboBox comboBoxCliente;
	private JLabel LabelCliente;
	private JLabel LabelNome;
	private JLabel LabelCognome;
	private JLabel LabelCodiceFiscale;
	private JLabel LabelSfondo;

	public ModificaClienteDialog(Controller ctrl) {
		setUndecorated(true);
		setSize(453, 364);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		getContentPane().setLayout(null);
		
		/*CONTENTPANE*/
		contentPane = new ContentPane();
		setContentPane(contentPane);
		getContentPane().isOpaque();
		setBackground(new Color(0, 67, 137, 0));
		contentPane.setLayout(null);
		
		/*BUTTON ANNULLA*/
		ButtonAnnulla = new JButton("");
		ButtonAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonAnnulla.setIcon(new ImageIcon(ModificaClienteDialog.class.getResource("/scrimg/ButtonAnnullaAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonAnnulla.setIcon(new ImageIcon(ModificaClienteDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
			}
		});
		ButtonAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		ButtonAnnulla.setPressedIcon(new ImageIcon(ModificaClienteDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
		ButtonAnnulla.setIcon(new ImageIcon(ModificaClienteDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
		ButtonAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAnnulla.setOpaque(false);
		ButtonAnnulla.setBorder(null);
		ButtonAnnulla.setContentAreaFilled(false);
		ButtonAnnulla.setBounds(41, 286, 110, 24);
		contentPane.add(ButtonAnnulla);
		
		/*BUTTON AGGIORNA*/
		ButtonAggiorna = new JButton("");
		ButtonAggiorna.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonAggiorna.setIcon(new ImageIcon(ModificaClienteDialog.class.getResource("/scrimg/ButtonAggiornaAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonAggiorna.setIcon(new ImageIcon(ModificaClienteDialog.class.getResource("/scrimg/ButtonAggiorna.png")));
			}
		});
		ButtonAggiorna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AggiornaInformazioniDialog(ctrl);
			}
		});
		ButtonAggiorna.setIcon(new ImageIcon(ModificaClienteDialog.class.getResource("/scrimg/ButtonAggiorna.png")));
		ButtonAggiorna.setPressedIcon(new ImageIcon(ModificaClienteDialog.class.getResource("/scrimg/ButtonAggiorna.png")));
		ButtonAggiorna.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonAggiorna.setOpaque(false);
		ButtonAggiorna.setBorder(null);
		ButtonAggiorna.setContentAreaFilled(false);
		ButtonAggiorna.setBounds(275, 286, 110, 24);
		contentPane.add(ButtonAggiorna);
		
		/*TEXTFIELD NOME*/
		textFieldNome = new JTextField();
		textFieldNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				textFieldNome.setText(textFieldNome.getText().toUpperCase());
			}
		});
		textFieldNome.setBounds(151, 97, 234, 20);
		textFieldNome.setBorder(new RoundedCornerBorder());
		textFieldNome.setOpaque(false);
		textFieldNome.setFont(new Font("Cambria", Font.BOLD, 15));
		textFieldNome.setForeground(new Color(0,41,82));
		textFieldNome.setSelectedTextColor(new Color (191,215,255));
		textFieldNome.setSelectionColor(new Color (0,41,82));
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		/*TEXTFIELD COGNOME*/
		textFieldCognome = new JTextField();
		textFieldCognome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				textFieldCognome.setText(textFieldCognome.getText().toUpperCase());
			}
		});
		textFieldCognome.setBounds(151, 146, 234, 20);
		textFieldCognome.setBorder(new RoundedCornerBorder());
		textFieldCognome.setOpaque(false);
		textFieldCognome.setFont(new Font("Cambria", Font.BOLD, 15));
		textFieldCognome.setForeground(new Color(0,41,82));
		textFieldCognome.setSelectedTextColor(new Color (191,215,255));
		textFieldCognome.setSelectionColor(new Color (0,41,82));
		contentPane.add(textFieldCognome);
		textFieldCognome.setColumns(10);
		
		/*TEXTFIELD COGNOME*/
		textFieldCodiceFiscale = new JTextField();
		textFieldCodiceFiscale.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				textFieldCodiceFiscale.setText(textFieldCodiceFiscale.getText().toUpperCase());
			}
		});
		textFieldCodiceFiscale.setBounds(151, 199, 234, 20);
		textFieldCodiceFiscale.setBorder(new RoundedCornerBorder());
		textFieldCodiceFiscale.setOpaque(false);
		textFieldCodiceFiscale.setFont(new Font("Cambria", Font.BOLD, 15));
		textFieldCodiceFiscale.setForeground(new Color(0,41,82));
		textFieldCodiceFiscale.setSelectedTextColor(new Color (191,215,255));
		textFieldCodiceFiscale.setSelectionColor(new Color (0,41,82));
		contentPane.add(textFieldCodiceFiscale);
		textFieldCodiceFiscale.setColumns(10);
		
		/*COMBOBOX CLIENTE*/
		comboBoxCliente = new JComboBox<Object>();
		comboBoxCliente.setFocusable(false);
		comboBoxCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CaricaTextFields(ctrl);
			}
		});
		comboBoxCliente.setBounds(152, 40, 233, 32);
		comboBoxCliente.setBorder(new RoundedCornerBorder());
		comboBoxCliente.setOpaque(false);
		comboBoxCliente.setFont(new Font("Cambria", Font.BOLD, 15));
		contentPane.add(comboBoxCliente);
		
		/*LABEL CLIENTE*/
		LabelCliente = new JLabel("Cliente");
		LabelCliente.setFont(new Font("Cambria", Font.BOLD, 15));
		LabelCliente.setBounds(41, 46, 62, 26);
		LabelCliente.setForeground(new Color (0,41,82));
		contentPane.add(LabelCliente);
		
		/*LABEL NOME*/
		LabelNome = new JLabel("Nome");
		LabelNome.setFont(new Font("Cambria", Font.BOLD, 15));
		LabelNome.setBounds(42, 96, 57, 22);
		LabelNome.setForeground(new Color (0,41,82));
		contentPane.add(LabelNome);
		
		/*LABEL COGNOME*/
		LabelCognome = new JLabel("Cognome");
		LabelCognome.setFont(new Font("Cambria", Font.BOLD, 15));
		LabelCognome.setBounds(41, 142, 100, 29);
		LabelCognome.setForeground(new Color (0,41,82));
		contentPane.add(LabelCognome);
		
		/*LABEL CODICE FISCALE*/
		LabelCodiceFiscale = new JLabel("Codice Fiscale");
		LabelCodiceFiscale.setFont(new Font("Cambria", Font.BOLD, 15));
		LabelCodiceFiscale.setBounds(42, 197, 99, 24);
		LabelCodiceFiscale.setForeground(new Color (0,41,82));
		contentPane.add(LabelCodiceFiscale);
		
		/*LABEL SFONDO*/
		LabelSfondo = new JLabel("");
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
	
	public void AggiornaInformazioniDialog(Controller ctrl) {
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
}
