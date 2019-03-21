package org.test.service;

import org.test.entity.User;
import org.test.implement.userImp;

//业务逻辑层：逻辑的操作集
public class UserService {
	public boolean isExists(User user) {
		userImp ui = new userImp();
		return ui.isExiestsQuerry(user);
	}
	public boolean addUser(User user) {
		userImp ui = new userImp();
		return ui.addQuerry(user);
	}
	public boolean close() {
		userImp ui = new userImp();
		return ui.close();
	}
	
}
