package shop.service;

import com.github.pagehelper.PageInfo;
import shop.entity.Products;

/**
 * Created by Administrator on 2017/5/6.
 * 商品
 */
public interface ProductService {
    /**
     * 查询所有商品信息
     * @param pageNum 页码
     * @param pageSize 每页显示数量
     * @return
     */
    public PageInfo<Products> queryAll(int pageNum, int pageSize);

    /**
     * 删除商品
     * @param productId 商品id
     * @return 修改的记录数
     */
    public int deleteProduct(int productId);

    /**
     * 增加商品
     * @param p
     * @return
     */
    public int addProduct(Products p);

    /**
     * 修改商品
     * @param p
     * @return
     */
    public int modifyProduct(Products p);

}
