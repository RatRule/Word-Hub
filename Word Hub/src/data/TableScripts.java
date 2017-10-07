package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import entities.Labels;

public class TableScripts {
	
	public static final String DATABASE_PATH = "src/database";
	
	private static final String WORDTABLE_CREATE_SQL = "CREATE TABLE WORD_TABLE(" +
			" WORD_ID NUMBER(5) PRIMARY KEY," +
			" WORD VARCHAR(20) UNIQUE NOT NULL," +
			" CATEGORY VARCHAR(20) CHECK (CATEGORY IN ('"+Labels.Category.CATEGORY1+"', '"+Labels.Category.CATEGORY2+"')) NOT NULL," +
			" LEVEL VARCHAR(20) CHECK (LEVEL IN ('"+Labels.Levels.LEVEL1+"', '"+Labels.Levels.LEVEL2+"', '"+Labels.Levels.LEVEL3+"')) NOT NULL" +
			");";
	private static final String WORDTABLE_INSERT_SQL ="INSERT INTO WORD_TABLE VALUES" +
			"(1,'LION','ANIMALS','EASY')," +
			"(2,'TIGER','ANIMALS','EASY')," +
			"(3,'PIGEON','BIRDS','EASY')";
	
	private static final String USERTABLE_CREATE_SQL = "CREATE TABLE USER_TABLE(" +
			"USER_ID  NUMBER(5) PRIMARY KEY," +
			"PASSWORD VARCHAR2(30) NOT NULL," +
			"HIGHSCORE NUMBER(6)" +
			");" ;
	
	private static final String WORDTABLE_DROP_SQL = "DROP TABLE IF EXISTS WORD_TABLE";
	private static final String USERTABLE_DROP_SQL = "DROP TABLE IF EXISTS USER_TABLE";
	
	private static void runQuery(String query){
		Connection  connection = null;
		try{
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:"+DATABASE_PATH);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("at query: "+query);
			throw new RuntimeException("SQL EXCEPTION");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(connection != null)
				try { connection.close();
				} catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	public static void insertAnimalsData() {
		File animalsFile = new File("src/data/animals.txt");
		try {
			Scanner scanner = new Scanner(animalsFile);
			String level = null;
			int wordId = 1000;
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if(line.equalsIgnoreCase("$easy")) level = "EASY";
				if(line.equalsIgnoreCase("$medium")) level = "MEDIUM";
				if(line.equalsIgnoreCase("$hard")) level = "HARD";
				
				if(level == null || line.startsWith("$") || line.trim().isEmpty()) continue;
				String animal = line.toLowerCase().trim();
				insertWord(wordId, animal, "ANIMALS", level);
				wordId++;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void insertWord(int wordId, String word, String category, String level) {
		Connection  connection = null;
		String query = "insert into WORD_TABLE values("+wordId+", '"+word+"', '"+category+"', '"+level+"')";
		System.out.println(query);
		try{
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:"+DATABASE_PATH);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL EXCEPTION");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(connection != null)
				try { connection.close();
				} catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	public static void recreateAllTables(){
		TableScripts.runQuery(WORDTABLE_DROP_SQL);
		TableScripts.runQuery(WORDTABLE_CREATE_SQL);
		TableScripts.runQuery(USERTABLE_DROP_SQL);
		TableScripts.runQuery(USERTABLE_CREATE_SQL);
		TableScripts.runQuery(WORDTABLE_INSERT_SQL);
	}
	
	public static void main(String[] args) {
		System.out.println("Creating tables");
		TableScripts.recreateAllTables();
		System.out.println("Table created");
		TableScripts.insertAnimalsData();
	}
}
