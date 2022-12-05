package com.zmscr.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        Node node1 = new Node(1, "1");
        Node node2 = new Node(2, "2");
        Node node3 = new Node(3, "3");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addJD(node1);
        doubleLinkedList.addJD(node2);
        doubleLinkedList.addJD(node3);

        doubleLinkedList.list();

        Node node4 = new Node(3, "4");
        doubleLinkedList.update(node4);
        doubleLinkedList.list();
    }

}

class Node {
    public int num;
    public String name;
    public Node next;
    public Node prev;

    public Node(int num, String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}

class DoubleLinkedList {

    //初始化头节点 ,不放具体数据
    private Node head = new Node(0, "");

    //返回头节点
    public Node getHead() {
        return head;
    }

    //遍历双向链表，并显示链表

    public void list() {
        //判断链表是否未空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //定义临时变量辅助遍历
        Node temp = head.next;
        while (true) {
            //如果为链表最后直接break
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }


    //添加节点到链表最后
    public void addJD(Node node) {
        //定义辅助链表
        Node temp = head;
        while (true) {
            //判断是否为链表最后
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
    }

    //修改节点的数据
    public void update(Node node) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //定义辅助变量
        Node temp = head.next;
        boolean flag = false;
        while (true) {
            //是否遍历完成
            if (temp == null) {
                break;
            }
            //根据num找到第几个节点
            if (node.num == temp.num) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = node.name;
        }
    }

    public void del(int num) {
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        Node temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.num == num) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            //指向了自己本身
            temp.prev.next = temp.next;

            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
        }

    }


}