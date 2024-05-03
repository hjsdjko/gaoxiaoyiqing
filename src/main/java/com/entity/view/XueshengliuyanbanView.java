package com.entity.view;

import com.entity.XueshengliuyanbanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 留言板
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xueshengliuyanban")
public class XueshengliuyanbanView extends XueshengliuyanbanEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 留言类型的值
		*/
		private String xueshengliuyanbanValue;



		//级联表 caozuorenyuan
			/**
			* 操作人员姓名
			*/
			private String caozuorenyuanName;
			/**
			* 操作人员电话
			*/
			private String caozuorenyuanPhone;
			/**
			* 操作人员身份证号
			*/
			private String caozuorenyuanIdNumber;
			/**
			* 操作人员头像
			*/
			private String caozuorenyuanPhoto;

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

	public XueshengliuyanbanView() {

	}

	public XueshengliuyanbanView(XueshengliuyanbanEntity xueshengliuyanbanEntity) {
		try {
			BeanUtils.copyProperties(this, xueshengliuyanbanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 留言类型的值
			*/
			public String getXueshengliuyanbanValue() {
				return xueshengliuyanbanValue;
			}
			/**
			* 设置： 留言类型的值
			*/
			public void setXueshengliuyanbanValue(String xueshengliuyanbanValue) {
				this.xueshengliuyanbanValue = xueshengliuyanbanValue;
			}





				//级联表的get和set caozuorenyuan
					/**
					* 获取： 操作人员姓名
					*/
					public String getCaozuorenyuanName() {
						return caozuorenyuanName;
					}
					/**
					* 设置： 操作人员姓名
					*/
					public void setCaozuorenyuanName(String caozuorenyuanName) {
						this.caozuorenyuanName = caozuorenyuanName;
					}
					/**
					* 获取： 操作人员电话
					*/
					public String getCaozuorenyuanPhone() {
						return caozuorenyuanPhone;
					}
					/**
					* 设置： 操作人员电话
					*/
					public void setCaozuorenyuanPhone(String caozuorenyuanPhone) {
						this.caozuorenyuanPhone = caozuorenyuanPhone;
					}
					/**
					* 获取： 操作人员身份证号
					*/
					public String getCaozuorenyuanIdNumber() {
						return caozuorenyuanIdNumber;
					}
					/**
					* 设置： 操作人员身份证号
					*/
					public void setCaozuorenyuanIdNumber(String caozuorenyuanIdNumber) {
						this.caozuorenyuanIdNumber = caozuorenyuanIdNumber;
					}
					/**
					* 获取： 操作人员头像
					*/
					public String getCaozuorenyuanPhoto() {
						return caozuorenyuanPhoto;
					}
					/**
					* 设置： 操作人员头像
					*/
					public void setCaozuorenyuanPhoto(String caozuorenyuanPhoto) {
						this.caozuorenyuanPhoto = caozuorenyuanPhoto;
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
