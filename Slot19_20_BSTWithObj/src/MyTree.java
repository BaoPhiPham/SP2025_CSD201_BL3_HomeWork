/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PhamBaoPhi
 */
public class MyTree {

    Node root;

    public MyTree() {
        this.root = null;
    }

    public void load() {
        insert(20, "Alice", 3.8);
        insert(10, "Bob", 3.5);
        insert(30, "Charlie", 3.9);
        insert(5, "David", 3.2);
        insert(15, "Eva", 3.7);
        insert(25, "Frank", 3.6);
        insert(35, "Grace", 4.0);
        insert(100, "Henry", 3.4);
    }

    private Node insertRec(Node p, Student key) {
        if (p == null) {
            p = new Node(key);
        } else if (p.info.getId() > key.getId()) {
            p.left = insertRec(p.left, key);
        } else if (p.info.getId() < key.getId()) {
            p.right = insertRec(p.right, key);
        }
        return p;
    }

    public void insert(int id, String name, double gpa) {
        Student newS = new Student(id, name, gpa);
        if (this.root == null) {
            this.root = insertRec(this.root, newS);
        } else {
            this.root = insertRec(this.root, newS);
        }
    }

    public void visit(Node p) {
        System.out.println(p.info);
    }

    public void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    public void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    public void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    private Student findStudentByID(int id, Node p) {
        if (p == null) {
            return null;
        }
        if (p.info.getId() == id) {
            return p.info;
        } else if (p.info.getId() > id) {
            return findStudentByID(id, p.left);
        }
        return findStudentByID(id, p.right);
    }

    public Student findStudentByID(int id) {
        if (this.root == null) {
            return null;
        }
        return findStudentByID(id, root);
    }

    private double sum(Node p) {
        if (p == null) {
            return 0;
        }
        return p.info.getGpa() + sum(p.left) + sum(p.right);
    }

    private int countNodes(Node p) {
        if (p == null) {
            return 0;
        }
        return 1 + countNodes(p.left) + countNodes(p.right);
    }

    public double getAverageGPA() {
        if (this.root == null) {
            return 0;
        }
        double sum = sum(root);
        double count = countNodes(root);
        return (count > 0) ? (sum / count) : 0;
    }

    // f1 - test insert
    public void f1() {
        System.out.println("Students after insertion:");
        inOrder(root);
    }

    // f2 - count students/nodes
    public int f2() {
        return countNodes(root);
    }

    // f3 - sum of GPAs
    public double f3() {
        return getAverageGPA();
    }

    // f4 - pre-order traversal
    public void f4() {
        preOrder(root);
    }

    // f5 - in-order traversal
    public void f5() {
        inOrder(root);
    }

    // f6 - post-order traversal
    public void f6() {
        postOrder(root);
    }

    // f7 - find student by ID
    public Student f7(int id) {
        return findStudentByID(id);
    }

}
