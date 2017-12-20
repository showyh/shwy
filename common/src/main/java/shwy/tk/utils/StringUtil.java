package shwy.tk.utils;

/**
 * @author showy on 2017/10/20.
 * @version 1.0
 */
public class StringUtil {
    public static Boolean isEmpty(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean isNotEmpty(String str) {
        if (str != null && !str.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static String formatLikeSQL(String str) {
        return str + "%";
    }
}
