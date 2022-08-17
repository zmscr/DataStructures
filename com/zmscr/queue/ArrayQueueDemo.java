package com.zmscr.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean status = true;
        while (status) {
            System.out.println("查看所有队列");
            System.out.println("退出");
            System.out.println("添加");
            System.out.println("取出队列");
            System.out.println("查看头数据");

            key = scanner.next().charAt(0);

            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    arrayQueue.addQueue(scanner.nextInt());
                    System.out.println("sucess");
                    break;
                case 'q':
                    try {
                        int j = arrayQueue.getQueue();
                        System.out.printf("%d\n", j);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 't':
                    try {
                        int k = arrayQueue.showFront();
                        System.out.println(k);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    status = false;
                default:
                    break;
            }
            System.out.println("exit");
        }


    }

}

//使用数组模拟队列
class ArrayQueue {
    private int maxSize; //数组最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr; //该数组用于存放数据

    //创建队列构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部,front是指向队列头的前一个位置
        rear = -1; // 指向队列尾部，队列尾部具体位置
    }

    //判断队列是否为满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列以满，不能添加数据");
            return;
        }
        System.out.println("input number");
        rear++;
        arr[rear] = n;
    }

    //获取队列的数据，出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能读取数据");
        }
        front++;
        return arr[front];
    }

    //显示队列所有数据
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //添加显示头队列
    public int showFront() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }

}
