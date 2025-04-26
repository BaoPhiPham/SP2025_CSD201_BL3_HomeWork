/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;

class FruitList {

    Node head, tail;

    FruitList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void loadDataFruit(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

    void addLast(String type, int amount, int price) {
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        Fruit newF = new Fruit(type, amount, price);
        Node newN = new Node(newF);
        if (isEmpty()) {
            this.head = this.tail = newN;
        } else {
            this.tail.next = newN;
            this.tail = newN;
        }
        //---------------------------------------------------------
    }

}

class RequestQueue {

    Node front, rear;

    RequestQueue() {
        front = rear = null;
    }

    boolean isEmpty() {
        return (front == null);
    }

    void clear() {
        front = rear = null;
    }

    void loadDataRequest(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k + 3);
        int[] b = Lib.readLineToIntArray("data.txt", k + 4);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            enQueue(a[i], b[i]);
        }
    }

    void enQueue(String type, int amount) {
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        Fruit newF = new Fruit(type, amount);
        Node newN = new Node(newF);
        if (isEmpty()) {
            this.front = this.rear = newN;
        } else {
            this.rear.next = newN;
            this.rear = newN;
        }
        //---------------------------------------------------------
    }

    Fruit deQueue() {
        Fruit tmp = new Fruit();
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        if (!isEmpty()) {
            tmp = this.front.info;
            this.front = this.front.next;
            if (this.front == null) {
                this.rear = null;
            }
        }
        //---------------------------------------------------------
        return tmp;
    }

    void deleteNode(Node p) {
        if (!isEmpty()) {
            Node q = this.front;
            Node prev = this.front;
            while (q != null) {
                if (p == q) {
                    if (this.front == q) {
                        this.front = q.next;
                        if (this.front == null) {
                            this.rear = null;
                        }

                    } else if (this.rear == q) {
                        this.rear = prev;
                        this.rear.next = null;
                    } else {
                        prev = q.next;
                        q = prev.next;
                    }

                } else {
                    prev = q;
                    q = q.next;
                }

            }
        }
    }

}

class MyStore {

    FruitList FList = new FruitList();
    RequestQueue RQueue = new RequestQueue();

    MyStore() {
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = FList.head;
        f.writeBytes("Data Fruit: ");
        if (p == null) {
            f.writeBytes("Empty");
        }
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
        f.writeBytes("Request   : ");
        p = RQueue.front;
        if (p == null) {
            f.writeBytes("Empty");
        }
        while (p != null) {
            f.writeBytes("(" + p.info.getType() + "," + p.info.getAmount() + ") ");
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void load(int k) throws Exception {
        FList.loadDataFruit(k);
        RQueue.loadDataRequest(k);
    }

    void f1() throws Exception {
        load(1);
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
        load(1);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        Node p = RQueue.front;
        boolean check1 = true;
        while (p != null) {
            if (check1) {
                Node q = FList.head;
                while (q != null) {
                    if (q.info.getType().equals(p.info.getType())
                            && q.info.getAmount() >= p.info.getAmount()) {
                        q.info.setAmount(q.info.getAmount() - p.info.getAmount());
                        check1 = false;
                        RQueue.deleteNode(p);
                        break;
                    }
                    q = q.next;
                }
            }
            p = p.next;
        }
        //---------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void f3() throws Exception {
        load(1);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        Node p = RQueue.front;
        while (p != null) {
            Node q = FList.head;
            while (q != null) {
                if (q.info.getType().equalsIgnoreCase(p.info.getType())
                        && q.info.getAmount() >= p.info.getAmount()) {
                    q.info.setAmount(q.info.getAmount() - p.info.getAmount());
                    break;
                }
                q = q.next;
            }
            p = p.next;
            RQueue.deQueue();
        }
        //---------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void f4() throws Exception {
        load(1);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        int S = 0;
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        Node p = RQueue.front;
        while (p != null) {
            Node q = FList.head;
            while (q != null) {
                if (q.info.getType().equalsIgnoreCase(p.info.getType())
                        && q.info.getAmount() >= p.info.getAmount()) {
                    S += (p.info.getAmount() * q.info.getPrice());
                    q.info.setAmount(q.info.getAmount() - p.info.getAmount());
                    break;
                }
                q = q.next;
            }
            p = p.next;
            RQueue.deQueue();
        }
        //---------------------------------------------------------
        f.writeBytes("Money     : " + S + " ");
        f.close();
    }

}
