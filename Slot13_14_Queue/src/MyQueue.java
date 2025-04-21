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

    public void enqueue(int key) {
        Node newN = new Node(key);
        if (isEmpty()) {
            this.head = this.tail = newN;
        } else {
            this.tail.next = newN;
            this.tail = newN;
        }
    }

    public int dequeue() {
        if (!isEmpty()) {
            int value = this.head.info;
            this.head = this.head.next;
            if (this.head == null) {
                this.tail = null;
            }
            return value;
        }
        return Integer.MIN_VALUE;
    }

    public int front() {
        if (!isEmpty()) {
            return this.head.info;
        }
        return Integer.MIN_VALUE;
    }
    
    public void display(){
        if(!isEmpty()){
            Node p = this.head;
            while(p != null){
                System.out.print(p.info + " ");
                p = p.next;
            }
            System.out.println("");
            return;
        }
        System.out.println("No element to print");
    }

}
