package SeleniumTrainings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverConfigs {

    public WebDriver driver;

    public void chrome() {
        String exepath = "C:\\Users\\Marat_Karamian\\Documents\\JavaMP\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exepath);
        driver = new ChromeDriver();
    }

    public void chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        String exepath = "C:\\Users\\Marat_Karamian\\Documents\\JavaMP\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exepath);
        driver = new ChromeDriver(options);
    }

    public void firefox() {
        String exepath = "C:\\Users\\Marat_Karamian\\Documents\\JavaMP\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", exepath);
        driver = new FirefoxDriver();
    }
}
