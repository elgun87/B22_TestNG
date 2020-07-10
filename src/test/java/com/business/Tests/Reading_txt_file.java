package com.business.Tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Reading_txt_file {
    String readLine;
    String line;

    @Test
    public void readingTxtFile() throws Exception {
        String filePath = System.getProperty("user.dir") + "/company.txt";
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        List<String> list = new ArrayList<>();
        while ((readLine = br.readLine()) != null) {
            line = readLine;
            list.add(line);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        Assert.assertTrue(list.get(1).contains("code2"));
    }


}
