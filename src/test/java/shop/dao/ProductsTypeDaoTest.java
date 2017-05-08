package shop.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import shop.entity.ProductsType;

public class ProductsTypeDaoTest extends BaseTest {

	@Autowired
	private ProductsTypeDao ptDao;

	@Test
	public void testInsertType() {
		ProductsType pt = new ProductsType();
		pt.setTypeInfo("测试2");
		pt.setTypeName("测试3");
		ptDao.insertType(pt);
		// 测试通过
	}

	@Test
	public void testDeleteTypeById() {
		ptDao.deleteTypeById(3);
		// 测试通过
	}

	@Test
	public void testUpdateType() {
		ProductsType pt = new ProductsType();
		pt.setId(4);
		pt.setTypeInfo("测试update");
		pt.setTypeName("update666");
		ptDao.updateType(pt);
		// 测试通过
	}

	@Test
	public void testQueryAllType() {
		List<ProductsType> productsTypeList = ptDao.queryAllType();
		for (ProductsType productsType : productsTypeList) {
			System.out.println(productsType);
			// 测试通过
		}
	}

	@Test
	public void testQueryTypeById() {
		ProductsType productsType = ptDao.queryTypeById(4);
		System.out.println(productsType);
		// 测试通过

	}

}
