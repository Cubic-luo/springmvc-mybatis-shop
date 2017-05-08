package shop.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 用户信息实体类
 * 
 * @author Administrator
 *
 */
public class User {
	private int id;// 用户id
	@NotNull(message = "用户名不能为空")
	private String username;// 用户名

	@NotNull(message = "密码不能为空")
	@Size(min = 6,max = 16,message = "长度为6到16位之间")
	private String password;// 登录密码

	private int role;// 权限
	private String imgUrl;// 头像
	private String sex;// 性别

	// 用户和订单的关系是1对多，即一个用户可以有多个订单
	private List<Order> orders;
	// 用户和评论的关系是1对多，即一个用户可以有多个评论
	private List<Discuss> discuss;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String img) {
		this.imgUrl = img;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Discuss> getDiscuss() {
		return discuss;
	}

	public void setDiscuss(List<Discuss> discuss) {
		this.discuss = discuss;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ", img="
				+ imgUrl + ", sex=" + sex + ",  orders=" + orders + ", discuss=" + discuss + "]";
	}

}
