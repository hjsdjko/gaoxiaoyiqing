















package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.LaoshiEntity;
import com.entity.LaoshidakaEntity;
import com.entity.view.LaoshidakaView;
import com.service.*;
import com.utils.PageUtils;
import com.utils.PoiUtil;
import com.utils.R;
import com.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 老师打卡信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/laoshidaka")
public class LaoshidakaController {
    private static final Logger logger = LoggerFactory.getLogger(LaoshidakaController.class);

    @Autowired
    private LaoshidakaService laoshidakaService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private LaoshiService laoshiService;

    @Autowired
    private XueshengService xueshengService;
    @Autowired
    private CaozuorenyuanService caozuorenyuanService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("学生".equals(role))
            params.put("xueshengId",request.getSession().getAttribute("userId"));
        else if("老师".equals(role))
            params.put("laoshiId",request.getSession().getAttribute("userId"));
        else if("操作人员".equals(role))
            params.put("caozuorenyuanId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = laoshidakaService.queryPage(params);

        //字典表数据转换
        List<LaoshidakaView> list =(List<LaoshidakaView>)page.getList();
        for(LaoshidakaView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        LaoshidakaEntity laoshidaka = laoshidakaService.selectById(id);
        if(laoshidaka !=null){
            //entity转view
            LaoshidakaView view = new LaoshidakaView();
            BeanUtils.copyProperties( laoshidaka , view );//把实体数据重构到view中

                //级联表
                LaoshiEntity laoshi = laoshiService.selectById(laoshidaka.getLaoshiId());
                if(laoshi != null){
                    BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLaoshiId(laoshi.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody LaoshidakaEntity laoshidaka, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,laoshidaka:{}",this.getClass().getName(),laoshidaka.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("老师".equals(role))
            laoshidaka.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        Wrapper<LaoshidakaEntity> queryWrapper = new EntityWrapper<LaoshidakaEntity>()
            .eq("laoshi_id", laoshidaka.getLaoshiId())
            .eq("insert_time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LaoshidakaEntity laoshidakaEntity = laoshidakaService.selectOne(queryWrapper);
        if(laoshidakaEntity==null){
            laoshidaka.setInsertTime(new Date());
            laoshidaka.setCreateTime(new Date());
            laoshidakaService.insert(laoshidaka);
            return R.ok();
        }else {
            return R.error(511,"今日已打卡");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LaoshidakaEntity laoshidaka, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,laoshidaka:{}",this.getClass().getName(),laoshidaka.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("老师".equals(role))
            laoshidaka.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<LaoshidakaEntity> queryWrapper = new EntityWrapper<LaoshidakaEntity>()
            .notIn("id",laoshidaka.getId())
            .andNew()
            .eq("laoshi_id", laoshidaka.getLaoshiId())
            .eq("insert_time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LaoshidakaEntity laoshidakaEntity = laoshidakaService.selectOne(queryWrapper);
        if(laoshidakaEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      laoshidaka.set
            //  }
            laoshidakaService.updateById(laoshidaka);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"当日已打卡");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        laoshidakaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save(String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<LaoshidakaEntity> laoshidakaList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            LaoshidakaEntity laoshidakaEntity = new LaoshidakaEntity();
                            laoshidakaEntity.setLaoshiId(Integer.valueOf(data.get(0)));   //老师 要改的
                            laoshidakaEntity.setDakaName(data.get(0));                    //打卡地点 要改的
                            laoshidakaEntity.setDakaContent("");//照片
                            laoshidakaEntity.setJiankangTypes(Integer.valueOf(data.get(0)));   //是否健康 要改的
                            laoshidakaEntity.setInsertTime(date);//时间
                            laoshidakaEntity.setCreateTime(date);//时间
                            laoshidakaList.add(laoshidakaEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        laoshidakaService.insertBatch(laoshidakaList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





}
