package model;

public class PlayList {
    private int p_id;
    private String p_name;
    private int u_id;

    public PlayList() {
    }

    public PlayList(int p_id, String p_name, int u_id) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.u_id = u_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }
}
