package SeleniumTrainings;

public class DriverConfig {

    public void chrome() {
        String exepath = "C:\\Users\\Marat_Karamian\\Documents\\JavaMP\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exepath);
    }

    public void firefox() {
        String exepath = "C:\\Users\\Marat_Karamian\\Documents\\JavaMP\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", exepath);
    }
}
