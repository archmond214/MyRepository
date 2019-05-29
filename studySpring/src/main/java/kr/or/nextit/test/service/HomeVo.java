package kr.or.nextit.test.service;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class HomeVo {

	private String title;
	private String name;
	private String age;
	private String pw;
	private String email;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
	return ToStringBuilder.reflectionToString(this);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
}
