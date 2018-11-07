package SeleniumTrainings;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class Alerts {

    @Test
    public void alerts() throws InterruptedException {
        DriverConfigs driverConfigs = new DriverConfigs();
        driverConfigs.chrome();
        driverConfigs.driver.manage().window().maximize();
        driverConfigs.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driverConfigs.driver.get("http://toolsqa.com/automation-practice-switch-windows");

        driverConfigs.driver.findElement(By.id("alert")).click();

        Alert myAlert = driverConfigs.driver.switchTo().alert();

        Thread.sleep(2000);

        myAlert.accept();

        driverConfigs.driver.quit();
    }
}
