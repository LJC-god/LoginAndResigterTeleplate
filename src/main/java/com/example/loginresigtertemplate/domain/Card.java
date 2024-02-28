package com.example.loginresigtertemplate.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import lombok.Data;

/**
 * card
 * @author 
 */
@Data
public class Card implements Serializable {
    private Integer cardId;

    private String frontContent;

    private String backContent;

    private Integer userId;

    private String profession;

    private Date createdAt;

    private static final long serialVersionUID = 1L;

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getFrontContent() {
        return frontContent;
    }

    public void setFrontContent(String frontContent) {
        this.frontContent = frontContent;
    }

    public String getBackContent() {
        return backContent;
    }

    public void setBackContent(String backContent) {
        this.backContent = backContent;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card card)) return false;
        return Objects.equals(cardId, card.cardId) && Objects.equals(frontContent, card.frontContent) && Objects.equals(backContent, card.backContent) && Objects.equals(userId, card.userId) && Objects.equals(profession, card.profession) && Objects.equals(createdAt, card.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, frontContent, backContent, userId, profession, createdAt);
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", frontContent='" + frontContent + '\'' +
                ", backContent='" + backContent + '\'' +
                ", userId=" + userId +
                ", profession='" + profession + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}