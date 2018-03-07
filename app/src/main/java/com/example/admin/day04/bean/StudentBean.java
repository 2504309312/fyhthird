package com.example.admin.day04.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by admin on 2018/3/6.
 */
@Entity
public class StudentBean {
    @Id(autoincrement = true)
    private Long Id;
    private String content;
    private String img;
    private String name;
    @Generated(hash = 441671471)
    public StudentBean(Long Id, String content, String img, String name) {
        this.Id = Id;
        this.content = content;
        this.img = img;
        this.name = name;
    }
    @Generated(hash = 2097171990)
    public StudentBean() {
    }
    public Long getId() {
        return this.Id;
    }
    public void setId(Long Id) {
        this.Id = Id;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getImg() {
        return this.img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
