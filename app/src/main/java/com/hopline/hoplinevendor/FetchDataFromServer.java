package com.hopline.hoplinevendor;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 21/10/16.
 */

public class FetchDataFromServer {

    static List<OrderVo> retrieveOrdersFromServer(List<String> orderStates) throws Exception {

        FetchOrderTo fetchOrderTo = new FetchOrderTo();
        fetchOrderTo.setOrderStates(orderStates);
        fetchOrderTo.setShopId(1);

        DummyModel dm = new DummyModel();
        dm.setFetchOrder(fetchOrderTo);


        final String url = "http://hopline.us-east-1.elasticbeanstalk.com/rest/fetchOrders";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        fetchOrderTo = restTemplate.postForObject(url,dm, FetchOrderTo.class);

        if (fetchOrderTo == null || fetchOrderTo.getOrders() == null) return new ArrayList<OrderVo>();

        return fetchOrderTo.getOrders();
    }

    public static List<OrderVo> retrieveOrderForConformation() throws  Exception{

        List<String> states = new ArrayList<>();
        states.add(OrderStates.OK_ORDER);
        states.add(OrderStates.BIG_ORDER_CALL);
        states.add(OrderStates.DEFAULTER_CALL);

        return retrieveOrdersFromServer(states);
    }

    public static List<OrderVo> retrievePreparingOrders() throws  Exception{

        List<String> states = new ArrayList<>();
        states.add(OrderStates.PREPARING);

        return retrieveOrdersFromServer(states);
    }

    public static List<OrderVo> retrieveReadyOrders() throws  Exception {

        List<String> states = new ArrayList<>();
        states.add(OrderStates.READY_FOR_PICKUP);

        return retrieveOrdersFromServer(states);
    }

    public static List<OrderVo> retrieveBigOrderPayOrders() throws  Exception {

        List<String> states = new ArrayList<>();
        states.add(OrderStates.BIG_ORDER_PAY);

        return retrieveOrdersFromServer(states);
    }




}
