
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;
    int size;

    MyList() {
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

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            f.writeBytes(p.info.name + "-" + p.info.price + "     "); // write data in the node p to the file f
            p = p.next;
        }

        f.writeBytes("\r\n");
    }

    void loadData(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        String[] b = Lib.readLineToStrArray("data.txt", k + 1);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(b[i]);

            addLast(a[i], p);
        }
    }

    // Luu y: doc ky dieu kien trong de bai
    void addLast(String n, float p) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        if (p > 0) {
            Phone newP = new Phone(n, p);
            Node newN = new Node(newP);
            if (isEmpty()) {
                this.head = this.tail = newN;
            } else {
                this.tail.next = newN;
                this.tail = newN;
            }
            size++;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
    }

    void f1() throws Exception {
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

    void f2() throws Exception {
        clear();
        loadData(0);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        Phone t = new Phone("FPT_Phone", 100);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        if (!isEmpty()) {
            Node MaxPrice = this.head;
            Node current = this.head;
            while (current != null) {
                if (MaxPrice.info.price < current.info.price) {
                    MaxPrice = current;
                }
                current = current.next;
            }
            Node nNext = MaxPrice.next;
            Node newN = new Node(t);
            newN.next = nNext;
            MaxPrice.next = newN;
            if (MaxPrice == this.tail) {
                this.tail = newN;
            }
        } else {
            addLast(t.name, t.price);
        }
        size++;
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void f3() throws Exception {
        clear();
        loadData(0);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        float avg_S = 0;
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        int count = 0;
        float sum = 0;
        Node p = this.head;
        while (p != null) {
            if (p.info.name.startsWith("S")) {
                count++;
                sum += p.info.price;
            }
            p = p.next;
        }
        count = (count == 0) ? 1 : count;
        avg_S = sum / count;
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        f.writeBytes(avg_S + "\n"); // write data
        ftraverse(f);
        f.close();
    }

    void f4() throws Exception {
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
        if (!isEmpty()) {
            int count = 0;
            Node p = this.head;
            while (p != null) {
                count++;
                if (count == 3) {
                    this.head = p.next;
                    if (this.head == null) {
                        this.tail = this.head = null;
                    }
                    p.next = null;
                    size -= count;
                    break;
                }
                p = p.next;
            }
            if(count < 3){
                this.tail = this.head = null;
                size -= count;
            }
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void f5() throws Exception {
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
        if (!isEmpty()) {
            Node minNode = this.head;
            Node maxNode = this.head;
            Node current = this.head;
            while (current != null) {
                if (current.info.price > maxNode.info.price) {
                    maxNode = current;
                }
                if (current.info.price < minNode.info.price) {
                    minNode = current;
                }
                current = current.next;
            }
            Phone tmp = minNode.info;
            minNode.info = maxNode.info;
            maxNode.info = tmp;

        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
