package com.market.cache;

import com.market.bean.StockBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by administrator on 8/27/17.
 */
public class StockCache {
    private static Map<String, Map<Integer, StockBean>> cache;

    public static Map<String, Map<Integer, StockBean>> getStockCacheInstance(){
        if(cache == null){
            cache = new HashMap<>();
        }
        return cache;
    }
}
