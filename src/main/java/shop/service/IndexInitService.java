package shop.service;

import java.util.List;

import shop.entity.Discuss;
import shop.entity.ProductsType;

public interface IndexInitService {
	/**
	 * 查询所有商品类型及其包含的单品
	 * 
	 * @return
	 */
	public List<ProductsType> queryAllProducts();

	/**
	 * 查询所有评论
	 * 
	 * @return
	 */
	public List<Discuss> queryAllDiscsss();
}
