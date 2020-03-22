package com.itamar.entity;

import com.datastax.driver.core.utils.UUIDs;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Table(value="tweets")
public class Tweet {
    @PrimaryKeyColumn(name = "tweet_id",ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    private UUID tweet_id = UUIDs.timeBased();

    @PrimaryKeyColumn(name = "user_name",ordinal = 1,type = PrimaryKeyType.CLUSTERED)
    private String user_name;

    @Column(value="tweet")
    private String tweet_text;

    @Column(value="created_at")
    private Date created_at;

    public UUID getTweet_id() {
        return tweet_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public String getTweet_text() {
        return tweet_text;
    }

    public void setTweet_id(UUID tweet_id) {
        this.tweet_id = tweet_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setTweet_text(String tweet_text) {
        this.tweet_text = tweet_text;
    }
}
