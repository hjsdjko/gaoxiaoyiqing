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
 * 学生请假管理
 *
 * @author 
 * @email
 */
@TableName("xueshengqingjia")
public class XueshengqingjiaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XueshengqingjiaEntity() {

	}

	public XueshengqingjiaEntity(T t) {
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
     * 请假开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "qingjia_start_time")

    private Date qingjiaStartTime;


    /**
     * 请假结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "qingjia_end_time")

    private Date qingjiaEndTime;


    /**
     * 请假原因
     */
    @TableField(value = "qingjia_content")

    private String qingjiaContent;


    /**
     * 是否同意
     */
    @TableField(value = "xueshengqingjia_yesno_types")

    private Integer xueshengqingjiaYesnoTypes;


    /**
     * 申请日期
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
	 * 设置：请假开始时间
	 */
    public Date getQingjiaStartTime() {
        return qingjiaStartTime;
    }


    /**
	 * 获取：请假开始时间
	 */

    public void setQingjiaStartTime(Date qingjiaStartTime) {
        this.qingjiaStartTime = qingjiaStartTime;
    }
    /**
	 * 设置：请假结束时间
	 */
    public Date getQingjiaEndTime() {
        return qingjiaEndTime;
    }


    /**
	 * 获取：请假结束时间
	 */

    public void setQingjiaEndTime(Date qingjiaEndTime) {
        this.qingjiaEndTime = qingjiaEndTime;
    }
    /**
	 * 设置：请假原因
	 */
    public String getQingjiaContent() {
        return qingjiaContent;
    }


    /**
	 * 获取：请假原因
	 */

    public void setQingjiaContent(String qingjiaContent) {
        this.qingjiaContent = qingjiaContent;
    }
    /**
	 * 设置：是否同意
	 */
    public Integer getXueshengqingjiaYesnoTypes() {
        return xueshengqingjiaYesnoTypes;
    }


    /**
	 * 获取：是否同意
	 */

    public void setXueshengqingjiaYesnoTypes(Integer xueshengqingjiaYesnoTypes) {
        this.xueshengqingjiaYesnoTypes = xueshengqingjiaYesnoTypes;
    }
    /**
	 * 设置：申请日期
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请日期
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
        return "Xueshengqingjia{" +
            "id=" + id +
            ", xueshengId=" + xueshengId +
            ", qingjiaStartTime=" + qingjiaStartTime +
            ", qingjiaEndTime=" + qingjiaEndTime +
            ", qingjiaContent=" + qingjiaContent +
            ", xueshengqingjiaYesnoTypes=" + xueshengqingjiaYesnoTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
