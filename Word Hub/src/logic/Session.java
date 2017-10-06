package logic;

import javax.swing.JFrame;

public class Session {
	private static String userId;
	
	public static void invalidate(JFrame frame) {
		frame.dispose();
		frame.setVisible(false);
	}
	
	public static void logout() {
		userId = null;
	}
	
	public static String getUserId() {
		return userId;
	}
	
	public static void setUserId(String userId) {
		Session.userId = userId;
	}
}
