package com.lwq.stack;

/**
 * @author: LWQ
 * @create: 2020/10/24
 * @description: Calculator
 **/
public class Calculator {
    public static final char PLUS = '+';
    public static final char MINUS = '-';
    public static final char MULTIPLY = '*';
    public static final char DIVIDE = '/';
    private Stack dataStack;
    private Stack operStack;

    public Calculator() {
        dataStack = new Stack(10);
        operStack = new Stack(10);
    }

    public static void main(String[] args) {
        String express = "17-4*3+2";
        Calculator calculator = new Calculator();
        System.out.printf("结果:%d", calculator.calc(express));
    }

    /**
     * 7+4*3-2
     * 实现思路：
     * 建立一个数据栈和一个符号栈
     * 遍历表达式，如果是数字就入栈
     * 如果是符号：
     * 如果符号栈中没有符号，直接入栈
     * 如果符号栈中有符号比较优先级，如果入栈符号的优先级>=栈顶符号，就入栈
     * 如果入栈符号的优先级<栈顶符号，取出数据栈栈顶的两个数据和符号栈顶的符号
     * 进行计算，然后将计算结果重新入栈，并将当前符号入栈
     * 直到遍历完整个表达式
     * 然后开始遍历符号栈，直到符号栈没有符号了，表示计算完成
     * 最后会有一个数据在数据栈，这个就是结果
     *
     * @param expression
     */
    public int calc(String expression) {
        if (expression == null || expression.length() == 0) {
            throw new RuntimeException("表达式为空，不能计算!");
        }
        int num1;
        int num2;
        int result;
        int index = 0;
        String keepNum = "";
        while (true) {
            char elem = expression.substring(index, index + 1).charAt(0);
            if (isOper(elem)) {
                if (operStack.isEmpty()) {
                    operStack.push(elem);
                } else {
                    char oper = (char) operStack.pop();
                    if (priority(oper) < priority(elem)) {
                        operStack.push(oper);
                        operStack.push(elem);
                    } else {
                        num1 = dataStack.pop();
                        num2 = dataStack.pop();
                        result = result(num1, num2, oper);
                        dataStack.push(result);
                        operStack.push(elem);
                    }
                }
            } else {
                keepNum += elem;
                // 如果下一个是符号就入栈
                if (index == expression.length() - 1 ||
                        (index + 1 < expression.length() &&
                                isOper(expression.substring(index + 1, index + 2).charAt(0)))) {
                    dataStack.push(Integer.parseInt(keepNum));
                    keepNum = "";
                }
            }

            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        while (!operStack.isEmpty()) {
            num1 = dataStack.pop();
            num2 = dataStack.pop();
            char oper = (char) operStack.pop();
            result = result(num1, num2, oper);
            dataStack.push(result);
        }

        return dataStack.pop();
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

    public boolean isOper(char oper) {
        if (oper == PLUS || oper == MINUS || oper == MULTIPLY || oper == DIVIDE) {
            return true;
        }
        return false;
    }

}
