















package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.CaozuorenyuanEntity;
import com.entity.view.CaozuorenyuanView;
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
import java.util.*;

/**
 * 操作人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/caozuorenyuan")
public class CaozuorenyuanController {
    private static final Logger logger = LoggerFactory.getLogger(CaozuorenyuanController.class);

    @Autowired
    private CaozuorenyuanService caozuorenyuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private XueshengService xueshengService;
    @Autowired
    private LaoshiService laoshiService;


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
        params.put("caozuorenyuanDeleteStart",1);params.put("caozuorenyuanDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = caozuorenyuanService.queryPage(params);

        //字典表数据转换
        List<CaozuorenyuanView> list =(List<CaozuorenyuanView>)page.getList();
        for(CaozuorenyuanView c:list){
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
        CaozuorenyuanEntity caozuorenyuan = caozuorenyuanService.selectById(id);
        if(caozuorenyuan !=null){
            //entity转view
            CaozuorenyuanView view = new CaozuorenyuanView();
            BeanUtils.copyProperties( caozuorenyuan , view );//把实体数据重构到view中

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
    public R save(@RequestBody CaozuorenyuanEntity caozuorenyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,caozuorenyuan:{}",this.getClass().getName(),caozuorenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        Wrapper<CaozuorenyuanEntity> queryWrapper = new EntityWrapper<CaozuorenyuanEntity>()
            .eq("username", caozuorenyuan.getUsername())
            .or()
            .eq("caozuorenyuan_phone", caozuorenyuan.getCaozuorenyuanPhone())
            .or()
            .eq("caozuorenyuan_id_number", caozuorenyuan.getCaozuorenyuanIdNumber())
            .andNew()
            .eq("caozuorenyuan_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CaozuorenyuanEntity caozuorenyuanEntity = caozuorenyuanService.selectOne(queryWrapper);
        if(caozuorenyuanEntity==null){
            caozuorenyuan.setCaozuorenyuanDelete(1);
            caozuorenyuan.setCreateTime(new Date());
            caozuorenyuan.setPassword("123456");
            caozuorenyuanService.insert(caozuorenyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者操作人员电话或者操作人员身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CaozuorenyuanEntity caozuorenyuan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,caozuorenyuan:{}",this.getClass().getName(),caozuorenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<CaozuorenyuanEntity> queryWrapper = new EntityWrapper<CaozuorenyuanEntity>()
            .notIn("id",caozuorenyuan.getId())
            .andNew()
            .eq("username", caozuorenyuan.getUsername())
            .or()
            .eq("caozuorenyuan_phone", caozuorenyuan.getCaozuorenyuanPhone())
            .or()
            .eq("caozuorenyuan_id_number", caozuorenyuan.getCaozuorenyuanIdNumber())
            .andNew()
            .eq("caozuorenyuan_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CaozuorenyuanEntity caozuorenyuanEntity = caozuorenyuanService.selectOne(queryWrapper);
        if("".equals(caozuorenyuan.getCaozuorenyuanPhoto()) || "null".equals(caozuorenyuan.getCaozuorenyuanPhoto())){
                caozuorenyuan.setCaozuorenyuanPhoto(null);
        }
        if(caozuorenyuanEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      caozuorenyuan.set
            //  }
            caozuorenyuanService.updateById(caozuorenyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者操作人员电话或者操作人员身份证号已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        caozuorenyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save(String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<CaozuorenyuanEntity> caozuorenyuanList = new ArrayList<>();//上传的东西
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
                            CaozuorenyuanEntity caozuorenyuanEntity = new CaozuorenyuanEntity();
                            caozuorenyuanEntity.setUsername(data.get(0));                    //账户 要改的
                            caozuorenyuanEntity.setPassword("123456");//密码
                            caozuorenyuanEntity.setCaozuorenyuanName(data.get(0));                    //操作人员姓名 要改的
                            caozuorenyuanEntity.setCaozuorenyuanPhone(data.get(0));                    //操作人员电话 要改的
                            caozuorenyuanEntity.setCaozuorenyuanIdNumber(data.get(0));                    //操作人员身份证号 要改的
                            caozuorenyuanEntity.setCaozuorenyuanPhoto("");//照片
                            caozuorenyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //操作人员性别 要改的
                            caozuorenyuanEntity.setCaozuorenyuanDelete(1);//逻辑删除字段
                            caozuorenyuanEntity.setCreateTime(date);//时间
                            caozuorenyuanList.add(caozuorenyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //操作人员电话
                                if(seachFields.containsKey("caozuorenyuanPhone")){
                                    List<String> caozuorenyuanPhone = seachFields.get("caozuorenyuanPhone");
                                    caozuorenyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> caozuorenyuanPhone = new ArrayList<>();
                                    caozuorenyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("caozuorenyuanPhone",caozuorenyuanPhone);
                                }
                                //操作人员身份证号
                                if(seachFields.containsKey("caozuorenyuanIdNumber")){
                                    List<String> caozuorenyuanIdNumber = seachFields.get("caozuorenyuanIdNumber");
                                    caozuorenyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> caozuorenyuanIdNumber = new ArrayList<>();
                                    caozuorenyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("caozuorenyuanIdNumber",caozuorenyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<CaozuorenyuanEntity> caozuorenyuanEntities_username = caozuorenyuanService.selectList(new EntityWrapper<CaozuorenyuanEntity>().in("username", seachFields.get("username")));
                        if(caozuorenyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CaozuorenyuanEntity s:caozuorenyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //操作人员电话
                        List<CaozuorenyuanEntity> caozuorenyuanEntities_caozuorenyuanPhone = caozuorenyuanService.selectList(new EntityWrapper<CaozuorenyuanEntity>().in("caozuorenyuan_phone", seachFields.get("caozuorenyuanPhone")));
                        if(caozuorenyuanEntities_caozuorenyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CaozuorenyuanEntity s:caozuorenyuanEntities_caozuorenyuanPhone){
                                repeatFields.add(s.getCaozuorenyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [操作人员电话] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //操作人员身份证号
                        List<CaozuorenyuanEntity> caozuorenyuanEntities_caozuorenyuanIdNumber = caozuorenyuanService.selectList(new EntityWrapper<CaozuorenyuanEntity>().in("caozuorenyuan_id_number", seachFields.get("caozuorenyuanIdNumber")));
                        if(caozuorenyuanEntities_caozuorenyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CaozuorenyuanEntity s:caozuorenyuanEntities_caozuorenyuanIdNumber){
                                repeatFields.add(s.getCaozuorenyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [操作人员身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        caozuorenyuanService.insertBatch(caozuorenyuanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        CaozuorenyuanEntity caozuorenyuan = caozuorenyuanService.selectOne(new EntityWrapper<CaozuorenyuanEntity>().eq("username", username));
        if(caozuorenyuan==null || !caozuorenyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(caozuorenyuan.getCaozuorenyuanDelete() != 1)
            return R.error("账户已被删除");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(caozuorenyuan.getId(),username, "caozuorenyuan", "操作人员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","操作人员");
        r.put("username",caozuorenyuan.getCaozuorenyuanName());
        r.put("tableName","caozuorenyuan");
        r.put("userId",caozuorenyuan.getId());
        return r;
    }

    /**
    * 注册
    */
        @IgnoreAuth
        @PostMapping(value = "/register")
        public R register(@RequestBody CaozuorenyuanEntity caozuorenyuan){
    //    	ValidatorUtils.validateEntity(user);
        Wrapper<CaozuorenyuanEntity> queryWrapper = new EntityWrapper<CaozuorenyuanEntity>()
		    .eq("username", caozuorenyuan.getUsername())
		    .or()
            .eq("caozuorenyuan_phone", caozuorenyuan.getCaozuorenyuanPhone())
		    .or()
            .eq("caozuorenyuan_id_number", caozuorenyuan.getCaozuorenyuanIdNumber())
            .andNew()
            .eq("caozuorenyuan_delete", 1)
            ;
        CaozuorenyuanEntity caozuorenyuanEntity = caozuorenyuanService.selectOne(queryWrapper);
        if(caozuorenyuanEntity != null)
            return R.error("账户或者操作人员电话或者操作人员身份证号已经被使用");
                caozuorenyuan.setCaozuorenyuanDelete(1);
        caozuorenyuan.setCreateTime(new Date());
        caozuorenyuanService.insert(caozuorenyuan);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        CaozuorenyuanEntity caozuorenyuan = new CaozuorenyuanEntity();
        caozuorenyuan.setPassword("123456");
        caozuorenyuan.setId(id);
        caozuorenyuanService.updateById(caozuorenyuan);
        return R.ok();
    }

    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrCaozuorenyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        CaozuorenyuanEntity caozuorenyuan = caozuorenyuanService.selectById(id);
        if(caozuorenyuan !=null){
            //entity转view
            CaozuorenyuanView view = new CaozuorenyuanView();
            BeanUtils.copyProperties( caozuorenyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }





}
