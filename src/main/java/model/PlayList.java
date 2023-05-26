package model;

public class PlayList {
    private String p_id;
    private String p_name;
    private String u_id;
    private String label;
    private boolean edit;

    public PlayList() {
    }

    public PlayList(String p_id, String p_name, String u_id,String label) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.u_id = u_id;
        this.label=label;

    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
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

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }
}
