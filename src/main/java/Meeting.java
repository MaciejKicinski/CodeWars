import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * John has invited some friends. His list is:
 * <p>
 * s = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
 * Could you make a program that
 * <p>
 * makes this string uppercase
 * gives it sorted in alphabetical order by last name.
 * When the last names are the same, sort them by first name. Last name and first name of a guest come in the result between parentheses separated by a comma.
 * <p>
 * So the result of function meeting(s) will be:
 * <p>
 * "(CORWILL, ALFRED)(CORWILL, FRED)(CORWILL, RAPHAEL)(CORWILL, WILFRED)(TORNBULL, BARNEY)(TORNBULL, BETTY)(TORNBULL, BJON)"
 * It can happen that in two distinct families with the same family name two people have the same first name too.
 */
class Meeting {

    public static String meeting(String s) {
        StringBuilder result = new StringBuilder();
        result.setLength(0);
        String[] arrayList = s.split(";");
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (String temp : arrayList) {
            String[] tempArray = temp.split(":");
            String tempLoopString = "(" + tempArray[1].trim().toUpperCase() + ", " + tempArray[0].trim().toUpperCase() + ")";
            stringArrayList.add(tempLoopString);
        }
        Collections.sort(stringArrayList);
        stringArrayList.forEach(ss -> result.append(ss));
        return result.toString();
    }

    public static String meeting2(String s) {
        return Arrays.stream(s.toUpperCase().split(";"))
                .map(guest -> guest.replaceAll("(\\w+):(\\w+)", "($2, $1)"))
                .sorted()
                .collect(Collectors.joining(""));
    }
}