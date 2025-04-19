
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

    void ftraverseFW(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            f.writeBytes(p.info.ID + "-" + p.info.name + "-" + p.info.price + "     "); // write data in the node p to the file f
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void ftraverseBW(RandomAccessFile f) throws Exception {
        Node p = tail;
        while (p != null) {
            f.writeBytes(p.info.ID + "-" + p.info.name + "-" + p.info.price + "     "); // write data in the node p to the file f
            p = p.pre;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        String[] b = Lib.readLineToStrArray("data.txt", k + 1);
        String[] c = Lib.readLineToStrArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(a[i]);
            int y = Integer.parseInt(c[i]);
            addLast(x, b[i], y);
        }
    }

    void addLast(int id, String name, int price) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        if (price > 0) {
            Phone newP = new Phone(id, name, price);
            Node newN = new Node(newP);
            if (isEmpty()) {
                this.head = this.tail = newN;
            } else {
                newN.pre = this.tail;
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
        ftraverseFW(f);
        ftraverseBW(f);
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
        ftraverseFW(f);
        ftraverseBW(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        if (!isEmpty()) {
            int count = 0;
            Node p = this.head;
            while (p != null) {
                count++;
                if (count == 2) {
                    this.head = p.next;
                    if (this.head == null) {
                        this.tail = this.head = null;
                    } else {
                        this.head.pre = null;//phải xử lý thêm cái prev
                        if (this.head == this.tail) {
                            this.tail.pre = null;
                        }
                        p.next = null;
                    }
                    size -= count;
                    break;
                }
                p = p.next;
            }
            if (count < 2) {
                this.tail = this.head = null;
                size -= count;
            }
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

    // f3: remove the all Phone 'I'
    void f3() throws Exception {
        clear();
        loadData(0);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverseFW(f);
        ftraverseBW(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Node current = this.head;
        while (current != null) {
            if (current.info.name.startsWith("I")) {
                if (size == 1) {
                    this.tail = this.head = null;
                    size = 0;
                    break;
                }
                if (this.head == current) {
                    this.head = this.head.next;
                    this.head.pre = null;
                    current = this.head;
                } else if (this.tail == current) {
                    this.tail = current.pre;
                    this.tail.next = null;
                    current = null;
                } else {
                    Node next = current.next;
                    Node prev = current.pre;
                    current.next = current.pre = null;
                    next.pre = prev;
                    prev.next = next;
                    current = next;
                }
                size--;
            } else {
                current = current.next;
            }
        }

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

    // f4: add a new Phone to the possition "after the head node"
    // (only add if the list does not contain the ID of the new Phone).
    // This also means that: 
    // (1) you should check the ID of the new Phone exist in the list or not; 
    // (2) if it does not exist, you write your code to add it to the list.
    void f4() throws Exception {
        clear();
        loadData(0);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverseFW(f);
        ftraverseBW(f);
        Phone t = new Phone(999, "FPT", 25);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        if (!isEmpty()) {
            Node p = this.head;
            boolean check = true;
            while (p != null) {
                if (p.info.ID == t.ID) {
                    check = false;
                    break;
                }
                p = p.next;
            }
            if (check) {
                Node nNext = this.head.next;
                Node newN = new Node(t);
                this.head.next = newN;
                newN.pre = this.head;
                newN.next = nNext;
                nNext.pre = newN;
                if (size == 1) {
                    this.tail = newN;
                }
                size++;
            }
        } else {
            addLast(t.ID, t.name, t.price);
        }

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

    // f5: swap min and max 
    void f5() throws Exception {
        clear();
        loadData(0);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverseFW(f);
        ftraverseBW(f);
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
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

}
