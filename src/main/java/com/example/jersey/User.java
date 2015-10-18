package com.example.jersey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by tada on 2015/10/18.
 * @see https://github.com/jersey/jersey/tree/master/examples/oauth-client-twitter
 * @see https://dev.twitter.com/rest/reference/get/statuses/user_timeline
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
