import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Complete the solution so that it strips all text that follows any of a set of comment markers passed in. Any whitespace at the end of the line should also be stripped out.
 * <p>
 * Example:
 * <p>
 * Given an input string of:
 * <p>
 * apples, pears # and bananas
 * grapes
 * bananas !apples
 * The output expected would be:
 * <p>
 * apples, pears
 * grapes
 * bananas
 * The code would be called like so:
 * <p>
 * var result = solution("apples, pears # and bananas\ngrapes\nbananas !apples", ["#", "!"])
 * // result should == "apples, pears\ngrapes\nbananas"
 */

public class StripComments {
    public static String stripComments(String text, String[] commentSymbols) {
        boolean markedFound = false;
        ArrayList<String> arrayList = new ArrayList<>();
        String[] letters = text.split("");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < commentSymbols.length; j++) {
                if (letters[i].equals(commentSymbols[j])) {
                    markedFound = true;
                }
            }
            if (markedFound && letters[i].equals("\n")) {
                markedFound = false;
            }
            if (markedFound == false) {
                arrayList.add(letters[i]);
            }
        }
        for (String s : arrayList) {
            result.append(s);
        }
        return result.toString().replace(" \n", "\n").replaceFirst("\\s++$","");
    }


    public static String stripComments2(String text, String[] commentSymbols) {
        String pattern = String.format(
                "[ ]*([%s].*)?$",
                Arrays.stream( commentSymbols ).collect( Collectors.joining() )
        );
        return Arrays.stream( text.split( "\n" ) )
                .map( x -> x.replaceAll( pattern, "" ) )
                .collect( Collectors.joining( "\n" ) );
    }


}

