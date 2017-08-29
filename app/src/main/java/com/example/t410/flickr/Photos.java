package com.example.t410.flickr;

/**
 * Created by T410 on 28/08/2017.
 */

public class Photos {
    private String id;
    private String owner;
    private String secret;
    private String title;

    public Photos() {
        id="";
        owner="";
        secret="";
        title="";
    }

    public Photos(String id, String owner, String secret, String title) {
        this.id = id;
        this.owner = owner;
        this.secret = secret;
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

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
