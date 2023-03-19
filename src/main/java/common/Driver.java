package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Driver {
    // Setup Web-driver base on testNG.xml parameters
    @Parameters("browser")
    public static void initDriver(String browser) {
        if (Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverOption driverOption = new DriverOption();
                if (browser.equalsIgnoreCase("chrome")) {
                    WebDriver driver = new ChromeDriver(driverOption.getChromeOptions());
                    DriverManager.setDriver(driver);
                } else if (browser.equalsIgnoreCase("firefox")) {
                    WebDriver driver = new ChromeDriver(driverOption.getChromeOptions());
                    DriverManager.setDriver(driver);
                } else if (browser.equalsIgnoreCase("edge")) {
                    WebDriver driver = new EdgeDriver(driverOption.getEdgeOptions());
                    DriverManager.setDriver(driver);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        }
    }

    // quit & remove driver
    public static void removeDriver(){
        if (Objects.isNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.removeDriver();
        }
    }
}
