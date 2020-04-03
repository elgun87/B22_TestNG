package com.business.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloaded_Verifying {

    /**           --  FILE DOWNLOADING --
     * Selenium cannot automate Windows_Handling Based actions:
     * File downloading verifying happens only we can verify the specific file downloaded to our computer.
     * We get the file name from the website and using that and our download folder we create a path.
     * Then using Files class in Java library we can verify after clicking the download button,
     * the specific file downloaded to our downloads folder and it exists there
     */


    @Test
    public void verifyFileExistInDownloadedFolder() {
        String fileName = "Java meseleler.java";
        String path = "C:\\Users\\salma\\Downloads\\" + fileName;
        Assert.assertTrue(Files.exists(Paths.get(path)));

    }


}
