package com.example.loginresigtertemplate.daomain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import lombok.Data;

/**
 * admin
 * @author 
 */
@Data
public class User implements Serializable {
    private Integer adminId;

    private String username;

    private String password;

    private String salt;

    private Date createdAt;

    private String jwtToken;

    private Date jwtExpiry;

    private int status;


    private static final long serialVersionUID = 1L;
    /**
     * 用户拥有的权限编码
     */
    private Set<String> permissionCodeSet;

    /**
     * 用户拥有的角色
     */
//    @TableField(exist = false)
//    private List<Role> roleList;
    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public Date getJwtExpiry() {
        return jwtExpiry;
    }

    public void setJwtExpiry(Date jwtExpiry) {
        this.jwtExpiry = jwtExpiry;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getAdminId() == null ? other.getAdminId() == null : this.getAdminId().equals(other.getAdminId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getJwtToken() == null ? other.getJwtToken() == null : this.getJwtToken().equals(other.getJwtToken()))
            && (this.getJwtExpiry() == null ? other.getJwtExpiry() == null : this.getJwtExpiry().equals(other.getJwtExpiry()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdminId() == null) ? 0 : getAdminId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        result = prime * result + ((getJwtToken() == null) ? 0 : getJwtToken().hashCode());
        result = prime * result + ((getJwtExpiry() == null) ? 0 : getJwtExpiry().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminId=").append(adminId);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", salt=").append(salt);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", jwtToken=").append(jwtToken);
        sb.append(", jwtExpiry=").append(jwtExpiry);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}