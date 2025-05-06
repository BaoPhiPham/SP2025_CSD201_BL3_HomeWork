
import java.io.*;

class ItemList {

    Node head, tail;

    ItemList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void deleteNode(Node q) {
        if (head.info.getName().equals(q.info.getName())) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            Node prevP = head;
            Node p = head.next;
            while (p != null && !p.info.getName().equals(q.info.getName())) {
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
    }

    Node deleteLastNonFragile() {
        Node result = null;
        //You should write here appropriate statements to complete this function.
        //----------------------------------------------------------------------
        Node cur = this.head;
        while (cur != null) {
            if (cur.info.getFragile() == 0) {
                result = cur;
            }
            cur = cur.next;
        }
        //----------------------------------------------------------------------
        return result;
    }

    void loadItemList(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int[] d = Lib.readLineToIntArray("data.txt", k + 3);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i], d[i]);
        }
    }

    void addLast(String name, int weight, int length, int fragile) {
        //You should write here appropriate statements to complete this function.
        //----------------------------------------------------------------------
        if (weight <= 0 || length <= 0) {
            return;
        }
        Item newI = new Item(name, weight, length, fragile);
        Node newN = new Node(newI);
        if (isEmpty()) {
            this.head = this.tail = newN;
        } else {
            this.tail.next = newN;
            this.tail = newN;
        }
        //----------------------------------------------------------------------
    }

}

class Truck {

    Node head;

    Truck() {
        head = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = null;
    }

    void loadTruck(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k + 4);
        int[] b = Lib.readLineToIntArray("data.txt", k + 5);
        int[] c = Lib.readLineToIntArray("data.txt", k + 6);
        int[] d = Lib.readLineToIntArray("data.txt", k + 7);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            push(a[i], b[i], c[i], d[i]);
        }
    }

    void push(String name, int weight, int length, int fragile) {
        //You should write here appropriate statements to complete this function.
        //----------------------------------------------------------------------
        if (weight <= 0 || length <= 0) {
            return;
        }
        Item newI = new Item(name, weight, length, fragile);
        Node newN = new Node(newI);
        if (isEmpty()) {
            this.head = newN;
        } else {
            newN.next = this.head;
            this.head = newN;
        }
        //----------------------------------------------------------------------
    }

    void push(Node q) {
        if (this.isEmpty()) {
            head = q;
        } else {
            q.next = head;
            head = q;
        }
    }

    Node pop() {
        if (isEmpty()) {
            return null;
        }
        Node tmp = head;
        head = head.next;
        return tmp;
    }
}

class House {

    ItemList list = new ItemList();
    Truck truck = new Truck();

    House() {
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = list.head;
        f.writeBytes("ItemList Inventory: ");
        if (p == null) {
            f.writeBytes("Empty");
        }
        while (p != null) {
            fvisit(p, f);
            p = p.next;
        }
        f.writeBytes("\r\n");

        f.writeBytes("Truck Contents: ");
        p = truck.head;
        if (p == null) {
            f.writeBytes("Empty");
        }
        while (p != null) {
            fvisit(p, f);
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void load(int k) throws Exception //do not edit this function
    {
        list.loadItemList(k);
        truck.loadTruck(k);
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
        //----------------------------------------------------------------------
        Node find = list.deleteLastNonFragile();
        if (find != null) {
            list.deleteNode(find);
            truck.push(find);
        }
        //----------------------------------------------------------------------
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
        //----------------------------------------------------------------------
        while (true) {
            Node find = list.deleteLastNonFragile();
            if (find != null) {
                list.deleteNode(find);
                truck.push(find);
            }else{
                break;
            }
        }
        //----------------------------------------------------------------------
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
        int totalWeight = 0;
        //You should write here appropriate statements to complete this function.
        //----------------------------------------------------------------------
        while (true) {
            Node find = list.deleteLastNonFragile();
            if (find != null) {
                list.deleteNode(find);
                truck.push(find);
                
            }else{
                break;
            }
        }
        Node cur = truck.head;
        while(cur != null){
            totalWeight += cur.info.getWeight();
            cur = cur.next;
        }
        //----------------------------------------------------------------------
        ftraverse(f);
        f.writeBytes("Total weight: " + totalWeight + " ");
        f.close();
    }

}
