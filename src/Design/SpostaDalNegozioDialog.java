package Design;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import ExternalClasses.ContentPane;
import ExternalClasses.RoundedCornerBorder;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SpostaDalNegozioDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private ContentPane contentPane;
	private SpinnerNumberModel spinnermodel;
	private JSpinner spinnerQuantita;
	private JLabel LabelQuantita;
	private JLabel LabelIDProdotto; //LABEL FISSA 
	private JLabel LabelID; //LABEL CARICAMENTO ID DEL PRODTTO SELEZIONATO
	private JLabel LabelNomeProdotto; //LABEL FISSA
	private JLabel LabelNome; //LABEL CARICAMENTO NOME DEL PRODOTTO SELEZIONATO
	private JButton ButtonSposta;
	private JButton ButtonAnnulla;
	private JLabel LabelSfondo;
	
	public SpostaDalNegozioDialog() {
		setAlwaysOnTop(true);
		setUndecorated(true);
		setSize(356, 300);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		getContentPane().setLayout(null);
		
		/*CONTENTPANE*/
		contentPane = new ContentPane();
		setContentPane(contentPane);
		getContentPane().isOpaque();
		setBackground(new Color(0, 67, 137, 0));
		contentPane.setLayout(null);
		
		/*SPINNER QUANTITA*/
		spinnermodel = new SpinnerNumberModel(1, 1, 50, 1);
		spinnerQuantita = new JSpinner(spinnermodel);
		spinnerQuantita.setOpaque(false);
		spinnerQuantita.setBorder(new RoundedCornerBorder());
		spinnerQuantita.getComponent(0).setBackground(new Color(191,215,255));
		spinnerQuantita.getComponent(1).setBackground(new Color(191,215,255));
		spinnerQuantita.getEditor().getComponent(0).setBackground(new Color(191,215,255));
		spinnerQuantita.getEditor().getComponent(0).setForeground(new Color(0, 41, 82));
		spinnerQuantita.setRequestFocusEnabled(false);
		spinnerQuantita.setFont(new Font("Impact", Font.PLAIN, 14));
		spinnerQuantita.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		spinnerQuantita.setBounds(251, 118, 53, 24);
		contentPane.add(spinnerQuantita);
		
		/*LABEL QUANTITA*/
		LabelQuantita = new JLabel("Quantit\u00E0");
		LabelQuantita.setFont(new Font("Impact", Font.PLAIN, 22));
		LabelQuantita.setForeground(new Color(0, 41, 82));
		LabelQuantita.setBounds(40, 115, 84, 24);
		contentPane.add(LabelQuantita);

		/*LABEL ID PRODOTTO*/
		LabelIDProdotto = new JLabel("ID Prodotto");
		LabelIDProdotto.setBounds(40, 32, 84, 14);
		contentPane.add(LabelIDProdotto);
		
		/*LABEL ID*/
		LabelID = new JLabel("");
		LabelID.setBounds(194, 32, 46, 14);
		contentPane.add(LabelID);
		
		/*LABEL NOME PRODTTO*/
		LabelNomeProdotto = new JLabel("Nome Prodotto");
		LabelNomeProdotto.setBounds(40, 75, 84, 14);
		contentPane.add(LabelNomeProdotto);
		
		/*LABEL NOME*/
		LabelNome = new JLabel("");
		LabelNome.setBounds(194, 75, 46, 14);
		contentPane.add(LabelNome);
		
		/*BUTTON SPOSTA*/
		ButtonSposta = new JButton("");
		ButtonSposta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "PRODOTTO AGGIUNTO CORRETTAMENTE", "", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		});
		ButtonSposta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonSposta.setIcon(new ImageIcon(SpostaDalNegozioDialog.class.getResource("/scrimg/ButtonSpostaAzzurro2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonSposta.setIcon(new ImageIcon(SpostaDalNegozioDialog.class.getResource("/scrimg/ButtonSposta2.png")));
			}
		});
		ButtonSposta.setIcon(new ImageIcon(SpostaDalNegozioDialog.class.getResource("/scrimg/ButtonSposta2.png")));
		ButtonSposta.setPressedIcon(new ImageIcon(SpostaDalNegozioDialog.class.getResource("/scrimg/ButtonSposta2.png")));
		ButtonSposta.setOpaque(false);
		ButtonSposta.setBorder(null);
		ButtonSposta.setContentAreaFilled(false);
		ButtonSposta.setBounds(194, 227, 110, 24);
		contentPane.add(ButtonSposta);
		
		/*BUTTON ANNULLA*/
		ButtonAnnulla = new JButton("");
		ButtonAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		ButtonAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonAnnulla.setIcon(new ImageIcon(SpostaDalNegozioDialog.class.getResource("/scrimg/ButtonAnnullaAzzurro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonAnnulla.setIcon(new ImageIcon(SpostaDalNegozioDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
			}
		});
		ButtonAnnulla.setPressedIcon(new ImageIcon(SpostaDalNegozioDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
		ButtonAnnulla.setIcon(new ImageIcon(SpostaDalNegozioDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
		ButtonAnnulla.setOpaque(false);
		ButtonAnnulla.setBorder(null);
		ButtonAnnulla.setContentAreaFilled(false);
		ButtonAnnulla.setBounds(40, 227, 110, 24);
		contentPane.add(ButtonAnnulla);
		
		/*LABEL SFONDO*/
		LabelSfondo = new JLabel("");
		LabelSfondo.setIcon(new ImageIcon(SpostaDalNegozioDialog.class.getResource("/scrimg/SfondoSpostaDalNegozio.png")));
		LabelSfondo.setBounds(-9, -9, 372, 322);
		contentPane.add(LabelSfondo);
	}
}
