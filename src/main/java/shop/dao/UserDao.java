package shop.dao;

import shop.entity.User;

public interface UserDao {

	/**
	 * 用户注册
	 * 
	 * @param
	 * @return
	 */
	public int creatUser(User user);

	/**
	 * 修改用户信息
	 * 
	 * @param User
	 * @return
	 */
	public int updateUser(User User);

	/**
	 * 通过id查询用户
	 * 
	 * @param userId
	 * @return
	 */
	public User queryById(int userId);

	/**
	 * 根据用户名查询用户
	 * 
	 * @param username
	 * @return
	 */
	public User queryByName(String username);
}
