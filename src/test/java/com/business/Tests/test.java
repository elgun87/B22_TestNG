package com.business.Tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test {
    //    ExcelUtil excelUtil = new ExcelUtil("src/test/resources/samir.xlsx", "data");
//
//    @DataProvider(name = "input")
//    public Object[][] input() {
//        Object[][] data = excelUtil.getDataArray();
//        return data;
//    }
//
//    @Test(dataProvider = "input")
//    public void testing(String str1, String str2, String str3, String str4, String str5) {
//        List<List<Object>> listOfList = new ArrayList<>();
//        List<Object> list = new ArrayList<>();
//        list.add(str1);
//        list.add(str2);
//        list.add(str3);
//        list.add(str4);
//        list.add(str5);
//        listOfList.add(list);
//        for(int i= 0; i<listOfList.size() ;i++){
//            System.out.println(listOfList.get(i));
//        }
//    }
    public static void main(String[] args) {
        String str1 = "09 Jul 10650 PUT";
        String str2 = "10650 Put 09 Jul";
        System.out.println(isSame(str1, str2));
    }

    public static boolean isSame(String str1, String str2) {
        String[] str1Arr = str1.toLowerCase().split(" ");
        String[] str2Arr = str2.toLowerCase().split(" ");
        List<String> listStr1 = new ArrayList<>();
        List<String> listStr2 = new ArrayList<>();
        for (String s : str1Arr) {
            listStr1.add(s);
        }
        for (String st : str2Arr) {
            listStr2.add(st);
        }
        Collections.sort(listStr1);
        Collections.sort(listStr2);
        if (listStr1.equals(listStr2)) {
            return true;
        }
        return false;
    }


}