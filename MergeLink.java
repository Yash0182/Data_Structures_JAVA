
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vaio1
 */


public class MergeLink {
    public static void main(String args[])
    {
        Scanner sc = new Scanner (System.in);
        Node first = new Node();
        Node head=first;
        System.out.println("Enter data");
        first.data=sc.nextInt();
        char c;
        System.out.println("Want to continue y/n");
        c=sc.next().charAt(0);
        while(c=='y'){
            Node next=new Node();
            System.out.println("Enter data");
            first.node=next;
            first=first.node;
            first.data=sc.nextInt();
            System.out.println("Want to continue y/n");
            c=sc.next().charAt(0);
        }
    }
    
}
