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

    //default constructor(no parameter): chỉ tồn tại nếu ko có constructors khác
    //          nếu cò 1 hoặc hơn constructors, phải khai báo constructor rỗng ra
    //          để tường minh và rõ ràng
    public Node() {
    }

    public Node(int infor) {
        this.infor = infor;//data stored inside the node
        this.next = null;// link to the next node
    }

}
