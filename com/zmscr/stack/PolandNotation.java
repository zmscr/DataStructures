package com.zmscr.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //定义逆波兰表达式
        // 4 5 * 8 - 60 + 8 2 / +
        String expression = "4 5 * 8 - 60 + 8 2 / +";
        //将表达式放入一个ArrayList里
        List<String> listString = getListString(expression);
        int calculate = calculate(listString);
        System.out.println(calculate);
    }

    public static List<String> getListString(String expression) {
        //将表达式分割
        String[] split = expression.split(" ");
        List<String> arrayList = new ArrayList<>();
        for (String ele : split) {
            arrayList.add(ele);
        }
        return arrayList;
    }

    public static int calculate(List<String> ls) {
        //创建栈
        Stack<String> stack = new Stack<String>();
        //遍历ls
        for (String item : ls) {
            if (item.matches("\\d+")) { //匹配的是多位数 \\d 正则表达式 \\d代表任何数字
                stack.push(item);
            } else { //如果不是数字，则是运算符,弹出两个数进行运算
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符号问题");
                }
                stack.push(Integer.toString(res));
            }
        }
        //最后只剩结果在栈中
        return Integer.parseInt(stack.pop());
    }
}

