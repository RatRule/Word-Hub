package gui;

import javax.swing.JFrame;

public class BaseFrame extends JFrame {
	
	public BaseFrame() {
		setTitle("Word Hub");
	}
	
	public void showBackgroundImage() {
		Utils.setBackground(this, "src/images/homeBackgroundBlur.jpg");
	}
}
