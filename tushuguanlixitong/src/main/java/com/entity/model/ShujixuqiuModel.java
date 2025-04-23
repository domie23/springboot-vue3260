package com.entity.model;

import com.entity.ShujixuqiuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 书籍需求
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShujixuqiuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 书籍需求编号
     */
    private String shujixuqiuUuidNumber;


    /**
     * 书籍名称
     */
    private String shujixuqiuName;


    /**
     * 书籍作者
     */
    private String shujixuqiuZuozhe;


    /**
     * 书籍出版社
     */
    private String shujixuqiuChubanshe;


    /**
     * 书籍详情
     */
    private String shujixuqiuContent;


    /**
     * 需求发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 回复内容
     */
    private String shujixuqiuHuifuContent;


    /**
     * 回复时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date updateTime;


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
	 * 获取：书籍需求编号
	 */
    public String getShujixuqiuUuidNumber() {
        return shujixuqiuUuidNumber;
    }


    /**
	 * 设置：书籍需求编号
	 */
    public void setShujixuqiuUuidNumber(String shujixuqiuUuidNumber) {
        this.shujixuqiuUuidNumber = shujixuqiuUuidNumber;
    }
    /**
	 * 获取：书籍名称
	 */
    public String getShujixuqiuName() {
        return shujixuqiuName;
    }


    /**
	 * 设置：书籍名称
	 */
    public void setShujixuqiuName(String shujixuqiuName) {
        this.shujixuqiuName = shujixuqiuName;
    }
    /**
	 * 获取：书籍作者
	 */
    public String getShujixuqiuZuozhe() {
        return shujixuqiuZuozhe;
    }


    /**
	 * 设置：书籍作者
	 */
    public void setShujixuqiuZuozhe(String shujixuqiuZuozhe) {
        this.shujixuqiuZuozhe = shujixuqiuZuozhe;
    }
    /**
	 * 获取：书籍出版社
	 */
    public String getShujixuqiuChubanshe() {
        return shujixuqiuChubanshe;
    }


    /**
	 * 设置：书籍出版社
	 */
    public void setShujixuqiuChubanshe(String shujixuqiuChubanshe) {
        this.shujixuqiuChubanshe = shujixuqiuChubanshe;
    }
    /**
	 * 获取：书籍详情
	 */
    public String getShujixuqiuContent() {
        return shujixuqiuContent;
    }


    /**
	 * 设置：书籍详情
	 */
    public void setShujixuqiuContent(String shujixuqiuContent) {
        this.shujixuqiuContent = shujixuqiuContent;
    }
    /**
	 * 获取：需求发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：需求发布时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：回复内容
	 */
    public String getShujixuqiuHuifuContent() {
        return shujixuqiuHuifuContent;
    }


    /**
	 * 设置：回复内容
	 */
    public void setShujixuqiuHuifuContent(String shujixuqiuHuifuContent) {
        this.shujixuqiuHuifuContent = shujixuqiuHuifuContent;
    }
    /**
	 * 获取：回复时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 设置：回复时间
	 */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
