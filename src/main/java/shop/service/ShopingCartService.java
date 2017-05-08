package shop.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import shop.entity.Products;

public interface ShopingCartService {
	/**
	 * 商品 加
	 * 
	 * @param productsId商品id
	 * @return
	 */
	public Map<Integer, Products> addProducts(int productsId, HttpServletRequest request);

	/**
	 * 商品 减
	 * 
	 * @param productsId商品id
	 * @return
	 */
	public Map<Integer, Products> reduceProducts(int productsId, HttpServletRequest request);

	/**
	 * 提交最终订单到数据库
	 * 
	 * @param request
	 * @return
	 */
	public int submitOrder(HttpServletRequest request);

	/**
	 * 清空购物车
	 * 
	 * @return
	 */

	public void clearShopingCart(HttpServletRequest request);

}
