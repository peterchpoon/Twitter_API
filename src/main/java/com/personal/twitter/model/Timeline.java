package com.personal.twitter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Timeline {
    private List<Tweet> timeline;

    public Timeline(int size) {
        timeline = new ArrayList<>(size < 0 ? 0 : size);
    }

    public void addToTimeline(Tweet t) {
        timeline.add(t);
    }

    @JsonProperty
    public List<Tweet> getTimeline() {
        return timeline;
    }
}
