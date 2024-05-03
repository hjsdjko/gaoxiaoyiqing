package com.entity.vo;

import com.entity.LaoshifanxiaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 老师返校申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("laoshifanxiao")
public class LaoshifanxiaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 老师
     */

    @TableField(value = "laoshi_id")
    private Integer laoshiId;


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

    @TableField(value = "laoshifanxiao_yesno_types")
    private Integer laoshifanxiaoYesnoTypes;


    /**
     * 提交日期
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
	 * 设置：老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }


    /**
	 * 获取：老师
	 */

    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
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
    public Integer getLaoshifanxiaoYesnoTypes() {
        return laoshifanxiaoYesnoTypes;
    }


    /**
	 * 获取：是否同意
	 */

    public void setLaoshifanxiaoYesnoTypes(Integer laoshifanxiaoYesnoTypes) {
        this.laoshifanxiaoYesnoTypes = laoshifanxiaoYesnoTypes;
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

}
