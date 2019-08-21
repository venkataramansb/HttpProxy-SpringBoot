//package com.aysncController;
//
//import org.springframework.http.HttpMethod;
//import org.springframework.http.client.SimpleClientHttpRequestFactory;
//import org.springframework.web.client.RestTemplate;
//
//import java.net.InetSocketAddress;
//import java.net.Proxy;
//
//public class Main {
//    public static void main(String args[]) {
////        System.setProperty("http.proxyHost", "19.12.1.40");
////        System.setProperty("http.proxyPort", "83");
//
//        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
//
//        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("19.12.1.40", 83));
//        requestFactory.setProxy(proxy);
//
//        RestTemplate restTemplate = new RestTemplate(requestFactory);
//
//        String url = "https://stg.api.m2m.vodafone.com/m2m/v1/devices/204046856040517";
////        String url = "https://google.com";
//        String result = restTemplate.getForObject(url, String.class);
//
//    }
//}