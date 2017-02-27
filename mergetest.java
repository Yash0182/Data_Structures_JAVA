public class mergetest {
    public static void main(String args[])
    {
        int a[]={5,2,4,7,1,3,2,6};
        int l[]=null;
        //int r[]=new int[5];
        try
        {
        for(int i=0;i<(a.length/2);i++)
        {
            l[i]=a[i];
            //r[i]=a[i+4];
            System.out.print(l.length);
            
        }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
        System.out.print(a.length);
        for(int i=0;i<4;i++)
        {
            System.out.print(l[i]);
        }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
//         System.out.print(l.length);
    }
}
