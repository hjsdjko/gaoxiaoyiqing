package com.entity.view;

import com.entity.LaoshidakaEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 老师打卡信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("laoshidaka")
public class LaoshidakaView extends LaoshidakaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 是否健康的值
		*/
		private String jiankangValue;



		//级联表 laoshi
			/**
			* 老师姓名
			*/
			private String laoshiName;
			/**
			* 老师手机号
			*/
			private String laoshiPhone;
			/**
			* 老师身份证号
			*/
			private String laoshiIdNumber;
			/**
			* 老师照片
			*/
			private String laoshiPhoto;
			/**
			* 电子邮箱
			*/
			private String laoshiEmail;
			/**
			* 住宅住址
			*/
			private String laoshiAddress;

	public LaoshidakaView() {

	}

	public LaoshidakaView(LaoshidakaEntity laoshidakaEntity) {
		try {
			BeanUtils.copyProperties(this, laoshidakaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 是否健康的值
			*/
			public String getJiankangValue() {
				return jiankangValue;
			}
			/**
			* 设置： 是否健康的值
			*/
			public void setJiankangValue(String jiankangValue) {
				this.jiankangValue = jiankangValue;
			}








				//级联表的get和set laoshi
					/**
					* 获取： 老师姓名
					*/
					public String getLaoshiName() {
						return laoshiName;
					}
					/**
					* 设置： 老师姓名
					*/
					public void setLaoshiName(String laoshiName) {
						this.laoshiName = laoshiName;
					}
					/**
					* 获取： 老师手机号
					*/
					public String getLaoshiPhone() {
						return laoshiPhone;
					}
					/**
					* 设置： 老师手机号
					*/
					public void setLaoshiPhone(String laoshiPhone) {
						this.laoshiPhone = laoshiPhone;
					}
					/**
					* 获取： 老师身份证号
					*/
					public String getLaoshiIdNumber() {
						return laoshiIdNumber;
					}
					/**
					* 设置： 老师身份证号
					*/
					public void setLaoshiIdNumber(String laoshiIdNumber) {
						this.laoshiIdNumber = laoshiIdNumber;
					}
					/**
					* 获取： 老师照片
					*/
					public String getLaoshiPhoto() {
						return laoshiPhoto;
					}
					/**
					* 设置： 老师照片
					*/
					public void setLaoshiPhoto(String laoshiPhoto) {
						this.laoshiPhoto = laoshiPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getLaoshiEmail() {
						return laoshiEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setLaoshiEmail(String laoshiEmail) {
						this.laoshiEmail = laoshiEmail;
					}
					/**
					* 获取： 住宅住址
					*/
					public String getLaoshiAddress() {
						return laoshiAddress;
					}
					/**
					* 设置： 住宅住址
					*/
					public void setLaoshiAddress(String laoshiAddress) {
						this.laoshiAddress = laoshiAddress;
					}
























}
