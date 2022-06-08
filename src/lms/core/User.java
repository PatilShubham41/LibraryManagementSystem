package lms.core;

import java.util.Date;

public class User {
	
	private long userID;
	private String name;
	private Date issualTime;
	
	public User() {
		this(00000000000L, "UNKNOWN");
	}
	
	public User(long uID, String name) {
		
		userID = uID;
		this.name = name;
	}
	
	
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
    public void setIssualTime(Date time) {
    	issualTime = time;
    }
	
    public Date getIssualTime() {
    	return issualTime;
    }

}
