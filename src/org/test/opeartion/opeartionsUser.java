package org.test.opeartion;

import java.util.List;

import org.test.entity.User;

public interface opeartionsUser {
	public boolean addQuerry(User user);
	public boolean delQuerry(String name);
	public boolean updateQuerry(User user);
	public List<User> allQuerry();
	public boolean isExiestsQuerry(User user);
}
