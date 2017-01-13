package com.baba.service.product.impl;

import java.util.List;

import javax.annotation.Resource;

import com.baba.dao.product.ProductDao;
import com.baba.entity.product.Product;
import com.baba.query.BasicQuery;
import com.baba.query.product.ProductQuery;
import com.baba.service.product.ProductService;
import com.baba.utils.page.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品事务层
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Resource
	ProductDao productDao;
	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addProduct(Product product) {
		return productDao.addProduct(product);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Product getProductByKey(Integer id) {
		return productDao.getProductByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Product> getProductsByKeys(List<Integer> idList) {
		return productDao.getProductsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return productDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return productDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateProductByKey(Product product) {
		return productDao.updateProductByKey(product);
	}
	
	@Transactional(readOnly = true)
	public PageBean getProductListWithPage(ProductQuery productQuery) {
        int pageNo = productQuery.getPageNo();
        int pageSize = productQuery.getPageSize();

        int totalAmount = productDao.getProductListCount(productQuery);
        PageBean pageBean = new PageBean(pageNo, pageSize, totalAmount);
		List<Product> products = productDao.getProductListWithPage(productQuery);
        pageBean.setData(products);
		return pageBean;
	}
	
	@Transactional(readOnly = true)
	public List<Product> getProductList(ProductQuery productQuery) {
		return productDao.getProductList(productQuery);
	}
}
