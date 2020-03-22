package com.itamar.repository;

import com.itamar.entity.Tweet;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.UUID;

public interface TweetRepository extends CassandraRepository<Tweet, UUID> {

    @Query("SELECT*FROM tweets WHERE user_name=?0 LIMIT ?1")
    public Iterable<Tweet> findByUserName(String user_name, Integer limit);

    @Query("SELECT*FROM tweets WHERE user=?0 AND id<?1 LIMIT ?2")
    public Iterable<Tweet> findByUserNameFrom(String user_name, UUID from, Integer limit);

}
