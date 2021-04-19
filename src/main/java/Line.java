import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * The new "Avengers" movie has just been released! There are a lot of people at the cinema
 * box office standing in a huge line. Each of them has a single 100, 50 or 25 dollar bill.
 * An "Avengers" ticket costs 25 dollars.
 * <p>
 * Vasya is currently working as a clerk. He wants to sell a ticket to every single person in this line.
 * <p>
 * Can Vasya sell a ticket to every person and give change if he initially
 * has no money and sells the tickets strictly in the order people queue?
 * <p>
 * Return YES, if Vasya can sell a ticket to every person and give change
 * with the bills he has at hand at that moment. Otherwise return NO.
 */
public class Line {


    public static String Tickets(int[] peopleInLine) {
        System.out.println(Arrays.toString(peopleInLine));
        Map<Integer, Integer> map = new HashMap();
        map.put(25, 0);
        map.put(50, 0);
        map.put(100, 0);
        if (peopleInLine[0] != 25) {
            return "NO";
        }

        for (int clientMoney : peopleInLine) {
            if (clientMoney == 25) {
                map.put(25, map.get(25) + 1);
            }
            if (clientMoney == 50) {
                map.put(50, map.get(50) + 1);
                if (map.get(25) >= 1) {
                    map.put(25, map.get(25) - 1);
                } else {
                    return "NO";
                }
            }
            if (clientMoney == 100) {
                map.put(100, map.get(100) + 1);
                if (map.get(25) >= 1 && map.get(50) >= 1) {
                    map.put(25, map.get(25) - 1);
                    map.put(50, map.get(50) - 1);

                } else if (map.get(25) >= 3) {
                    map.put(25, map.get(25) - 3);
                } else {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    public static String Tickets2(int[] peopleInLine) {
        int bill25 = 0, bill50 = 0;
        for (int payment : peopleInLine) {
            if (payment == 25) {
                bill25++;
            } else if (payment == 50) {
                bill25--;
                bill50++;
            } else if (payment == 100) {
                if (bill50 > 0) {
                    bill50--;
                    bill25--;
                } else {
                    bill25 -= 3;
                }
            }
            if (bill25 < 0 || bill50 < 0) {
                return "NO";
            }
        }
        return "YES";
    }
}
