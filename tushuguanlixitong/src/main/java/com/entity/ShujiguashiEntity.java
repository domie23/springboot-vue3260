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
 * 书籍挂失
 *
 * @author 
 * @email
 */
@TableName("shujiguashi")
public class ShujiguashiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShujiguashiEntity() {

	}

	public ShujiguashiEntity(T t) {
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
     * 书籍
     */
    @TableField(value = "shuji_id")

    private Integer shujiId;


    /**
     * 书籍挂失编号
     */
    @TableField(value = "shujiguashi_uuid_number")

    private String shujiguashiUuidNumber;


    /**
     * 挂失数量
     */
    @TableField(value = "shujiguashi_number")

    private Integer shujiguashiNumber;


    /**
     * 挂失详情
     */
    @TableField(value = "shujiguashi_content")

    private String shujiguashiContent;


    /**
     * 逻辑删除
     */
    @TableField(value = "shujiguashi_delete")

    private Integer shujiguashiDelete;


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
	 * 设置：书籍挂失编号
	 */
    public String getShujiguashiUuidNumber() {
        return shujiguashiUuidNumber;
    }
    /**
	 * 获取：书籍挂失编号
	 */

    public void setShujiguashiUuidNumber(String shujiguashiUuidNumber) {
        this.shujiguashiUuidNumber = shujiguashiUuidNumber;
    }
    /**
	 * 设置：挂失数量
	 */
    public Integer getShujiguashiNumber() {
        return shujiguashiNumber;
    }
    /**
	 * 获取：挂失数量
	 */

    public void setShujiguashiNumber(Integer shujiguashiNumber) {
        this.shujiguashiNumber = shujiguashiNumber;
    }
    /**
	 * 设置：挂失详情
	 */
    public String getShujiguashiContent() {
        return shujiguashiContent;
    }
    /**
	 * 获取：挂失详情
	 */

    public void setShujiguashiContent(String shujiguashiContent) {
        this.shujiguashiContent = shujiguashiContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getShujiguashiDelete() {
        return shujiguashiDelete;
    }
    /**
	 * 获取：逻辑删除
	 */

    public void setShujiguashiDelete(Integer shujiguashiDelete) {
        this.shujiguashiDelete = shujiguashiDelete;
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
        return "Shujiguashi{" +
            "id=" + id +
            ", shujiId=" + shujiId +
            ", shujiguashiUuidNumber=" + shujiguashiUuidNumber +
            ", shujiguashiNumber=" + shujiguashiNumber +
            ", shujiguashiContent=" + shujiguashiContent +
            ", shujiguashiDelete=" + shujiguashiDelete +
            ", createTime=" + createTime +
        "}";
    }
}
