package com.personal.twitter.mapper;

import com.personal.twitter.model.Account;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements ResultSetMapper<Account>
{
    public Account map(int index, ResultSet r, StatementContext ctx) throws SQLException
    {
        Account account = new Account();
        account.setId(r.getString("id"));
        account.setTwitterId(r.getString("twitter_id"));
        account.setOAuthToken(r.getString("oauth_token"));
        account.setOAuthSecret(r.getString("oauth_secret"));

        return account;
    }
}