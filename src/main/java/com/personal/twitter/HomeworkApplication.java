package com.personal.twitter;

import com.personal.twitter.resources.TweetResource;
import com.personal.twitter.dao.AccountDAO;
import com.personal.twitter.resources.TimelineResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class HomeworkApplication extends Application<HomeworkConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HomeworkApplication().run(args);
    }

    @Override
    public String getName() {
        return "Homework";
    }

    @Override
    public void initialize(final Bootstrap<HomeworkConfiguration> bootstrap) {
    }

    @Override
    public void run(final HomeworkConfiguration configuration, final Environment environment) {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "sqlite");
        final AccountDAO accountDAO = jdbi.onDemand(AccountDAO.class);
        final TwitterClient client = new TwitterClient(configuration.getTwitterConsumerKey(), configuration.getTwitterConsumerSecret());
        environment.jersey().register(new TweetResource(client, accountDAO));
        environment.jersey().register(new TimelineResource(client, accountDAO));
    }

}
