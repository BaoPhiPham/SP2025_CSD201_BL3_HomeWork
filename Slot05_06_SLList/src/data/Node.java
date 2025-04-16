/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author PhamBaoPhi
 */
public class Node {
    
    //props:
    int infor;
    Node next;

    //constructor for a typical node
    public Node(int infor, Node next) {
        this.infor = infor;
        this.next = next;
    }

    //default constructor(no parameter)
    public Node() {
    }

    //overloading
    public Node(int infor) {
        this.infor = infor;//data stored inside the node
        this.next = null;// link to the next node
    }
    
}
