package com.entity.view;

import com.entity.ShujiguashiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 书籍挂失
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shujiguashi")
public class ShujiguashiView extends ShujiguashiEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 shuji
			/**
			* 书籍编号
			*/
			private String shujiUuidNumber;
			/**
			* 书籍名称
			*/
			private String shujiName;
			/**
			* 书籍照片
			*/
			private String shujiPhoto;
			/**
			* 书籍类型
			*/
			private Integer shujiTypes;
				/**
				* 书籍类型的值
				*/
				private String shujiValue;
			/**
			* 书架
			*/
			private Integer shujiaTypes;
				/**
				* 书架的值
				*/
				private String shujiaValue;
			/**
			* 书籍库存
			*/
			private Integer shujiKucunNumber;
			/**
			* 热度
			*/
			private Integer shujiClicknum;
			/**
			* 书籍介绍
			*/
			private String shujiContent;
			/**
			* 是否上架
			*/
			private Integer shangxiaTypes;
				/**
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer shujiDelete;

	public ShujiguashiView() {

	}

	public ShujiguashiView(ShujiguashiEntity shujiguashiEntity) {
		try {
			BeanUtils.copyProperties(this, shujiguashiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}











				//级联表的get和set shuji

					/**
					* 获取： 书籍编号
					*/
					public String getShujiUuidNumber() {
						return shujiUuidNumber;
					}
					/**
					* 设置： 书籍编号
					*/
					public void setShujiUuidNumber(String shujiUuidNumber) {
						this.shujiUuidNumber = shujiUuidNumber;
					}

					/**
					* 获取： 书籍名称
					*/
					public String getShujiName() {
						return shujiName;
					}
					/**
					* 设置： 书籍名称
					*/
					public void setShujiName(String shujiName) {
						this.shujiName = shujiName;
					}

					/**
					* 获取： 书籍照片
					*/
					public String getShujiPhoto() {
						return shujiPhoto;
					}
					/**
					* 设置： 书籍照片
					*/
					public void setShujiPhoto(String shujiPhoto) {
						this.shujiPhoto = shujiPhoto;
					}

					/**
					* 获取： 书籍类型
					*/
					public Integer getShujiTypes() {
						return shujiTypes;
					}
					/**
					* 设置： 书籍类型
					*/
					public void setShujiTypes(Integer shujiTypes) {
						this.shujiTypes = shujiTypes;
					}


						/**
						* 获取： 书籍类型的值
						*/
						public String getShujiValue() {
							return shujiValue;
						}
						/**
						* 设置： 书籍类型的值
						*/
						public void setShujiValue(String shujiValue) {
							this.shujiValue = shujiValue;
						}

					/**
					* 获取： 书架
					*/
					public Integer getShujiaTypes() {
						return shujiaTypes;
					}
					/**
					* 设置： 书架
					*/
					public void setShujiaTypes(Integer shujiaTypes) {
						this.shujiaTypes = shujiaTypes;
					}


						/**
						* 获取： 书架的值
						*/
						public String getShujiaValue() {
							return shujiaValue;
						}
						/**
						* 设置： 书架的值
						*/
						public void setShujiaValue(String shujiaValue) {
							this.shujiaValue = shujiaValue;
						}

					/**
					* 获取： 书籍库存
					*/
					public Integer getShujiKucunNumber() {
						return shujiKucunNumber;
					}
					/**
					* 设置： 书籍库存
					*/
					public void setShujiKucunNumber(Integer shujiKucunNumber) {
						this.shujiKucunNumber = shujiKucunNumber;
					}

					/**
					* 获取： 热度
					*/
					public Integer getShujiClicknum() {
						return shujiClicknum;
					}
					/**
					* 设置： 热度
					*/
					public void setShujiClicknum(Integer shujiClicknum) {
						this.shujiClicknum = shujiClicknum;
					}

					/**
					* 获取： 书籍介绍
					*/
					public String getShujiContent() {
						return shujiContent;
					}
					/**
					* 设置： 书籍介绍
					*/
					public void setShujiContent(String shujiContent) {
						this.shujiContent = shujiContent;
					}

					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}

					/**
					* 获取： 逻辑删除
					*/
					public Integer getShujiDelete() {
						return shujiDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setShujiDelete(Integer shujiDelete) {
						this.shujiDelete = shujiDelete;
					}














}
