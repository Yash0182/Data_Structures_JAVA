
import java.util.Scanner;

class NodeDouble
{
    int data;
    NodeDouble next,previous;
    public void display(NodeDouble head)
    {
        NodeDouble current=null;
        System.out.println("");
        System.out.println("Traversing in forward order");
        while(head!=null)
        {
            System.out.print(head.data +"-->");
            if(head.next==null)
            {
                current=head;
            }
            head=head.next;
            
            
        }
        System.out.println("");
        System.out.println("Traversing in opposite order");
        
        while(current!=null)
        {
            System.out.print(current.data +"-->");
            current=current.previous;
        }
    }
}
public class Assignment4
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        NodeDouble first = new NodeDouble();
        first.next=null;
        first.previous=null;
        NodeDouble head = first;
        NodeDouble headtemp = first;
        System.out.println("Enter data for the very firast node");
        first.data=sc.nextInt();
        char c='y';
        System.out.println("Wanna continue y/n");
        c= sc.next().charAt(0);
        while(c!='n')
        {
            NodeDouble temp = new NodeDouble();
            System.out.println("Enter data");
            temp.data=sc.nextInt();
            first.next=temp;
            first=first.next;
            first.previous=headtemp;
            headtemp=first;
            System.out.println("Wanna continue y/n");
            c= sc.next().charAt(0);
            
        }
        first=head;
        first.display(first);
        
    }
}