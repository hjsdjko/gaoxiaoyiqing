package com.entity.vo;

import com.entity.XueshengliuyanbanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 留言板
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xueshengliuyanban")
public class XueshengliuyanbanVO implements Serializable {
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
     * 留言名称
     */

    @TableField(value = "xueshengliuyanban_name")
    private String xueshengliuyanbanName;


    /**
     * 留言图片
     */

    @TableField(value = "xueshengliuyanban_photo")
    private String xueshengliuyanbanPhoto;


    /**
     * 留言类型
     */

    @TableField(value = "xueshengliuyanban_types")
    private Integer xueshengliuyanbanTypes;


    /**
     * 留言详情
     */

    @TableField(value = "xueshengliuyanban_text")
    private String xueshengliuyanbanText;


    /**
     * 操作人员
     */

    @TableField(value = "caozuorenyuan_id")
    private Integer caozuorenyuanId;


    /**
     * 回复详情
     */

    @TableField(value = "huifu_text")
    private String huifuText;


    /**
     * 留言时间
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
	 * 设置：留言名称
	 */
    public String getXueshengliuyanbanName() {
        return xueshengliuyanbanName;
    }


    /**
	 * 获取：留言名称
	 */

    public void setXueshengliuyanbanName(String xueshengliuyanbanName) {
        this.xueshengliuyanbanName = xueshengliuyanbanName;
    }
    /**
	 * 设置：留言图片
	 */
    public String getXueshengliuyanbanPhoto() {
        return xueshengliuyanbanPhoto;
    }


    /**
	 * 获取：留言图片
	 */

    public void setXueshengliuyanbanPhoto(String xueshengliuyanbanPhoto) {
        this.xueshengliuyanbanPhoto = xueshengliuyanbanPhoto;
    }
    /**
	 * 设置：留言类型
	 */
    public Integer getXueshengliuyanbanTypes() {
        return xueshengliuyanbanTypes;
    }


    /**
	 * 获取：留言类型
	 */

    public void setXueshengliuyanbanTypes(Integer xueshengliuyanbanTypes) {
        this.xueshengliuyanbanTypes = xueshengliuyanbanTypes;
    }
    /**
	 * 设置：留言详情
	 */
    public String getXueshengliuyanbanText() {
        return xueshengliuyanbanText;
    }


    /**
	 * 获取：留言详情
	 */

    public void setXueshengliuyanbanText(String xueshengliuyanbanText) {
        this.xueshengliuyanbanText = xueshengliuyanbanText;
    }
    /**
	 * 设置：操作人员
	 */
    public Integer getCaozuorenyuanId() {
        return caozuorenyuanId;
    }


    /**
	 * 获取：操作人员
	 */

    public void setCaozuorenyuanId(Integer caozuorenyuanId) {
        this.caozuorenyuanId = caozuorenyuanId;
    }
    /**
	 * 设置：回复详情
	 */
    public String getHuifuText() {
        return huifuText;
    }


    /**
	 * 获取：回复详情
	 */

    public void setHuifuText(String huifuText) {
        this.huifuText = huifuText;
    }
    /**
	 * 设置：留言时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：留言时间
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
