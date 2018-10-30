package SeleniumTrainings;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




public class Screenshot {

    @Test
    public void aTest() {
        DriverConfigs driverConfigs = new DriverConfigs();
        driverConfigs.chrome();
        driverConfigs.driver.get("http://www.google.com/");
        //more test logic  - test might pass or fail at this point
        // take the screenshot at the end of every test
        File scrFile = ((TakesScreenshot)driverConfigs.driver).getScreenshotAs(OutputType.FILE);
        // now save the screenshot to a file some place


        try {
            // now copy the  screenshot to desired location using copyFile //method
            FileUtils.copyFile(scrFile, new File("JavaTrainingscreenshot.png"));
        }

        catch (IOException e)
        {
            System.out.println(e.getMessage());

        }


        //quit WebDriver session
        driverConfigs.driver.quit();
    }
}

