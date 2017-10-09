package com.market.parser;

import com.market.bean.StockBean;
import com.market.cache.StockCache;
import com.market.commonutils.CommonUtil;
import com.market.constants.Constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by administrator on 8/30/17.
 */
public class StockResponseParser {
    public static final int SKIP_LINES = 7;
    /*
        EXCHANGE%3DNSE
        MARKET_OPEN_MINUTE=555
        MARKET_CLOSE_MINUTE=930
        INTERVAL=900
        COLUMNS=DATE,CLOSE,HIGH,LOW,OPEN,VOLUME
        DATA=
        TIMEZONE_OFFSET=330
        a1504064700,440,440,440,440,1665
        1,439.95,441.15,437.8,439.8,277393
        2,448.1,448.15,440,440.05,565695
        3,448.5,449,446.4,448.2,477112
        4,448.25,450.65,448.2,448.75,473450
        5,448.05,448.65,447.6,448.4,217535
        6,449.45,450,447.95,448.05,278488
        7,449.55,449.95,449.15,449.45,233945
        8,450.55,451.8,449.45,449.45,482678
        9,452.45,452.75,450.55,450.55,479213
        10,453.3,453.4,452,452.45,293783
        11,453,454.3,452.75,453.1,407488
        12,453.2,453.6,452.9,453,250060
        13,452.5,453.55,452.3,453.4,300068
        14,452.9,453,452.35,452.5,288063
        15,452.5,453,452.3,452.95,184321
        16,452.85,453,452.35,452.5,260136
        17,453.4,454,452.85,452.9,244600
        18,452.75,453.5,450.8,453.4,257266
        19,454.15,454.55,452.5,452.6,376313
        20,453.95,454.2,453.55,454.1,182528
        21,452.7,454.15,452.7,453.95,252782
        22,453.05,454.2,452.25,452.5,281826
        23,453.05,454.45,452.95,452.95,289956
        24,453.6,453.9,453.05,453.15,332511
        25,450.5,454.85,449.85,453.6,1049889
     */
    public static void parserResponse(List<String> stockData, String stockName){
        //stockData.stream().skip(8).forEach(line -> addToCahce(line));
        //List<String> actualResponse = stockData.stream().skip(8).collect(Collectors.toList());
        Map<String, Map<Integer, StockBean>> stockCacheInstance = StockCache.getStockCacheInstance();
        final Map<Integer, StockBean> stockListKey = stockCacheInstance.containsKey(stockName) ? stockCacheInstance.get(stockName) : new HashMap<>();

        stockData.stream().skip(8).forEach(line -> {
            //stockCacheInstance;
            String[] value = line.split(",");
            int key = CommonUtil.parseShort(value[Constants.KEY_INDEX]);
            StockBean bean = parseValues(line);
            stockListKey.put(key, bean);
        });

    }

    public static StockBean parseValues(String line){
        if(null == line && line.length() <= 0)
            return null;
        
        String[] value = line.split(",");
        if(value.length != 6){
            return null;
        }
        StockBean bean = new StockBean();
        bean.setKey(CommonUtil.parseShort(value[Constants.KEY_INDEX]));
        bean.setOpen(CommonUtil.parseDouble(value[Constants.OPEN_INDEX]));
        bean.setClose(CommonUtil.parseDouble(value[Constants.CLOSE_INDEX]));
        bean.setHigh(CommonUtil.parseDouble(value[Constants.HIGH_INDEX]));
        bean.setLow(CommonUtil.parseDouble(value[Constants.LOW_INDEX]));
        bean.setVolume(CommonUtil.parseLong(value[Constants.VOLUME_INDEX]));
        return bean;
    }
}
