package com.baba.service.product.impl;

import java.util.List;

import javax.annotation.Resource;

import com.baba.dao.product.ColorDao;
import com.baba.entity.product.Color;
import com.baba.query.product.ColorQuery;
import com.baba.service.product.ColorService;
import com.baba.utils.page.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 颜色
 */
@Service
@Transactional
public class ColorServiceImpl implements ColorService {

	@Resource
	private ColorDao colorDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addColor(Color color) {
		return colorDao.addColor(color);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Color getColorByKey(Integer id) {
		return colorDao.getColorByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Color> getColorsByKeys(List<Integer> idList) {
		return colorDao.getColorsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return colorDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return colorDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateColorByKey(Color color) {
		return colorDao.updateColorByKey(color);
	}
	
	@Transactional(readOnly = true)
	public PageBean<Color> getColorListWithPage(ColorQuery colorQuery) {
		PageBean<Color> p = new PageBean<>(colorQuery.getPageNo(),colorQuery.getPageSize(),colorDao.getColorListCount(colorQuery));
		p.setData(colorDao.getColorListWithPage(colorQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Color> getColorList(ColorQuery colorQuery) {
		return colorDao.getColorList(colorQuery);
	}
}
