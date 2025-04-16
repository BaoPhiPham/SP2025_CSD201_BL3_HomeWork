/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author PhamBaoPhi
 */
public class MySLList {

    //props:
    Node head, tail; // cả 2 đều sẽ là null do ch có new Node

    //constructor:
    public MySLList() {
        this.head = this.tail = null;
        //phải viết vậy vì lúc này trong object node vẫn có giá trị rỗng
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void clear() {
        this.head = this.tail = null;
    }

    public void traverse() {
        Node p = this.head;
        while (p != null) {
            System.out.print(p.infor);
            System.out.print(" ");
            p = p.next;
        }
        System.out.print("\n");
    }

    public void addFirst(int n) {
        Node newNode = new Node(n);
        //addFirst
        newNode.next = this.head;
        this.head = newNode;
    }

    public void loadData(int k) {
        Random generator = new Random();
        for (int i = 0; i < k; i++) {
            int number = generator.nextInt(1000) + 1;//(0 -> 9999) + 1
            //add into list:
            addFirst(number);
        }
    }

    public void addLast(int n) {
        Node newNode = new Node(n);
        //addLast
        //+ case 1:
        if (isEmpty()) {
            this.head = newNode;
            return;
        }
        //+ case2;
        Node last = this.head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    //f1: in data of list
    public void f1() {
        System.out.println("Linked List: ");
        this.traverse();
    }

    //nhập dử liệu 1 con số từ bàn phím -> addLast
    public void f2() {
        System.out.println("\nBefore: ");
        this.traverse();
        //---------start code------------
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nInput the vale that you want to add last: ");
            int value = sc.nextInt();
            this.addLast(value);
        } catch (Exception e) {
            System.out.println(e);
        }
        //---------end code---------------
        System.out.println("\nAfter: ");
        this.traverse();
    }

    //f3: hàm addPos ==> thêm node vào vị trí thứ k:
    //      trong đó node mới và chỉ số k được nhập từ bàn phím
    public void f3() {
        System.out.println("Before: ");
        this.traverse();
        //------ Start your code here---------------------------------------------------------
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a value:");
        int value = sc.nextInt();
        System.out.println("Enter position k (0-based index): ");
        int k = sc.nextInt();

        // Special case for head
        if (k == 0) {
            addFirst(value);
        } else {
            // Find the node at position k-1
            Node curent = head;
            int currentIndex = 0;
            while (currentIndex < k - 1 && curent != null) {
                curent = curent.next;
                currentIndex++;
            }
            // Insert the new node
            Node newNode = new Node(value);
            newNode.next = curent.next;
            curent.next = newNode;
        }

        //------ End your code here-----------------------------------------------------------
        System.out.println("After: ");
        this.traverse();
    }

    // f4: removeFirst
    public void f4() {
        System.out.print("Before:   ");
        this.traverse();
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        if (isEmpty()) {
            System.out.println("No data to remove first");
            return;
        }
        System.out.println("The first node have been removed: " + this.head.infor);
        this.head = head.next;
        //------ End your code here-----------------------------------------------------------
        System.out.print("After:    ");
        this.traverse();
    }

    // f5: removeLast
    public void f5() throws Exception {
        System.out.print("Before:   ");
        this.traverse();
        //------ Start your code here---------------------------------------------------------
        if (isEmpty()) {
            System.out.println("No data to remove last");
            return;
        }else if(this.head != null){
            //if there is only element:
            if(this.head == null){
                System.out.println("The last node have been removed: " + this.head.infor);
                this.head = null;
            }else{
                Node secondLast = this.head;
                while(secondLast.next.next != null){
                    secondLast = secondLast.next;
                }
                System.out.println("The last node have been removed: " + secondLast.next.infor);
                secondLast.next = null; 
            }        
        }
        //------ End your code here-----------------------------------------------------------
        System.out.print("After:    ");
        this.traverse();
    }

}
