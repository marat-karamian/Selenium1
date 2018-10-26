package SeleniumTrainings;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Size {

    //static WebDriver driver;

//    @Before
//    public void setDriver() {
//        DriverConfigs driverConfig = new DriverConfigs();
//        driverConfig.chrome();
//        driver = new ChromeDriver();
//    }

    @Test
    public void getSize() {
        DriverConfigs driverConfigs = new DriverConfigs();
        driverConfigs.chrome();
        driverConfigs.driver.get("https://www.google.com/");
        WebElement button = driverConfigs.driver.findElement(By.name("btnK"));
        System.out.println(button.getSize());
        System.out.println(button.getSize().height + " " + button.getSize().width);
        System.out.println(button.getSize().getHeight() + " " + button.getSize().getWidth());
        driverConfigs.driver.quit();
    }

    @After
    public void tearDown() {

    }
}