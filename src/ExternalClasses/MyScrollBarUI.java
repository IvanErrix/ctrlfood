package ExternalClasses;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

import Design.AggiungiAlDepositoDialog;

public class MyScrollBarUI extends BasicScrollBarUI {
	
	private final Dimension d = new Dimension();

	  @Override
	  protected JButton createDecreaseButton(int orientation) {
		  JButton button = new JButton();
		  button.setBorder(null);
		  button.setContentAreaFilled(false);
		  button.setOpaque(false);
		  button.setSize(16,16);
		  button.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/FrecciaSu.png")));
	    return  button ;
	    };
	  

	  @Override
	  protected JButton createIncreaseButton(int orientation) {
		  JButton button = new JButton();
		  button.setBorder(null);
		  button.setBackground(new Color(191,215,255));
		  button.setContentAreaFilled(false);
		  button.setOpaque(false);
		  button.setSize(16,16);
		  button.setIcon(new ImageIcon(AggiungiAlDepositoDialog.class.getResource("/scrimg/FrecciaGiu.png")));
	    return  button ;
	    };
	  

//    @Override
//    protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
//    	Graphics2D g2 = (Graphics2D)g.create();
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  RenderingHints.VALUE_ANTIALIAS_ON);
//        Color color = null;
//        JScrollBar sb = (JScrollBar)c;
//        if(!sb.isEnabled() || r.width>r.height) {
//        	return;
//        }else if(isDragging) {
//        	color = new Color(191,215,255,255);
//        }else if(isThumbRollover()) {
//        	color = new Color(191,215,255,255);
//        }else {
//        	color = new Color(191,215,255,255);
//        }
//        g2.setPaint(color);
//        g2.fillRoundRect(r.x,r.y,r.width,r.height,10,10);
//        g2.setPaint(new Color(191,215,255,255));
//        g2.drawRoundRect(r.x,r.y,r.width,r.height,10,10);
//        g2.dispose();
//    }
//
//    @Override
//    protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
//        Graphics2D g2 = (Graphics2D)g.create();
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        Color color = null;
//        JScrollBar sb = (JScrollBar)c;
//        if(!sb.isEnabled() || r.width>r.height) {
//          return;
//        }else if(isDragging) {
//          color = new Color(0,41,82,255);
//        }else if(isThumbRollover()) {
//          color = new Color(0,41,82,255);
//        }else {
//          color = new Color(0,41,82,255);
//        }
//        g2.setPaint(color);
//        g2.fillRoundRect(r.x,r.y,r.width,r.height,10,10);
//        g2.setPaint(new Color(0,42,82));
//        g2.drawRoundRect(r.x,r.y,r.width,r.height,10,10);
//        g2.dispose();
//    }
}