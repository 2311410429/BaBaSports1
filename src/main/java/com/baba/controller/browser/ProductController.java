package com.baba.controller.browser;


import com.baba.entity.product.*;
import com.baba.query.OrderField;
import com.baba.query.product.*;
import com.baba.service.product.*;
import com.baba.utils.Constants;
import com.baba.utils.page.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private ProductService productService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private FeatureService featureService;

    @Autowired
    private ColorService colorService;


    @RequestMapping("/add")
    public String add(ModelMap modelMap){
        //获取产品类别
        TypeQuery typeQuery = new TypeQuery();
        typeQuery.setFields("id,name");
        typeQuery.setParentId(0);
        List<Type> typeList = typeService.getTypeList(typeQuery);
        for (Type type :typeList)
            System.out.println(type);
        modelMap.addAttribute("typeList",typeList);

        //获取所有的商标
        getAllBrands(modelMap);

        //获取所有的材质
        FeatureQuery featureQuery = new FeatureQuery();
        featureQuery.setFields("id,name");
        List<Feature> featureList = featureService.getFeatureList(featureQuery);
        modelMap.addAttribute("featureList",featureList);

        //获取所有的颜色
        ColorQuery colorQuery = new ColorQuery();
        colorQuery.setFields("id,name");
        colorQuery.setParentId(0);
        List<Color> colorList = colorService.getColorList(colorQuery);
        modelMap.addAttribute("colorList",colorList);

        return "product/add";
    }

    @RequestMapping("/list")
    public String list(String name, Integer brandId, Integer isShow,Integer pageNo, ModelMap modelMap){
        StringBuffer params = new StringBuffer(); //分页用


        getAllBrands(modelMap);
        //商品信息

        ProductQuery productQuery = new ProductQuery();
        if (StringUtils.isNotBlank(name)) {
            productQuery.setName(name);
            productQuery.setNameLike(true);
            params.append("name=").append(name);
            modelMap.addAttribute("name",name); //数据回显
        }
        if (null != brandId) {
            productQuery.setBrandId(brandId);
            params.append("&brandId=").append(brandId);
            modelMap.addAttribute("brandId",brandId); //数据回显
        }
        if (null != isShow) {
            productQuery.setIsShow(isShow);
            params.append("&isShow=").append(isShow);
            modelMap.addAttribute("isShow",isShow); //数据回显
        }else{
            productQuery.setIsShow(0);
            params.append("&isShow=").append(0);
            modelMap.addAttribute("isShow",0); //数据回显
        }
        productQuery.setFields("id,no,name,description,is_new,is_hot,is_commend");

        productQuery.setPageNo(PageBean.cpn(pageNo)); //页号

        PageBean<Product> productListPageBean = productService.getProductListWithPage(productQuery);
        modelMap.addAttribute("productListPageBean",productListPageBean);
        productListPageBean.pageView("/product/list.do", params.toString());

        for(Product product : productListPageBean.getData())
            System.out.println(product);

        System.out.println(params.toString());
        return "product/list";
    }

    /**
     * 获取商标类别，并将其放到ModelMap中
     * @param modelMap
     */
    private void getAllBrands(ModelMap modelMap) {
        BrandQuery brandQuery = new BrandQuery();
        brandQuery.setFields("id,name");
        brandQuery.getOrderFields().add(new OrderField("sort","desc"));
        List<Brand> allBrands = brandService.findBrands(brandQuery);
        System.out.println(allBrands.size());
        modelMap.addAttribute("allBrands",allBrands);
    }
}
