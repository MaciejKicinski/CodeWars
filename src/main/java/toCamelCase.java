import java.util.Arrays;

public class toCamelCase {

    static String toCamelCase(String s) {
        StringBuilder result = new StringBuilder();
        result.setLength(0);

        char[] charArray = s.toCharArray();

        for (int i = 0; i < s.toCharArray().length; i++) {
            if (result.length() == 0 && Character.isLetter(charArray[i])) {
                result.append(charArray[i]);
            } else if (result.length() != 0 && Character.isLetter(charArray[i])
                    && !Character.isLetter(charArray[i - 1])) {
                String myStr = Character. toString(charArray[i]);
                result.append(myStr.toUpperCase());
            } else if (Character.isLetter(charArray[i])) {
                result.append(charArray[i]);
            }
        }
        return result.toString();
    }

    static String toCamelCase2(String str){
        String[] words = str.split("[-_]");
        return Arrays.stream(words, 1, words.length)
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .reduce(words[0], String::concat);
    }
}
