package com.entity.vo;

import com.entity.XueshengqingjiaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 学生请假管理
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xueshengqingjia")
public class XueshengqingjiaVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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

}
