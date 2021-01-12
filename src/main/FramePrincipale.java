package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Cursor;

public class FramePrincipale extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrincipale frame = new FramePrincipale();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FramePrincipale() {
		setTitle("CtrlFood");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1152, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ButtonDeposito = new JButton("");
		ButtonDeposito.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ButtonDeposito.setContentAreaFilled(false);
		ButtonDeposito.setBorderPainted(false);
		ButtonDeposito.setVisible(false);
		ButtonDeposito.setOpaque(false);
		ButtonDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/Group 1.png")));
		ButtonDeposito.setBounds(74, 150, 151, 52);
		contentPane.add(ButtonDeposito);
		
		JButton ButtonNegozio = new JButton("");
		ButtonNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/Group 2.png")));
		ButtonNegozio.setVisible(false);
		ButtonNegozio.setOpaque(false);
		ButtonNegozio.setContentAreaFilled(false);
		ButtonNegozio.setBorderPainted(false);
		ButtonNegozio.setBounds(74, 215, 137, 52);
		contentPane.add(ButtonNegozio);
		
		JButton ButtonCliente = new JButton("");
		ButtonCliente.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/Group 3.png")));
		ButtonCliente.setVisible(false);
		ButtonCliente.setOpaque(false);
		ButtonCliente.setContentAreaFilled(false);
		ButtonCliente.setBorderPainted(false);
		ButtonCliente.setBounds(74, 290, 128, 52);
		contentPane.add(ButtonCliente);
		
		JButton ButtonCarello = new JButton("");
		ButtonCarello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/Group 4.png")));
		ButtonCarello.setVisible(false);
		ButtonCarello.setOpaque(false);
		ButtonCarello.setContentAreaFilled(false);
		ButtonCarello.setBorderPainted(false);
		ButtonCarello.setBounds(74, 365, 141, 52);
		contentPane.add(ButtonCarello);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/Homepage.png")));
		lblNewLabel.setBounds(0, 0, 1156, 600);
		contentPane.add(lblNewLabel);
	}
}
