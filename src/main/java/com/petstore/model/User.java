package com.petstore.model;

public class User {
    private long id;
    private String userName;
    private String fistName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;

    public User() {
    }

    public User(long id, String userName, String fistName, String lastName, String email, String password, String phone, int userStatus) {
        this.id = id;
        this.userName = userName;
        this.fistName = fistName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userStatus = userStatus;
    }

    @Override
    public String toString(){
        return "User  id -- " + getId() +  ", firstName -- " + getFistName() + ", lastName -- " + getLastName() +
                ", email -- " +getEmail()+  ", phone --" +getPhone() +", userStatus --" +getUserStatus();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }
}
