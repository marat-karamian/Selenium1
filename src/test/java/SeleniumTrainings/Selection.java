package SeleniumTrainings;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Selection {

    @Test
    public void isSelect() throws InterruptedException {
        DriverConfigs driverConfigs = new DriverConfigs();
        driverConfigs.chrome();

        driverConfigs.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverConfigs.driver.manage().window().maximize();
        driverConfigs.driver.get("http://toolsqa.com/automation-practice-form/");

        WebElement continents = driverConfigs.driver.findElement(By.id("continents"));
        Select oSelect = new Select(continents);
        oSelect.selectByVisibleText("South America");

        Thread.sleep(2000);

        List<WebElement> options = driverConfigs.driver.findElements(By.xpath("//*[@id=\"continents\"]/option"));
        int size = options.size();

        for (int i = 0; i < size; i++) {
            oSelect.selectByIndex(i);
            Thread.sleep(1000);
        }

        Thread.sleep(2000);

        driverConfigs.driver.quit();

    }
}
