package com.personal.twitter.dao;

import com.personal.twitter.mapper.AccountMapper;
import com.personal.twitter.model.Account;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

public interface AccountDAO {

    @RegisterMapper(AccountMapper.class)
    @SqlQuery("Select id, twitter_id, oauth_token, oauth_secret " +
            "from twitter_accounts " +
            "where twitter_id = :accountId")
    Account getAccountById(@Bind("accountId") String accountId);

}
