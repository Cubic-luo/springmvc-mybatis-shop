package shop.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import shop.entity.Products;

public class ProductsDaoTest extends BaseTest {

	@Autowired
	private ProductsDao productsDao;

	@Test
	public void testQueryById() {
		Products products = productsDao.queryById(1);
		System.out.print(products);
	}

	// 测试通过
	@Test
	public void testQueryAll() {
		List<Products> productsList = productsDao.queryAll();
		for (Products products : productsList) {
			System.out.println(products);
		}
	}
	@Test
	public void testQueryByOrderId() {
		List<Products> productsList = productsDao.queryByOrderId(1);
		for (Products products : productsList) {
			System.out.println(products);
		}
	}
	@Test
	public void testQueryByTpeyId(){
		List<Products> productsList = productsDao.queryByTpeyId(1);
		for (Products products : productsList) {
			System.out.println(products);
		}
	}
	// 测试通过
	@Test
	public void testInsertProducts() {
		Products products = new Products();
		products.setImgUrl("1.png");
		products.setInfo("测试数据");
		products.setName("测试的菜");
		products.setNumber(1);
		products.setPrice(28);
		products.setTypeId(1);
		productsDao.insertProducts(products);
		// 测试通过

	}

	@Test
	public void testDeleteProducts() {
		productsDao.deleteProducts(1);
		// 测试通过
	}

	@Test
	public void testUpdateProducts() {
		Products products = new Products();
		products.setId(1);
		products.setImgUrl("1");
		products.setInfo("测试update22");
		products.setName("测试的菜");
		products.setNumber(99);
		products.setPrice(8);
		products.setTypeId(2);
		productsDao.updateProducts(products);
		// 测试通过
	}

}
