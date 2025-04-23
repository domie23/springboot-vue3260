package com.entity.vo;

import com.entity.ShujixuqiuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 书籍需求
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shujixuqiu")
public class ShujixuqiuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 书籍需求编号
     */

    @TableField(value = "shujixuqiu_uuid_number")
    private String shujixuqiuUuidNumber;


    /**
     * 书籍名称
     */

    @TableField(value = "shujixuqiu_name")
    private String shujixuqiuName;


    /**
     * 书籍作者
     */

    @TableField(value = "shujixuqiu_zuozhe")
    private String shujixuqiuZuozhe;


    /**
     * 书籍出版社
     */

    @TableField(value = "shujixuqiu_chubanshe")
    private String shujixuqiuChubanshe;


    /**
     * 书籍详情
     */

    @TableField(value = "shujixuqiu_content")
    private String shujixuqiuContent;


    /**
     * 需求发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 回复内容
     */

    @TableField(value = "shujixuqiu_huifu_content")
    private String shujixuqiuHuifuContent;


    /**
     * 回复时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "update_time")
    private Date updateTime;


    /**
     * 创建时间
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
	 * 设置：书籍需求编号
	 */
    public String getShujixuqiuUuidNumber() {
        return shujixuqiuUuidNumber;
    }


    /**
	 * 获取：书籍需求编号
	 */

    public void setShujixuqiuUuidNumber(String shujixuqiuUuidNumber) {
        this.shujixuqiuUuidNumber = shujixuqiuUuidNumber;
    }
    /**
	 * 设置：书籍名称
	 */
    public String getShujixuqiuName() {
        return shujixuqiuName;
    }


    /**
	 * 获取：书籍名称
	 */

    public void setShujixuqiuName(String shujixuqiuName) {
        this.shujixuqiuName = shujixuqiuName;
    }
    /**
	 * 设置：书籍作者
	 */
    public String getShujixuqiuZuozhe() {
        return shujixuqiuZuozhe;
    }


    /**
	 * 获取：书籍作者
	 */

    public void setShujixuqiuZuozhe(String shujixuqiuZuozhe) {
        this.shujixuqiuZuozhe = shujixuqiuZuozhe;
    }
    /**
	 * 设置：书籍出版社
	 */
    public String getShujixuqiuChubanshe() {
        return shujixuqiuChubanshe;
    }


    /**
	 * 获取：书籍出版社
	 */

    public void setShujixuqiuChubanshe(String shujixuqiuChubanshe) {
        this.shujixuqiuChubanshe = shujixuqiuChubanshe;
    }
    /**
	 * 设置：书籍详情
	 */
    public String getShujixuqiuContent() {
        return shujixuqiuContent;
    }


    /**
	 * 获取：书籍详情
	 */

    public void setShujixuqiuContent(String shujixuqiuContent) {
        this.shujixuqiuContent = shujixuqiuContent;
    }
    /**
	 * 设置：需求发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：需求发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：回复内容
	 */
    public String getShujixuqiuHuifuContent() {
        return shujixuqiuHuifuContent;
    }


    /**
	 * 获取：回复内容
	 */

    public void setShujixuqiuHuifuContent(String shujixuqiuHuifuContent) {
        this.shujixuqiuHuifuContent = shujixuqiuHuifuContent;
    }
    /**
	 * 设置：回复时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 获取：回复时间
	 */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

}
