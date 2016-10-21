package com.hopline.hoplinevendor;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

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
        startOrderForConformationRefresh();
        return START_STICKY;
    }

    private static volatile boolean locallyUpdated;


    




    private void startOrderForConformationRefresh() {

        new Thread() {
            public void run() {


                while (true) {

                    try {
                        Thread.sleep(10000);

                        if (DataStore.getConformationOrders() == null) {
                            Log.d("servcie", "Local data null!! going to refresh everyting");
                            DataStore.loadEverythingFromServer();
                        }

                        Log.d("servcie", "Going to refresh Conformation List");
                        List<OrderVo> serverOrders = ServerHelper.retrieveOrderForConformation();

                        List<OrderVo> localOrders = DataStore.getConformationOrders();


                        List<OrderVo> serverBackup = new ArrayList<OrderVo>(serverOrders);

                        serverOrders.removeAll(localOrders);

                        if (!serverOrders.isEmpty()) {
                            Log.d("servcie", "New item added on server");
                            DataStore.setConformationOrders(serverBackup);
                            Intent intent = new Intent("newOrderForConformation");
                            LocalBroadcastManager.getInstance(getBaseContext()).sendBroadcast(intent);
                        }

                        Log.d("servcie", "Refresh done, sleeeping for 10 secs");

                    }  catch (Exception e) {
                        e.printStackTrace();
                    }


                }
            }
        }.start();
    }
}
