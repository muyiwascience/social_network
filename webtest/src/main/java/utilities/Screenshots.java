package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Screenshots {

    private WebDriver driver;
    private static File scrFile;

    public Screenshots(WebDriver driver){
        this.driver = driver;
    }


    public void takeShot(String ScreenName) {
        try {

            Calendar cal = new GregorianCalendar();
            int month = cal.get(Calendar.MONTH); //3
            int year = cal.get(Calendar.YEAR); //2014
            int sec = cal.get(Calendar.SECOND);
            int min = cal.get(Calendar.MINUTE);
            int date = cal.get(Calendar.DATE);
            int day = cal.get(Calendar.HOUR_OF_DAY);

            scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                String timeStamp = year + "-" + date + "-" + (month + 1) + "-" + day + "-" + min + "-" + sec;
                String systemPath = System.getProperty("user.dir");
                String fullPath = systemPath + "/target/test_report/screen_report/"+ScreenName + timeStamp;
                File destFile = new File(fullPath + ".png");
                FileUtils.copyFile(scrFile, destFile);
            } catch (IOException e) {
            }
        } catch (IllegalArgumentException e) {

        }
    }}

