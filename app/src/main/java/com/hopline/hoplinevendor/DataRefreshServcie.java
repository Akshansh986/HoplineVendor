package com.hopline.hoplinevendor;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 20/10/16.
 */

public class DataRefreshServcie extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();


    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("servcie", "enterned onstart command");
        startNewThread();
        return START_STICKY;
    }

    private void startNewThread() {

        new Thread() {
            public void run() {
                try {
//                    System.out.println("Does it work?");
                    FetchOrderTo fetchOrderTo = new FetchOrderTo();
                    List<String> orderStates = new ArrayList<String>();
                    orderStates.add(OrderStates.CANCELLED);
                    orderStates.add(OrderStates.PREPARING);
                    fetchOrderTo.setOrderStates(orderStates);
                    fetchOrderTo.setShopId(1);

                    DummyModel dm = new DummyModel();
                    dm.setFetchOrder(fetchOrderTo);


                    final String url = "http://hopline.us-east-1.elasticbeanstalk.com/rest/fetchOrders";
                    RestTemplate restTemplate = new RestTemplate();
                    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                    fetchOrderTo = restTemplate.postForObject(url,dm, FetchOrderTo.class);


                    Log.d("sercvie", "going to sleep");

                    Thread.sleep(1000);
                    Log.d("sender", "Broadcasting message");
                    Intent intent = new Intent("custom-event-name");
                    // You can also include some extra data.
                    intent.putExtra("message", "This is my message akshansh!");


                    LocalBroadcastManager.getInstance(getBaseContext()).sendBroadcast(intent);


                    Log.d("service", "sleep done");


                } catch(InterruptedException v) {
                    System.out.println(v);
                }
            }
        }.start();
    }
}
