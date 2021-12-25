package com.tyx.model;

import java.util.Date;

public class Record {
    private int id; // id
    private String userName;
    private String bookName;
    private Date startTime;
    private Date endTime;

    public Record() {
    }

    public Record(String userName, String bookName, Date startTime, Date endTime) {
        this.userName = userName;
        this.bookName = bookName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
