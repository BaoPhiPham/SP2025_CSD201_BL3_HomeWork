/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PhamBaoPhi
 */
public class MyStack {

    Node top;

    public MyStack() {
    }

    public MyStack(Node top) {
        this.top = top;
    }

    // insert an element at the top position
    public void push(String id, String name, int age, double gpa) {
        //create student:
        Student s = new Student(id, name, age, gpa);
        // Create new node with given data
        Node newNode = new Node(s);
        // Make the new node point to the current top
        newNode.next = top;
        // Update top to point to the new node
        top = newNode;
    }

    // Utility function to check if the stack is empty or not
    public boolean isEmpty() {
        return top == null;
    }
    
    public Student peek() {
        if (!isEmpty()) {
            return top.infor;
        } else {
            System.out.println("Stack is empty!");
            return null;
        }
    }
    
    // function to return value of top element and remove top element in a stack
    // -1: return a default value if stack is empty
    public Student pop() {
        if (!isEmpty()) {
            Student value = top.infor; // lưu giữ giá trị của top
            top = top.next; // dời top sang phần tử tiếp theo
            return value; // trả về giá trị của top
        } else {
            System.out.println("Stack is empty!");
            return null;
        }
    }
    
    // display all
    public void display() {
        if (!isEmpty()) {
            Node current = top;
            System.out.print("Stack elements: ");
            while (current != null) {
                System.out.print(current.infor + " ");
                current = current.next;
            }
            System.out.println("");
        } else {
            System.out.println("Stack is empty");
        }

    }
}
