package SeleniumTrainings;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;


public class Coordinates {

    @Test
    public void getCoordinates() {
        String url = "https://en.wikipedia.org/wiki/Main_Page";

        DriverConfigs driverConfigs = new DriverConfigs();
        driverConfigs.ie();

        driverConfigs.driver1.manage().window().maximize();
        driverConfigs.driver1.get(url);

        WebElement button = driverConfigs.driver1.findElement(By.id("ca-talk"));
        button.click();
//        Point location = button.getLocation();
//        System.out.println(location.x + " " + location.y);
//        System.out.println(location.getX() + " " + location.getY());

        driverConfigs.driver1.quit();
    }
}