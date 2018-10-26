package SeleniumTrainings;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckRadioButton {

    static DriverConfigs driverConfigs = new DriverConfigs();

    @BeforeClass
    public static void setDriver() {
        driverConfigs.chrome();
        driverConfigs.driver.manage().window().maximize();
        driverConfigs.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverConfigs.driver.get("http://toolsqa.com/automation-practice-form/");
    }

    @Test
    public void chkRdBtn() {

        List<WebElement> rdBtn = driverConfigs.driver.findElements(By.name("sex"));
        boolean bValue = rdBtn.get(0).isSelected();

        if (bValue) {
            rdBtn.get(1).click();
        } else {
            rdBtn.get(0).click();
        }
    }

    @Test
    public void clickExp() {
        driverConfigs.driver.findElement(By.id("exp-2")).click();
    }

    @Test
    public void chkProfession() {
        List<WebElement> profession = driverConfigs.driver.findElements(By.name("profession"));

        int size = profession.size();

        for (
                int i = 0;
                i < size; i++) {
            String value = profession.get(i).getAttribute("value");
            if (value.equalsIgnoreCase("Automation Tester")) {
                profession.get(i).click();
                break;
            }
        }
    }

    @Test
    public void clickTool() {
        driverConfigs.driver.findElement(By.cssSelector("input[value='Selenium IDE']")).click();
    }

    @AfterClass
    public static void quit() {
        driverConfigs.driver.quit();
    }
}
