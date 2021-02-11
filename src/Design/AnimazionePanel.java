package Design;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import Main.Controller;

import javax.swing.ImageIcon;

public class AnimazionePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Timer timer;

	public AnimazionePanel(Controller ctrl) {
		setSize(754, 553);
		setLocation(77, 0);
		setBackground(new Color(191, 215, 255));
		setOpaque(false);
		setLayout(null);
		
		JLabel banana = new JLabel();
		banana.setIcon(new ImageIcon(AnimazionePanel.class.getResource("/scrimg/bananas.png")));
		banana.setSize(64, 64);
		banana.setLocation(0, 0);
		add(banana);
		
		JLabel pera = new JLabel();
		pera.setIcon(new ImageIcon(AnimazionePanel.class.getResource("/scrimg/pear.png")));
		pera.setSize(64, 64);
		pera.setLocation(690, 0);
		add(pera);
		
		JLabel uovo = new JLabel();
		uovo.setIcon(new ImageIcon(AnimazionePanel.class.getResource("/scrimg/egg.png")));
		uovo.setSize(64, 64);
		uovo.setLocation(690, 490);
		add(uovo);
		
		JLabel caffe = new JLabel();
		caffe.setIcon(new ImageIcon(AnimazionePanel.class.getResource("/scrimg/coffee.png")));
		caffe.setSize(64, 64);
		caffe.setLocation(0, 490);
		add(caffe);
		
		JLabel latte = new JLabel();
		latte.setIcon(new ImageIcon(AnimazionePanel.class.getResource("/scrimg/milk.png")));
		latte.setSize(64, 64);
		latte.setLocation(344, 0);
		add(latte);
		
		JLabel arancia = new JLabel();
		arancia.setIcon(new ImageIcon(AnimazionePanel.class.getResource("/scrimg/orange.png")));
		arancia.setSize(64, 64);
		arancia.setLocation(690, 244);
		add(arancia);
		
		JLabel nutella = new JLabel();
		nutella.setIcon(new ImageIcon(AnimazionePanel.class.getResource("/scrimg/nutella.png")));
		nutella.setSize(64, 64);
		nutella.setLocation(344, 490);
		add(nutella);
		
		JLabel insalata = new JLabel();
		insalata.setIcon(new ImageIcon(AnimazionePanel.class.getResource("/scrimg/salad.png")));
		insalata.setSize(64, 64);
		insalata.setLocation(0, 244);
		add(insalata);
		
		timer = new Timer(5, new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e){
            	ctrl.MovimentoIcone(banana);
            	ctrl.MovimentoIcone(pera);
            	ctrl.MovimentoIcone(uovo);
            	ctrl.MovimentoIcone(caffe);
            	ctrl.MovimentoIcone(latte);
            	ctrl.MovimentoIcone(arancia);
            	ctrl.MovimentoIcone(nutella);
            	ctrl.MovimentoIcone(insalata);
            }               
        });
		timer.start();
	}
}
