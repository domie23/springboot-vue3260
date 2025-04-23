package com.entity.model;

import com.entity.ShujiOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 书籍借阅订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShujiOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 借阅单号
     */
    private String shujiOrderUuidNumber;


    /**
     * 书籍
     */
    private Integer shujiId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 借阅时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 还书时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date huanshuTime;


    /**
     * 实际还书时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shijihuanshuTime;


    /**
     * 借阅状态
     */
    private Integer shujiOrderTypes;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：借阅单号
	 */
    public String getShujiOrderUuidNumber() {
        return shujiOrderUuidNumber;
    }


    /**
	 * 设置：借阅单号
	 */
    public void setShujiOrderUuidNumber(String shujiOrderUuidNumber) {
        this.shujiOrderUuidNumber = shujiOrderUuidNumber;
    }
    /**
	 * 获取：书籍
	 */
    public Integer getShujiId() {
        return shujiId;
    }


    /**
	 * 设置：书籍
	 */
    public void setShujiId(Integer shujiId) {
        this.shujiId = shujiId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：借阅时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：借阅时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：还书时间
	 */
    public Date getHuanshuTime() {
        return huanshuTime;
    }


    /**
	 * 设置：还书时间
	 */
    public void setHuanshuTime(Date huanshuTime) {
        this.huanshuTime = huanshuTime;
    }
    /**
	 * 获取：实际还书时间
	 */
    public Date getShijihuanshuTime() {
        return shijihuanshuTime;
    }


    /**
	 * 设置：实际还书时间
	 */
    public void setShijihuanshuTime(Date shijihuanshuTime) {
        this.shijihuanshuTime = shijihuanshuTime;
    }
    /**
	 * 获取：借阅状态
	 */
    public Integer getShujiOrderTypes() {
        return shujiOrderTypes;
    }


    /**
	 * 设置：借阅状态
	 */
    public void setShujiOrderTypes(Integer shujiOrderTypes) {
        this.shujiOrderTypes = shujiOrderTypes;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
