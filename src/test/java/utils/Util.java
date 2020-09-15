package utils;

public class Util {

    public enum OS {
        WINDOWS, MAC
    }

    public static OS getOS() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return OS.WINDOWS;
        } else if (os.contains("mac")) {
            return OS.MAC;
        }else {
            return null;
        }
    }

}
