/**
 * The aim of this kata is to split a given string into different strings of equal size (note size of strings is passed to the method)
 * <p>
 * Example:
 * <p>
 * Split the below string into other strings of size #3
 * <p>
 * 'supercalifragilisticexpialidocious'
 * <p>
 * Will return a new string
 * 'sup erc ali fra gil ist ice xpi ali doc iou s'
 * Assumptions:
 * <p>
 * String length is always greater than 0
 * String has no spaces
 * Size is always positive
 */

public class InParts {
    public static String splitInParts(String s, int partLength) {
        StringBuilder result = new StringBuilder();
        result.setLength(0);
        char[] charArray = s.toCharArray();
        for (int i = 1; i < charArray.length + 1; i++) {
            result.append(charArray[i - 1]);
            if (i % partLength == 0) {
                result.append(" ");
            }
        }
        return result.toString().trim();
    }


        public static String splitInParts2(String s, int partLength) {
            StringBuilder sb = new StringBuilder(s);
            for (int i = partLength++; i < sb.length(); i += partLength){
                sb.insert(i, " ");
            }
            return sb.toString();
        }

    public static String splitInParts3(String s, int partLength) {
        return s.replaceAll("(.{"+partLength+"})(?!$)", "$1 ");
    }
}
