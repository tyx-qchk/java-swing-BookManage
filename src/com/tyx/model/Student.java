package com.tyx.model;

import java.sql.Date;

public class Student {
    private int id; //学号
    private String userName; //学生姓名
    private int bookId; // 图书编号
    private Date startTime; //借书时间
    private Date endTime; //还书时间

    public Student( String userName, int bookId, Date startTime, Date endTime) {
        this.userName = userName;
        this.bookId = bookId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Student() {
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

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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
