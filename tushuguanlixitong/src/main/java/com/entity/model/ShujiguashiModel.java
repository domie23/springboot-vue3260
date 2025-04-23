package com.entity.model;

import com.entity.ShujiguashiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 书籍挂失
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShujiguashiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 书籍
     */
    private Integer shujiId;


    /**
     * 书籍挂失编号
     */
    private String shujiguashiUuidNumber;


    /**
     * 挂失数量
     */
    private Integer shujiguashiNumber;


    /**
     * 挂失详情
     */
    private String shujiguashiContent;


    /**
     * 逻辑删除
     */
    private Integer shujiguashiDelete;


    /**
     * 创建时间
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
	 * 获取：书籍挂失编号
	 */
    public String getShujiguashiUuidNumber() {
        return shujiguashiUuidNumber;
    }


    /**
	 * 设置：书籍挂失编号
	 */
    public void setShujiguashiUuidNumber(String shujiguashiUuidNumber) {
        this.shujiguashiUuidNumber = shujiguashiUuidNumber;
    }
    /**
	 * 获取：挂失数量
	 */
    public Integer getShujiguashiNumber() {
        return shujiguashiNumber;
    }


    /**
	 * 设置：挂失数量
	 */
    public void setShujiguashiNumber(Integer shujiguashiNumber) {
        this.shujiguashiNumber = shujiguashiNumber;
    }
    /**
	 * 获取：挂失详情
	 */
    public String getShujiguashiContent() {
        return shujiguashiContent;
    }


    /**
	 * 设置：挂失详情
	 */
    public void setShujiguashiContent(String shujiguashiContent) {
        this.shujiguashiContent = shujiguashiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getShujiguashiDelete() {
        return shujiguashiDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setShujiguashiDelete(Integer shujiguashiDelete) {
        this.shujiguashiDelete = shujiguashiDelete;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
