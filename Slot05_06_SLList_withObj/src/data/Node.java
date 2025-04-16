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
class Node {

    Phone info;
    Node next;

    Node() {
    }

    Node(Phone x, Node p) {
        this.info = x; // data stored inside the node
        this.next = p; // link to the next node
    }

    Node(Phone x) {
        this(x, null);
    }
}

class Phone {

    String name;
    int price;

    Phone() {
    }

    Phone(String n, int p) {
        this.name = n; // data stored inside the node
        this.price = p; // link to the next node
    }
}
