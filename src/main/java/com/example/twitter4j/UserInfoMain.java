package com.example.twitter4j;

import twitter4j.*;

/**
 * Created by tada on 2015/10/18.
 */
public class UserInfoMain {
    public static void main(String[] args) throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        User user = twitter.verifyCredentials();
        System.out.println(user.getName());
        System.out.println(user.getScreenName());
        System.out.println(user.getFriendsCount());
        System.out.println(user.getFollowersCount());

        Status status = twitter.updateStatus("Twitter4Jから2回目のツイート！ #twitter4j");
    }
}
