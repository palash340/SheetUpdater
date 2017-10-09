package com.market.bean;

/**
 * Created by administrator on 8/27/17.
 */
public class StockBean {
    private short key;
    private double close;
    private double high;
    private double low;
    private double open;
    private long volume;


    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public short getKey() {
        return key;
    }

    public void setKey(short key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "StockBean{" +
                "key=" + key +
                ", close=" + close +
                ", high=" + high +
                ", low=" + low +
                ", open=" + open +
                ", volume=" + volume +
                '}';
    }
}
