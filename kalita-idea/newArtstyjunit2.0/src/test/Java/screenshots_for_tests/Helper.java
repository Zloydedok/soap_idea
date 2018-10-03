package screenshots_for_tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Helper {
    public void takeScreenshot(WebDriver browser,String status){
        TakesScreenshot takesScreenshot = (TakesScreenshot) browser;
        File scrFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String fileName = "screenShot.png";
        String absoluteFileName ="./target/screenshots"+ "/" + fileName;
        File destFile = new File(absoluteFileName);
        try {
            FileUtils.copyFile(scrFile, destFile);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
        File file = new File("./target/screenshots/result.txt");

        try
        {
            FileWriter writer = new FileWriter(file);
            // запись всей строки
            String text = status;
            writer.write(text);

            writer.flush();
        }
        catch(IOException ex) {

            System.out.println(ex.getMessage());
        }
    }


}