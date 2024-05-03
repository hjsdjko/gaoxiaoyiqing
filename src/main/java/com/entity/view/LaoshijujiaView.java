package com.entity.view;

import com.entity.LaoshijujiaEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 老师居家信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("laoshijujia")
public class LaoshijujiaView extends LaoshijujiaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 是否隔离的值
		*/
		private String jujiaValue;
		/**
		* 所在地风险等级的值
		*/
		private String jujiafengxiandengjiValue;
		/**
		* 同住人员身体状况的值
		*/
		private String tongzhurenyuanValue;



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

	public LaoshijujiaView() {

	}

	public LaoshijujiaView(LaoshijujiaEntity laoshijujiaEntity) {
		try {
			BeanUtils.copyProperties(this, laoshijujiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 是否隔离的值
			*/
			public String getJujiaValue() {
				return jujiaValue;
			}
			/**
			* 设置： 是否隔离的值
			*/
			public void setJujiaValue(String jujiaValue) {
				this.jujiaValue = jujiaValue;
			}
			/**
			* 获取： 所在地风险等级的值
			*/
			public String getJujiafengxiandengjiValue() {
				return jujiafengxiandengjiValue;
			}
			/**
			* 设置： 所在地风险等级的值
			*/
			public void setJujiafengxiandengjiValue(String jujiafengxiandengjiValue) {
				this.jujiafengxiandengjiValue = jujiafengxiandengjiValue;
			}
			/**
			* 获取： 同住人员身体状况的值
			*/
			public String getTongzhurenyuanValue() {
				return tongzhurenyuanValue;
			}
			/**
			* 设置： 同住人员身体状况的值
			*/
			public void setTongzhurenyuanValue(String tongzhurenyuanValue) {
				this.tongzhurenyuanValue = tongzhurenyuanValue;
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
