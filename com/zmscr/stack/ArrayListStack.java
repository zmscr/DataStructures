package com.zmscr.stack;

import java.util.Scanner;
import java.util.Stack;

public class ArrayListStack {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        Scanner scanner = new Scanner(System.in);
        String key = "";
        boolean flag = true;
        while (flag) {
            System.out.println("按1入栈");
            System.out.println("按2出栈");
            System.out.println("按3显示所有");
            System.out.println("按4 exit");
            switch (scanner.nextInt()) {
                case 1:
                    if (stack.isFull()) {
                        System.out.println("man");
                        break;
                    }
                    System.out.println("输入入栈的值");
                    int i = scanner.nextInt();
                    stack.push(i);
                    break;
                case 2:
                    int pop1 = stack.pop();
                    System.out.println("出栈的数据是:"+pop1);
                    break;
                case 3:
                    stack.showList();
                    break;
                case 4:
                    flag = false;
            }
        }
    }
}

class ArrayStack {
    private int maxSize;
    private int top = -1;
    private int[] stack;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize-1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void showList() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n",i,stack[i]);
            System.out.println("-----------------");
        }
    }
}


