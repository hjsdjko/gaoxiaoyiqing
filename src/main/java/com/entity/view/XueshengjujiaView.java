package com.entity.view;

import com.entity.XueshengjujiaEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 学生居家信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xueshengjujia")
public class XueshengjujiaView extends XueshengjujiaEntity implements Serializable {
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



		//级联表 xuesheng
			/**
			* 学号
			*/
			private String xueshengUuidNumber;
			/**
			* 学生姓名
			*/
			private String xueshengName;
			/**
			* 学生手机号
			*/
			private String xueshengPhone;
			/**
			* 学生身份证号
			*/
			private String xueshengIdNumber;
			/**
			* 学生照片
			*/
			private String xueshengPhoto;
			/**
			* 电子邮箱
			*/
			private String xueshengEmail;
			/**
			* 住宅住址
			*/
			private String xueshengAddress;

	public XueshengjujiaView() {

	}

	public XueshengjujiaView(XueshengjujiaEntity xueshengjujiaEntity) {
		try {
			BeanUtils.copyProperties(this, xueshengjujiaEntity);
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


















				//级联表的get和set xuesheng
					/**
					* 获取： 学号
					*/
					public String getXueshengUuidNumber() {
						return xueshengUuidNumber;
					}
					/**
					* 设置： 学号
					*/
					public void setXueshengUuidNumber(String xueshengUuidNumber) {
						this.xueshengUuidNumber = xueshengUuidNumber;
					}
					/**
					* 获取： 学生姓名
					*/
					public String getXueshengName() {
						return xueshengName;
					}
					/**
					* 设置： 学生姓名
					*/
					public void setXueshengName(String xueshengName) {
						this.xueshengName = xueshengName;
					}
					/**
					* 获取： 学生手机号
					*/
					public String getXueshengPhone() {
						return xueshengPhone;
					}
					/**
					* 设置： 学生手机号
					*/
					public void setXueshengPhone(String xueshengPhone) {
						this.xueshengPhone = xueshengPhone;
					}
					/**
					* 获取： 学生身份证号
					*/
					public String getXueshengIdNumber() {
						return xueshengIdNumber;
					}
					/**
					* 设置： 学生身份证号
					*/
					public void setXueshengIdNumber(String xueshengIdNumber) {
						this.xueshengIdNumber = xueshengIdNumber;
					}
					/**
					* 获取： 学生照片
					*/
					public String getXueshengPhoto() {
						return xueshengPhoto;
					}
					/**
					* 设置： 学生照片
					*/
					public void setXueshengPhoto(String xueshengPhoto) {
						this.xueshengPhoto = xueshengPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getXueshengEmail() {
						return xueshengEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setXueshengEmail(String xueshengEmail) {
						this.xueshengEmail = xueshengEmail;
					}
					/**
					* 获取： 住宅住址
					*/
					public String getXueshengAddress() {
						return xueshengAddress;
					}
					/**
					* 设置： 住宅住址
					*/
					public void setXueshengAddress(String xueshengAddress) {
						this.xueshengAddress = xueshengAddress;
					}














}
