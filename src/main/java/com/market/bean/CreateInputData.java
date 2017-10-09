package com.market.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by administrator on 9/4/17.
 */
public class CreateInputData {
    private List<List<Object>> inputData;

    public CreateInputData(){
        setInputData(new ArrayList<>());
    }

    public boolean addRow(List<Object> row){
        return getInputData().add(row);
    }

    public List<List<Object>> getInputData() {
        return inputData;
    }

    public void setInputData(List<List<Object>> inputData) {
        this.inputData = inputData;
    }
}
