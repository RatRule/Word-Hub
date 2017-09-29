package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class WordDataAccess {
	
	public String getRandomWord(String category, String level) {
		String query = "SELECT WORD FROM WORD_TABLE WHERE CATEGORY='"+category+"' AND LEVEL='"+level+"'";
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:"+ TableScripts.DATABASE_PATH);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			ArrayList<String> list = new ArrayList<String>();
			while(rs.next()){
				list.add(rs.getString("WORD"));
			}
			if(list.isEmpty()) return null;
			Collections.shuffle(list);
			return list.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("at query: " + query);
			throw new RuntimeException("SQL EXCEPTION");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;
	}
public static void main(String[] args) {
	WordDataAccess word=new WordDataAccess();
	String wordString =  word.getRandomWord("ANIMALS","EASY");
	System.out.println(wordString);
}	
}
