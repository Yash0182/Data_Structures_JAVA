
import java.util.Scanner;


public class DetectLoop {
public static void main(String args[])    
{
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter any string");
    String first = sc.next();
    first=first.replaceAll("\\s","");
    System.out.println(first);
    String second = first;
    //System.out.println(second);
    int flag=0;
    for(int i=0;i<second.length();i++)
    {
        for(int j=i+1;j<second.length();j++)
        {
        if(first.charAt(i)==second.charAt(j))
        {
            flag=1;
        }
        }
    }
    if(flag==1)
    {
        System.out.println("String has duplicate characters");
    }
    else
    {
        System.out.println("No it does not have duplicate characters");
    }
}
}
