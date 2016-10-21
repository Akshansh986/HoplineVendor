package com.hopline.hoplinevendor;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Activity myAct ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myAct = this;
        setContentView(R.layout.activity_main);

        if (DataStore.getConformationOrders() == null)
            new InitialiseDataFromServer().execute("");

    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(
                mMessageReceiver);
        super.onPause();
    }

    @Override
    protected void onResume() {
        LocalBroadcastManager.getInstance(this).registerReceiver(
                mMessageReceiver, new IntentFilter("newOrderForConformation"));
        super.onResume();
    }

    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("ManAct","New orders!!!!!!!!!");
        }
    };

    void cancelClick(View v) {


    }


    private class CancelOrder extends AsyncTask<String, Void, String> {
        ProgressDialog dialog;
        Integer orderId;
        String cancelReason;

        CancelOrder(Integer orderId, String cancelReason){
            this.orderId = orderId;
        }

        @Override
        protected String doInBackground(String... params) {
            return  ServerHelper.markOrderCancel(orderId,cancelReason) ? "success" : "failure";
        }

        @Override
        protected void onPostExecute(String result) {
            if (dialog != null)
                dialog.dismiss();

            if (result.equals("failure")) {
                Toast.makeText(myAct,"Error communicating with server!", Toast.LENGTH_LONG).show();
                return;
            }

            //TODO: start from here.

            OrderVo deletedOrder = new OrderVo();
            deletedOrder.setIdorder(orderId);

            List<OrderVo> localOrderCopy = new ArrayList<OrderVo>(DataStore.getConformationOrders());

            localOrderCopy.remove(deletedOrder);







            Intent intent = new Intent(myAct, DataRefreshServcie.class);
            startService(intent);
        }

        @Override
        protected void onPreExecute() {

            dialog = new ProgressDialog(myAct); // this = YourActivity
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setMessage("Loading. Please wait...");
            dialog.setIndeterminate(true);
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();

        }
    }


    private class InitialiseDataFromServer extends AsyncTask<String, Void, String> {
        ProgressDialog dialog;
        @Override
        protected String doInBackground(String... params) {


            try {
                DataStore.loadEverythingFromServer();
            } catch (Exception e) {
                e.printStackTrace();
                return "failure";
            }

            return "success";
        }

        @Override
        protected void onPostExecute(String result) {
            if (dialog != null)
                dialog.dismiss();

            if (result.equals("failure"))
                Toast.makeText(myAct,"Error communicating with server!", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(myAct, DataRefreshServcie.class);
            startService(intent);
        }

        @Override
        protected void onPreExecute() {

            dialog = new ProgressDialog(myAct); // this = YourActivity
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setMessage("Loading. Please wait...");
            dialog.setIndeterminate(true);
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();

        }
    }



















}
