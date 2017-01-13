package com.baba.test;

import com.baba.entity.product.Brand;
import com.baba.entity.product.Product;
import com.baba.query.BasicQuery;
import com.baba.query.OrderField;
import com.baba.query.product.BrandQuery;
import com.baba.query.product.ProductQuery;
import com.baba.service.product.BrandService;
import com.baba.service.product.ProductService;
import com.baba.utils.SpringJunitTestUtil;
import com.baba.utils.page.PageBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/1/9.
 */

public class ServiceTest extends SpringJunitTestUtil {

    @Autowired
    private ProductService productService;

    @Autowired
    private BrandService brandService;

    @Test
    public void fun123423() throws Exception {
        BrandQuery brandQuery = new BrandQuery();
        brandQuery.setPageNo(3);
        brandQuery.getOrderFields().add(new OrderField("id","desc"));
        PageBean<Brand> pageBean = brandService.findBrandsWidthPage(brandQuery);
        List<Brand> data = pageBean.getData();
        for (Brand brand : data) {
            System.out.println(brand);
        }
    }


    @Test
    public void fun2() throws Exception {
        ProductQuery productQuery = new ProductQuery();
        productQuery.setPageNo(8);

        PageBean<Product> pageBean= productService.getProductListWithPage(productQuery);
        for (Product product : pageBean.getData()) {
            System.out.println(product);
        }
    }

}