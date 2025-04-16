/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtime;

import java.util.Scanner;

/**
 *
 * @author PhamBaoPhi
 */
public class Program {

    public static void main(String[] args) {
        //Array:
        int n = 3;
        int[] array = new int[n];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i <= n; i++) {
            try {
                System.out.println("Input a[" + i + "]: ");
                array[i] = sc.nextInt();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println("-----------------");
        System.out.println(array);//in ra địa chỉ của biến
        for (int i : array) {
            i = 2;
        }
        for (int i : array) {
            System.out.print(i + " ");
        }
        for (int i : array) {
            System.out.println(i);
        }
        System.out.println("Số lượng: " + array.length);

        //String:
        String str = "Chào mừng bạn quay lại với CSD201";
        System.out.println(str.length());
    }
}
