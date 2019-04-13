package com.fx.hmwac.domain;

public class UserLoginBean {

	private String userName;

    private String password;
    
    private int role;

    public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getUserName() {
        return userName;
    }

    public String getPasswrd() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	@Override
	public String toString() {
		return "UserLoginBean [userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}
}
