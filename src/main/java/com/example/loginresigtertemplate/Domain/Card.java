package com.example.loginresigtertemplate.Domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName card
 */
@TableName(value ="card")
@Data
public class Card implements Serializable {
    private Integer card_id;

    private String front_content;

    private String back_content;

    private Integer user_id;

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
        Card other = (Card) that;
        return (this.getCard_id() == null ? other.getCard_id() == null : this.getCard_id().equals(other.getCard_id()))
            && (this.getFront_content() == null ? other.getFront_content() == null : this.getFront_content().equals(other.getFront_content()))
            && (this.getBack_content() == null ? other.getBack_content() == null : this.getBack_content().equals(other.getBack_content()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCard_id() == null) ? 0 : getCard_id().hashCode());
        result = prime * result + ((getFront_content() == null) ? 0 : getFront_content().hashCode());
        result = prime * result + ((getBack_content() == null) ? 0 : getBack_content().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", card_id=").append(card_id);
        sb.append(", front_content=").append(front_content);
        sb.append(", back_content=").append(back_content);
        sb.append(", user_id=").append(user_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}