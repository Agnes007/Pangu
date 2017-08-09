package com.pangu.entity;

//import org.springframework.data.annotation.Id;

import javax.persistence.*;

/**
 * Created by DongHao on 2017/8/7.
 */

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;
    @Column(name = "userid")
    private String userid;
    @Column(name = "password")
    private String password;
    @Column(name = "Name")
    private String name;
    @Column(name = "Age")
    private int age;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return "User[id=" + id + ",userid=" + userid + ",password=" + password + ",name=" + name + ",age=" + age + "]";
    }
}
