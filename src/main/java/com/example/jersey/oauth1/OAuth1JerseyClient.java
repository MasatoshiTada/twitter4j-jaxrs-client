package com.example.jersey.oauth1;

import com.example.jersey.Status;
import org.glassfish.jersey.client.oauth1.AccessToken;
import org.glassfish.jersey.client.oauth1.ConsumerCredentials;
import org.glassfish.jersey.client.oauth1.OAuth1ClientSupport;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by tada on 2015/10/18.
 * @see https://github.com/jersey/jersey/tree/master/examples/oauth-client-twitter
 * @see https://dev.twitter.com/rest/reference/get/statuses/user_timeline
 */
public class OAuth1JerseyClient {
    public static void main(String[] args) {
        // twitter4j.propertiesからアクセストークンなどの情報を取得
        ResourceBundle bundle = ResourceBundle.getBundle("twitter4j");
        String consumerKeyString = bundle.getString("oauth.consumerKey");
        String consumerSecretString = bundle.getString("oauth.consumerSecret");
        String accessTokenString = bundle.getString("oauth.accessToken");
        String accessTokenSecretString = bundle.getString("oauth.accessTokenSecret");

        // 自分のツイートリストを取得するURL
//        String url = "https://api.twitter.com/1.1/statuses/user_timeline.json";
        // フォローしている人のツイートリストを取得するURL
        String url = "https://api.twitter.com/1.1/statuses/home_timeline.json";

        ConsumerCredentials consumerCredentials = new ConsumerCredentials(consumerKeyString, consumerSecretString);
        AccessToken accessToken = new AccessToken(accessTokenString, accessTokenSecretString);

        Feature filterFeature = OAuth1ClientSupport.builder(consumerCredentials)
                .feature()
                .accessToken(accessToken)
                .build();

        Client client = ClientBuilder.newBuilder()
                .register(filterFeature)
                .register(JacksonFeature.class)
                .build();

        Response response = null;

        try {
            // リクエスト送信
            response = client.target(url)
                    .queryParam("count", "5")
                    .request()
                    .get();

            System.out.println("HTTP status code = " + response.getStatus());
            System.out.println("Content-Length = " + response.getLength());

            if (response.getStatus() == 200) {
                List<Status> statusList = response.readEntity(new GenericType<List<Status>>() {
                });
                statusList.forEach(System.out::println);
            } else {
                System.out.println("ERROR!! : " + response.getStatus());
                String errorJson = response.readEntity(String.class);
                System.out.println(errorJson);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }
}
