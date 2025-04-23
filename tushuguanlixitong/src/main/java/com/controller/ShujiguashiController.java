
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 书籍挂失
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shujiguashi")
public class ShujiguashiController {
    private static final Logger logger = LoggerFactory.getLogger(ShujiguashiController.class);

    @Autowired
    private ShujiguashiService shujiguashiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private ShujiService shujiService;

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("shujiguashiDeleteStart",1);params.put("shujiguashiDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = shujiguashiService.queryPage(params);

        //字典表数据转换
        List<ShujiguashiView> list =(List<ShujiguashiView>)page.getList();
        for(ShujiguashiView c:list){
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
        ShujiguashiEntity shujiguashi = shujiguashiService.selectById(id);
        if(shujiguashi !=null){
            //entity转view
            ShujiguashiView view = new ShujiguashiView();
            BeanUtils.copyProperties( shujiguashi , view );//把实体数据重构到view中

                //级联表
                ShujiEntity shuji = shujiService.selectById(shujiguashi.getShujiId());
                if(shuji != null){
                    BeanUtils.copyProperties( shuji , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShujiId(shuji.getId());
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
    public R save(@RequestBody ShujiguashiEntity shujiguashi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shujiguashi:{}",this.getClass().getName(),shujiguashi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ShujiguashiEntity> queryWrapper = new EntityWrapper<ShujiguashiEntity>()
            .eq("shuji_id", shujiguashi.getShujiId())
            .eq("shujiguashi_uuid_number", shujiguashi.getShujiguashiUuidNumber())
            .eq("shujiguashi_number", shujiguashi.getShujiguashiNumber())
            .eq("shujiguashi_delete", shujiguashi.getShujiguashiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShujiguashiEntity shujiguashiEntity = shujiguashiService.selectOne(queryWrapper);
        if(shujiguashiEntity==null){
            shujiguashi.setShujiguashiDelete(1);
            shujiguashi.setCreateTime(new Date());
            shujiguashiService.insert(shujiguashi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShujiguashiEntity shujiguashi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shujiguashi:{}",this.getClass().getName(),shujiguashi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ShujiguashiEntity> queryWrapper = new EntityWrapper<ShujiguashiEntity>()
            .notIn("id",shujiguashi.getId())
            .andNew()
            .eq("shuji_id", shujiguashi.getShujiId())
            .eq("shujiguashi_uuid_number", shujiguashi.getShujiguashiUuidNumber())
            .eq("shujiguashi_number", shujiguashi.getShujiguashiNumber())
            .eq("shujiguashi_delete", shujiguashi.getShujiguashiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShujiguashiEntity shujiguashiEntity = shujiguashiService.selectOne(queryWrapper);
        if(shujiguashiEntity==null){
            shujiguashiService.updateById(shujiguashi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<ShujiguashiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ShujiguashiEntity shujiguashiEntity = new ShujiguashiEntity();
            shujiguashiEntity.setId(id);
            shujiguashiEntity.setShujiguashiDelete(2);
            list.add(shujiguashiEntity);
        }
        if(list != null && list.size() >0){
            shujiguashiService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ShujiguashiEntity> shujiguashiList = new ArrayList<>();//上传的东西
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
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ShujiguashiEntity shujiguashiEntity = new ShujiguashiEntity();
//                            shujiguashiEntity.setShujiId(Integer.valueOf(data.get(0)));   //书籍 要改的
//                            shujiguashiEntity.setShujiguashiUuidNumber(data.get(0));                    //书籍挂失编号 要改的
//                            shujiguashiEntity.setShujiguashiNumber(Integer.valueOf(data.get(0)));   //挂失数量 要改的
//                            shujiguashiEntity.setShujiguashiContent("");//详情和图片
//                            shujiguashiEntity.setShujiguashiDelete(1);//逻辑删除字段
//                            shujiguashiEntity.setCreateTime(date);//时间
                            shujiguashiList.add(shujiguashiEntity);


                            //把要查询是否重复的字段放入map中
                                //书籍挂失编号
                                if(seachFields.containsKey("shujiguashiUuidNumber")){
                                    List<String> shujiguashiUuidNumber = seachFields.get("shujiguashiUuidNumber");
                                    shujiguashiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shujiguashiUuidNumber = new ArrayList<>();
                                    shujiguashiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shujiguashiUuidNumber",shujiguashiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //书籍挂失编号
                        List<ShujiguashiEntity> shujiguashiEntities_shujiguashiUuidNumber = shujiguashiService.selectList(new EntityWrapper<ShujiguashiEntity>().in("shujiguashi_uuid_number", seachFields.get("shujiguashiUuidNumber")).eq("shujiguashi_delete", 1));
                        if(shujiguashiEntities_shujiguashiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShujiguashiEntity s:shujiguashiEntities_shujiguashiUuidNumber){
                                repeatFields.add(s.getShujiguashiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [书籍挂失编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shujiguashiService.insertBatch(shujiguashiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = shujiguashiService.queryPage(params);

        //字典表数据转换
        List<ShujiguashiView> list =(List<ShujiguashiView>)page.getList();
        for(ShujiguashiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShujiguashiEntity shujiguashi = shujiguashiService.selectById(id);
            if(shujiguashi !=null){


                //entity转view
                ShujiguashiView view = new ShujiguashiView();
                BeanUtils.copyProperties( shujiguashi , view );//把实体数据重构到view中

                //级联表
                    ShujiEntity shuji = shujiService.selectById(shujiguashi.getShujiId());
                if(shuji != null){
                    BeanUtils.copyProperties( shuji , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShujiId(shuji.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ShujiguashiEntity shujiguashi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shujiguashi:{}",this.getClass().getName(),shujiguashi.toString());
        Wrapper<ShujiguashiEntity> queryWrapper = new EntityWrapper<ShujiguashiEntity>()
            .eq("shuji_id", shujiguashi.getShujiId())
            .eq("shujiguashi_uuid_number", shujiguashi.getShujiguashiUuidNumber())
            .eq("shujiguashi_number", shujiguashi.getShujiguashiNumber())
            .eq("shujiguashi_delete", shujiguashi.getShujiguashiDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShujiguashiEntity shujiguashiEntity = shujiguashiService.selectOne(queryWrapper);
        if(shujiguashiEntity==null){
            shujiguashi.setShujiguashiDelete(1);
            shujiguashi.setCreateTime(new Date());
        shujiguashiService.insert(shujiguashi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
