package com.cisco.webex.signup.user.validation;

public class InsertionTest {

    static class Node
    {
        Node left;
        Node right;
        int data;
        Node(int data)
        {
            this.data=data;
        }
    }

    public static Node insert(Node root, int data)
    {
        if(root==null)
        {
            Node n=new Node(data);
            return n;
        }
        if(root.data>data)
           root.left= insert(root.left,data);
        else
           root.right = insert(root.right,data);

        return root;
    }

    public static void traverse(Node root)
    {
        if(root==null)
            return;
        traverse(root.left);
        System.out.println(root.data);
        traverse(root.right);
    }


    public static void main(String args[])
    {
        int []arr=new int[]{11,3,5,1,6,9,4,2,8,0,7,10};
        //int[] ar = sort(arr);
        //int[] ar = insertionSort(arr);
        //int[] ar = mergeSort(arr);
        //recursion("");
        //perm("AB","", 2);
        /*
        for(int i:ar)
        {
            System.out.println(i);
        }

         */
        Node root=insert(null,14);
        insert(root,121);
        insert(root,2);
        insert(root,1);
        insert(root,12);
        insert(root,100);
        insert(root,10);
        insert(root,223);
        insert(root,-1);
        insert(root,13);
        insert(root,11);
        //traverse(root);
        removeNode(root,11);
        System.out.println(" After remove");
        traverse(root);
        System.out.println("Parent of 2: "+ findParent( root,new Node(2)).data);
        System.out.println("Parent of 13: "+ findParent( root,new Node(13)).data);
        System.out.println("Parent of 10: "+ findParent( root,new Node(10)).data);
        System.out.println("Parent of 121: "+ findParent( root,new Node(121)).data);
    }

    public static int[] insertionSort(int arr[])
    {
        for(int i=1;i<arr.length;i++)
        {
            int j=i-1;
            int comparingElement = arr[i];
            while(j>=0 && comparingElement<arr[j])
            {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=comparingElement;
        }
        return arr;
    }

    public static int[] sort(int[] arr)
    {
        for(int i=1;i< arr.length;i++)
        {
            System.out.print(i+ "  "+arr[i]+"   =>  ");
            for(int j:arr)
            {
                System.out.print(j+" ");
            }
            System.out.println("");
            for(int j=0;j<i;j++)
            {
                if(arr[i]<arr[j])
                {
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;

                }
                for(int k:arr)
                {
                    System.out.print(k+" ");
                }
                System.out.println("");
                System.out.println("--------------------------");
            }

            for(int j:arr)
            {
                System.out.print(j+" ");
            }
            System.out.println("");
            System.out.println("===============================");
        }
        return arr;
    }

    public static int[] mergeSort(int arr[])
    {
        if(arr==null || arr.length==0)
            return new int[0];
        if(arr.length==1)
            return arr;
        int low=0, high=arr.length;
        int mid = low+(int)Math.ceil((high-low)/2);
        int []firstHalf = new int[mid];
        for(int i=0;i<mid;i++)
        {
            firstHalf[i]=arr[i];
            System.out.print("firstHalf: "+firstHalf[i]+" ");
        }
        System.out.println("");
        int []secondHalf = null;
        if(high%2!=0)
            secondHalf = new int[mid+1];
        else
            secondHalf = new int[mid];
        for(int i=mid;i<high;i++)
        {
            secondHalf[i-mid]=arr[i];
            System.out.print("secondHalf: "+secondHalf[i-mid]+" ");
        }
        System.out.println("");
        int[] left = mergeSort(firstHalf);
        int[] right = mergeSort(secondHalf);
        int []res = merge(left,right);
        return res;
    }


    public static int[] merge(int[]left, int[]right)
    {
        int res[]=new int[left.length+right.length];
        int i=0,j=0,k=0;
        while(i< left.length&&j< right.length)
        {
            if(left[i]<right[j])
            {
                res[k++]=left[i++];
            }
            else
                res[k++]=right[j++];
        }
        if(i< left.length)
        {
            while(i< left.length) {
                res[k++] = left[i++];
            }
        }

        if(j< right.length)
        {
            while (j< right.length)
            {
                res[k++]=right[j++];
            }
        }
        return res;
    }

    public static void recursion(String arr)
    {
        if(arr.length()==3)
        {
            for(char i:arr.toCharArray()) {
                System.out.print(i + "    ");
            }
            System.out.println("");
            return;
        }
        for(int i=arr.length();i<3;i++)
        {
            for(char j:arr.toCharArray()) {
                System.out.print(j + "  before concat  ");
            }
            System.out.println("");
            arr=arr.concat(i+"");
            for(char j:arr.toCharArray()) {
                System.out.print(j + "  inside  ");
            }
            System.out.println("");
            recursion(arr);
            for(char j:arr.toCharArray()) {
                System.out.print(j + "  after calling recursion  ");
            }
            System.out.println("");
        }
    }

    public static void perm(String str, String res, int length)
    {
        if(res.length()==length)
        {
            System.out.println(res);
            return;
        }
        if(res.length()>length)
            return;

        for(char c:str.toCharArray())
        {
            if(res.contains(c+""))
                continue;
            res=res.concat(c+"");
            perm(str,res,length);
            res=res.substring(0,res.length()-1);
        }
    }

    static void removeNode(Node root, int data)
    {
        deleteNode(root,root,data);
    }
    public static void deleteNode(Node root, Node rootPr, int data)
    {
        if(root==null)
            return;
        if(root.data==data) {
            Node par=findParent(rootPr,root);
            //System.out.println("Inside parent of "+data+ "  " + par.data );
            delete(root, data, par);
            return;
        }

        if(root.data>data) {
            deleteNode(root.left,rootPr,data);
        }
        else if(root.data<data) {
            deleteNode(root.right,rootPr,data);
        }

    }
    public static void delete(Node root, int data, Node parent)
    {
        if(root==null)
            return ;

        if(root.left==null&&root.right==null)
        {
            if(parent==null) {
                Node minNode = findMinRightSubTree(root.right);
                System.out.println("Min node of "+ root.data +" is: "+ minNode.data);
                Node minNodeParent = findParent(root,minNode);
                System.out.println("Parent of min node "+minNode.data + "  is "+ minNodeParent.data);
                delete(minNode,minNode.data,minNodeParent);
                root.data=minNode.data;

                //root=null;
                return;
            }
            if(root.data>parent.data)
                parent.right=null;
            else
                parent.left=null;
            return ;
        }
        else if(root.left==null)
        {
            if(parent==null)
                return ;
            if(root.data>parent.data)
                parent.right=root.right;
            else
                parent.left=root.right;
        }

        else if(root.right==null)
        {
            if(parent==null)
                return ;
            if(root.data>parent.data)
                parent.right=root.left;
            else
                parent.left=root.left;
        }
        else
        {
            Node minNode = findMinRightSubTree(root.right);
            System.out.println("Min node of "+ root.data +" is: "+ minNode.data);
            Node minNodeParent = findParent(root,minNode);
            System.out.println("Parent of min node "+minNode.data + "  is "+ minNodeParent.data);
            /*if(minNode.right!=null)
            {
                minNodeParent.left=minNode.right;
            }
            else
                minNodeParent.left=null;

             */
            delete(minNode,minNode.data,minNodeParent);
            root.data=minNode.data;

        }
    }

    public static Node findMinRightSubTree(Node root)
    {
        if (root.left==null)
            return root;

        return findMinRightSubTree(root.left);

    }

    public static Node findParent(Node root,Node child)
    {
        if(root==null)
            return null;
/*
        if(root.left==null)
            return root.right;
        if(root.right==null)
            return root.left;


 */
        if((root.left!=null&&root.left.data==child.data) || (root.right!=null&&root.right.data==child.data))
            return root;

        if(root.data>child.data)
            return findParent(root.left,child);
        else
            return findParent(root.right,child);
    }
}
