package model;

import java.sql.Timestamp;

public class Song {
    private int s_id;
    private String song_name;
    private String author;
    private Timestamp upload_day;
    private String song_url;
    private int listening_frequency;
    private String label;
    private int u_id;

    public Song() {
    }

    public Song(int s_id, String song_name, String author, Timestamp upload_day, String song_url, int listening_frequency, String label, int u_id) {
        this.s_id = s_id;
        this.song_name = song_name;
        this.author = author;
        this.upload_day = upload_day;
        this.song_url = song_url;
        this.listening_frequency = listening_frequency;
        this.label = label;
        this.u_id = u_id;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Timestamp getUpload_day() {
        return upload_day;
    }

    public void setUpload_day(Timestamp upload_day) {
        this.upload_day = upload_day;
    }

    public String getSong_url() {
        return song_url;
    }

    public void setSong_url(String song_url) {
        this.song_url = song_url;
    }

    public int getListening_frequency() {
        return listening_frequency;
    }

    public void setListening_frequency(int listening_frequency) {
        this.listening_frequency = listening_frequency;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }
}
