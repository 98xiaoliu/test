package com.sc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sc.dao.UsersDao;
import com.sc.entity.Users;

@Repository //组件注解，把dao类注册成bean对象
public class UsersDaoImpl implements UsersDao {

	//我们自己的dao类依赖于hibernate模板对象
	@Autowired  //通过类型找bean对象，自动织入
	HibernateTemplate hibernateTemplate;
	
   	@Override
	public void add(Users u) {
		this.hibernateTemplate.save(u);
	}

	@Override
	public void update(Users u) {
		this.hibernateTemplate.update(u);
	}

	@Override
	public void delete(Users u) {
		this.hibernateTemplate.delete(u);
	}

	@Override
	public Users get(Integer uid) {
		return this.hibernateTemplate.get(Users.class, uid);
	}

	@Override
	public List<Users> select() {
		return (List<Users>)this.hibernateTemplate.find("from Users");
	}

	@Override
	public List<Users> login(Users u) {
		return (List<Users>)this.hibernateTemplate.find("from Users where uname=? and upass=?",u.getUname(),u.getUpass());
	}
	
	
	
}
