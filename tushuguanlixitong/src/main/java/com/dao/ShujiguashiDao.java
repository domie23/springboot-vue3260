package com.dao;

import com.entity.ShujiguashiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShujiguashiView;

/**
 * 书籍挂失 Dao 接口
 *
 * @author 
 */
public interface ShujiguashiDao extends BaseMapper<ShujiguashiEntity> {

   List<ShujiguashiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
