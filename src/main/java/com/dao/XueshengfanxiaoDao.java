package com.dao;

import com.entity.XueshengfanxiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XueshengfanxiaoView;

/**
 * 学生返校申请 Dao 接口
 *
 * @author 
 */
public interface XueshengfanxiaoDao extends BaseMapper<XueshengfanxiaoEntity> {

   List<XueshengfanxiaoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
