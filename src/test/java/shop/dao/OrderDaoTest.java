package shop.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import shop.entity.Order;

public class OrderDaoTest extends BaseTest {
	@Autowired
	private OrderDao orderDao;

	@Test
	public void testInsertOrder() {
		Order order = new Order();
		order.setCreatTime(new Date());
		order.setTotal(205);
		order.setUserId(2);
		orderDao.insertOrder(order);
		// 测试通过
	}

	@Test
	public void testQueryOrderByUserId() {
		List<Order> orderList = orderDao.queryOrderByUserId(1);
		for (Order order : orderList) {
			System.out.println(order);
		}
		// 测试通过
	}

	@Test
	public void testInsertOrderMapProducts() {
		orderDao.insertOrderMapProducts(1, 8, 3);
		// 测试通过,注意上面的前2个参数，即订单id和商品id在数据库设置了双主键，防止一个订单重复出现一个菜，所以测试的时候记得和以前测试的不同，第2个参数加1即可

	}

	@Test
	public void testQueryOrderById() {
		Order order = orderDao.queryOrderById(1);
		System.out.println(order);
		// 测试通过
	}

}
