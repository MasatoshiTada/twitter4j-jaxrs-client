package com.example.jersey.oauth2;

import java.util.ResourceBundle;

/**
 * Created by tada on 2015/10/18.
 */
public class OAuth2JerseyClient {
    public static void main(String[] args) {
        // twitter4j.propertiesからアクセストークンなどの情報を取得
        ResourceBundle bundle = ResourceBundle.getBundle("twitter4j");
        String consumerKeyString = bundle.getString("oauth.consumerKey");
        String consumerSecretString = bundle.getString("oauth.consumerSecret");
        String accessTokenString = bundle.getString("oauth.accessToken");
        String accessTokenSecretString = bundle.getString("oauth.accessTokenSecret");

        // TODO:調査中
    }
}
