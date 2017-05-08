package shop.dao;

import java.util.List;

import shop.entity.ProductsType;

public interface ProductsTypeDao {

	/**
	 * 增加商品类型
	 * 
	 * @param productsType
	 * @return
	 */
	public int insertType(ProductsType productsType);

	/**
	 * 根据商品类型id删除商品类型
	 * 
	 * @param typeId
	 * @return
	 */
	public int deleteTypeById(int typeId);

	/**
	 * 修改商品类型信息
	 * 
	 * @param productsType
	 * @return
	 */
	public int updateType(ProductsType productsType);

	/**
	 * 查询所有商品类别
	 * 
	 * @return
	 */
	public List<ProductsType> queryAllType();

	/**
	 * 根据商品类型id查询商品类型
	 * 
	 * @param typeId
	 * @return
	 */
	public ProductsType queryTypeById(int typeId);

}
