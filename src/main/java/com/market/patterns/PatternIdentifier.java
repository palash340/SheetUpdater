package com.market.patterns;

import com.market.bean.StockBean;

/**
 * Created by administrator on 8/27/17.
 */
public class PatternIdentifier {
    public boolean isBullishEngulfing(StockBean prevCandle, StockBean currCandle){
        /*
            Bullish Engulfing Condition
                1.) PreviousClose < PreviousOpen   --> Signifies previous candle is red
                2.) CurrentOpen   < PreviousClose
                3.) CurrentClose  > PreviousOpen
        */

        return (prevCandle.getClose() < prevCandle.getOpen() && currCandle.getOpen() < prevCandle.getClose() && currCandle.getClose() > prevCandle.getOpen());
    }

    public boolean isBearishEngulfing(StockBean prevCandle, StockBean currCandle){
        /*
            Bearish Engulfing Condition
                1.) PreviousClose > PreviousOpen   --> Signifies previous candle is green
                2.) CurrentOpen   > PreviousClose
                3.) CurrentClose  < PreviousOpen
         */
        return (prevCandle.getClose() > prevCandle.getOpen() && currCandle.getOpen() > prevCandle.getClose() && currCandle.getClose() < prevCandle.getOpen());
    }

    public boolean isBullishHarami(StockBean prevCandle, StockBean currCandle){
        /*
            Bullish Harami Condition
                1.) PreviousClose < PreviousOpen   --> Signifies previous candle is red
                2.) CurrentClose  > CurrentOpen   --> Signifies Current candle is green
                2.) CurrentClose  < PreviousOpen
                3.) CurrentOpen   > PreviousClose
         */
        return (prevCandle.getClose() < prevCandle.getOpen() && currCandle.getClose() > currCandle.getOpen() && currCandle.getClose() < prevCandle.getOpen() && currCandle.getOpen() > prevCandle.getClose());
    }

    public boolean isBearishHarami(StockBean prevCandle, StockBean currCandle){
        /*
            Bearish Harami Condition
                1.) PreviousClose > PreviousOpen   --> Signifies previous candle is green
                2.) CurrentClose  < CurrentOpen   --> Signifies Current candle is red
                2.) CurrentClose  > PreviousOpen
                3.) CurrentOpen   < PreviousClose
         */
        return (prevCandle.getClose() > prevCandle.getOpen() && currCandle.getClose() < currCandle.getOpen() && currCandle.getClose() > prevCandle.getOpen() && currCandle.getOpen() < prevCandle.getClose());
    }

}
