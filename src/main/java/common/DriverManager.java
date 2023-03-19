package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {
    /** This is how we create a threadLocal generic object
     * //create a generic thread-local object
     * private static ThreadLocal<String> myThreadLocal = new ThreadLocal<String>();
     *
     * //set thread-local value
     * myThreadLocal.set("Hello ThreadLocal");
     *
     * //get thread-local value
     * String threadLocalValue = myThreadLocal.get();
     *
     * //remove thread-local value for the current thread
     * myTheadlocal.remove();
     */

    // so firstly, create a threadLocal driver
    private static final ThreadLocal <WebDriver> driver = new ThreadLocal<> ();

    // set thread-local value
    public static void setDriver(WebDriver drivers){
        //Log.info("Set driver" + driver.toString());
        driver.set(drivers);
    }

    // get thread-local driver
    public static WebDriver getDriver(){
        //Log.info("Set driver")
        return driver.get();
    }

    // Remove thread-local driver
    public static void removeDriver(){
        driver.remove();
    }
}
