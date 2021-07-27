package com.lwq.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: LWQ
 * @create: 2020/10/25
 * @description: ReversePolishNotation
 **/
public class ReversePolishNotation {
    public static final char PLUS = '+';
    public static final char MINUS = '-';
    public static final char MULTIPLY = '*';
    public static final char DIVIDE = '/';

    public static void main(String[] args) {
        String expression = "3 4 + 5 * 6 -";
        List<String> list = parseExpression(expression);
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
        int result = reversePolishNotation.calc(list);
        System.out.printf("结果:%d", result);
        System.out.println(isNumber("23"));
    }

    public static List<String> parseExpression(String expression) {
        ArrayList<String> list = new ArrayList<>();
        String[] arr = expression.split(" ");
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i].trim());
        }
        return list;
    }

    public int calc(List<String> list) {
        Stack stack = new Stack(list.size());
        for (int i = 0; i < list.size(); i++) {
            if (isNumber(list.get(i))) {
                stack.push(Integer.parseInt(list.get(i)));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int result = result(num1, num2, list.get(i).charAt(0));
                stack.push(result);
            }
        }
        return stack.pop();
    }

    public int result(int num1, int num2, char oper) {
        if (oper == PLUS) {
            return num1 + num2;
        }
        if (oper == MINUS) {
            return num2 - num1;
        }
        if (oper == MULTIPLY) {
            return num1 * num2;
        }
        if (oper == DIVIDE) {
            return num2 / num1;
        }
        return 0;
    }

    public static boolean isNumber(String s) {
        return s.matches("\\d+");
    }

    public int priority(char oper) {
        if (oper == MULTIPLY || oper == DIVIDE) {
            return 1;
        } else if (oper == PLUS || oper == MINUS) {
            return 0;
        } else {
            return -1;
        }
    }

}
