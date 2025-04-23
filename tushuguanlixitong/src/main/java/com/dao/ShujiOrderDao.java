package com.dao;

import com.entity.ShujiOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShujiOrderView;

/**
 * 书籍借阅订单 Dao 接口
 *
 * @author 
 */
public interface ShujiOrderDao extends BaseMapper<ShujiOrderEntity> {

   List<ShujiOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
