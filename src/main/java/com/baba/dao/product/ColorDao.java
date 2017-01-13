package com.baba.dao.product;

import com.baba.entity.product.Color;
import com.baba.query.product.ColorQuery;

import java.util.List;

public interface ColorDao {

	/**
	 * 添加
	 * @param color
	 */
	public Integer addColor(Color color);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public Color getColorByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<Color> getColorsByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * @param id
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * @param idList
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 * @param color
	 */
	public Integer updateColorByKey(Color color);

	/**
	 * 分页查询
	 * @param colorQuery
	 */
	public List<Color> getColorListWithPage(ColorQuery colorQuery);

	/**
	 * 集合查询
	 * @param colorQuery
	 */
	public List<Color> getColorList(ColorQuery colorQuery);
	
	/**
	 * 总条数
	 * @param colorQuery
	 */
	public int getColorListCount(ColorQuery colorQuery);
}
