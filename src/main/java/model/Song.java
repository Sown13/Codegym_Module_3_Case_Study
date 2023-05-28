package model;

import java.sql.Timestamp;

public class Song {
    private String s_id;
    private String song_name;
    private String author;
    private Timestamp upload_date;
    private String song_url;
    private int listening_frequency;
    private String label;
    private int u_id;

    public Song(){}
    public Song(String s_id,String song_name,Timestamp upload_date,String author,String song_url,int listening_frequency,String label){
        this.s_id=s_id;
        this.song_name=song_name;
        this.author=author;
        this.song_url=song_url;
        this.label=label;
        this.upload_date=upload_date;
        this.listening_frequency=listening_frequency;
    }



    public Song(String s_id, String song_name, String author, String label) {
        this.s_id = s_id;
        this.song_name = song_name;
        this.author = author;
        this.label = label;
    }

    public Song(String song_name, String author, String label) {
        this.song_name = song_name;
        this.author = author;
        this.label = label;
    }

    public Song(String s_id, String song_name, String author, String song_url, String label) {
        this.s_id = s_id;
        this.song_name = song_name;
        this.author = author;
        this.song_url = song_url;
        this.label = label;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
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

    public Timestamp getUpload_date() {
        return upload_date;
    }

    public void setUpload_date(Timestamp upload_date) {
        this.upload_date = upload_date;
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

    @Override
    public String toString() {
        return "Song{" +
                "s_id='" + s_id + '\'' +
                ", song_name='" + song_name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
