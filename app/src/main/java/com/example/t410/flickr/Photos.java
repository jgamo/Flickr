package com.example.t410.flickr;

/**
 * Created by T410 on 28/08/2017.
 */

public class Photos {
    private String id;
    private String owner;
    private String url;
    private String title;

    public Photos() {
        id="";
        owner="";
        url="";
        title="";
    }

    public Photos(String id, String owner, String url, String title) {
        this.id = id;
        this.owner = owner;
        this.url = url;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
