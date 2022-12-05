package com.zmscr.linkedlist;

public class Josephu {

}

class CircleSingleLinkedList {
    //定义头节点
    private JoNode head = null;

    public void addJoNode(int num) {
        if (num < 1) {
            System.out.println("num不能小于1");
            return;
        }
        //创建辅助指针
        JoNode temp = null;
        for (int i = 1; i <= num; i++) {
            JoNode joNode = new JoNode(i);
            //如果新加的节点为第一个节点
            if (i == 1) {
                head = joNode;
                head.setNext(head); //构成环
                temp = head; //让temp指向第一个
            } else {
                temp.setNext(joNode);//辅助节点指向新建的节点
                joNode.setNext(head);//新节点指向头节点
                temp = joNode; //将新建的JoNode节点赋值给temp节点;
            }
        }
    }

    //遍历环形链表
    public void showAllLinked(JoNode joNode) {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        //新建一个辅助变量
        JoNode temp = head;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    /*
     *   startNum表示第几个节点
     *   countNum表示为第几个
     *   nums表示为有多少个节点在圈中
     * */
    public void countJoNode(int startNum, int countNum, int nums) {
        //对数据进行校验
        if (head == null || startNum < 1 || startNum > nums) {
            System.out.println("参数错误");
            return;
        }
        //创建辅助节点,让该节点指向最后一个节点
        JoNode temp = head;
        while (true) {
            if (temp.getNext() == head) {
                break;
            }
            temp = temp.getNext();
        }
        //报数前，先让first和temp移动 startNum - 1 次
        for (int j = 0; j < startNum - 1; j++) {
            head = head.getNext();
            temp = temp.getNext();
        }
        //报数时，让first和temp移动 countNum - 1 次，然后出圈
        //这里是个循环操作，直到圈中只有一个节点
        while(true) {
            if (temp == head) {
                break;
            }
            //让head和temp同时移动countNum - 1
            for (int j = 0; j < countNum - 1; j++) {
                head = head.getNext();
                temp = temp.getNext();
            }
            //这时head指向的节点，就是要出圈的小孩节点
            System.out.printf("报数%d出圈\n",head.getNext());
            head = head.getNext();
            temp.setNext(head);
        }
        System.out.printf("第几个节点的编号%d \n", head.getNum());
    }


    //递归解决约瑟夫问题
    public int diGui(int n, int m ) {
        if (n == 1) {
            return 0;
        }
        int result = (diGui(n - 1, m) + m)%n;
        return result;
    }
}

class JoNode {
    private int num;
    private JoNode next;

    public JoNode(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public JoNode getNext() {
        return next;
    }

    public void setNext(JoNode next) {
        this.next = next;
    }
}


