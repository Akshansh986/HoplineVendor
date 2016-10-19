package com.hopline.hoplinevendor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        String s = "{\"orderStates\":[\"CANCELLED\",\"PREPARING\"],\"orders\":[{\"cancelReason\":\"Testing\",\"customerOrderId\":190,\"idorder\":190,\"orderCreator\":\"\",\"orderProducts\":[{\"count\":1,\"idorderProduct\":411,\"orderProductAddons\":[],\"product\":{\"addOns\":[],\"expanded\":false,\"longDesc\":\"-\",\"name\":\"Asian Ratatouille\",\"price\":100,\"productId\":6,\"quantity\":1,\"shortDesc\":\"English Vegetable Sandwich\",\"stockYn\":\"Y\",\"vegYn\":\"Y\"}}],\"orderState\":\"CANCELLED\",\"orderTime\":\"2016-10-14T18:31:49\",\"paidYn\":\"N\",\"shop\":{\"activeYn\":\"Y\",\"idshop\":1,\"imgUrl\":null,\"phone\":\"9560558201\",\"shopName\":\"Bistro 37\"},\"totalItemCount\":1,\"totalPrice\":100,\"user\":{\"iduser\":47,\"name\":\"akshansh\",\"phone\":\"9999966666\"}},{\"cancelReason\":null,\"customerOrderId\":220,\"idorder\":220,\"orderCreator\":\"\",\"orderProducts\":[{\"count\":1,\"idorderProduct\":471,\"orderProductAddons\":[],\"product\":{\"addOns\":[],\"expanded\":false,\"longDesc\":\"-\",\"name\":\"Wow\",\"price\":130,\"productId\":9,\"quantity\":1,\"shortDesc\":\"Oriental Paneer Sandwich\",\"stockYn\":\"Y\",\"vegYn\":\"Y\"}},{\"count\":1,\"idorderProduct\":472,\"orderProductAddons\":[],\"product\":{\"addOns\":[],\"expanded\":false,\"longDesc\":\"-\",\"name\":\"Asian Ratatouille\",\"price\":100,\"productId\":6,\"quantity\":1,\"shortDesc\":\"English Vegetable Sandwich\",\"stockYn\":\"Y\",\"vegYn\":\"Y\"}}],\"orderState\":\"PREPARING\",\"orderTime\":\"2016-10-17T02:02:13\",\"paidYn\":\"Y\",\"shop\":{\"activeYn\":\"Y\",\"idshop\":1,\"imgUrl\":null,\"phone\":\"9560558201\",\"shopName\":\"Bistro 37\"},\"totalItemCount\":2,\"totalPrice\":230,\"user\":{\"iduser\":51,\"name\":\"ayush arnav\",\"phone\":\"9958675060\"}},{\"cancelReason\":null,\"customerOrderId\":227,\"idorder\":227,\"orderCreator\":\"\",\"orderProducts\":[{\"count\":1,\"idorderProduct\":491,\"orderProductAddons\":[],\"product\":{\"addOns\":[],\"expanded\":false,\"longDesc\":\"-\",\"name\":\"Asian Ratatouille\",\"price\":100,\"productId\":6,\"quantity\":1,\"shortDesc\":\"English Vegetable Sandwich\",\"stockYn\":\"Y\",\"vegYn\":\"Y\"}},{\"count\":1,\"idorderProduct\":492,\"orderProductAddons\":[],\"product\":{\"addOns\":[],\"expanded\":false,\"longDesc\":\"-\",\"name\":\"Wow\",\"price\":130,\"productId\":9,\"quantity\":1,\"shortDesc\":\"Oriental Paneer Sandwich\",\"stockYn\":\"Y\",\"vegYn\":\"Y\"}},{\"count\":1,\"idorderProduct\":490,\"orderProductAddons\":[],\"product\":{\"addOns\":[],\"expanded\":false,\"longDesc\":\"-\",\"name\":\"Asian Ratatouille\",\"price\":100,\"productId\":6,\"quantity\":1,\"shortDesc\":\"English Vegetable Sandwich\",\"stockYn\":\"Y\",\"vegYn\":\"Y\"}}],\"orderState\":\"CANCELLED\",\"orderTime\":\"2016-10-17T14:04:35\",\"paidYn\":\"N\",\"shop\":{\"activeYn\":\"Y\",\"idshop\":1,\"imgUrl\":null,\"phone\":\"9560558201\",\"shopName\":\"Bistro 37\"},\"totalItemCount\":3,\"totalPrice\":330,\"user\":{\"iduser\":51,\"name\":\"ayush arnav\",\"phone\":\"9958675060\"}},{\"cancelReason\":null,\"customerOrderId\":228,\"idorder\":228,\"orderCreator\":\"\",\"orderProducts\":[{\"count\":1,\"idorderProduct\":494,\"orderProductAddons\":[],\"product\":{\"addOns\":[],\"expanded\":false,\"longDesc\":\"-\",\"name\":\"Asian Ratatouille\",\"price\":100,\"productId\":6,\"quantity\":1,\"shortDesc\":\"English Vegetable Sandwich\",\"stockYn\":\"Y\",\"vegYn\":\"Y\"}},{\"count\":1,\"idorderProduct\":493,\"orderProductAddons\":[],\"product\":{\"addOns\":[],\"expanded\":false,\"longDesc\":\"-\",\"name\":\"Wow\",\"price\":130,\"productId\":9,\"quantity\":1,\"shortDesc\":\"Oriental Paneer Sandwich\",\"stockYn\":\"Y\",\"vegYn\":\"Y\"}}],\"orderState\":\"CANCELLED\",\"orderTime\":\"2016-10-17T15:42:11\",\"paidYn\":\"N\",\"shop\":{\"activeYn\":\"Y\",\"idshop\":1,\"imgUrl\":null,\"phone\":\"9560558201\",\"shopName\":\"Bistro 37\"},\"totalItemCount\":2,\"totalPrice\":230,\"user\":{\"iduser\":51,\"name\":\"ayush arnav\",\"phone\":\"9958675060\"}},{\"cancelReason\":null,\"customerOrderId\":229,\"idorder\":229,\"orderCreator\":\"\",\"orderProducts\":[{\"count\":1,\"idorderProduct\":496,\"orderProductAddons\":[],\"product\":{\"addOns\":[],\"expanded\":false,\"longDesc\":\"-\",\"name\":\"Wow\",\"price\":130,\"productId\":9,\"quantity\":1,\"shortDesc\":\"Oriental Paneer Sandwich\",\"stockYn\":\"Y\",\"vegYn\":\"Y\"}},{\"count\":1,\"idorderProduct\":495,\"orderProductAddons\":[],\"product\":{\"addOns\":[],\"expanded\":false,\"longDesc\":\"-\",\"name\":\"Asian Ratatouille\",\"price\":100,\"productId\":6,\"quantity\":1,\"shortDesc\":\"English Vegetable Sandwich\",\"stockYn\":\"Y\",\"vegYn\":\"Y\"}}],\"orderState\":\"CANCELLED\",\"orderTime\":\"2016-10-17T13:19:05\",\"paidYn\":\"N\",\"shop\":{\"activeYn\":\"Y\",\"idshop\":1,\"imgUrl\":null,\"phone\":\"9560558201\",\"shopName\":\"Bistro 37\"},\"totalItemCount\":2,\"totalPrice\":230,\"user\":{\"iduser\":51,\"name\":\"ayush arnav\",\"phone\":\"9958675060\"}},{\"cancelReason\":null,\"customerOrderId\":235,\"idorder\":235,\"orderCreator\":\"\",\"orderProducts\":[{\"count\":1,\"idorderProduct\":503,\"orderProductAddons\":[],\"product\":{\"addOns\":[],\"expanded\":false,\"longDesc\":\"-\",\"name\":\"The Loaded Ming\",\"price\":130,\"productId\":17,\"quantity\":1,\"shortDesc\":\"Oriental Chicken Sandwich\",\"stockYn\":\"Y\",\"vegYn\":\"N\"}}],\"orderState\":\"PREPARING\",\"orderTime\":\"2016-10-17T15:34:11\",\"paidYn\":\"N\",\"shop\":{\"activeYn\":\"Y\",\"idshop\":1,\"imgUrl\":null,\"phone\":\"9560558201\",\"shopName\":\"Bistro 37\"},\"totalItemCount\":1,\"totalPrice\":130,\"user\":{\"iduser\":2,\"name\":\"Akshansh\",\"phone\":\"9560558203\"}},{\"cancelReason\":null,\"customerOrderId\":261,\"idorder\":261,\"orderCreator\":\"\",\"orderProducts\":[{\"count\":2,\"idorderProduct\":581,\"orderProductAddons\":[],\"product\":{\"addOns\":[],\"expanded\":false,\"longDesc\":\"-\",\"name\":\"Mr Spicy Soyabean\",\"price\":100,\"productId\":5,\"quantity\":1,\"shortDesc\":\"Healthy Soya Chaap Sandwich\",\"stockYn\":\"Y\",\"vegYn\":\"Y\"}}],\"orderState\":\"PREPARING\",\"orderTime\":\"2016-10-19T00:19:39\",\"paidYn\":\"Y\",\"shop\":{\"activeYn\":\"Y\",\"idshop\":1,\"imgUrl\":null,\"phone\":\"9560558201\",\"shopName\":\"Bistro 37\"},\"totalItemCount\":2,\"totalPrice\":200,\"user\":{\"iduser\":2,\"name\":\"Akshansh\",\"phone\":\"9560558203\"}},{\"cancelReason\":null,\"customerOrderId\":262,\"idorder\":262,\"orderCreator\":\"\",\"orderProducts\":[{\"count\":2,\"idorderProduct\":582,\"orderProductAddons\":[],\"product\":{\"addOns\":[],\"expanded\":false,\"longDesc\":\"-\",\"name\":\"Mr Spicy Soyabean\",\"price\":100,\"productId\":5,\"quantity\":1,\"shortDesc\":\"Healthy Soya Chaap Sandwich\",\"stockYn\":\"Y\",\"vegYn\":\"Y\"}}],\"orderState\":\"PREPARING\",\"orderTime\":\"2016-10-19T00:21:25\",\"paidYn\":\"Y\",\"shop\":{\"activeYn\":\"Y\",\"idshop\":1,\"imgUrl\":null,\"phone\":\"9560558201\",\"shopName\":\"Bistro 37\"},\"totalItemCount\":2,\"totalPrice\":200,\"user\":{\"iduser\":54,\"name\":\"akshansh a\",\"phone\":\"9560558213\"}},{\"cancelReason\":null,\"customerOrderId\":263,\"idorder\":263,\"orderCreator\":\"vendor\",\"orderProducts\":[{\"count\":2,\"idorderProduct\":583,\"orderProductAddons\":[],\"product\":{\"addOns\":[],\"expanded\":false,\"longDesc\":\"-\",\"name\":\"Mr Spicy Soyabean\",\"price\":100,\"productId\":5,\"quantity\":1,\"shortDesc\":\"Healthy Soya Chaap Sandwich\",\"stockYn\":\"Y\",\"vegYn\":\"Y\"}}],\"orderState\":\"PREPARING\",\"orderTime\":\"2016-10-19T00:33:18\",\"paidYn\":\"Y\",\"shop\":{\"activeYn\":\"Y\",\"idshop\":1,\"imgUrl\":null,\"phone\":\"9560558201\",\"shopName\":\"Bistro 37\"},\"totalItemCount\":2,\"totalPrice\":200,\"user\":{\"iduser\":54,\"name\":\"akshansh a\",\"phone\":\"9560558213\"}}],\"shopId\":1,\"success\":true}" ;
//
//        Gson gson = new GsonBuilder()
//                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
//
//
//        FetchOrderTo fetchOrderTo = gson.fromJson(s, FetchOrderTo.class);
//
//        fetchOrderTo.getOrders();



        Intent intent = new Intent(this, DataRefreshServcie.class);
        startService(intent);






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
                mMessageReceiver, new IntentFilter("custom-event-name"));
        super.onResume();
    }

    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            // Get extra data included in the Intent
            String message = intent.getStringExtra("message");
            Log.d("receiver", "Got message: " + message);
        }
    };


}
