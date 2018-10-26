package SeleniumTrainings;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindAllLinks {

    static WebDriver driver;

    @Before
    public void setDriver() {
        DriverConfigs driverConfigs = new DriverConfigs();
        driverConfigs.chrome();
        driver = new ChromeDriver();
    }

    @Test
    public void findLinks() {
        driver.manage().window().maximize();
        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        List<WebElement> links = driver.findElements(By.tagName("a"));

        int size = links.size();
        System.out.println(size);

        for (int i = 0; i < size; i++) {
            System.out.println(i + " " + links.get(i).getText());
        }
    }

    @After
    public void quit() {
        driver.quit();
    }
}
