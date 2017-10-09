package com.market.bean;

import com.google.api.services.sheets.v4.model.ValueRange;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by administrator on 8/29/17.
 */
public class ValueRangeBean {
    private List<ValueRange> valueRangeLst;

    public List<ValueRange> valueRangeLst() {
        return valueRangeLst;
    }

    public void addValueRange(ValueRange valueRange){
        if(null == valueRangeLst)
            valueRangeLst = new ArrayList<>();
        if(valueRange != null)
            valueRangeLst.add(valueRange);
    }

    public ValueRange getValueRange(String range, List<List<Object>> values){
        return new ValueRange().setRange(range).setValues(values);
    }
}
