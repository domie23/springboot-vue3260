package com.thread;

import com.entity.ShujiEntity;
import com.entity.ShujiOrderEntity;
import com.entity.view.ShujiOrderView;
import com.service.ShujiOrderService;
import com.utils.PageUtils;
import org.apache.poi.hssf.record.chart.DatRecord;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 线程执行方法（做一些项目启动后 一直要执行的操作，比如根据时间自动更改订单状态，比如订单签收30天自动收货功能，比如根据时间来更改状态）
 */
public class MyThreadMethod extends Thread  {
    private ShujiOrderService shujiOrderService;
    public void run() {
        while (!this.isInterrupted()) {// 线程未中断执行循环

            System.out.println("----------------------------查询未还书的超时借阅书籍-------------------------------------------------------");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = sdf.format(new Date());

            Map<String, Object> params = new HashMap<>();
            params.put("orderBy","id");
            params.put("huanshuTimeEnd",date);
            PageUtils page = shujiOrderService.queryPage(params);
            List<ShujiOrderView> list = (List<ShujiOrderView>) page.getList();
            if(list != null && list.size()>0){
                List<ShujiOrderEntity> shujiEntities = new ArrayList<>();
                for(ShujiOrderView s:list){
                    ShujiOrderEntity shujiOrderEntity = new ShujiOrderEntity();
                    shujiOrderEntity.setId(s.getId());
                    shujiOrderEntity.setShujiOrderTypes(3);
                    shujiEntities.add(shujiOrderEntity);
                }
                System.out.println("----------------------------更新了"+shujiEntities.size()+"条书籍借阅状态-------------------------------------------------------");
                shujiOrderService.updateBatchById(shujiEntities);
            }

            try {
                Thread.sleep(5000); //每隔2000ms执行一次
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//			 ------------------ 开始执行 ---------------------------
//            System.out.println("线程执行中:" + System.currentTimeMillis());
        }
    }

    public ShujiOrderService getShujiOrderService() {
        return shujiOrderService;
    }

    public void setShujiOrderService(ShujiOrderService shujiOrderService) {
        this.shujiOrderService = shujiOrderService;
    }
}
