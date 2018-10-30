package SeleniumTrainings;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.Locatable;

import java.util.concurrent.TimeUnit;

public class MouseActions {

    @Test
    public void mouse() {

        DriverConfigs driverConfigs = new DriverConfigs();
        driverConfigs.chrome();

        driverConfigs.driver.manage().window().maximize();
        driverConfigs.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverConfigs.driver.get("https://en.wikipedia.org/wiki/Main_Page");

        Actions actions = new Actions(driverConfigs.driver);
        WebElement link = driverConfigs.driver.findElement(By.xpath("//*[@id=\"mp-topbanner\"]/div/div[1]/a"));
        actions.click(link).perform();

        driverConfigs.driver.navigate().back();

        driverConfigs.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement link1 = driverConfigs.driver.findElement(By.xpath("//*[@id=\"mp-topbanner\"]/div/div[1]/a"));
        Locatable locatable = (Locatable) link1;
        Mouse mouse = ((HasInputDevices) driverConfigs.driver).getMouse();
        mouse.click(locatable.getCoordinates());


        driverConfigs.driver.quit();
    }
}
