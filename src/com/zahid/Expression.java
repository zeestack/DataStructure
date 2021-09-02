package com.zahid;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {

    private final List<Character> openingBrackets = Arrays.asList('(', '<', '{', '[');
    private final List<Character> closingBrackets = Arrays.asList(')', '>', '}', ']');

    public boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (Character ch : expression.toCharArray()) {

            if (isOpeningBracket(ch))
                stack.push(ch);

            if (isClosingBracket(ch)) {
                if (stack.empty()) return false;

                var top = stack.pop();
                if (!isMatchingBrackets(top, ch))
                    return false;

            }
        }

        return stack.empty();
    }

    private boolean isOpeningBracket(Character ch) {
        return openingBrackets.contains(ch);
    }
    
    private boolean isClosingBracket(Character ch) {
        return closingBrackets.contains(ch);
    }

    private boolean isMatchingBrackets(Character left, Character right) {
        return (closingBrackets.indexOf(left) == openingBrackets.indexOf(right));
    }

}


