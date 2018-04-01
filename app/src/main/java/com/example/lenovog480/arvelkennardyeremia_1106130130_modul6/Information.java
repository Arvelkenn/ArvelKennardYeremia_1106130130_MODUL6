package com.example.lenovog480.arvelkennardyeremia_1106130130_modul6;

public class Information {
    String thumbnail;
    String titles;

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    String post;

    public Information(){

    }

    public Information(String post, String thumbnail, String titles){


        this.post = post;
        this.thumbnail = thumbnail;
        this.titles = titles;
    }
}
