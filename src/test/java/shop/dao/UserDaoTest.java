package shop.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import shop.entity.User;

public class UserDaoTest extends BaseTest {

	@Autowired
	private UserDao userDao;

	@Test
	public void testQueryById() {

		User user = userDao.queryById(1);
		System.out.println(user);
		// 测试通过
	}

	@Test
	public void testCreatUser() {
		User user = new User();
		user.setImgUrl("1");
		user.setPassword("123");
		user.setRole(1);
		user.setSex("女");
		user.setUsername("测试222");
		userDao.creatUser(user);
		// 测试通过
	}

	@Test
	public void testUpdateUser() {
		User user = new User();
		user.setId(3);
		user.setUsername("测试修改用户信息");
		userDao.updateUser(user);
		// 测试通过
	}
}
