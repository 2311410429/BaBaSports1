package com.baba.service.product.impl;

import java.util.List;

import javax.annotation.Resource;

import com.baba.dao.product.TypeDao;
import com.baba.entity.product.Type;
import com.baba.query.product.TypeQuery;
import com.baba.service.product.TypeService;
import com.baba.utils.page.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品类型
 */
@Service
@Transactional
public class TypeServiceImpl implements TypeService {

	@Resource
	private TypeDao typeDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addType(Type type) {
		return typeDao.addType(type);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Type getTypeByKey(Integer id) {
		return typeDao.getTypeByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Type> getTypesByKeys(List<Integer> idList) {
		return typeDao.getTypesByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return typeDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return typeDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateTypeByKey(Type type) {
		return typeDao.updateTypeByKey(type);
	}
	
	@Transactional(readOnly = true)
	public PageBean<Type> getTypeListWithPage(TypeQuery typeQuery) {
		int totalCount = typeDao.getTypeListCount(typeQuery);
		PageBean p = new PageBean(typeQuery.getPageNo(),typeQuery.getPageSize(), totalCount);
		p.setData(typeDao.getTypeListWithPage(typeQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Type> getTypeList(TypeQuery typeQuery) {
		return typeDao.getTypeList(typeQuery);
	}
}
