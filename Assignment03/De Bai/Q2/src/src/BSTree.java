/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        //System.out.println(p);
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    private Node insertRec(Node p, User u) {
        if (p == null) {
            p = new Node(u);
        } else if (p.info.getId() > u.getId()) {
            p.left = insertRec(p.left, u);
        } else if (p.info.getId() < u.getId()) {
            p.right = insertRec(p.right, u);
        }
        return p;
    }

    private void postOrderWithCondition(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrderWithCondition(p.left, f);
        postOrderWithCondition(p.right, f);
        if (p.info.getAge() < 25) {
            fvisit(p, f);
        }
    }

    private int maxLevel(Node p) {
        if (p == null) {
            return 0;
        }
        int leftMax = maxLevel(p.left);
        int rightMax = maxLevel(p.right);
        return Math.max(rightMax, leftMax) + 1;
    }

    private void findLastPostOrder(Node root, List<Node> result) {
        if (root == null) {
            return;
        }
        findLastPostOrder(root.left, result);
        findLastPostOrder(root.right, result);
        result.add(root);
    }

    private void addAgeWithAChild(Node p) {
        if (p == null) {
            return;
        }
        if ((p.left == null && p.right != null) || (p.right == null && p.left != null)) {
            p.info.setAge(p.info.getAge() + 3);
        }
        addAgeWithAChild(p.left);
        addAgeWithAChild(p.right);
    }

    private void resetNodeOfLeftInpreOrder(Node p) {
        if (p == null) {
            return;
        }
        p.info.setAge(0);
        resetNodeOfLeftInpreOrder(p.left);
        resetNodeOfLeftInpreOrder(p.right);
    }

    private Node maxIdOnRight(Node p) {
        if (p == null) {
            User u = new User("", -1, -1);
            return new Node(u);
        }
        Node rightMax = maxIdOnRight(p.right);
        Node res = (rightMax.info.getId() > p.info.getId()) ? rightMax : p;
        return res;
    }

    void insert(String xName, int xAge, int xId) {
        //You should insert here statements to complete this function
        if (xAge > 0) {
            User u = new User(xName, xAge, xId);
            this.root = insertRec(this.root, u);
        }
    }

    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete insert  function
        above only.
         */
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        if (!isEmpty()) {
            postOrderWithCondition(this.root, f);
        }
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

// f.writeBytes(" k = " + k + "\r\n");
//=============================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        if (!isEmpty()) {
            addAgeWithAChild(this.root);
        }
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        int h = 0;//Height of the last node
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        if (!isEmpty()) {
            List<Node> q = new ArrayList<>();
            findLastPostOrder(this.root, q);
            h = maxLevel(q.get(q.size() - 1));
        }

        //------------------------------------------------------------------------------------
        f.writeBytes(h + "");
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================    
    void f5() throws Exception {
        clear();
        loadData(17);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        inOrder(root, f);
        f.writeBytes("\r\n");

        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        if (!isEmpty()) {
            resetNodeOfLeftInpreOrder(this.root.left);
        }
        //------------------------------------------------------------------------------------
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void f6() throws Exception {
        clear();
        loadData(21);
        String fname = "f6.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        inOrder(root, f);
        f.writeBytes("\r\n");
        Node right_most = null;//right_most node
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        if (!isEmpty()) {
            right_most = maxIdOnRight(this.root.right);
        }
        //------------------------------------------------------------------------------------
        fvisit(right_most, f);
        f.writeBytes("\r\n");
        f.close();
    }
}
