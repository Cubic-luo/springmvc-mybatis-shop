package shop.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import shop.dao.OrderDao;
import shop.dao.ProductsDao;
import shop.dao.UserDao;
import shop.entity.Order;
import shop.entity.Products;
import shop.entity.User;

@Service
public class ShopingCartServiceImpl implements shop.service.ShopingCartService {
	@Autowired
	private ProductsDao productsDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private OrderDao orderDao;

	Products products;// 商品
	int amount;// 商品总数量
	double total;// 商品总价
	Map<Integer, Products> shopingCart;// 购物车里的商品map

	/*
	 * 
	 * 
	 * @see shop.service.ShopingCartService#addProducts(int,
	 * javax.servlet.http.HttpServletRequest)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, Products> addProducts(int productsId, HttpServletRequest request) {
		products = productsDao.queryById(productsId);// 根据商品id，从数据库查询商品信息
		shopingCart = (Map<Integer, Products>) request.getSession().getAttribute("shopingCart");// 获取session里的购物车
		if (shopingCart == null) {
			shopingCart = new HashMap<Integer, Products>();
			// 购物车中不存在该商品，把查询出来的商品加入购物车
			shopingCart.put(productsId, products);
			request.getSession().setAttribute("shopingCart", shopingCart);
		} else if (shopingCart.containsKey(productsId)) {
			// 如果购物车中存在该商品
			Products products = shopingCart.get(productsId);// 获取该商品
			int number = products.getNumber();// 获取商品数量
			number++;// 商品数量加1
			products.setNumber(number);// 设置新的商品数量
			shopingCart.put(productsId, products);
			request.getSession().setAttribute("shopingCart", shopingCart);
		} else {
			shopingCart.put(productsId, products);
			request.getSession().setAttribute("shopingCart", shopingCart);
		}
		total = 0;// 计算前清零
		amount = 0;// 计算前清零
		// 计算总价和总数量
		for (Products p : shopingCart.values()) {
			total += p.getPrice() * p.getNumber();
			amount += p.getNumber();
		}
		request.getSession().setAttribute("total", total);// 把商品总价放入session
		request.getSession().setAttribute("amount", amount);// 把商品总数量放入session

		return shopingCart;
	}

	/*
	 * @see shop.service.ShopingCartService#reduceProducts(int,
	 * javax.servlet.http.HttpServletRequest)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, Products> reduceProducts(int productsId, HttpServletRequest request) {

		shopingCart = (Map<Integer, Products>) request.getSession().getAttribute("shopingCart");
		// 如果购物车中存在该商品
		Products products = shopingCart.get(productsId);// 获取该商品
		int number = products.getNumber();// 获取商品数量
		number--;// 商品数量减1
		products.setNumber(number);// 设置新的商品数量
		shopingCart.put(productsId, products);
		if (number == 0) {
			// 如果购物车里的该种商品数量为0，则删除该商品
			shopingCart.remove(productsId);
		}
		request.getSession().setAttribute("shopingCart", shopingCart);
		total = 0;// 计算前清零
		amount = 0;// 计算前清零
		// 计算总价和总数量
		for (Products p : shopingCart.values()) {
			total += p.getPrice() * p.getNumber();
			amount += p.getNumber();
		}
		request.getSession().setAttribute("total", total);// 把商品总价放入session
		request.getSession().setAttribute("amount", amount);// 把商品总数量放入session
		return shopingCart;
	}

	@Override
	public void clearShopingCart(HttpServletRequest request) {
		request.getSession().removeAttribute("shopingCart");// 删除购物车
		request.getSession().removeAttribute("total");// 删除商品总价
		request.getSession().removeAttribute("amount");// 删除商品总数量

	}

	@SuppressWarnings("unchecked")
	@Override
	public int submitOrder(HttpServletRequest request) {
		shopingCart = (Map<Integer, Products>) request.getSession().getAttribute("shopingCart");
		total = (double) request.getSession().getAttribute("total");// 获取商品总价

		String username = getUserName();// 获取用户姓名
		User user = userDao.queryByName(username);// 获取用户信息
		int userId = user.getId();// 获取用户id
		Date creatTime = new Date();// 用服务器现在的时间作为订单创建的时间
		Order order = new Order();// 订单实体
		order.setCreatTime(creatTime);// 往订单中放入订单时间
		order.setTotal(total);// 往订单中放入订单总金额
		order.setUserId(userId);// 往订单中放入订单用户的id

		orderDao.insertOrder(order);// 向数据库插入订单
		int oid = order.getId();// 获取主键id
		// 插入此订单中所有商品到订单与商品关系维护表中
		for (Products p : shopingCart.values()) {
			int pid = p.getId();// 商品id
			orderDao.insertOrderMapProducts(oid, pid, userId);
		}
		clearShopingCart(request);// 清空购物车
		return 0;
	}

	/**
	 * 获取认证用户信息详情
	 * 
	 * @return
	 */
	private UserDetails getUserDetail() {
		return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	/**
	 * 获取当前认证用户姓名
	 * 
	 * @return
	 */
	private String getUserName() {
		String userName = getUserDetail().getUsername();
		return userName;

	}

}
