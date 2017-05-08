package shop.entity;

import java.util.List;

/**
 * 商品类型实体类
 * 
 * @author Administrator
 *
 */
public class ProductsType {

	private String typeName;// 商品类别名称
	private String typeInfo;// 商品类型描述信息
	private int id;// 商品类型id
	// 商品类型与商品是1对多的关系
	private List<Products> products;

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeInfo() {
		return typeInfo;
	}

	public void setTypeInfo(String typeInfo) {
		this.typeInfo = typeInfo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ProductsType [typeName=" + typeName + ", typeInfo=" + typeInfo + ", id=" + id + ", products=" + products
				+ "]";
	}

}
