















package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.LaoshiEntity;
import com.entity.LaoshijujiaEntity;
import com.entity.view.LaoshijujiaView;
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
 * 老师居家信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/laoshijujia")
public class LaoshijujiaController {
    private static final Logger logger = LoggerFactory.getLogger(LaoshijujiaController.class);

    @Autowired
    private LaoshijujiaService laoshijujiaService;


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
        PageUtils page = laoshijujiaService.queryPage(params);

        //字典表数据转换
        List<LaoshijujiaView> list =(List<LaoshijujiaView>)page.getList();
        for(LaoshijujiaView c:list){
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
        LaoshijujiaEntity laoshijujia = laoshijujiaService.selectById(id);
        if(laoshijujia !=null){
            //entity转view
            LaoshijujiaView view = new LaoshijujiaView();
            BeanUtils.copyProperties( laoshijujia , view );//把实体数据重构到view中

                //级联表
                LaoshiEntity laoshi = laoshiService.selectById(laoshijujia.getLaoshiId());
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
    public R save(@RequestBody LaoshijujiaEntity laoshijujia, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,laoshijujia:{}",this.getClass().getName(),laoshijujia.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("老师".equals(role))
            laoshijujia.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        Wrapper<LaoshijujiaEntity> queryWrapper = new EntityWrapper<LaoshijujiaEntity>()
            .eq("laoshi_id", laoshijujia.getLaoshiId())
            .eq("insert_time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LaoshijujiaEntity laoshijujiaEntity = laoshijujiaService.selectOne(queryWrapper);
        if(laoshijujiaEntity==null){
            laoshijujia.setInsertTime(new Date());
            laoshijujia.setCreateTime(new Date());
            laoshijujiaService.insert(laoshijujia);
            return R.ok();
        }else {
            return R.error(511,"今日已添加居家记录");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LaoshijujiaEntity laoshijujia, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,laoshijujia:{}",this.getClass().getName(),laoshijujia.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("老师".equals(role))
            laoshijujia.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<LaoshijujiaEntity> queryWrapper = new EntityWrapper<LaoshijujiaEntity>()
            .notIn("id",laoshijujia.getId())
            .andNew()
            .eq("laoshi_id", laoshijujia.getLaoshiId())
            .eq("insert_time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LaoshijujiaEntity laoshijujiaEntity = laoshijujiaService.selectOne(queryWrapper);
        if(laoshijujiaEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      laoshijujia.set
            //  }
            laoshijujiaService.updateById(laoshijujia);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"当日已添加居家记录");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        laoshijujiaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save(String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<LaoshijujiaEntity> laoshijujiaList = new ArrayList<>();//上传的东西
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
                            LaoshijujiaEntity laoshijujiaEntity = new LaoshijujiaEntity();
                            laoshijujiaEntity.setLaoshiId(Integer.valueOf(data.get(0)));   //学生 要改的
                            laoshijujiaEntity.setJujiaName(data.get(0));                    //居家地点 要改的
                            laoshijujiaEntity.setJujiaTypes(Integer.valueOf(data.get(0)));   //是否隔离 要改的
                            laoshijujiaEntity.setJujiafengxiandengjiTypes(Integer.valueOf(data.get(0)));   //所在地风险等级 要改的
                            laoshijujiaEntity.setTongzhurenyuanTypes(Integer.valueOf(data.get(0)));   //同住人员身体状况 要改的
                            laoshijujiaEntity.setInsertTime(date);//时间
                            laoshijujiaEntity.setCreateTime(date);//时间
                            laoshijujiaList.add(laoshijujiaEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        laoshijujiaService.insertBatch(laoshijujiaList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





}
