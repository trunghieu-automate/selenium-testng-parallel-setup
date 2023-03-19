package utils;

public final class GlobalConstants {
    public static final String sysPath = System.getProperty("user.dir");
    public static final String resPath = sysPath.concat("/src/test/resources/");
    public static final String configProp = resPath.concat("/configs/config.properties");
}
