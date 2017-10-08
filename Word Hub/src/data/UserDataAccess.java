package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import entities.UserEntity;

public class UserDataAccess {
	public UserEntity getUser(String userid) {
		String query = "SELECT USER_ID,PASSWORD,HIGHSCORE FROM USER_TABLE WHERE USER_ID='"
				+ userid + "'";
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:"
					+ TableScripts.DATABASE_PATH);
			PreparedStatement preparedStatement = connection
					.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			if (!rs.next())
				return null;
			UserEntity user = new UserEntity();
			user.setUserId(rs.getString("USER_ID"));
			user.setHighScore(rs.getInt("HIGHSCORE"));
			user.setPassword(rs.getString("PASSWORD"));
			return user;
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

	public void addUser(UserEntity user) throws UserAlreadyExistException {
		String query = "INSERT INTO USER_TABLE VALUES ('" + user.getUserId()
				+ "','" + user.getPassword() + "'," + user.getHighScore() + ")";
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:"
					+ TableScripts.DATABASE_PATH);
			PreparedStatement preparedStatement = connection
					.prepareStatement(query);
			preparedStatement.execute();

		} catch (SQLException e) {
			if (e.getMessage().contains(
					"UNIQUE constraint failed: USER_TABLE.USER_ID"))
				throw new UserAlreadyExistException();
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

	}

	public void updateHighScore(String userid, int highscore) {
		String query = "UPDATE USER_TABLE SET HIGHSCORE =" + highscore
				+ " WHERE USER_ID ='" + userid + "'";

		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:"
					+ TableScripts.DATABASE_PATH);
			PreparedStatement preparedStatement = connection
					.prepareStatement(query);
			preparedStatement.execute();

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
	}

	public void updatePassword(String userid, String password) {
		String query = "UPDATE USER_TABLE SET PASSWORD =" + password
				+ " WHERE USER_ID ='" + userid + "'";

		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:"
					+ TableScripts.DATABASE_PATH);
			PreparedStatement preparedStatement = connection
					.prepareStatement(query);
			preparedStatement.execute();

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
	}

	public void deleteUser(String userid) {
		String query = "DELETE FROM USER_TABLE WHERE USER_ID='" + userid+"'";

		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:"
					+ TableScripts.DATABASE_PATH);
			PreparedStatement preparedStatement = connection
					.prepareStatement(query);
			preparedStatement.execute();

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

	}

	public static class UserAlreadyExistException extends Exception {

	}

	public static void main(String[] args) throws UserAlreadyExistException {
	UserDataAccess userData=new UserDataAccess();
	UserEntity u=new UserEntity("abc7","125",6764);
	
	
	//userData.addUser(u);
	userData.updateHighScore("abc4",15);
	userData.updatePassword("abc4","123");
	userData.deleteUser("utsav5");
	UserEntity ue = userData.getUser("");
	System.out.println(userData.getUser("utsav"));
	
}}
