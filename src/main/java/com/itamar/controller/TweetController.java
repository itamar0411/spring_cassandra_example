package com.itamar.controller;

import com.itamar.entity.Tweet;
import com.itamar.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class TweetController {

    @Autowired
    private TweetRepository tweetRepository;

    @RequestMapping(value = "/tweet",method = RequestMethod.GET)
    @ResponseBody
    public List<Tweet> tweets() {
        List<Tweet> tweets = new ArrayList<>();
        tweetRepository.findAll().forEach(e->tweets.add(e));
        return tweets;
    }

    @RequestMapping(value = "/tweet/{user_name}/",method = RequestMethod.GET)
    @ResponseBody
    public List<Tweet> tweetUserNameLimit(@PathVariable String user_name, Integer limit) {
        List<Tweet> tweets = new ArrayList<>();
        tweetRepository.findByUserName(user_name,limit).forEach(e -> tweets.add(e));
        return tweets;
    }

    @RequestMapping(value = "/tt",method = RequestMethod.POST)
    @ResponseBody
    public String saveGreeting(@RequestBody Tweet tweet) {
        tweet.setCreated_at(new Date());
        tweetRepository.save(tweet);

        return "OK";
    }
}
