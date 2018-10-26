package SeleniumTrainings;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class HomeWork1 {

    @Test
    public void hw1() {
        DriverConfigs driverConfigs = new DriverConfigs();
        driverConfigs.chromeOptions();
        driverConfigs.driver.manage().window().maximize();
        driverConfigs.driver.get("https://facebook.com");

        driverConfigs.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement email = driverConfigs.driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys("mkaramyan.dp3@gmail.com");

        WebElement pass = driverConfigs.driver.findElement(By.id("pass"));
        pass.clear();
        pass.sendKeys("TestPassword");

        driverConfigs.driver.findElement(By.id("loginbutton")).click();

        driverConfigs.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Checks if user is logged in

        boolean isLogged = driverConfigs.driver.findElement(By.xpath("//*[@id=\"navItem_4748854339\"]/a/div")).isDisplayed();

        if (isLogged) {
            System.out.println("The user is logged in");
        } else {
            System.out.println("The user is not logged in");
        }

        driverConfigs.driver.quit();
    }
}