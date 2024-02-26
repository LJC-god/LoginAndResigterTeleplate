package com.example.loginresigtertemplate.Domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    private Integer user_id;

    private String username;

    private String password;

    private String salt;

    private String email;

    private String gender;

    private Integer age;

    private LocalDateTime last_login_time;

    private String last_login_location;

    private LocalDateTime created_at;

    private String user_role;

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
        User other = (User) that;
        return (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getLast_login_time() == null ? other.getLast_login_time() == null : this.getLast_login_time().equals(other.getLast_login_time()))
            && (this.getLast_login_location() == null ? other.getLast_login_location() == null : this.getLast_login_location().equals(other.getLast_login_location()))
            && (this.getCreated_at() == null ? other.getCreated_at() == null : this.getCreated_at().equals(other.getCreated_at()))
            && (this.getUser_role() == null ? other.getUser_role() == null : this.getUser_role().equals(other.getUser_role()))
            && (this.getJwt_token() == null ? other.getJwt_token() == null : this.getJwt_token().equals(other.getJwt_token()))
            && (this.getJwt_expiry() == null ? other.getJwt_expiry() == null : this.getJwt_expiry().equals(other.getJwt_expiry()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getLast_login_time() == null) ? 0 : getLast_login_time().hashCode());
        result = prime * result + ((getLast_login_location() == null) ? 0 : getLast_login_location().hashCode());
        result = prime * result + ((getCreated_at() == null) ? 0 : getCreated_at().hashCode());
        result = prime * result + ((getUser_role() == null) ? 0 : getUser_role().hashCode());
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
        sb.append(", user_id=").append(user_id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", salt=").append(salt);
        sb.append(", email=").append(email);
        sb.append(", gender=").append(gender);
        sb.append(", age=").append(age);
        sb.append(", last_login_time=").append(last_login_time);
        sb.append(", last_login_location=").append(last_login_location);
        sb.append(", created_at=").append(created_at);
        sb.append(", user_role=").append(user_role);
        sb.append(", jwt_token=").append(jwt_token);
        sb.append(", jwt_expiry=").append(jwt_expiry);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}