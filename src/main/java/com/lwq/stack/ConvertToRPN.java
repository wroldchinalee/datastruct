package com.lwq.stack;

/**
 * @author: LWQ
 * @create: 2020/10/25
 * @description: ConvertToRPN
 **/
public class ConvertToRPN {
    public static final char PLUS = '+';
    public static final char MINUS = '-';
    public static final char MULTIPLY = '*';
    public static final char DIVIDE = '/';
    public static final char LEFT_BRACKET = '(';
    public static final char RIGTH_BRACKET = ')';

    /**
     * 1+((2+3)×4)-5 转换后结果为 1 2 3 + 4 × + 5 –
     *
     * @param expression
     * @return
     */
    public String convert(String expression) {
        // 运算符栈
        Stack stack1 = new Stack(32);
        // 操作数栈
        Stack stack2 = new Stack(32);
        int index = 0;
        while (true) {
            char elem = expression.substring(index, index).charAt(0);
            handleElem(elem, stack1, stack2);
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
    }

    public void handleElem(char elem, Stack stack1, Stack stack2) {
        if (isNumber(elem + "")) {
            stack2.push(elem);
            return;
        }

        if (stack1.isEmpty()) {
            stack1.push(elem);
            return;
        }
        char top = (char) stack1.pop();
        if (top == LEFT_BRACKET) {
            stack1.push(elem);
            return;
        }
        if (top == RIGTH_BRACKET) {

        }
        if (priority(elem) > priority(top)) {
            stack1.push(elem);
            return;
        }

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

    public int priority(char oper) {
        if (oper == MULTIPLY || oper == DIVIDE) {
            return 1;
        } else if (oper == PLUS || oper == MINUS) {
            return 0;
        } else {
            return -1;
        }
    }

    public static boolean isNumber(String s) {
        return s.matches("\\d+");
    }

    public boolean isOper(char oper) {
        if (oper == PLUS || oper == MINUS || oper == MULTIPLY || oper == DIVIDE) {
            return true;
        }
        return false;
    }

    public boolean isBrackets(char c) {
        if (c == LEFT_BRACKET || c == RIGTH_BRACKET) {
            return true;
        }
        return false;
    }
}
