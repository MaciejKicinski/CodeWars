import java.util.Stack;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Write a function that takes a string of parentheses, and determines if the order of the parentheses is valid.
 * The function should return true if the string is valid, and false if it's invalid.
 * <p>
 * Examples
 * <p>
 * "()"              =>  true
 * ")(()))"          =>  false
 * "("               =>  false
 * "(())((()())())"  =>  true
 * Constraints
 * <p>
 * 0 <= input.length <= 100
 * <p>
 * Along with opening (() and closing ()) parenthesis, input may contain any valid ASCII characters.
 * Furthermore, the input string may be empty and/or not contain any parentheses at all.
 * Do not treat other forms of brackets as parentheses (e.g. [], {}, <>).
 */

public class ValidParentheses {

    public static boolean validParentheses(String parens) {
        String str = parens.replaceAll("[^()]", "");
        Stack<Character> stack = new Stack<Character>();

        for (char st : str.toCharArray()) {
            if (st == '(') {
                stack.push(st);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = (Character) stack.peek();
                    if (st == ')' && top == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean validParentheses2(String parens) {
        try {
            Pattern.compile(parens.replaceAll("[^()]", ""));
            return true;
        } catch (PatternSyntaxException e) {
            return false;
        }
    }
}
