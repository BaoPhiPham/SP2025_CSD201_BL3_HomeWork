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

    int info;
    Node left, right;

    public Node(int info, Node left, Node right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    public Node(int info) {
        this(info, null, null);
    }

    public Node() {
        this.left = this.right = null;
    }

}
