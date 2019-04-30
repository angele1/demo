package com.xhb.dao;

import java.util.List;

import org.junit.Test;

import com.xhb.entity.Notice;
import com.xhb.entity.User;

public class test {
	@Test
	public void test1() {
		String name = "j";
		String id = "1";
		UserService service = new UserServiceImpl();
//		List<User> list = service.selectAllUser();
//		for(User user:list) {
//			System.out.println(user);
//		}
		
		//根据姓名查询
		//User user = service.selectByName(name);
		
		//根据id查询
		//User user = service.selectById(id);
		User user = new User();
//		user.setPermission("0");
//		user.setClasses("土木");
//		user.setReal_name("jason");

//		List<User> list = service.selectLikeName("3");
//		for(User user2:list) {
//			System.out.println(user2);
//		}
		Notice notice = new Notice();
		notice.setNotice_id(1);
		notice.setNotice_content("1111");
		notice.setNotice_permission("0");
		service.insertNotice(notice);;
		
	}
}
