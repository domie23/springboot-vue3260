package com.entity.view;

import com.entity.ShujiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 书籍
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shuji")
public class ShujiView extends ShujiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 书籍类型的值
		*/
		private String shujiValue;
		/**
		* 书架的值
		*/
		private String shujiaValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



	public ShujiView() {

	}

	public ShujiView(ShujiEntity shujiEntity) {
		try {
			BeanUtils.copyProperties(this, shujiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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












}
