package com.wojia.springboot.boot2.pojo;

import javax.persistence.Id;

public class Emp {
    @Id
    private Integer id;
    private String username;
    private String password;
    private String address;
    private String img;
  //  private String path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

//    public String getPath() {
//        return path;
//    }
//
//    public void setPath(String path) {
//        this.path = path;
//    }

    public Emp(Integer id, String username, String password, String address, String img, String path) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.address = address;
        this.img = img;
//        this.path = path;
    }

    public Emp() {
    }
}
