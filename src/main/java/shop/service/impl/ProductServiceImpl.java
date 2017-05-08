package shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.ProductsDao;
import shop.entity.Products;
import shop.service.ProductService;

import java.util.List;

/**
 * Created by Administrator on 2017/5/6.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductsDao pd;
    @Override
    public PageInfo<Products> queryAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Products> productsList=pd.queryAll();
        PageInfo<Products> p=new PageInfo<>(productsList);
        return p;
    }

    @Override
    public int deleteProduct(int productId) {
        return pd.deleteProducts(productId);
    }

    @Override
    public int addProduct(Products p) {
        return pd.insertProducts(p);
    }

    @Override
    public int modifyProduct(Products p) {
        return pd.updateProducts(p);
    }
}
