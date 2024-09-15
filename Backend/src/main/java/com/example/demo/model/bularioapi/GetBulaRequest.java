package com.example.demo.model.bularioapi;

public class GetBulaRequest {
    private String id;

    public GetBulaRequest() {
    }
    public GetBulaRequest(String id) { this.id = id; }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
