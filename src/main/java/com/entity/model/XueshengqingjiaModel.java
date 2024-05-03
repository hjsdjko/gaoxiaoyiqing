package com.entity.model;

import com.entity.XueshengqingjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 学生请假管理
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XueshengqingjiaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 学生
     */
    private Integer xueshengId;


    /**
     * 请假开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date qingjiaStartTime;


    /**
     * 请假结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date qingjiaEndTime;


    /**
     * 请假原因
     */
    private String qingjiaContent;


    /**
     * 是否同意
     */
    private Integer xueshengqingjiaYesnoTypes;


    /**
     * 申请日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }


    /**
	 * 设置：学生
	 */
    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 获取：请假开始时间
	 */
    public Date getQingjiaStartTime() {
        return qingjiaStartTime;
    }


    /**
	 * 设置：请假开始时间
	 */
    public void setQingjiaStartTime(Date qingjiaStartTime) {
        this.qingjiaStartTime = qingjiaStartTime;
    }
    /**
	 * 获取：请假结束时间
	 */
    public Date getQingjiaEndTime() {
        return qingjiaEndTime;
    }


    /**
	 * 设置：请假结束时间
	 */
    public void setQingjiaEndTime(Date qingjiaEndTime) {
        this.qingjiaEndTime = qingjiaEndTime;
    }
    /**
	 * 获取：请假原因
	 */
    public String getQingjiaContent() {
        return qingjiaContent;
    }


    /**
	 * 设置：请假原因
	 */
    public void setQingjiaContent(String qingjiaContent) {
        this.qingjiaContent = qingjiaContent;
    }
    /**
	 * 获取：是否同意
	 */
    public Integer getXueshengqingjiaYesnoTypes() {
        return xueshengqingjiaYesnoTypes;
    }


    /**
	 * 设置：是否同意
	 */
    public void setXueshengqingjiaYesnoTypes(Integer xueshengqingjiaYesnoTypes) {
        this.xueshengqingjiaYesnoTypes = xueshengqingjiaYesnoTypes;
    }
    /**
	 * 获取：申请日期
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请日期
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
