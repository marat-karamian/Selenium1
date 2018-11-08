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
import org.openqa.selenium.NoSuchElementException;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeWork3 {

    static DriverConfigs driverConfigs = new DriverConfigs();

    @BeforeClass
    public static void setUp() {
        driverConfigs.chromeOptions();
        driverConfigs.driver.manage().window().maximize();
        driverConfigs.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverConfigs.driver.get("https://www.google.com/");
    }

    @Test
    public void isLocatedOnTheFirstPage() throws IOException, InterruptedException {
        WebElement searchBox = driverConfigs.driver.findElement(By.id("lst-ib"));
        searchBox.clear();
        searchBox.sendKeys("selenium automation testing");
        searchBox.submit();
        WebElement searchResults = (new WebDriverWait(driverConfigs.driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='rso']")));

        WebElement languageChoice = driverConfigs.driver.findElement(By.xpath("//*[@id=\"Rzn5id\"]/div/a[1]"));
        boolean isDisplayed = languageChoice.isDisplayed();

        if (isDisplayed) {
            languageChoice.click();
        }

        List<WebElement> links = searchResults.findElements(By.tagName("a"));

        boolean isPresent = false;

            if (driverConfigs.driver.findElements(By.cssSelector("[valign=top] > td > a[aria-label=\"Page 1\"]")).size() == 0) {
                for (WebElement desiredLink : links) {
                    if (desiredLink.getText().contains("seleniumhq.org")) {
                        isPresent = true;
                    }
                }
                if (isPresent) {
                    WebElement search = driverConfigs.driver.findElement(By.xpath("//*[@id='rso']"));
                    File scr = search.getScreenshotAs(OutputType.FILE);
                    FileUtils.copyFile(scr, new File("SeleniumHQscreenshot.png"));
                    System.out.println("The page number of the search results is 1");
                } else {
                    System.out.println("Result is not found on the 1st page");
                }
            }
    }

    @Test
    public void isLocatedFurtherThan10thPage() {

    }

    @AfterClass
    public static void tearDown() {
        driverConfigs.driver.quit();
    }
}
