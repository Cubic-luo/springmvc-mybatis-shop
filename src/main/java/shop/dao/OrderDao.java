package shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import shop.entity.Order;

public interface OrderDao {

	/**
	 * 插入订单
	 * 
	 * @param order
	 * @return
	 */
	public int insertOrder(Order order);

	/**
	 * 插入订单与与商品的映射,即把商品插入订单
	 * 
	 * @Param("seckillId")是mybatis的注解，用于告诉mybatis形成名字，因为Java是用arg0，arg1代表的，单个形参时可不用，多个的时候需要用这个注解
	 * 
	 * @return
	 */
	public int insertOrderMapProducts(@Param("orderId") int orderId, @Param("productsId") int productsId,
			@Param("amount") int amount);

	/**
	 * 通过用户id查找该用户所有订单
	 * 
	 * @param userId
	 * @return
	 */
	public List<Order> queryOrderByUserId(int userId);

	/**
	 * 通过订单id查询单个订单
	 * 
	 * @param orderId
	 * @return
	 */
	public Order queryOrderById(int orderId);

}
