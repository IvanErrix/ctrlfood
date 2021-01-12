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
		ButtonDeposito.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/Button_Deposito.png")));
		ButtonDeposito.setBounds(59, 97, 223, 52);
		contentPane.add(ButtonDeposito);
		
		JButton ButtonNegozio = new JButton("");
		ButtonNegozio.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/Button_Negozio.png")));
		ButtonNegozio.setVisible(false);
		ButtonNegozio.setOpaque(false);
		ButtonNegozio.setContentAreaFilled(false);
		ButtonNegozio.setBorderPainted(false);
		ButtonNegozio.setBounds(59, 200, 223, 52);
		contentPane.add(ButtonNegozio);
		
		JButton ButtonCliente = new JButton("");
		ButtonCliente.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/Button_Cliente.png")));
		ButtonCliente.setVisible(false);
		ButtonCliente.setOpaque(false);
		ButtonCliente.setContentAreaFilled(false);
		ButtonCliente.setBorderPainted(false);
		ButtonCliente.setBounds(59, 300, 223, 52);
		contentPane.add(ButtonCliente);
		
		JButton ButtonCarello = new JButton("");
		ButtonCarello.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/Button_Carrello.png")));
		ButtonCarello.setVisible(false);
		ButtonCarello.setOpaque(false);
		ButtonCarello.setContentAreaFilled(false);
		ButtonCarello.setBorderPainted(false);
		ButtonCarello.setBounds(59, 400, 223, 52);
		contentPane.add(ButtonCarello);
		
		JLabel Homepage = new JLabel("");
		Homepage.setIcon(new ImageIcon(FramePrincipale.class.getResource("/scrimg/Homepage.png")));
		Homepage.setBounds(0, 0, 1146, 571);
		contentPane.add(Homepage);
	}
}
