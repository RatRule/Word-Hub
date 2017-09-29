package logic;

import data.UserDataAccess;
import data.UserDataAccess.UserAlreadyExistException;
import entities.UserEntity;

public class UserLogic {
	public boolean isUserValid(String userid,String password){
		UserDataAccess userdata=new UserDataAccess();
		UserEntity user=userdata.getUser(userid);
		if(user==null){
			return false;
		}else if(user.getPassword().equals(password)){
			return true;
		}else{
			return false;
		}
		
		
		
	}
	public boolean addUser(String userId,String password){
		UserEntity user=new UserEntity();
		user.setUserId(userId);
		user.setPassword(password);
		user.setHighScore(0);
	 	UserDataAccess userData = new UserDataAccess();
		try {
			userData.addUser(user);
		} catch (UserAlreadyExistException e) {
			return false;
			
		}
		return true;
	}
public static void main(String[] args) {
	UserLogic u=new UserLogic();
	System.out.println(u.isUserValid("abc7","125"));
	System.out.println(u.addUser("ab","125" ));
}
}