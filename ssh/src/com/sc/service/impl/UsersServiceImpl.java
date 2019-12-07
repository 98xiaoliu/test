package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.dao.UsersDao;
import com.sc.entity.Users;
import com.sc.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	UsersDao usersDao;

	@Override
	public void add(Users u) {
		if(u!=null){
		  this.usersDao.add(u);
		}
	}

	@Override
	public void update(Users u) {
		if(u!=null&&u.getUid()!=null){
			this.usersDao.update(u);
		}
	}

	@Override
	public void delete(Users u) {
		if(u!=null){
			this.usersDao.delete(u);
		}
	}

	@Override
	public Users get(Integer uid) {
		if(uid!=null){
		   return this.usersDao.get(uid);
		}
		return null;
	}

	@Override
	public List<Users> select() {
		return this.usersDao.select();
	}

	@Override
	public Users login(Users u) {
		
		if(u!=null&&u.getUname()!=null&&u.getUpass()!=null){
			List<Users> list = this.usersDao.login(u);
			if(list!=null&&list.size()>0){
				return list.get(0);
			}
		}
		
		return null;
	}

}
