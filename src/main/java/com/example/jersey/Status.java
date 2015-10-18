package com.example.jersey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by tada on 2015/10/18.
 * @see https://github.com/jersey/jersey/tree/master/examples/oauth-client-twitter
 * @see https://dev.twitter.com/rest/reference/get/statuses/user_timeline
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Status {
    private String text;
    private User user;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return getUser().getName() + ": " + text;
    }
}
