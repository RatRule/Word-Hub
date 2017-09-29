package entities;

public class UserEntity {
	private String userId;
	private String password;
	private int highScore;
	
	public UserEntity(){}
	
	public UserEntity(String userid, String password, int highScore){
		setUserId(userid); setPassword(password); setHighScore(highScore);
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getHighScore() {
		return highScore;
	}
	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", password=" + password
				+ ", highScore=" + highScore + "]";
	}

	public static void main(String[] args) {
		UserEntity user=new UserEntity("abc", "jdj", 45);
		UserEntity ui;
	}	
	
}
