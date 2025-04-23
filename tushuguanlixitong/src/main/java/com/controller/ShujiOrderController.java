
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
 * 书籍借阅订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shujiOrder")
public class ShujiOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ShujiOrderController.class);

    @Autowired
    private ShujiOrderService shujiOrderService;


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
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = shujiOrderService.queryPage(params);

        //字典表数据转换
        List<ShujiOrderView> list =(List<ShujiOrderView>)page.getList();
        for(ShujiOrderView c:list){
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
        ShujiOrderEntity shujiOrder = shujiOrderService.selectById(id);
        if(shujiOrder !=null){
            //entity转view
            ShujiOrderView view = new ShujiOrderView();
            BeanUtils.copyProperties( shujiOrder , view );//把实体数据重构到view中

                //级联表
                ShujiEntity shuji = shujiService.selectById(shujiOrder.getShujiId());
                if(shuji != null){
                    BeanUtils.copyProperties( shuji , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShujiId(shuji.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(shujiOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
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
    public R save(@RequestBody ShujiOrderEntity shujiOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shujiOrder:{}",this.getClass().getName(),shujiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            shujiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        shujiOrder.setInsertTime(new Date());
        shujiOrder.setCreateTime(new Date());
        shujiOrderService.insert(shujiOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShujiOrderEntity shujiOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shujiOrder:{}",this.getClass().getName(),shujiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            shujiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ShujiOrderEntity> queryWrapper = new EntityWrapper<ShujiOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShujiOrderEntity shujiOrderEntity = shujiOrderService.selectOne(queryWrapper);
        if(shujiOrderEntity==null){
            shujiOrderService.updateById(shujiOrder);//根据id更新
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
        shujiOrderService.deleteBatchIds(Arrays.asList(ids));
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
            List<ShujiOrderEntity> shujiOrderList = new ArrayList<>();//上传的东西
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
                            ShujiOrderEntity shujiOrderEntity = new ShujiOrderEntity();
//                            shujiOrderEntity.setShujiOrderUuidNumber(data.get(0));                    //借阅单号 要改的
//                            shujiOrderEntity.setShujiId(Integer.valueOf(data.get(0)));   //书籍 要改的
//                            shujiOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            shujiOrderEntity.setInsertTime(date);//时间
//                            shujiOrderEntity.setHuanshuTime(sdf.parse(data.get(0)));          //还书时间 要改的
//                            shujiOrderEntity.setShijihuanshuTime(sdf.parse(data.get(0)));          //实际还书时间 要改的
//                            shujiOrderEntity.setShujiOrderTypes(Integer.valueOf(data.get(0)));   //借阅状态 要改的
//                            shujiOrderEntity.setCreateTime(date);//时间
                            shujiOrderList.add(shujiOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //借阅单号
                                if(seachFields.containsKey("shujiOrderUuidNumber")){
                                    List<String> shujiOrderUuidNumber = seachFields.get("shujiOrderUuidNumber");
                                    shujiOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shujiOrderUuidNumber = new ArrayList<>();
                                    shujiOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shujiOrderUuidNumber",shujiOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //借阅单号
                        List<ShujiOrderEntity> shujiOrderEntities_shujiOrderUuidNumber = shujiOrderService.selectList(new EntityWrapper<ShujiOrderEntity>().in("shuji_order_uuid_number", seachFields.get("shujiOrderUuidNumber")));
                        if(shujiOrderEntities_shujiOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShujiOrderEntity s:shujiOrderEntities_shujiOrderUuidNumber){
                                repeatFields.add(s.getShujiOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [借阅单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shujiOrderService.insertBatch(shujiOrderList);
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
        PageUtils page = shujiOrderService.queryPage(params);

        //字典表数据转换
        List<ShujiOrderView> list =(List<ShujiOrderView>)page.getList();
        for(ShujiOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShujiOrderEntity shujiOrder = shujiOrderService.selectById(id);
            if(shujiOrder !=null){


                //entity转view
                ShujiOrderView view = new ShujiOrderView();
                BeanUtils.copyProperties( shujiOrder , view );//把实体数据重构到view中

                //级联表
                    ShujiEntity shuji = shujiService.selectById(shujiOrder.getShujiId());
                if(shuji != null){
                    BeanUtils.copyProperties( shuji , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShujiId(shuji.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(shujiOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
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
    public R add(@RequestBody ShujiOrderEntity shujiOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shujiOrder:{}",this.getClass().getName(),shujiOrder.toString());
            ShujiEntity shujiEntity = shujiService.selectById(shujiOrder.getShujiId());
            if(shujiEntity == null){
                return R.error(511,"查不到该书籍");
            }
            // Double shujiNewMoney = shujiEntity.getShujiNewMoney();

            if(false){
            }
            else if((shujiEntity.getShujiKucunNumber() -1)<0){
                return R.error(511,"书籍库存不够啦");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            shujiOrder.setYonghuId(userId); //设置订单支付人id
            shujiOrder.setShujiOrderUuidNumber(String.valueOf(new Date().getTime()));
            shujiOrder.setInsertTime(new Date());
            shujiOrder.setCreateTime(new Date());
        shujiOrder.setShujiOrderTypes(1);
                shujiEntity.setShujiKucunNumber( shujiEntity.getShujiKucunNumber() -1);
                shujiService.updateById(shujiEntity);
                shujiOrderService.insert(shujiOrder);//新增订单
            return R.ok();
    }



    /**
     * 还书
     */
    @RequestMapping("/huanshu")
    public R huanshu(@RequestParam("id") Integer id){
        logger.debug("huanshu:,,Controller:{},,id:{}",this.getClass().getName(),id.toString());

        ShujiOrderEntity shujiOrderEntity = shujiOrderService.selectById(id);
        if(shujiOrderEntity == null)
            return R.error("查不到书籍借阅订单");
        ShujiEntity shujiEntity = shujiService.selectById(shujiOrderEntity);
        if(shujiEntity == null)
            return R.error("查不到书籍");
        shujiOrderEntity.setShijihuanshuTime(new Date());
        shujiOrderEntity.setShujiOrderTypes(2);
        shujiOrderService.updateById(shujiOrderEntity);
        shujiEntity.setShujiKucunNumber(shujiEntity.getShujiKucunNumber()+1);
        shujiService.updateById(shujiEntity);

        return R.ok();
    }

















}
