package utils;

import org.openqa.selenium.Proxy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Reading property from properties file.
 */

public final class PropertyUtils {

    private static Properties property = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<String, String>();

    static {
        try {
            FileInputStream fis = new FileInputStream(GlobalConstants.configProp);
            property.load(fis);
            for (Map.Entry<Object, Object> entry : property.entrySet()) {
                CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String get(ConfigMap key) {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
            try {
                throw new Exception("Property name '" + key.toString().toLowerCase() + "' not found. Please check config.properties");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return CONFIGMAP.get(key.name().trim().toLowerCase());
    }

    public static ArrayList<String> getArgsOption(){
        ArrayList<String> list = new ArrayList<>();
        CONFIGMAP.values().stream().filter(k -> k.startsWith("args")).forEach(k -> list.add(CONFIGMAP.get(k)));
        return list;
    }

    public static Proxy getProxySetting(){
        if (get(ConfigMap.noProxy).equalsIgnoreCase("false")){
            Proxy proxy = new Proxy();
            proxy.setHttpProxy(get(ConfigMap.httpProxyServer));
            proxy.setHttpProxy(get(ConfigMap.httpProxyServer));
            proxy.setAutodetect(get(ConfigMap.autodetect).equalsIgnoreCase("true"));
            return proxy;
        }
        else {
            return new Proxy();
        }
    }
}