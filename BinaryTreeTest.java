
import java.util.Scanner;

class NodeCircular
{
    int data;
    NodeCircular next;
    
    public void display(NodeCircular head)
    {
        while(head!=null)
        {
        System.out.print(head.data + "-->");
        head=head.next;
        }
    }
}

public class BinaryTreeTest
{
    public static void factorial(int n)
        {
            int k=n;
         for(;n>1;--n)   
         {
             
             k=k*(n-1);
             
         }
         System.out.println("Value of k is "+k);
        }
    public static void main(String args[])
    {
        NodeCircular first= new NodeCircular();
        NodeCircular head=null;
        head=first;
        first.next=null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data for the very first node");
        first.data=sc.nextInt();
                char c='y';
        System.out.println("Wanna Continue y/n");
        c=sc.next().charAt(0);
        while(c!='n')
        {
            System.out.println("Enter data for next node");
            NodeCircular temp = new NodeCircular();
            temp.data = sc.nextInt();
            temp.next=null;
            first.next=temp;
            first=first.next;
            System.out.println("Wanna Continue y/n");
            c=sc.next().charAt(0);
        }
        first.next=head;
        first.display(head);
        
        factorial(4);
    }
}
