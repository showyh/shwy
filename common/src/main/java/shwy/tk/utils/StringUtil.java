package shwy.tk.utils;

/**
 * Created by shwy on 2017/10/20.
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
