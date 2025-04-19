
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;
import jdk.nashorn.internal.parser.Lexer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PhamBaoPhi
 */
public class StudentStack {

    Node top;

    public StudentStack(Node top) {
        this.top = top;
    }

    public StudentStack() {
        this.top = null;
        //nếu đề có thêm size thì xử lý khác
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public void clear() {
        this.top = null;
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = top;
        while (p != null) {
            f.writeBytes(p.infor.toString() + "\n"); // write data in the node p to the file f
            p = p.next;
        }

        f.writeBytes("\r\n");
    }

    void loadData(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        String[] b = Lib.readLineToStrArray("data.txt", k + 1);
        String[] c = Lib.readLineToStrArray("data.txt", k + 2);
        String[] d = Lib.readLineToStrArray("data.txt", k + 3);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int age = Integer.parseInt(c[i]);
            double gpa = Double.parseDouble(d[i]);
            push(a[i], b[i], age, gpa);
        }
    }

    public void push(String id, String name, int age, double gpa) {
        Student newS = new Student(id, name, age, gpa);
        Node newN = new Node(newS);
        if (isEmpty()) {
            this.top = newN;
        } else {
            newN.next = this.top;
            this.top = newN;
        }
    }

    public Student pop() {
        if (!isEmpty()) {
            Student popS = this.top.infor;
            this.top = this.top.next;
            return popS;
        } else {
            System.out.println("Stack is empty!");
            return null;
        }
    }

    public Student peek() {
        if (!isEmpty()) {
            return this.top.infor;
        } else {
            System.out.println("Stack is empty!");
            return null;
        }
    }

// f1: Load data from file and display all students
    void f1() throws Exception {
        clear();
        loadData(0);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

    // f2: Add a new student from console input
    void f2() throws Exception {
        clear();
        loadData(0);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id of student: ");
        String id = sc.nextLine();
        System.out.println("Enter the name of student: ");
        String name = sc.nextLine();
        System.out.println("Enter the age of student: ");
        int age = sc.nextInt();
        System.out.println("Enter the gpa of student: ");
        double gpa = sc.nextDouble();
        push(id, name, age, gpa);
        //------
        ftraverse(f);
        f.close();
    }

    // f3: Calculate average GPA of all students
    void f3() throws Exception {
        clear();
        loadData(0);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        double average = 0;
        //---------
        int count = 0;
        double sum = 0;
        StudentStack st = this;
        while(!st.isEmpty()){
            Student s = st.pop();
            sum += s.getGpa();
            count++;
        }
        count = (count == 0) ? 1 : count;
        average = sum / count;
        //---------
        f.writeBytes("Average GPA: " + average + "\r\n");
        f.close();
    }
}
