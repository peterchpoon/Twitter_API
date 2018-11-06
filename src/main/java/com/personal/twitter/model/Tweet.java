package com.personal.twitter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tweet {

    private String screenName;
    private String profileImageUrl;
    private String text;
    private String createdAt;

    public Tweet(String screenName, String profileImageUrl, String text, String createdAt) {
        this.screenName = screenName;
        this.profileImageUrl = profileImageUrl;
        this.text = text;
        this.createdAt = createdAt;
    }

    @JsonProperty
    public String getScreen_Name() {
        return screenName;
    }

    @JsonProperty
    public String getProfile_Image_Url() {
        return profileImageUrl;
    }

    @JsonProperty
    public String getText() {
        return text;
    }

    @JsonProperty
    public String getCreated_At() {
        return createdAt;
    }
}
