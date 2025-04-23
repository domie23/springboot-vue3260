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
 * 书籍
 *
 * @author 
 * @email
 */
@TableName("shuji")
public class ShujiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShujiEntity() {

	}

	public ShujiEntity(T t) {
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
     * 书籍编号
     */
    @TableField(value = "shuji_uuid_number")

    private String shujiUuidNumber;


    /**
     * 书籍名称
     */
    @TableField(value = "shuji_name")

    private String shujiName;


    /**
     * 书籍照片
     */
    @TableField(value = "shuji_photo")

    private String shujiPhoto;


    /**
     * 书籍类型
     */
    @TableField(value = "shuji_types")

    private Integer shujiTypes;


    /**
     * 书架
     */
    @TableField(value = "shujia_types")

    private Integer shujiaTypes;


    /**
     * 书籍库存
     */
    @TableField(value = "shuji_kucun_number")

    private Integer shujiKucunNumber;


    /**
     * 热度
     */
    @TableField(value = "shuji_clicknum")

    private Integer shujiClicknum;


    /**
     * 书籍介绍
     */
    @TableField(value = "shuji_content")

    private String shujiContent;


    /**
     * 是否上架
     */
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @TableField(value = "shuji_delete")

    private Integer shujiDelete;


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
	 * 设置：书籍编号
	 */
    public String getShujiUuidNumber() {
        return shujiUuidNumber;
    }
    /**
	 * 获取：书籍编号
	 */

    public void setShujiUuidNumber(String shujiUuidNumber) {
        this.shujiUuidNumber = shujiUuidNumber;
    }
    /**
	 * 设置：书籍名称
	 */
    public String getShujiName() {
        return shujiName;
    }
    /**
	 * 获取：书籍名称
	 */

    public void setShujiName(String shujiName) {
        this.shujiName = shujiName;
    }
    /**
	 * 设置：书籍照片
	 */
    public String getShujiPhoto() {
        return shujiPhoto;
    }
    /**
	 * 获取：书籍照片
	 */

    public void setShujiPhoto(String shujiPhoto) {
        this.shujiPhoto = shujiPhoto;
    }
    /**
	 * 设置：书籍类型
	 */
    public Integer getShujiTypes() {
        return shujiTypes;
    }
    /**
	 * 获取：书籍类型
	 */

    public void setShujiTypes(Integer shujiTypes) {
        this.shujiTypes = shujiTypes;
    }
    /**
	 * 设置：书架
	 */
    public Integer getShujiaTypes() {
        return shujiaTypes;
    }
    /**
	 * 获取：书架
	 */

    public void setShujiaTypes(Integer shujiaTypes) {
        this.shujiaTypes = shujiaTypes;
    }
    /**
	 * 设置：书籍库存
	 */
    public Integer getShujiKucunNumber() {
        return shujiKucunNumber;
    }
    /**
	 * 获取：书籍库存
	 */

    public void setShujiKucunNumber(Integer shujiKucunNumber) {
        this.shujiKucunNumber = shujiKucunNumber;
    }
    /**
	 * 设置：热度
	 */
    public Integer getShujiClicknum() {
        return shujiClicknum;
    }
    /**
	 * 获取：热度
	 */

    public void setShujiClicknum(Integer shujiClicknum) {
        this.shujiClicknum = shujiClicknum;
    }
    /**
	 * 设置：书籍介绍
	 */
    public String getShujiContent() {
        return shujiContent;
    }
    /**
	 * 获取：书籍介绍
	 */

    public void setShujiContent(String shujiContent) {
        this.shujiContent = shujiContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getShujiDelete() {
        return shujiDelete;
    }
    /**
	 * 获取：逻辑删除
	 */

    public void setShujiDelete(Integer shujiDelete) {
        this.shujiDelete = shujiDelete;
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
        return "Shuji{" +
            "id=" + id +
            ", shujiUuidNumber=" + shujiUuidNumber +
            ", shujiName=" + shujiName +
            ", shujiPhoto=" + shujiPhoto +
            ", shujiTypes=" + shujiTypes +
            ", shujiaTypes=" + shujiaTypes +
            ", shujiKucunNumber=" + shujiKucunNumber +
            ", shujiClicknum=" + shujiClicknum +
            ", shujiContent=" + shujiContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", shujiDelete=" + shujiDelete +
            ", createTime=" + createTime +
        "}";
    }
}
