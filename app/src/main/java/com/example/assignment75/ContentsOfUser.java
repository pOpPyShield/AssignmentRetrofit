package com.example.assignment75;

public class ContentsOfUser {
    private String title;
    private String body;
    private String usrId;
    public ContentsOfUser(String id, String title, String body) {
        this.usrId = id;
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getUsrId() {
        return usrId;
    }
}
