package SeleniumTrainings;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HomeWork2 {

    @Test
    public void hw2() throws IOException {
        DriverConfigs driverConfigs = new DriverConfigs();
        driverConfigs.chrome();

        driverConfigs.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        driverConfigs.driver.get("https://en.wikipedia.org/wiki/Main_Page");

        WebElement didYouKnow = driverConfigs.driver.findElement(By.xpath("//*[@id='mp-dyk']//img"));

        File scr1 = (didYouKnow).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(scr1, new File("E:\\Java\\didYouKnow.png"));

        WebElement inTheNews = driverConfigs.driver.findElement(By.id("mp-itn"));

        File scr2 = inTheNews.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(scr2, new File("E:\\Java\\inTheNews.png"));

        driverConfigs.driver.quit();
    }
}
