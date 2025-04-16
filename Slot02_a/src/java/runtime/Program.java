/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtime;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PhamBaoPhi
 */
public class Program {
    
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        String a = "a";//kiểu dữ liệu tham chiếu
        //về mặt nguyên tắc thì List, set, map,...(collection) dùng để quản lý 
        //     các đối tượng  nhìu hơn, muốn quản lý số thì chỉ dùng array thường
        int b = 1;
        Integer c = 1;
        //interface là nơi quy định có các method, nhưng các method này được 
        //      hiện thực bởi các tk con(class) extend từ nó
        //1 vài method của ArrayList:
        list1.add(5);
        list1.add(410);
        for (int i = 0; i < 10; i++) {
            list1.add(i);
        }
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
        System.out.println("Số lượng: " + list1.size());
//        list1.remove(list1.remove(0));
//        list1.remove(list1.remove(list1.size() - 1));
        //
        list1.set(0, 192);
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Input the index: ");
            int index = sc.nextInt();
            System.out.println("getFirst: " + list1.get(0));
            System.out.println("getLast: " + list1.get(list1.size()-1));
            System.out.println("getNext: " + list1.get(index + 1));
            System.out.println("getPrev: " + list1.get(index - 1));
            System.out.println("get Value: " + list1.get(index));
            //insert:
            list1.add(index, index);
            //find: tìm vị trí:
            list1.indexOf(5);//lấy ra vị trí của số 5
            //find lấy ra giá trị:
            list1.get(list1.indexOf(5));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
