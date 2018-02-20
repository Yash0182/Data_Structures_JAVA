
import java.util.Scanner;

class StackImple
{
    int size;
    static int top=-1;
    int arr[];

    public StackImple(int size) {
        this.size = size;
        this.arr=new int[size];
    }
   /* public void insertElements()
    {
        char c; int i=0;
        System.out.println("Enter elements");
        Scanner sc = new Scanner(System.in);
        do{
            arr[i]=sc.nextInt();
            i++;
            System.out.println("Want to continue y/n");
            c=sc.next().charAt(0);
            
        }while(c=='y');
    }*/
    public int isEmpty()
    {
        if(top==-1)
        {
        return -1;
        }
        else
        {
            return 1;
        }
    }
    public void push(int number)
    {
        if(top+1>=size)
        {
            System.out.println("Cannot Push stack is full");
        }
        else
        {
            arr[top+1]=number;
            ++top;
        }
        display();
    }
    public void pop()
    {
        if(top<0)
        {
            System.out.println("Cannot POP, astack is empty");
        }
        else
        {
        System.out.println(arr[top]);
        --top;
        }
    }
    public void display()
    {
        for(int i=top;i<=0;i--)
        {
        System.out.println(arr[i]);
        }
    }
    
}
public class Codility1
{
public static void main(String args[])
{
System.out.println("Size of stack");
Scanner sc = new Scanner(System.in);
int a = sc.nextInt();
StackImple st = new StackImple(a);
st.push(4);
st.push(3);
st.push(7);
st.push(8);
st.push(9);

st.display();
}
}
