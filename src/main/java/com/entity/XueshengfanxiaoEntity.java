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
 * 学生返校申请
 *
 * @author 
 * @email
 */
@TableName("xueshengfanxiao")
public class XueshengfanxiaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XueshengfanxiaoEntity() {

	}

	public XueshengfanxiaoEntity(T t) {
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
     * 预计返校时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "fanxiao_time")

    private Date fanxiaoTime;


    /**
     * 返校原因
     */
    @TableField(value = "fanxiao_content")

    private String fanxiaoContent;


    /**
     * 是否同意
     */
    @TableField(value = "xueshengfanxiao_yesno_types")

    private Integer xueshengfanxiaoYesnoTypes;


    /**
     * 提交日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
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
	 * 设置：预计返校时间
	 */
    public Date getFanxiaoTime() {
        return fanxiaoTime;
    }


    /**
	 * 获取：预计返校时间
	 */

    public void setFanxiaoTime(Date fanxiaoTime) {
        this.fanxiaoTime = fanxiaoTime;
    }
    /**
	 * 设置：返校原因
	 */
    public String getFanxiaoContent() {
        return fanxiaoContent;
    }


    /**
	 * 获取：返校原因
	 */

    public void setFanxiaoContent(String fanxiaoContent) {
        this.fanxiaoContent = fanxiaoContent;
    }
    /**
	 * 设置：是否同意
	 */
    public Integer getXueshengfanxiaoYesnoTypes() {
        return xueshengfanxiaoYesnoTypes;
    }


    /**
	 * 获取：是否同意
	 */

    public void setXueshengfanxiaoYesnoTypes(Integer xueshengfanxiaoYesnoTypes) {
        this.xueshengfanxiaoYesnoTypes = xueshengfanxiaoYesnoTypes;
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
        return "Xueshengfanxiao{" +
            "id=" + id +
            ", xueshengId=" + xueshengId +
            ", fanxiaoTime=" + fanxiaoTime +
            ", fanxiaoContent=" + fanxiaoContent +
            ", xueshengfanxiaoYesnoTypes=" + xueshengfanxiaoYesnoTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
