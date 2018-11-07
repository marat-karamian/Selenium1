package SeleniumTrainings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverLogLevel;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;

public class DriverConfigs {

    public WebDriver driver;
    public InternetExplorerDriver driver1;

    public void chrome() {
        String exepath = "C:\\Users\\Marat_Karamian\\Documents\\JavaMP\\chromedriver_win.exe";
        System.setProperty("webdriver.chrome.driver", exepath);
        driver = new ChromeDriver();
    }

    public void chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        String exepath = "C:\\Users\\Marat_Karamian\\Documents\\JavaMP\\chromedriver_win.exe";
        System.setProperty("webdriver.chrome.driver", exepath);
        driver = new ChromeDriver(options);
    }

    public void firefox() {
        String exepath = "C:\\Users\\Marat_Karamian\\Documents\\JavaMP\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", exepath);
        driver = new FirefoxDriver();
    }

    public void edge() {
        String exepath = "C:\\Users\\Marat_Karamian\\Documents\\JavaMP\\MicrosoftWebDriver.exe";
        System.setProperty("webdriver.edge.driver", exepath);
        driver = new EdgeDriver();
    }

    public void safari() {
        driver = new SafariDriver();
    }

    public void iexplorer() {
        String exepath = "C:\\Users\\Marat_Karamian\\Documents\\JavaMP\\IEDriverServer_x64_3.8.0.exe";
        System.setProperty("webdriver.ie.driver", exepath);
        driver1 = new InternetExplorerDriver();
    }

    public void ie() {
        String exepath = "C:\\Users\\Marat_Karamian\\Documents\\JavaMP\\IEDriverServer_x64_3.8.0.exe";
        InternetExplorerDriverService.Builder serviceBuilder = new InternetExplorerDriverService.Builder();
        serviceBuilder.usingAnyFreePort();
        serviceBuilder.usingDriverExecutable(new File(exepath));
        serviceBuilder.withLogLevel(InternetExplorerDriverLogLevel.TRACE);
        serviceBuilder.withLogFile(new File("C:\\Users\\Marat_Karamian\\Documents\\JavaMP\\logFile.txt"));
        InternetExplorerDriverService service = serviceBuilder.build();
        driver1 = new InternetExplorerDriver(service);
    }
}
