package com.djs.springboot.entity;

public class Admin {
    private String id;
    private String username;
    private String password;
    private String beforePassword;
    private String passwordSalt;
    private String version;

    public Admin() {

    }

    public Admin(String id, String username, String password, String beforePassword, String passwordSalt, String version) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.beforePassword = beforePassword;
        this.passwordSalt = passwordSalt;
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getBeforePassword() {
        return beforePassword;
    }

    public void setBeforePassword(String beforePassword) {
        this.beforePassword = beforePassword;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", beforePassword='" + beforePassword + '\'' +
                ", passwordSalt='" + passwordSalt + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
