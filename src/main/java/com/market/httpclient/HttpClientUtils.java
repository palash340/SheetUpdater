package com.market.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by administrator on 8/27/17.
 */
public class HttpClientUtils {

    public static List<String> getStockData(String stockName, int retry){
        String url = "http://www.google.com/finance/getprices?q="+ stockName + "&x=NSE&i=900&p=1d&f=d,o,h,l,c,v";
        BufferedReader br = null;
        System.out.println("url = " + url);
        List<String> result = null;
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpGet request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);
            br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            String line = "";
            result = new ArrayList<String>();
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        }catch (IOException e) {
            retry++;
            if(retry < 3){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                return getStockData(stockName, retry);
            }
            //System.out.println(e.getLocalizedMessage());
        }finally {
            if(null != br) {
                try {
                    br.close();
                } catch (IOException e1) {
                    //IGNORE Exception
                    //e1.printStackTrace();
                }
            }
        }
        return result;
    }
}
