package com.example.happytravel.register;

public class User {
    private String username;            //用户名
    private String password;        //密码

    public User(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public String getName() {
        return username;
    }
    public void setName(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +

                '}';
    }
}
