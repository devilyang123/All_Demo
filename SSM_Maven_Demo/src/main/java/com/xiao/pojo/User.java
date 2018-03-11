package com.xiao.pojo;

import java.io.Serializable;

/**
 * @author 笑笑
 * @Date   2018年1月27日下午9:44:18  
 * 
 */
@SuppressWarnings("serial")
public class User implements Serializable {
	
	private Integer uid = 0;
	private String  username = null;
	private String  password = null;
	private Integer age = 0;
	private String  gender = null;
	private String  email = null;
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
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
	
	

}
