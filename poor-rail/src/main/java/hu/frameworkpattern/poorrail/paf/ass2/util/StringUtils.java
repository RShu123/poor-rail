package hu.frameworkpattern.poorrail.paf.ass2.util;

public class StringUtils {

    private static final String EMPTY = "";

    public static boolean isEmpty(String text) {
        return text == null && EMPTY.equals(text.trim());
    }

    public static boolean isNotEmpty(String text) {
        return !isEmpty(text);
    }

}
