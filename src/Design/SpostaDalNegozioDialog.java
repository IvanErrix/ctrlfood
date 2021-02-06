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

import ExternalClasses.RoundedCornerBorder;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SpostaDalNegozioDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public SpostaDalNegozioDialog() {
		setAlwaysOnTop(true);
		setUndecorated(true);
		setSize(356, 300);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		getContentPane().setLayout(null);
		ContentPane contentPane = new ContentPane();
		setContentPane(contentPane);
		getContentPane().isOpaque();
		setBackground(new Color(0, 67, 137, 0));
		contentPane.setLayout(null);
		
		SpinnerNumberModel spinnermodel = new SpinnerNumberModel(1, 1, 50, 1);
		JSpinner spinnerQuantita = new JSpinner(spinnermodel);
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
		getContentPane().add(spinnerQuantita);
		
		JLabel LabelQuantita = new JLabel("Quantit\u00E0");
		LabelQuantita.setFont(new Font("Impact", Font.PLAIN, 22));
		LabelQuantita.setForeground(new Color(0, 41, 82));
		LabelQuantita.setBounds(40, 115, 84, 24);
		getContentPane().add(LabelQuantita);
		
		JLabel LabelNomeProdotto = new JLabel("");
		LabelNomeProdotto.setFont(new Font("Impact", Font.PLAIN, 20));
		LabelNomeProdotto.setForeground(new Color(0, 41, 82));
		LabelNomeProdotto.setBounds(89, 32, 170, 37);
		contentPane.add(LabelNomeProdotto);
		
		JButton ButtonSposta = new JButton("");
		ButtonSposta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null, "PRODOTTO AGGIUNTO CORRETTAMENTE", "", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		});
		ButtonSposta.setPressedIcon(new ImageIcon(SpostaDalNegozioDialog.class.getResource("/scrimg/ButtonSposta2.png")));
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
		ButtonSposta.setOpaque(false);
		ButtonSposta.setBorder(null);
		ButtonSposta.setContentAreaFilled(false);
		ButtonSposta.setBounds(194, 227, 110, 24);
		getContentPane().add(ButtonSposta);
		
		JButton ButtonAnnulla = new JButton("");
		ButtonAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		ButtonAnnulla.setPressedIcon(new ImageIcon(SpostaDalNegozioDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
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
		ButtonAnnulla.setIcon(new ImageIcon(SpostaDalNegozioDialog.class.getResource("/scrimg/ButtonAnnulla.png")));
		ButtonAnnulla.setOpaque(false);
		ButtonAnnulla.setBorder(null);
		ButtonAnnulla.setContentAreaFilled(false);
		ButtonAnnulla.setBounds(40, 227, 110, 24);
		getContentPane().add(ButtonAnnulla);
		
		JLabel LabelSfondo = new JLabel("");
		LabelSfondo.setIcon(new ImageIcon(SpostaDalNegozioDialog.class.getResource("/scrimg/SfondoSpostaDalNegozio.png")));
		LabelSfondo.setBounds(-9, -9, 372, 322);
		getContentPane().add(LabelSfondo);
	}
}
