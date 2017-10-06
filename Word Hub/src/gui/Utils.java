package gui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Utils {
	public static ImageIcon getScaledImage(ImageIcon srcImgIcon, int w, int h){
		Image srcImg = srcImgIcon.getImage();
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return new ImageIcon(resizedImg);
	}
	
	public static void setBackground(JPanel panel, String path) {
		JLabel lblNewLabel = new JLabel("");
		ImageIcon imageIcon = Utils.getScaledImage(
				new ImageIcon(path),
				panel.getWidth(), panel.getHeight()
		);
		
		lblNewLabel.setIcon(imageIcon);
		lblNewLabel.setBounds(panel.getX(), panel.getY(), panel.getX()+ panel.getWidth(), panel.getY() + panel.getHeight());
		panel.add(lblNewLabel);
	}
	public static void setBackground(JFrame frame, String path) {
		JLabel lblNewLabel = new JLabel("");
		ImageIcon imageIcon = Utils.getScaledImage(
				new ImageIcon(path),
				frame.getWidth(), frame.getHeight()
		);
		
		lblNewLabel.setIcon(imageIcon);
		lblNewLabel.setBounds(0,0, frame.getWidth(),frame.getHeight());
		frame.add(lblNewLabel);
	}

}
