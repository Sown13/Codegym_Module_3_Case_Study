package model;

import java.sql.Date;

public class PlayList {
    private String p_id;
    private String p_name;
    private Date createDate;
    private String u_id;
    private String label;

    public PlayList() {
    }

    public PlayList(String p_id, String p_name, String u_id, String label) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.u_id = u_id;
        this.label = label;
    }

    public PlayList(String p_id, String p_name, String u_id, String label, Date createDate) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.u_id = u_id;
        this.label=label;
        this.createDate = createDate;
    }

    public PlayList(String p_name, String u_id, String label,Date createDate) {
        this.p_name = p_name;
        this.u_id = u_id;
        this.label = label;
        this.createDate = createDate;
    }

    public PlayList(String p_name, String u_id, String label) {
        this.p_name = p_name;
        this.u_id = u_id;
        this.label = label;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getPlayListName() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
