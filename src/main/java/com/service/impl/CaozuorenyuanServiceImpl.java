package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import com.dao.CaozuorenyuanDao;
import com.entity.CaozuorenyuanEntity;
import com.service.CaozuorenyuanService;
import com.entity.view.CaozuorenyuanView;

/**
 * 操作人员 服务实现类
 */
@Service("caozuorenyuanService")
@Transactional
public class CaozuorenyuanServiceImpl extends ServiceImpl<CaozuorenyuanDao, CaozuorenyuanEntity> implements CaozuorenyuanService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<CaozuorenyuanView> page =new Query<CaozuorenyuanView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
