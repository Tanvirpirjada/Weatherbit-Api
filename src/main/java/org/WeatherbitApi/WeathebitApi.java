package org.WeatherbitApi;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class WeathebitApi {
    public static void main(String[] args) {
        try {
            CallWeatherbitApi();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void CallWeatherbitApi() throws URISyntaxException, IOException {
        //Create object for api 
        URIBuilder builder = new URIBuilder("https://api.weatherbit.io/v2.0/current?lat=38&lon=-78.25&include=minutely&marine=t&units=S&lang=is&key=f0ecf11ac88b42059d34ee2f040ce92d");
        // Creating http getdata  using httpget mathod
        HttpGet getdata=new HttpGet(builder.build());

        //creating a client for send request
        CloseableHttpClient  httpclient= HttpClients.createDefault();

        //create response
        CloseableHttpResponse  response= httpclient.execute(getdata);

        //  get main data
        HttpEntity EntityResponse= response.getEntity();
        // into String
        String result = EntityUtils.toString(EntityResponse);

        System.out.println(result);

        httpclient.close();

    }
}