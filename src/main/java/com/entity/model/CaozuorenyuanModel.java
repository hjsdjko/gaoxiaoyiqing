package com.entity.model;

import com.entity.CaozuorenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 操作人员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CaozuorenyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


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


    /**
     * 操作人员性别
     */
    private Integer sexTypes;


    /**
     * 逻辑删除
     */
    private Integer caozuorenyuanDelete;


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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：操作人员姓名
	 */
    public String getCaozuorenyuanName() {
        return caozuorenyuanName;
    }


    /**
	 * 设置：操作人员姓名
	 */
    public void setCaozuorenyuanName(String caozuorenyuanName) {
        this.caozuorenyuanName = caozuorenyuanName;
    }
    /**
	 * 获取：操作人员电话
	 */
    public String getCaozuorenyuanPhone() {
        return caozuorenyuanPhone;
    }


    /**
	 * 设置：操作人员电话
	 */
    public void setCaozuorenyuanPhone(String caozuorenyuanPhone) {
        this.caozuorenyuanPhone = caozuorenyuanPhone;
    }
    /**
	 * 获取：操作人员身份证号
	 */
    public String getCaozuorenyuanIdNumber() {
        return caozuorenyuanIdNumber;
    }


    /**
	 * 设置：操作人员身份证号
	 */
    public void setCaozuorenyuanIdNumber(String caozuorenyuanIdNumber) {
        this.caozuorenyuanIdNumber = caozuorenyuanIdNumber;
    }
    /**
	 * 获取：操作人员头像
	 */
    public String getCaozuorenyuanPhoto() {
        return caozuorenyuanPhoto;
    }


    /**
	 * 设置：操作人员头像
	 */
    public void setCaozuorenyuanPhoto(String caozuorenyuanPhoto) {
        this.caozuorenyuanPhoto = caozuorenyuanPhoto;
    }
    /**
	 * 获取：操作人员性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：操作人员性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getCaozuorenyuanDelete() {
        return caozuorenyuanDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setCaozuorenyuanDelete(Integer caozuorenyuanDelete) {
        this.caozuorenyuanDelete = caozuorenyuanDelete;
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
