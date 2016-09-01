package com.blessing.calculator;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by blessingorazulume on 7/20/16.
 */
public class Caller {
    public static void makeAPICall (final OnResponse onResponse){
        final Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    new HttpUrlConnectionToApi().sendGet(new OnResponse() {
                        @Override
                        public void response(JSONObject response) {
                            if(response != null){
                                try {
                                    onResponse.response(response);
                                    join();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                            }
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
    }
}
