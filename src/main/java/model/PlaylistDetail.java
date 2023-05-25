package model;

public class PlaylistDetail {
    private String pd_id;
    private String songId;
    private String playlistId;

    public PlaylistDetail() {
    }

    public PlaylistDetail(String pd_id, String songId, String playlistId) {
        this.pd_id = pd_id;
        this.songId = songId;
        this.playlistId = playlistId;
    }

    public PlaylistDetail(String songId, String playlistId) {
        this.songId = songId;
        this.playlistId = playlistId;
    }

    public String getPd_id() {
        return pd_id;
    }

    public void setPd_id(String pd_id) {
        this.pd_id = pd_id;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }
}
