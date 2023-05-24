package model;

public class User {
    private int u_id;
    private String user_name;
    private String password;
    private String address;
    private String email;

    public User(int u_id, String user_name, String password, String address, String email) {
        this.u_id = u_id;
        this.user_name = user_name;
        this.password = password;
        this.address = address;
        this.email = email;
    }

    public User() {
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
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
}
