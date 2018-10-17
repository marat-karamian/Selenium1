package SeleniumTrainings;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise1 {

    static WebDriver driver;

    @Before
    public void setDriver() {
        DriverConfig driverConfig = new DriverConfig();
        driverConfig.chrome();
        driver = new ChromeDriver();
    }

    @Test
    public void ex1() {
        String url = "https://en.wikipedia.org";
        driver.get(url);

        String title = driver.getTitle();
        int titleLength = title.length();

        System.out.println("Page title is " + title);
        System.out.println("Title length is " + titleLength);

        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.equals(url)) {
            System.out.println("Verification is successful");
        } else {
            System.out.println("Verification failed");
            System.out.println("Actual url is " + actualUrl);
            System.out.println("Expected url is " + url);
        }

        String pageSource = driver.getPageSource();
        System.out.println(pageSource.length());
    }

    @After
    public void quit() {
        driver.quit();
    }
}
