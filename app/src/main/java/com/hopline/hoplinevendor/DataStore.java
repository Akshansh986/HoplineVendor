package com.hopline.hoplinevendor;

import java.util.List;

/**
 * Created by root on 20/10/16.
 */

public class DataStore {


    private static List<OrderVo> conformationOrders;
    private static List<OrderVo> preparingOrders;
    private static List<OrderVo> readyOrders;

    public static synchronized List<OrderVo> getConformationOrders() {
        return conformationOrders;
    }

    public static synchronized void setConformationOrders(List<OrderVo> conformationOrders) {
        DataStore.conformationOrders = conformationOrders;
    }

    public static synchronized List<OrderVo> getPreparingOrders() {
        return preparingOrders;
    }

    public static synchronized void setPreparingOrders(List<OrderVo> preparingOrders) {
        DataStore.preparingOrders = preparingOrders;
    }

    public static synchronized List<OrderVo> getReadyOrders() {
        return readyOrders;
    }

    public static synchronized void setReadyOrders(List<OrderVo> readyOrders) {
        DataStore.readyOrders = readyOrders;
    }


    public static synchronized void loadEverythingFromServer() throws  Exception{

        setConformationOrders(ServerHelper.retrieveOrderForConformation());
        setPreparingOrders(ServerHelper.retrievePreparingOrders());
        setReadyOrders(ServerHelper.retrieveReadyOrders());


    }
}

