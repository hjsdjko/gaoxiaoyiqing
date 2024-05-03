package com.entity.model;

import com.entity.LaoshijujiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 老师居家信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LaoshijujiaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 学生
     */
    private Integer laoshiId;


    /**
     * 居家地点
     */
    private String jujiaName;


    /**
     * 是否隔离
     */
    private Integer jujiaTypes;


    /**
     * 所在地风险等级
     */
    private Integer jujiafengxiandengjiTypes;


    /**
     * 同住人员身体状况
     */
    private Integer tongzhurenyuanTypes;


    /**
     * 提交日期
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
    public Integer getLaoshiId() {
        return laoshiId;
    }


    /**
	 * 设置：学生
	 */
    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 获取：居家地点
	 */
    public String getJujiaName() {
        return jujiaName;
    }


    /**
	 * 设置：居家地点
	 */
    public void setJujiaName(String jujiaName) {
        this.jujiaName = jujiaName;
    }
    /**
	 * 获取：是否隔离
	 */
    public Integer getJujiaTypes() {
        return jujiaTypes;
    }


    /**
	 * 设置：是否隔离
	 */
    public void setJujiaTypes(Integer jujiaTypes) {
        this.jujiaTypes = jujiaTypes;
    }
    /**
	 * 获取：所在地风险等级
	 */
    public Integer getJujiafengxiandengjiTypes() {
        return jujiafengxiandengjiTypes;
    }


    /**
	 * 设置：所在地风险等级
	 */
    public void setJujiafengxiandengjiTypes(Integer jujiafengxiandengjiTypes) {
        this.jujiafengxiandengjiTypes = jujiafengxiandengjiTypes;
    }
    /**
	 * 获取：同住人员身体状况
	 */
    public Integer getTongzhurenyuanTypes() {
        return tongzhurenyuanTypes;
    }


    /**
	 * 设置：同住人员身体状况
	 */
    public void setTongzhurenyuanTypes(Integer tongzhurenyuanTypes) {
        this.tongzhurenyuanTypes = tongzhurenyuanTypes;
    }
    /**
	 * 获取：提交日期
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：提交日期
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
