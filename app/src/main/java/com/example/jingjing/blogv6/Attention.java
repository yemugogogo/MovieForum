package com.example.jingjing.blogv6;

public class Attention {
    String owner;
    String blgger_name;

    public Attention(){

    }


    public Attention(String owner, String blgger_name) {
        this.owner = owner;
        this.blgger_name = blgger_name;
    }

    public String getOwner() {
        return owner;
    }


    public String getBlgger_name() {
        return blgger_name;
    }
}
