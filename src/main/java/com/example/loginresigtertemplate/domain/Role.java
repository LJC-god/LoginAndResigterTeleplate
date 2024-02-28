package com.example.loginresigtertemplate.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * card
 * @author 
 */
@Data
public class Role implements Serializable {
    private Integer cardId;

    private String frontContent;

    private String backContent;

    private Integer userId;

    private String profession;

    private Date createdAt;

    private static final long serialVersionUID = 1L;
}