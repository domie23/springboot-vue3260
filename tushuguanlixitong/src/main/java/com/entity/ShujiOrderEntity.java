package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 书籍借阅订单
 *
 * @author 
 * @email
 */
@TableName("shuji_order")
public class ShujiOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShujiOrderEntity() {

	}

	public ShujiOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

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
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ShujiOrder{" +
            "id=" + id +
            ", shujiOrderUuidNumber=" + shujiOrderUuidNumber +
            ", shujiId=" + shujiId +
            ", yonghuId=" + yonghuId +
            ", insertTime=" + insertTime +
            ", huanshuTime=" + huanshuTime +
            ", shijihuanshuTime=" + shijihuanshuTime +
            ", shujiOrderTypes=" + shujiOrderTypes +
            ", createTime=" + createTime +
        "}";
    }
}
