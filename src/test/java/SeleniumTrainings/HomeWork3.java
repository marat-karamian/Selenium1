package SeleniumTrainings;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeWork3 {

    static DriverConfigs driverConfigs = new DriverConfigs();

    @BeforeClass
    public static void setUp() {
        driverConfigs.chromeOptions();
        //driverConfigs.driver.manage().window().maximize();
        driverConfigs.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverConfigs.driver.get("https://www.google.com/");
    }

    @Test
    public void isLocatedOnTheFirstPage() throws IOException, InterruptedException {
        WebElement searchBox = driverConfigs.driver.findElement(By.id("lst-ib"));
        searchBox.clear();
        searchBox.sendKeys("selenium automation testing");
        searchBox.submit();
        WebElement wait = (new WebDriverWait(driverConfigs.driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));

        WebElement languageChoice = driverConfigs.driver.findElement(By.xpath("//*[@id=\"Rzn5id\"]/div/a[1]"));
        boolean isDisplayed = languageChoice.isDisplayed();

        if (isDisplayed) {
            languageChoice.click();
        }

        List<WebElement> searchResults = driverConfigs.driver.findElements(By.tagName("a"));

        boolean isPresent = false;

        for (WebElement searchResult : searchResults) {
            if (searchResult.getText().contains("seleniumhq.org")) {
                isPresent = true;
            }
        }
        if (isPresent) {
            WebElement search = driverConfigs.driver.findElement(By.xpath("//*[@id='rso']"));
            File scr = search.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scr, new File("SeleniumHQscreenshot.png"));
        } else {
            System.out.println("Result is not found on the 1st page");
        }
    }


    @AfterClass
    public static void tearDown() {
        driverConfigs.driver.quit();
    }
}
