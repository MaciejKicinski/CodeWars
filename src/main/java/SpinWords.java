import java.util.Arrays;
import java.util.stream.Collectors;

public class SpinWords {
    public String spinWords(String sentence) {

        String[] sentenceArray = sentence.split(" ");

        for (int i=0 ; i<sentenceArray.length; i++) {
            if (sentenceArray[i].length() >= 5) {
                sentenceArray[i] = new StringBuilder(sentenceArray[i]).reverse().toString();
            }
        }
        return String.join(" ", sentenceArray);
    }

    public String spinWords2(String sentence) {
        return Arrays.stream(sentence.split(" "))
                .map(i -> i.length() > 4 ? new StringBuilder(i).reverse().toString() : i)
                .collect(Collectors.joining(" "));
    }
}


