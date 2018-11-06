package com.personal.twitter.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.twitter.TwitterClient;
import com.personal.twitter.model.Account;
import com.personal.twitter.model.Timeline;
import com.personal.twitter.dao.AccountDAO;
import com.personal.twitter.model.Tweet;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1")
@Produces(MediaType.APPLICATION_JSON)
public class TimelineResource {
    private TwitterClient client;
    private AccountDAO accountDAO;


    public TimelineResource(TwitterClient client, AccountDAO accountDAO) {
        this.client = client;
        this.accountDAO = accountDAO;
    }

    private void buildClient(String id) {
        Account account = accountDAO.getAccountById(id);

        client.setOAuthAccessToken(account.getOAuthToken());
        client.setOAuthAccessTokenSecret(account.getOAuthSecret());
        client.buildClient();
    }

    @GET
    @Path("/twitter/{id}/timeline")
    public String getHomeTimeline(@PathParam("id") String id) throws TwitterException, JsonProcessingException {
        buildClient(id);
        ResponseList<Status> tweets = client.getHomeTimeline();
        Timeline tl = new Timeline(tweets.size());

        for (Status tweet : tweets) {
            tl.addToTimeline(new Tweet(tweet.getUser().getScreenName(), tweet.getUser().getProfileImageURL(),
                    tweet.getText(), String.valueOf(tweet.getCreatedAt().getTime() / 1000)));
        }

        ObjectMapper mapper = new ObjectMapper();

        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tl);
    }
}
