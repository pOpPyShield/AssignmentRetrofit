package com.example.assignment75;

public class ExampleItem {
    private String usrName;
    private String Email;
    private String id;

    public ExampleItem(String usrName, String Email, String id) {
        this.usrName= usrName;
        this.Email= Email;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getUsrName() {
        return usrName;
    }

    public String getEmail() {
        return Email;
    }
}
