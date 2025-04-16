/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author PhamBaoPhi
 */
public class MyList {

    Node head, tail;
    int size;

    public MyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public MyList(Node head, Node tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void traverse() {
        Node p = this.head;
        while (p != null) {
            System.out.print(p.infor + " ");
            p = p.next;
        }
        System.out.println("");
    }

    public void ftraverse(RandomAccessFile f) throws Exception {
        Node p = this.head;
        while (p != null) {
            f.writeBytes(p.infor + " ");
            p = p.next;
        }
        f.writeBytes("\r\n");
        //lưu ý khi ghi file:
        //a b c d e r g h
        //               * => chỉ \n
        //* => \r\n cùng lúc
    }

    public void loadData(int k) throws Exception {
        //k là dòng thứ k trong tập tin của bạn
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(a[i]);
            //addLast
            addLast(number);
        }
    }

    public void addFirst(int n) {

        Node newN = new Node(n);
        if (this.head == null) {
            this.head = this.tail = newN;
        } else {
            newN.next = this.head;
            this.head = newN;
        }
        size++;
    }

    public void addLast(int n) {
        Node newN = new Node(n);
        if (this.head == null) {
            this.head = this.tail = newN;
        } else {
            this.tail.next = newN;
            this.tail = newN;
        }
        size++;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
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
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the value you want to add first: ");
        int value = sc.nextInt();
        addFirst(value);
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // f3: ham addPos ==> them node vao vi tri thu k, trong do node moi va chi so k duoc nhap tu ban phim
    public void f3() throws Exception {
        clear();
        loadData(0);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");

        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the value you want to insert: ");
        int value = sc.nextInt();
        System.out.println("Input the position to add(0 to " + size + "): ");
        int k = sc.nextInt();
        if (k == 0) {
            addFirst(value);
        } else if (k == size) {
            addLast(value);
        } else {
            Node newN = new Node(value);
            Node p = head;
            //traverse to the node before position k:
            for (int i = 0; i < k - 1; i++) {
                p = p.next;
            }
            //insert
            newN.next = p.next;
            p.next = newN;
            size++;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // f4: removeFirst
    public void f4() throws Exception {
        clear();
        loadData(0);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");

        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        System.out.println("List before remove: ");
        traverse();
        if (!isEmpty()) {
            this.head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // f5: removeLast
    public void f5() throws Exception {
        clear();
        loadData(0);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        System.out.println("List before remove: ");
        traverse();
        if (!isEmpty()) {
            if (size == 1) {
                head = tail = null;
            } else {
                Node p = this.head;
                //find the node before tail:
                for (int i = 0; i < size - 2; i++) {
                    p = p.next;
                }
                p.next = null;
                this.tail = p;
            }
            size--;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
}
