package com.baba.service.product.impl;

import java.util.List;

import javax.annotation.Resource;

import com.baba.dao.product.FeatureDao;
import com.baba.entity.product.Color;
import com.baba.entity.product.Feature;
import com.baba.query.product.FeatureQuery;
import com.baba.service.product.FeatureService;
import com.baba.utils.page.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品属性事务层
 */
@Service
@Transactional
public class FeatureServiceImpl implements FeatureService {

	@Resource
	private FeatureDao featureDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addFeature(Feature feature) {
		return featureDao.addFeature(feature);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Feature getFeatureByKey(Integer id) {
		return featureDao.getFeatureByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Feature> getFeaturesByKeys(List<Integer> idList) {
		return featureDao.getFeaturesByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return featureDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return featureDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateFeatureByKey(Feature feature) {
		return featureDao.updateFeatureByKey(feature);
	}
	
	@Transactional(readOnly = true)
	public PageBean<Feature> getFeatureListWithPage(FeatureQuery featureQuery) {
		PageBean<Feature> p = new PageBean<Feature>(featureQuery.getPageNo(),featureQuery.getPageSize(),featureDao.getFeatureListCount(featureQuery));
		p.setData(featureDao.getFeatureListWithPage(featureQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Feature> getFeatureList(FeatureQuery featureQuery) {
		return featureDao.getFeatureList(featureQuery);
	}
}
