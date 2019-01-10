package com.sunland.pojo;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class TestDemo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Integer test_id;

    @ApiModelProperty(value="标题")
    private String test_title;

    @ApiModelProperty(value="作者")
    private String test_author;

    @ApiModelProperty(value="时间")
    private Date create_date;

    private static final long serialVersionUID = 1L;

    public Integer getTest_id() {
        return test_id;
    }

    public void setTest_id(Integer test_id) {
        this.test_id = test_id;
    }

    public String getTest_title() {
        return test_title;
    }

    public void setTest_title(String test_title) {
        this.test_title = test_title == null ? null : test_title.trim();
    }

    public String getTest_author() {
        return test_author;
    }

    public void setTest_author(String test_author) {
        this.test_author = test_author == null ? null : test_author.trim();
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
}