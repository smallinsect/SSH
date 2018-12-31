package com.ssh.actions;

public class TestAction {
	private String pwd;
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String tbaction() {
		System.out.println("222222222"+pwd);
		if(pwd.equals("3333")) {
			return "success";
		}
		return "fail";
	}
}
