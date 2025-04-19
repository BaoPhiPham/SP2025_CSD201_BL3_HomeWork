/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PhamBaoPhi
 */
public class Node {

    Student infor;
    Node next;

    public Node() {
    }

    public Node(Student infor, Node next) {
        this.infor = infor;
        this.next = next;
    }

    public Node(Student infor) {
        this.infor = infor;
    }

}
