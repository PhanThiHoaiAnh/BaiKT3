package com.example.baikt3;

public class NgonNgu {
    private String id, nhapVidu;

    @Override
    public String toString() {
        return "NgonNgu{" +
                "id='" + id + '\'' +
                ", nhapVidu='" + nhapVidu + '\'' +
                '}';
    }

    public NgonNgu(){}

    public NgonNgu(String id, String nhapVidu) {
        this.id = id;
        this.nhapVidu = nhapVidu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNhapVidu() {
        return nhapVidu;
    }

    public void setNhapVidu(String nhapVidu) {
        this.nhapVidu = nhapVidu;
    }
}
