/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PhamBaoPhi
 */
public class MyQueue {

    Node head, tail;

    public MyQueue() {
        this.head = this.tail = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void enqueue(String id, String name, int age, double gpa) {
        Student newS = new Student(id, name, age, gpa);
        Node newN = new Node(newS);
        if (isEmpty()) {
            this.head = this.tail = newN;
        } else {
            this.tail.next = newN;
            this.tail = newN;
        }
    }

    public Student dequeue() {
        if (!isEmpty()) {
            Student value = this.head.info;
            this.head = this.head.next;
            if (this.head == null) {
                this.tail = null;
            }
            return value;
        }
        return null;
    }

    public Student front() {
        if (!isEmpty()) {
            return this.head.info;
        }
        return null;
    }

    public void display() {
        if (!isEmpty()) {
            Node p = this.head;
            while (p != null) {
                System.out.print(p.info + "\n");
                p = p.next;
            }
            return;
        }
        System.out.println("No element to print");
    }

    public void findStuTithHighGPA() {
        if (!isEmpty()) {
            Student st = this.head.info;
            Node p = this.head;
            while (p != null) {
                if (st.getGpa() < p.info.getGpa()) {
                    st = p.info;
                }
                p = p.next;
            }
            System.out.println("The student with highest GPA: " + "\n" + st);
            return;
        }
        System.out.println("No element in Queue");
    }

}
