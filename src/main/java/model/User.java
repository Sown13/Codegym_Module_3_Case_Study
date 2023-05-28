package model;

public class User {
    private String u_id;
    private String user_name;
    private String password;
    private String fullname;
    private String address;
    private String email;

    private String lastSongPlayID;

    public User(String u_id, String user_name, String password,String fullname, String address, String email, String lastSongPlayID) {
        this.u_id = u_id;
        this.user_name = user_name;
        this.password = password;
        this.fullname = fullname;
        this.address = address;
        this.email = email;
        this.lastSongPlayID = lastSongPlayID;
    }

    public User(String user_name, String password, String fullname, String address, String email) {
        this.user_name = user_name;
        this.password = password;
        this.fullname = fullname;
        this.address = address;
        this.email = email;
    }

    public User(String user_name, String fullname, String address, String email) {
        this.user_name = user_name;
        this.fullname = fullname;
        this.address = address;
        this.email = email;
    }

    public User() {
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getLastSongPlayID() {
        return lastSongPlayID;
    }

    public void setLastSongPlayID(String lastSongPlayID) {
        this.lastSongPlayID = lastSongPlayID;
    }
}
