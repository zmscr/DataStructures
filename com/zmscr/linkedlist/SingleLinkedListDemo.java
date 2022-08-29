package com.zmscr.linkedlist;

import java.util.LinkedList;
import java.util.Stack;

import com.zmscr.linkedlist.HeroNode;
import com.zmscr.linkedlist.SingleLinkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {

        //创建节点
        HeroNode hero1 = new HeroNode(1, "zm", "nb");
        HeroNode hero2 = new HeroNode(2, "czm", "cnb");
        HeroNode hero3 = new HeroNode(3, "czm", "ccnb");
        HeroNode hero4 = new HeroNode(4, "czm", "cccnb");
        //创建链表存储节点
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入节点
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        //singleLinkedList.addByOrder(hero3);

        //singleLinkedList.delete(4);
        singleLinkedList.list();
        System.out.println();
        System.out.println(getLength(singleLinkedList.getHead()));

        HeroNode respond = finaLastLocation(singleLinkedList.getHead(), 2);
        System.out.println(respond);


        reversePrint(singleLinkedList.getHead());

    }


    public static HeroNode finaLastLocation(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        //获取所有节点
        int size = getLength(head);

        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;

    }


    //打印链表反转
    public static void reversePrint(HeroNode heroNode) {
        if (heroNode.next == null) {
            return;
        }
        //创建一个栈，将节点存入栈
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = heroNode.next;
        while(cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }

    }


    //将链表反转
    //方式一
    public static void reverseList(HeroNode head) {
        //如果链表为空或者只有一个直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reserveHead = new HeroNode(0, "", "");

        while(cur != null) {
            next = cur.next;
            cur.next = reserveHead.next;
            reserveHead.next = cur;
            cur = next; //cur往后移

        }
        //head.next指向reverseHead.next指向下一节点
        head.next = reserveHead.next;

    }


   /* public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //判断如果链表为空，返回null
        if(head.next == null) {
            return null;//没有找到
        }
        //第一个遍历得到链表的长度(节点个数)
        int size = getLength(head);
        //第二次遍历  size-index 位置，就是我们倒数的第K个节点
        //先做一个index的校验
        if(index <=0 || index > size) {
            return null;
        }
        //定义给辅助变量， for 循环定位到倒数的index
        HeroNode cur = head.next; //3 // 3 - 1 = 2
        for(int i =0; i< size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }*/


    //获取节点个数
    public static int getLength(HeroNode head) {
        if(head.next == null) { //空链表
            return 0;
        }
        int length = 0;
        HeroNode test = head.next;
        while (test != null) {
            length++;
            test = test.next;
        }
        return length;
    }
}

class SingleLinkedList {
    //头节点不能动，用private修饰
    private static HeroNode head = new HeroNode(0, "", "");


    public HeroNode getHead() {
        return head;
    }


    //添加
    public void add(HeroNode heroNode) {

        HeroNode temp = head;

        while (true) {
            //temp的next为空则为最后一个
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }

        //退出循环表示到达链表的最后，将这个节点的next指向新的节点
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false; //标识添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) {//说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) {//位置找到,在temp后面插入
                break;
            } else if (temp.next.no == heroNode.no) {//说明希望添加的heroNode编号已经存在
                flag = true;
                break;
            }
            temp = temp.next; //后移，遍历当前链表
        }
        //判断flag的值
        if (flag) {//true不能添加，说明编号存在
            System.out.printf("准备插入的人物编号%d已经存在，不能加入\n", heroNode.no);
        } else {
            //插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }


    //修改
    public void update(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println("null");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        } else {
            System.out.printf("not found %d\n", heroNode.no);
        }
    }

    //删除
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null || temp.next.next == null) {
                System.out.println("null");
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        } else {
            System.out.println("no such num");
        }

    }

    //显示链表来遍历链表
    public void list() {
        //判断列表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head.next;
        while (true) {
            //判断是否为链表最后
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}