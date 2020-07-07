package com.business.Tests;

import com.business.Utilities.ExcelUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class test {
    ExcelUtil excelUtil = new ExcelUtil("src/test/resources/samir.xlsx", "data");

    @DataProvider(name = "input")
    public Object[][] input() {
        Object[][] data = excelUtil.getDataArray();
        return data;
    }

    @Test(dataProvider = "input")
    public void testing(String str1, String str2, String str3, String str4, String str5) {
        List<List<Object>> listOfList = new ArrayList<>();
        List<Object> list = new ArrayList<>();
        list.add(str1);
        list.add(str2);
        list.add(str3);
        list.add(str4);
        list.add(str5);
        listOfList.add(list);
        for(int i= 0; i<listOfList.size() ;i++){
            System.out.println(listOfList.get(i));
        }
    }


}