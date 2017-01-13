package com.baba.test;

import com.baba.dao.product.BrandDao;
import com.baba.dao.product.ProductDao;
import com.baba.entity.product.Brand;
import com.baba.entity.product.Product;
import com.baba.query.BasicQuery;
import com.baba.query.OrderField;
import com.baba.query.product.BrandQuery;
import com.baba.query.product.ProductQuery;
import com.baba.utils.SpringJunitTestUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/1/11.
 */
public class DaoTest extends SpringJunitTestUtil {

    @Autowired
    private SqlSessionFactory sessionFactory;

    @Test
    public void fun1() {
        SqlSession session = sessionFactory.openSession();
        ProductDao productDao = session.getMapper(ProductDao.class);
        ProductQuery productQuery = new ProductQuery();
        productQuery.setFields("id,no");

        productQuery.getOrderFields().add(new OrderField("no","desc"));
        productQuery.getOrderFields().add(new OrderField("id","asc"));

        List<Product> productList = productDao.getProductList(productQuery);
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    @Test
    public void fun2() {
        SqlSession session = sessionFactory.openSession();

        ProductDao productDao = session.getMapper(ProductDao.class);

        ProductQuery productQuery = new ProductQuery();
        productQuery.setPageNo(8);

        List<Product> productList = productDao.getProductListWithPage(productQuery);
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    @Test
    public void fun3() {
        SqlSession session = sessionFactory.openSession();

        BrandDao brandDao = session.getMapper(BrandDao.class);
        BrandQuery brandQuery = new BrandQuery();
        brandQuery.setName("莲");
        brandQuery.setNameLike(true);

        int res = brandDao.selectBrandAmount(brandQuery);
        System.out.println(res);
    }

    @Test
    public void fun4() {
        SqlSession session = sessionFactory.openSession();

        BrandDao brandDao = session.getMapper(BrandDao.class);

        BrandQuery brandQuery = new BrandQuery();
        brandQuery.getOrderFields().add(new OrderField("id","desc"));

        List<Brand> brands = brandDao.selectBrands(brandQuery);
        for(Brand brand : brands)
            System.out.println(brand);
    }

    @Test
    public void fun5() {
        SqlSession session = sessionFactory.openSession();

        BrandDao brandDao = session.getMapper(BrandDao.class);
        BrandQuery brandQuery = new BrandQuery();
        brandQuery.setPageNo(4);

        List<Brand> brands = brandDao.selectBrandsWidthPage(brandQuery);
        for(Brand brand : brands)
            System.out.println(brand);
    }


}
