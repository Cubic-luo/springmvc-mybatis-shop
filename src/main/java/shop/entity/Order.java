package shop.entity;

import java.util.Date;
import java.util.List;

/**
 * 订单实体类
 * 
 * @author Administrator
 *
 */
public class Order {
	private int id;// 订单id
	private double total;// 订单总金额
	private Date creatTime;// 订单产生的时间
	private int userId;// 用户id
	// 订单与用户时多对一的关系
	private User user;
	// 订单和商品是一对多的关系
	private List<Products> products;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", total=" + total + ", creatTime=" + creatTime + ", userId=" + userId + ", user="
				+ user + ", products=" + products + "]";
	}

}
