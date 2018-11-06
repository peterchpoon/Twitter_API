package com.personal.twitter;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterClient {
    private String OAuthConsumerKey;
    private String OAuthConsumerSecret;
    private String OAuthAccessToken;
    private String OAuthAccessTokenSecret;
    private Twitter twitter;
    private ConfigurationBuilder configurationBuilder;

    public TwitterClient(String consumerKey, String consumerSecret) {
        setOAuthConsumerKey(consumerKey);
        setOAuthConsumerSecret(consumerSecret);
    }

    public void buildClient() {
        configurationBuilder = new ConfigurationBuilder();

        configurationBuilder.setOAuthConsumerKey(OAuthConsumerKey);
        configurationBuilder.setOAuthConsumerSecret(OAuthConsumerSecret);
        configurationBuilder.setOAuthAccessToken(OAuthAccessToken);
        configurationBuilder.setOAuthAccessTokenSecret(OAuthAccessTokenSecret);

        TwitterFactory tf = new TwitterFactory(configurationBuilder.build());
        twitter = tf.getInstance();
    }

    public void setOAuthConsumerKey(String OAuthConsumerKey) {
        this.OAuthConsumerKey = OAuthConsumerKey;
    }


    public void setOAuthConsumerSecret(String OAuthConsumerSecret) {
        this.OAuthConsumerSecret = OAuthConsumerSecret;
    }


    public void setOAuthAccessToken(String OAuthAccessToken) {
        this.OAuthAccessToken = OAuthAccessToken;
    }


    public void setOAuthAccessTokenSecret(String OAuthAccessTokenSecret) {
        this.OAuthAccessTokenSecret = OAuthAccessTokenSecret;
    }

    public Status tweet(String tweet) throws TwitterException {
        Status status = twitter.updateStatus(tweet);
        return status;
    }

    public ResponseList<Status> getHomeTimeline() throws TwitterException {
        ResponseList<Status> tweets = twitter.getHomeTimeline();
        return tweets;
    }
}
