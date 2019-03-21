package org.test.implement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.test.dao.LoginDao;
import org.test.entity.User;
import org.test.opeartion.*;
import org.test.servlet.LoginServlet;
public class userImp implements opeartionsUser{

	@Override
	public boolean addQuerry(User user) {
		String sql = "insert into userInfo(name,psd) values(?,?)";
		Object []parmes = {user.getName(),user.getPsd()}; 
		return LoginDao.Connect(sql, parmes);
	}

	@Override
	public boolean delQuerry(String name) {
		String sql = "delete from userInfo where name = ?";
		Object[] parmes = {name,null};
		return LoginDao.Connect(sql, parmes);
	}

	@Override
	public boolean updateQuerry(User user) {
		String sql = "updata userInfo set pad = ? where name = ?";
		Object []parmes = {user.getName(),user.getPsd()}; 
		return LoginDao.Connect(sql, parmes);
	}

	@Override
	public List<User> allQuerry() {
		String sql = "select *from userInfo";
		Object[] parmes = {};
		List <User> users= new ArrayList<User>(); 
		User user = null;
		ResultSet rs = LoginDao.getResultSet(sql, parmes);
		try {
			while(rs.next()) {
				String name = rs.getString("name");
				String psd = rs.getString("psd");
				user = new User(name,psd);
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean close() {
		return LoginDao.closeAll(LoginDao.pstet, LoginDao.rs, LoginDao.conn);
	}

	@Override
	public boolean isExiestsQuerry(User user) {
		boolean flag = false;
		String sql = "Select *from userinfo";
		ResultSet rs = LoginDao.getResultSet(sql, null);
		try {
			while(rs.next()) {
				String aname = rs.getString("name");
				String apsd = rs.getString("psd");
				if(aname.equals(user.getName()) && apsd.equals(user.getPsd())) {
					flag = true;
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

}
