package com.blessing.calculator;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by blessingorazulume on 7/19/16.
 */
public class HttpUrlConnectionToApi {

    public static final String ACCESS_KEY = "810a36e38923afe99b54ca99e8841985";
    public static final String BASE_URL = "http://apilayer.net/api/";
    public static final String ENDPOINT = "live";

    // this object is used for executing requests to the (REST) HttpUrlConnectionToApi
    public void sendGet(OnResponse jsonResponse) throws Exception {
        String url = BASE_URL+ENDPOINT+"?access_key="+ACCESS_KEY;

        URL obj = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();
        httpURLConnection.setRequestMethod("GET");

        //Request header
//        httpURLConnection.setRequestProperty("User-Agent", user);

        int respondCode = httpURLConnection.getResponseCode();
        System.out.println("\nSending a GET request to URL : " + url);

        BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String inputLine;

        StringBuffer resp = new StringBuffer();

        while((inputLine = in.readLine()) != null) {
            resp.append(inputLine);
        }

        in.close();

        //play with response here
        try {
            JSONObject jsonObject = new JSONObject(resp.toString());
//            System.out.println(jsonObject.toString());

            JSONObject quotesObj = new JSONObject(jsonObject.optString("quotes"));
//            System.out.println(quotesObj.optString("USDNGN"));

            jsonResponse.response(quotesObj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}

//convert method, taking 3 params()
// google web tool kit(front and backend, )
