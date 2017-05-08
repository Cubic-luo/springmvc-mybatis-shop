package shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import shop.entity.Products;

/**
 * 处理商品相关数据库操作
 * 
 * @author Administrator
 *
 */
public interface ProductsDao {

	/**
	 * 根据商品id查询商品
	 * 
	 * @param productsId
	 * @return
	 */
	public Products queryById(int productsId);

	/**
	 * 查询所有商品
	 * 
	 * @return
	 */
	public List<Products> queryAll();

	/**
	 * 根据商品类型id查询商品
	 * 
	 * @param typeId
	 * @return
	 */
	public List<Products> queryByTpeyId(int typeId);

	/**
	 * 根据订单id查询商品
	 * 
	 * @param orderId
	 * @return
	 */
	public List<Products> queryByOrderId(int orderId);

	/**
	 * 增加商品
	 * 
	 * @param products
	 * @return
	 */
	public int insertProducts(Products products);

	/**
	 * 插入商品类别信息
	 * 
	 * @param typeName
	 * @param typeInfo
	 * @return
	 */
	public int insertProductsType(@Param("typeName") String typeName, @Param("typeInfo") String typeInfo);

	/**
	 * 通过商品id删除商品
	 * 
	 * @param productsId
	 * @return
	 */
	public int deleteProducts(int productsId);

	/**
	 * 修改商品
	 * 
	 * @param productsId
	 * @return
	 */
	public int updateProducts(Products products);
}
