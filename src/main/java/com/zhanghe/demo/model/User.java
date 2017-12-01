package com.zhanghe.demo.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 用户信息
 *
 * @author admin
 */
@TableName("user")
public class User {
	
    @TableId(type = IdType.AUTO)
    private Long id;
    private String userName;
    private String name;
    private String password;
    private String salt;
    private Integer status;

    
    public static final String ID="id";
    public static final String USERNAME="userName";
    public static final String NAME="name";
    public static final String PASSWORD="password";
    public static final String SALT="salt";
    public static final String STATUS="status";
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 密码盐.
     */
    public String getCredentialsSalt() {
        return this.userName + this.salt;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}
