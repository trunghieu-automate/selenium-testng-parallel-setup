package common;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.PropertyUtils;

import java.util.ArrayList;

public final class DriverOption {

    // static field option list
    static ArrayList<String> options = PropertyUtils.getArgsOption();
    // static field Proxy objects
    static Proxy proxy = PropertyUtils.getProxySetting();

    // Static method that get option by browser
    public ChromeOptions getChromeOptions() {
        ChromeOptions option = new ChromeOptions();
        option.setCapability("proxy", proxy);
        return option.addArguments(options);
    }

    //Get Firefox Options
    public FirefoxOptions getFirefoxOptions() {
        FirefoxOptions option = new FirefoxOptions();
        option.setCapability("proxy", proxy);
        return option.addArguments(options);
    }

    //Get Firefox Options
    public EdgeOptions getEdgeOptions() {
        EdgeOptions option = new EdgeOptions();
        option.setCapability("proxy", proxy);
        return option.addArguments(options);
    }
}
