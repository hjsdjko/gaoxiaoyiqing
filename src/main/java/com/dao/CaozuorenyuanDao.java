package com.dao;

import com.entity.CaozuorenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.CaozuorenyuanView;

/**
 * 操作人员 Dao 接口
 *
 * @author 
 */
public interface CaozuorenyuanDao extends BaseMapper<CaozuorenyuanEntity> {

   List<CaozuorenyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
