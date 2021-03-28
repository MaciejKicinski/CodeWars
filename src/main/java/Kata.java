import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

// Make sure your class is public
public class Kata {

    public static double findUniq(double arr[]) {
        HashMap<Double, Integer> map = new HashMap<>();
        for (double x : arr) {
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }
        for (double y : map.keySet()) {
            if (map.get(y) == 1) {
                return y;
            }
        }
        return 0;
    }

    public static double findUniq2(double[] arr) {
        Arrays.sort(arr);
        return arr[0] == arr[1] ? arr[arr.length-1]:arr[0];
    }

    public static double findUniq3(double arr[]) {
        final double x = arr[arr[0] == arr[1] ? 0 : 2];
        for (double y : arr)
            if (y != x)
                return y;
        throw new RuntimeException("no unique number found");
    }

    static double findUniq4(final double[] array) {
        return Arrays.stream(array).boxed()
                .collect(groupingBy(identity(), counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(0.0);
    }
}