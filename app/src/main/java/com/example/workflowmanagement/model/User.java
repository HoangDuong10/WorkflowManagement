package com.example.workflowmanagement.model;

import android.util.Patterns;

import java.util.Date;
import java.util.regex.Pattern;

public class User {
    private Long id;
    private String fullName;
    private String userName;
    private String passWord;
    private String email;
    private String address;
    private String phone;
    private boolean isDelete;
    private Date createDate;
    private String token;
    public User(){

    }
    public User(String userName,String passWord){
        this.userName = userName;
        this.passWord=passWord;
    }
    public User(String email,String userName,String passWord){
        this.email=email;
        this.userName = userName;
        this.passWord=passWord;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isValiName(){
        return !this.userName.isEmpty();
    }
    public boolean isValiPassWord(){
        return !this.passWord.isEmpty() && this.passWord.length()>5;
    }
    public boolean isValiEmail(){
        return !this.email.isEmpty()&& Patterns.EMAIL_ADDRESS.matcher(this.email).matches();
    }
    public boolean checkEmail(){
        Pattern p = Pattern.compile("^[a-zA-Z]+[a-zA-Z0-9\\-_]+@[a-zA-Z]+(\\.[a-zA-Z]+)+");
        if(p.matcher(this.email).find()){
            return true;
        }
        return false;
    }

}
