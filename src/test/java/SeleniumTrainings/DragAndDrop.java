package SeleniumTrainings;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class DragAndDrop {

    @Test
    public void dragnDrop() throws InterruptedException {
        DriverConfigs driverConfigs = new DriverConfigs();
        driverConfigs.firefox();

        driverConfigs.driver.manage().window().maximize();
        driverConfigs.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverConfigs.driver.get("http://demo.guru99.com/test/drag_drop.html");

        WebElement From = driverConfigs.driver.findElement(By.xpath("//*[@id='credit2']/a"));
        WebElement To = driverConfigs.driver.findElement(By.xpath("//*[@id='bank']/li"));

        Actions builder = new Actions(driverConfigs.driver);
        builder.dragAndDrop(From, To).build().perform();

        Thread.sleep(2000);

        driverConfigs.driver.quit();

    }

}
