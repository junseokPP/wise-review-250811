package com.back.domain.wiseSaying.entity;

import java.time.LocalDateTime;

public class WiseSaying {
    private int id;
    private String saying;
    private String author;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public WiseSaying(){}

    public WiseSaying(int id, String saying, String author) {
        this.id = id;
        this.saying = saying;
        this.author = author;
    }

    public boolean isNew(){
        return id == 0;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSaying() {
        return saying;
    }

    public void setSaying(String saying) {
        this.saying = saying;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
