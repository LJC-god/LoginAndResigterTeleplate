package com.example.loginresigtertemplate.Domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

/**
 * @TableName admin
 */
@TableName(value = "admin")
@Data
public class Admin implements Serializable {
    private Integer admin_id;

    private String username;

    private String password;

    private String salt;

    private LocalDateTime created_at;

    private String jwt_token;

    private LocalDateTime jwt_expiry;

    private static final long serialVersionUID = 1L;

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
        Admin other = (Admin) that;
        return (this.getAdmin_id() == null ? other.getAdmin_id() == null : this.getAdmin_id().equals(other.getAdmin_id()))
                && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
                && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
                && (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()))
                && (this.getCreated_at() == null ? other.getCreated_at() == null : this.getCreated_at().equals(other.getCreated_at()))
                && (this.getJwt_token() == null ? other.getJwt_token() == null : this.getJwt_token().equals(other.getJwt_token()))
                && (this.getJwt_expiry() == null ? other.getJwt_expiry() == null : this.getJwt_expiry().equals(other.getJwt_expiry()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdmin_id() == null) ? 0 : getAdmin_id().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
        result = prime * result + ((getCreated_at() == null) ? 0 : getCreated_at().hashCode());
        result = prime * result + ((getJwt_token() == null) ? 0 : getJwt_token().hashCode());
        result = prime * result + ((getJwt_expiry() == null) ? 0 : getJwt_expiry().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", admin_id=").append(admin_id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", salt=").append(salt);
        sb.append(", created_at=").append(created_at);
        sb.append(", jwt_token=").append(jwt_token);
        sb.append(", jwt_expiry=").append(jwt_expiry);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}