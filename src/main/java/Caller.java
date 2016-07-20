import java.net.HttpURLConnection;

/**
 * Created by blessingorazulume on 7/20/16.
 */
public class Caller {
    public static void makeAPICall (){
        final Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    new HttpUrlConnectionToApi().sendGet(new OnResponse() {
                        @Override
                        public void response(String response) {
                            if(response != null){
                                try {
                                    join();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                //play with response here


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
