package shop.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.dto.JsonResult;
import shop.entity.Products;
import shop.service.impl.ShopingCartServiceImpl;

@Controller
@RequestMapping("/shopingCart")
public class ShopingCartController {
	@Autowired
	private ShopingCartServiceImpl shopCartServiceImpl;

	/**
	 * 选完商品后，点击选好了，跳转到订单详情页面，确认自己的订单信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/confirmation")
	public String orderConfirmation() {
		return "orderDetail";
	}

	/**
	 * 在订单详情页，点击付款，跳转到付款页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/payfor")
	public String orderPayfor() {
		return "payfor";
	}

	/**
	 * 确认订单，提交到数据库，并支付
	 * 
	 * @return
	 */
	@RequestMapping(value = "/submit")
	public String submitOrder(HttpServletRequest request) {
		shopCartServiceImpl.submitOrder(request);
		return "redirect:/";// 重定向到主页
	}

	/**
	 * ajax json 购物车加
	 * 
	 * @param seckillId
	 * @return
	 * @return返回json数据
	 */
	/**
	 * @return
	 */
	@RequestMapping(value = "/{productsId}/add", method = RequestMethod.POST, produces = {
			"application/json;charset=utf-8" })
	@ResponseBody
	public JsonResult<Map<Integer, Products>> addProducts(@PathVariable("productsId") int productsId,
			HttpServletRequest request) {
		JsonResult<Map<Integer, Products>> result;// 封装json数据
		Map<Integer, Products> data = shopCartServiceImpl.addProducts(productsId, request);
		result = new JsonResult<Map<Integer, Products>>(data);
		return result;
	}

	/**
	 * ajax json 购物车减
	 * 
	 * @param seckillId
	 * @return
	 * @return返回json数据
	 */
	/**
	 * @return
	 */
	@RequestMapping(value = "/{productsId}/reduce", method = RequestMethod.POST, produces = {
			"application/json;charset=utf-8" })
	@ResponseBody
	public JsonResult<Map<Integer, Products>> reduceProducts(@PathVariable("productsId") int productsId,
			HttpServletRequest request) {
		JsonResult<Map<Integer, Products>> result;// 封装json数据
		Map<Integer, Products> data = shopCartServiceImpl.reduceProducts(productsId, request);
		result = new JsonResult<Map<Integer, Products>>(data);
		return result;
	}

	/**
	 * 清空购物车
	 * 
	 * @param request
	 */
	@RequestMapping(value = "/clear", method = RequestMethod.POST, produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public void clearShopingCart(HttpServletRequest request) {
		shopCartServiceImpl.clearShopingCart(request);
	}

}
