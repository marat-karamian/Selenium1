package SeleniumTrainings;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributes1 {

    static WebDriver driver;
    private By bySearchButton = By.name("btnK");

    @BeforeClass

    public static void setUp() {
        DriverConfig driverConfig = new DriverConfig();
        driverConfig.chrome();
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
    }

    @Test
    public void getAttribute_ButtonName() {
        WebElement googleSearchBtn = driver.findElement(bySearchButton);
        System.out.println("Name of the button is:- " +googleSearchBtn.getAttribute("name"));
        System.out.println("Id of the button is:- "+ googleSearchBtn.getAttribute("id"));
        System.out.println("Class of the button is:- "+ googleSearchBtn.getAttribute("class"));
        //Will return null value as the 'status' attribute doesn't exists
        System.out.println("Invalid Attribute status of the button is:- "+ googleSearchBtn.getAttribute("status"));
        System.out.println("Label of the button is:- "+ googleSearchBtn.getAttribute("aria-label"));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}