package com.socialnetworking.data;

public class Comments {

    private int postId;
    private String name;
    private String email;



    public int getPostId(int postId) {
        return this.postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getName(String name) {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail(String email) {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
