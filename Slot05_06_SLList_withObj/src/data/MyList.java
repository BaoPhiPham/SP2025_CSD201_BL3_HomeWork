/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;
    int size;

    public MyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            f.writeBytes(p.info.name + "-" + p.info.price + "     "); // write data in the node p to the file f
            p = p.next;
        }

        f.writeBytes("\r\n");
    }

    public void loadData(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        String[] b = Lib.readLineToStrArray("data.txt", k + 1);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(b[i]);

            addLast(a[i], p);
        }
    }

    public void addFirst(String n, int p) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Phone newP = new Phone(n, p);
        if (isEmpty()) {
            this.head = this.tail = new Node(newP);
        } else {
            Node newN = new Node(newP);
            newN.next = this.head;
            this.head = newN;
        }
        size++;
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
    }

    public void addLast(String n, int p) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Phone newP = new Phone(n, p);
        if (isEmpty()) {
            this.head = this.tail = new Node(newP);
        } else {
            Node newN = new Node(newP);
            this.tail.next = newN;
            this.tail = newN;
        }
        size++;
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
    }

    // f1: ham nay se goi ham addLast nhieu lan
    public void f1() throws Exception {
        clear();
        loadData(0);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

    // f2: ham addFirst ==> du lieu nhap tu ban phim
    public void f2() throws Exception {
        clear();
        loadData(0);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the name of phone: ");
        String name = sc.nextLine();
        System.out.println("Input the price of phone: ");
        int price = sc.nextInt();
        addFirst(name, price);
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // f3: ham computeSum ==> tinh tong gia tri cua tat ca cac Phone co trong list
    public void f3() throws Exception {
        clear();
        loadData(0);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        long sum = 0;
        if (!isEmpty()) {
            Node p = this.head;
            while (p != null) {
                sum += p.info.price;
                p = p.next;
            }
        }
        System.out.println("Sum = " + sum);
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // f4: remove the most expensive Phone
    public void f4() throws Exception {
        clear();
        loadData(0);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        if (isEmpty()) {
            f.writeBytes("The list is empty\r\n");
        } else {
            // Find the maximum price
            Node current = head;
            int maxPrice = current.info.price;

            while (current != null) {
                if (current.info.price > maxPrice) {
                    maxPrice = current.info.price;
                }
                current = current.next;
            }

            // Remove
            if (head.info.price == maxPrice) {
                head = head.next;
                if (head == null) {
                    tail = null;
                }
            } else {
                Node prevP = head;
                Node p = head.next;
                while (p != null && p.info.price != maxPrice) {
                    prevP = p;
                    p = p.next;
                }

                if (p != null) {
                    prevP.next = p.next; // Remove P
                    if (p == tail) {
                        tail = prevP;   // Chuyen tail thanh prev
                    }
                }
            }
            size--;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // f5: discount all Phone 'S' with 10%
    public void f5() throws Exception {
        clear();
        loadData(0);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Node p = this.head;
        while (p != null) {
            if (p.info.name.startsWith("S")) {
                p.info.price *= 0.9;
            }
            p = p.next;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
