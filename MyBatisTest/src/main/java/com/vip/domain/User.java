package com.vip.domain;

import java.io.Serializable;
import java.util.Date;

/***
 * 用户实体类
 */
public class User implements Serializable {
    private Integer id;      //用户id
    private String userName; //用户名称
    private Date birthday;   //用户生日
    private String sex;      //用户性别
    private String address;  //用户地址

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("User{")
                .append("id=")
                .append(id)
                .append(",userName=")
                .append(userName)
                .append(",birthday=")
                .append(birthday)
                .append(",sex= ")
                .append(sex)
                .append(",address= ")
                .append(address)
                .append('}').toString();
    }
}
