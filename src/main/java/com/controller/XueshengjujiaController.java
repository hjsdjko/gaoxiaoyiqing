















package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.XueshengEntity;
import com.entity.XueshengjujiaEntity;
import com.entity.view.XueshengjujiaView;
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
 * 学生居家信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xueshengjujia")
public class XueshengjujiaController {
    private static final Logger logger = LoggerFactory.getLogger(XueshengjujiaController.class);

    @Autowired
    private XueshengjujiaService xueshengjujiaService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private XueshengService xueshengService;

    @Autowired
    private LaoshiService laoshiService;
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
        PageUtils page = xueshengjujiaService.queryPage(params);

        //字典表数据转换
        List<XueshengjujiaView> list =(List<XueshengjujiaView>)page.getList();
        for(XueshengjujiaView c:list){
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
        XueshengjujiaEntity xueshengjujia = xueshengjujiaService.selectById(id);
        if(xueshengjujia !=null){
            //entity转view
            XueshengjujiaView view = new XueshengjujiaView();
            BeanUtils.copyProperties( xueshengjujia , view );//把实体数据重构到view中

                //级联表
                XueshengEntity xuesheng = xueshengService.selectById(xueshengjujia.getXueshengId());
                if(xuesheng != null){
                    BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXueshengId(xuesheng.getId());
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
    public R save(@RequestBody XueshengjujiaEntity xueshengjujia, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xueshengjujia:{}",this.getClass().getName(),xueshengjujia.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("学生".equals(role))
            xueshengjujia.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        Wrapper<XueshengjujiaEntity> queryWrapper = new EntityWrapper<XueshengjujiaEntity>()
            .eq("xuesheng_id", xueshengjujia.getXueshengId())
//            .eq("jujia_name", xueshengjujia.getJujiaName())
//            .eq("jujia_types", xueshengjujia.getJujiaTypes())
//            .eq("jujiafengxiandengji_types", xueshengjujia.getJujiafengxiandengjiTypes())
//            .eq("tongzhurenyuan_types", xueshengjujia.getTongzhurenyuanTypes())
            .eq("insert_time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XueshengjujiaEntity xueshengjujiaEntity = xueshengjujiaService.selectOne(queryWrapper);
        if(xueshengjujiaEntity==null){
            xueshengjujia.setInsertTime(new Date());
            xueshengjujia.setCreateTime(new Date());
            xueshengjujiaService.insert(xueshengjujia);
            return R.ok();
        }else {
            return R.error(511,"今日有居家记录");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XueshengjujiaEntity xueshengjujia, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xueshengjujia:{}",this.getClass().getName(),xueshengjujia.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("学生".equals(role))
            xueshengjujia.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<XueshengjujiaEntity> queryWrapper = new EntityWrapper<XueshengjujiaEntity>()
            .notIn("id",xueshengjujia.getId())
            .andNew()
            .eq("xuesheng_id", xueshengjujia.getXueshengId())
            .eq("insert_time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XueshengjujiaEntity xueshengjujiaEntity = xueshengjujiaService.selectOne(queryWrapper);
        if(xueshengjujiaEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      xueshengjujia.set
            //  }
            xueshengjujiaService.updateById(xueshengjujia);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"当日有居家记录");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xueshengjujiaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save(String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<XueshengjujiaEntity> xueshengjujiaList = new ArrayList<>();//上传的东西
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
                            XueshengjujiaEntity xueshengjujiaEntity = new XueshengjujiaEntity();
                            xueshengjujiaEntity.setXueshengId(Integer.valueOf(data.get(0)));   //学生 要改的
                            xueshengjujiaEntity.setJujiaName(data.get(0));                    //居家地点 要改的
                            xueshengjujiaEntity.setJujiaTypes(Integer.valueOf(data.get(0)));   //是否隔离 要改的
                            xueshengjujiaEntity.setJujiafengxiandengjiTypes(Integer.valueOf(data.get(0)));   //所在地风险等级 要改的
                            xueshengjujiaEntity.setTongzhurenyuanTypes(Integer.valueOf(data.get(0)));   //同住人员身体状况 要改的
                            xueshengjujiaEntity.setInsertTime(date);//时间
                            xueshengjujiaEntity.setCreateTime(date);//时间
                            xueshengjujiaList.add(xueshengjujiaEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        xueshengjujiaService.insertBatch(xueshengjujiaList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





}
