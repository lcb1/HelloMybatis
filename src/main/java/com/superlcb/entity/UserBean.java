package com.superlcb.entity;

/***
 * @author: lcb
 * @date: 2019-7-22 19:36
 * Description: 
 */
public class UserBean {
    private Integer id=null;
    private String userName=null;
    private String password=null;

    public UserBean() {
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public UserBean setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserBean setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserBean setPassword(String password) {
        this.password = password;
        return this;
    }
}
