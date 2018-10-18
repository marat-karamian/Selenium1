package SeleniumTrainings;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckRadioButton {

    static WebDriver driver;

    @Before
    public void setDriver() {
        DriverConfig driverConfig = new DriverConfig();
        driverConfig.chrome();
        driver = new ChromeDriver();
    }

    @Test
    public void chkRdBtn() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://toolsqa.com/automation-practice-form/");

        List<WebElement> rdBtn = driver.findElements(By.name("sex"));
        boolean bValue = rdBtn.get(0).isSelected();

        if (bValue) {
            rdBtn.get(1).click();
        } else {
            rdBtn.get(0).click();
        }

        driver.findElement(By.id("exp-2")).click();

        List<WebElement> profession = driver.findElements(By.name("profession"));

        int size = profession.size();

        for (int i=0; i<size; i++) {
            String value = profession.get(i).getAttribute("value");
            if (value.equalsIgnoreCase("Automation Tester")) {
                profession.get(i).click();
                break;
            }
        }

        driver.findElement(By.cssSelector("input[value='Selenium IDE']")).click();
    }

    @After
    public void quit() {
        driver.quit();
    }
}
