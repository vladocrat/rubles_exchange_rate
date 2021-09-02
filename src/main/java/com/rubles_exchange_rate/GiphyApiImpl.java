package com.rubles_exchange_rate;


import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GiphyApiImpl implements GiphyApi{
   private GiphyApiConfig config;
   private GifResponseMapper mapper;

    @Override
    public GifResponse getRandomGif(String tag) {
        //"XqfoKHCqG1qMCneQDCfKZN4BOvbRDY1C";
        //https://api.giphy.com/

        String apiUrl = config.getEndpoint()
                + config.getApiVersion() +
                "/gifs/random?api_key=" + config.getApiKey() + "&tag=" + tag;


        BufferedReader bufferedReader;
        try{
            StringBuffer response = new StringBuffer();
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            String responseMsg = connection.getResponseMessage();
            System.out.println(responseMsg);

            int responseCode = connection.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
            bufferedReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;

            while ((inputLine = bufferedReader.readLine()) != null) {
                response.append(inputLine);
            }
            bufferedReader.close();


            return mapper.map(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public GiphyApiImpl(GiphyApiConfig config, GifResponseMapper mapper) {
        this.config = config;
        this.mapper = mapper;
    }
}
