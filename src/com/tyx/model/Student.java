package com.tyx.model;

public class Student {
    private Integer id; //学号
    private String userName; //学生姓名
    private int bookId; // 图书编号
    private String phone; //手机号

    public Student() {
    }

    public Student(String userName, int bookId, String phone) {
        this.userName = userName;
        this.bookId = bookId;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
