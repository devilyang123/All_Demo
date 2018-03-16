package com.xiao.pojo;

/**
 * @author 笑笑
 * @Date   2018年3月15日上午9:20:28
 *	
 */
public class User {
	
	private int uid = 0;
	private String username = null;
	private String password = null;
	private int age = 0;
	private String gender = null;
	private String email = null;
	
	//空参构造器
	public User() {
	}
	//有参构造器
	public User(int uid, String username, String password, int age, String gender, String email) {
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.email = email;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//重写toString
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", age=" + age + ", gender="
				+ gender + ", email=" + email + "]";
	}

	
}
