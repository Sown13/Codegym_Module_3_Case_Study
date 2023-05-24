package model;

public class Comment {
    private String c_id;
    private String content;
    private String s_id;
    private String u_id;

    public Comment(String c_id, String content, String s_id, String u_id) {
        this.c_id = c_id;
        this.content = content;
        this.s_id = s_id;
        this.u_id = u_id;
    }

    public Comment(String content, String s_id, String u_id) {
        this.content = content;
        this.s_id = s_id;
        this.u_id = u_id;
    }

    public Comment() {
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }
}
