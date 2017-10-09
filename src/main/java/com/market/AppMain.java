package com.market;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.market.bean.CreateInputData;
import com.market.httpclient.HttpClientUtils;
import com.market.parser.StockResponseParser;
import com.market.spreadsheetutils.SpreadSheetUtils;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by administrator on 8/27/17.
 */
public class AppMain {
    static String spreadsheetId = "1C478zIYH3_Pz5av8-MKVNosH3SFXp2W0PsUxFKRXmfY";

    public static void main(String[] args) throws IOException {
        Sheets service = SpreadSheetUtils.getSheetsService();
        String range = "Screener!A:A";
        //ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
        ValueRange response = SpreadSheetUtils.readRange(spreadsheetId, range);

        // Write Data
        CreateInputData inputData = new CreateInputData();
        List<Object> valueD = Stream.of("Palash2", "Cheenee2").collect(Collectors.toList());
        inputData.addRow(valueD);
        SpreadSheetUtils.writeRange(spreadsheetId, "Formulas!G2:H2", inputData.getInputData());


        //Read Data
        List<List<Object>> values = response.getValues();
        values.remove(0);
        if (values == null || values.size() == 0) {
            System.out.println("No data found.");
        } else {
            List<String> res;
            for (List<Object> value: values) {
                String stockName = (String)value.get(0);
                res = HttpClientUtils.getStockData(stockName, 0);
                StockResponseParser.parserResponse(res,stockName);
                //break;
            }
        }
        // Identify patterns

    }


    public static void identifyPatter(){

    }

}

