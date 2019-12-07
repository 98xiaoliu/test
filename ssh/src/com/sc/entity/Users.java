package com.sc.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String uname;
	private String upass;
	private String sex;
	private Integer age;
	@DateTimeFormat(pattern="yyyy-MM-dd")//日期注解，字符串转日期
	private Date birthday;
	private String active;
	private String pic;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** full constructor */
	public Users(String uname, String upass, String sex, Integer age, Date birthday, String active, String pic) {
		this.uname = uname;
		this.upass = upass;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
		this.active = active;
		this.pic = pic;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return this.upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Override
	public String toString() {
		return "Users [uid=" + uid + ", uname=" + uname + ", upass=" + upass + ", sex=" + sex + ", age=" + age
				+ ", birthday=" + birthday + ", active=" + active + ", pic=" + pic + "]";
	}
	
	

}