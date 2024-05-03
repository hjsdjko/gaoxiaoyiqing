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
 * 学生居家信息
 *
 * @author 
 * @email
 */
@TableName("xueshengjujia")
public class XueshengjujiaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XueshengjujiaEntity() {

	}

	public XueshengjujiaEntity(T t) {
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
     * 学生
     */
    @TableField(value = "xuesheng_id")

    private Integer xueshengId;


    /**
     * 居家地点
     */
    @TableField(value = "jujia_name")

    private String jujiaName;


    /**
     * 是否隔离
     */
    @TableField(value = "jujia_types")

    private Integer jujiaTypes;


    /**
     * 所在地风险等级
     */
    @TableField(value = "jujiafengxiandengji_types")

    private Integer jujiafengxiandengjiTypes;


    /**
     * 同住人员身体状况
     */
    @TableField(value = "tongzhurenyuan_types")

    private Integer tongzhurenyuanTypes;


    /**
     * 提交日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 设置：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }


    /**
	 * 获取：学生
	 */

    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 设置：居家地点
	 */
    public String getJujiaName() {
        return jujiaName;
    }


    /**
	 * 获取：居家地点
	 */

    public void setJujiaName(String jujiaName) {
        this.jujiaName = jujiaName;
    }
    /**
	 * 设置：是否隔离
	 */
    public Integer getJujiaTypes() {
        return jujiaTypes;
    }


    /**
	 * 获取：是否隔离
	 */

    public void setJujiaTypes(Integer jujiaTypes) {
        this.jujiaTypes = jujiaTypes;
    }
    /**
	 * 设置：所在地风险等级
	 */
    public Integer getJujiafengxiandengjiTypes() {
        return jujiafengxiandengjiTypes;
    }


    /**
	 * 获取：所在地风险等级
	 */

    public void setJujiafengxiandengjiTypes(Integer jujiafengxiandengjiTypes) {
        this.jujiafengxiandengjiTypes = jujiafengxiandengjiTypes;
    }
    /**
	 * 设置：同住人员身体状况
	 */
    public Integer getTongzhurenyuanTypes() {
        return tongzhurenyuanTypes;
    }


    /**
	 * 获取：同住人员身体状况
	 */

    public void setTongzhurenyuanTypes(Integer tongzhurenyuanTypes) {
        this.tongzhurenyuanTypes = tongzhurenyuanTypes;
    }
    /**
	 * 设置：提交日期
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：提交日期
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Xueshengjujia{" +
            "id=" + id +
            ", xueshengId=" + xueshengId +
            ", jujiaName=" + jujiaName +
            ", jujiaTypes=" + jujiaTypes +
            ", jujiafengxiandengjiTypes=" + jujiafengxiandengjiTypes +
            ", tongzhurenyuanTypes=" + tongzhurenyuanTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
