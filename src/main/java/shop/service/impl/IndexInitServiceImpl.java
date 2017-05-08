package shop.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.dao.DiscussDao;
import shop.dao.ProductsTypeDao;
import shop.entity.Discuss;
import shop.entity.ProductsType;
import shop.service.IndexInitService;

@Service
public class IndexInitServiceImpl implements IndexInitService {
	@Autowired
	private ProductsTypeDao ptDao;
	@Autowired
	private DiscussDao discussDao;

	/*
	 * 返回对所有商品类型及其所属商品的查询，用于展示
	 * 
	 * @see shop.service.IndexInitService#queryAllProducts()
	 */
	@Override
	public List<ProductsType> queryAllProducts() {
		List<ProductsType> ptList = ptDao.queryAllType();
		return ptList;
	}

	/*
	 * 返回所与评论，用于展示
	 * 
	 * @see shop.service.IndexInitService#queryAllDiscsss()
	 */
	@Override
	public List<Discuss> queryAllDiscsss() {
		PageHelper.startPage(1,5);
		List<Discuss> discussList = discussDao.queryAll();
		return discussList;
	}

}
