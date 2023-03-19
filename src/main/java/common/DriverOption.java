package common;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Parameters;
import utils.PropertyUtils;

import java.util.ArrayList;

public final class DriverOption {

    // get list of option from config File
    private ArrayList<String> options = getListOptionArguments();

    public static ArrayList<String> getListOptionArguments(){
        return PropertyUtils.getArgsOption();
    }


    // Static method that get option by browser
    public ChromeOptions getChromeOptions() {
        return new ChromeOptions().addArguments(options);
    }

    //Get Firefox Options
    public FirefoxOptions getFirefoxOptions() {
        return new FirefoxOptions().addArguments(options);
    }

    //Get Firefox Options
    public EdgeOptions getEdgeOptions() {
        return new EdgeOptions().addArguments(options);
    }
}
