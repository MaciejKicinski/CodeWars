public class Maskify {
    private static final char HASH_CHAR = '#';

    public static String maskify(String str) {
        if (str.length() <= 4) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length - 4; i++) {
            charArray[i] = HASH_CHAR;
        }
        System.out.println(String.valueOf(charArray));
        return String.valueOf(charArray);
    }

    public static String maskify2(String str) {
        return str.replaceAll(".(?=.{4})", "#");
    }

    public static String maskify3(String str) {
        if (str.length() <= 4) return str;
        String result = "";
        for (int i = 0; i < str.length() - 4; i++) {
            result += "#";
        }
        return result + str.substring(str.length() - 4);
    }
}
