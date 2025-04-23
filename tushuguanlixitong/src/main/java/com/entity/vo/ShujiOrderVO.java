package com.entity.vo;

import com.entity.ShujiOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 书籍借阅订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shuji_order")
public class ShujiOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 借阅单号
     */

    @TableField(value = "shuji_order_uuid_number")
    private String shujiOrderUuidNumber;


    /**
     * 书籍
     */

    @TableField(value = "shuji_id")
    private Integer shujiId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 借阅时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 还书时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "huanshu_time")
    private Date huanshuTime;


    /**
     * 实际还书时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shijihuanshu_time")
    private Date shijihuanshuTime;


    /**
     * 借阅状态
     */

    @TableField(value = "shuji_order_types")
    private Integer shujiOrderTypes;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：借阅单号
	 */
    public String getShujiOrderUuidNumber() {
        return shujiOrderUuidNumber;
    }


    /**
	 * 获取：借阅单号
	 */

    public void setShujiOrderUuidNumber(String shujiOrderUuidNumber) {
        this.shujiOrderUuidNumber = shujiOrderUuidNumber;
    }
    /**
	 * 设置：书籍
	 */
    public Integer getShujiId() {
        return shujiId;
    }


    /**
	 * 获取：书籍
	 */

    public void setShujiId(Integer shujiId) {
        this.shujiId = shujiId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：借阅时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：借阅时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：还书时间
	 */
    public Date getHuanshuTime() {
        return huanshuTime;
    }


    /**
	 * 获取：还书时间
	 */

    public void setHuanshuTime(Date huanshuTime) {
        this.huanshuTime = huanshuTime;
    }
    /**
	 * 设置：实际还书时间
	 */
    public Date getShijihuanshuTime() {
        return shijihuanshuTime;
    }


    /**
	 * 获取：实际还书时间
	 */

    public void setShijihuanshuTime(Date shijihuanshuTime) {
        this.shijihuanshuTime = shijihuanshuTime;
    }
    /**
	 * 设置：借阅状态
	 */
    public Integer getShujiOrderTypes() {
        return shujiOrderTypes;
    }


    /**
	 * 获取：借阅状态
	 */

    public void setShujiOrderTypes(Integer shujiOrderTypes) {
        this.shujiOrderTypes = shujiOrderTypes;
    }
    /**
	 * 设置：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
