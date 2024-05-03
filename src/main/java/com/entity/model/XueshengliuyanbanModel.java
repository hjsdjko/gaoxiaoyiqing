package com.entity.model;

import com.entity.XueshengliuyanbanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 留言板
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XueshengliuyanbanModel implements Serializable {
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
     * 留言名称
     */
    private String xueshengliuyanbanName;


    /**
     * 留言图片
     */
    private String xueshengliuyanbanPhoto;


    /**
     * 留言类型
     */
    private Integer xueshengliuyanbanTypes;


    /**
     * 留言详情
     */
    private String xueshengliuyanbanText;


    /**
     * 操作人员
     */
    private Integer caozuorenyuanId;


    /**
     * 回复详情
     */
    private String huifuText;


    /**
     * 留言时间
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
	 * 获取：留言名称
	 */
    public String getXueshengliuyanbanName() {
        return xueshengliuyanbanName;
    }


    /**
	 * 设置：留言名称
	 */
    public void setXueshengliuyanbanName(String xueshengliuyanbanName) {
        this.xueshengliuyanbanName = xueshengliuyanbanName;
    }
    /**
	 * 获取：留言图片
	 */
    public String getXueshengliuyanbanPhoto() {
        return xueshengliuyanbanPhoto;
    }


    /**
	 * 设置：留言图片
	 */
    public void setXueshengliuyanbanPhoto(String xueshengliuyanbanPhoto) {
        this.xueshengliuyanbanPhoto = xueshengliuyanbanPhoto;
    }
    /**
	 * 获取：留言类型
	 */
    public Integer getXueshengliuyanbanTypes() {
        return xueshengliuyanbanTypes;
    }


    /**
	 * 设置：留言类型
	 */
    public void setXueshengliuyanbanTypes(Integer xueshengliuyanbanTypes) {
        this.xueshengliuyanbanTypes = xueshengliuyanbanTypes;
    }
    /**
	 * 获取：留言详情
	 */
    public String getXueshengliuyanbanText() {
        return xueshengliuyanbanText;
    }


    /**
	 * 设置：留言详情
	 */
    public void setXueshengliuyanbanText(String xueshengliuyanbanText) {
        this.xueshengliuyanbanText = xueshengliuyanbanText;
    }
    /**
	 * 获取：操作人员
	 */
    public Integer getCaozuorenyuanId() {
        return caozuorenyuanId;
    }


    /**
	 * 设置：操作人员
	 */
    public void setCaozuorenyuanId(Integer caozuorenyuanId) {
        this.caozuorenyuanId = caozuorenyuanId;
    }
    /**
	 * 获取：回复详情
	 */
    public String getHuifuText() {
        return huifuText;
    }


    /**
	 * 设置：回复详情
	 */
    public void setHuifuText(String huifuText) {
        this.huifuText = huifuText;
    }
    /**
	 * 获取：留言时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：留言时间
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
