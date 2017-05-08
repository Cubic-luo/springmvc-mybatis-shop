package shop.entity;

import java.util.List;

/**
 * 商品实体类，映射数据库的商品数据表
 * 
 * @author Administrator
 *
 */
public class Products {

	private int id;// 商品id
	private String name;// 商品名称
	private double price;// 商品价格
	private int number;// 商品数量
	private int typeId;// 商品类型
	private String imgUrl;// 商品图片路径
	private String info;// 商品描述信息
	// 单个商品和订单是1对多的关系，即一种商品可以出现在多个订单中
	private List<Order> orders;

	private ProductsType productsType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductsType getProductsType() {
		return productsType;
	}

	public void setProductsType(ProductsType productsType) {
		this.productsType = productsType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", price=" + price + ", number=" + number + ", typeId="
				+ typeId + ", imgUrl=" + imgUrl + ", info=" + info + ", orders=" + orders + ", productsType="
				+ productsType + "]";
	}

}
