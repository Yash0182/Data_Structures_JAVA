package com.cisco.webex.signup.junit;

public class TestAlgo {

    public static void main(String args[])
    {
        int arr[] = mergeSort(new int[]{3,6,1,8,9,4,2,7},0,7);
        for(int i:arr)
        {
            System.out.print(i + " ");
        }
    }

    public static int[] mergeSort(int arr[], int low, int high)
    {
        if(arr.length==0)
            return null;
        if(arr.length==1)
            return arr;
        if(low>high)
            return null;
        if(low==high)
            return arr;
        int mid = low + (high-low)/2;
        int leftarr[] = separateArray(arr,low,mid);
        int rightarr[]= separateArray(arr,mid+1,high);cd 
        int left[] = mergeSort(leftarr,low,mid);
        //this is important, where we pass the pointers as low and mid again to the right side as well.
        int right[] = mergeSort(rightarr,low,mid);

        return merge(left,right);
    }

    public static int[] separateArray(int arr[], int start, int end)
    {
        int newarr[] = new int[end-start+1];
        int j=0;
        for(int i=start;  start<arr.length && i<=end;i++)
        {
            newarr[j++]=arr[i];
        }

        return newarr;
    }

    public static int[] merge(int []left, int[] right)
    {
        int [] merged = new int[left.length+right.length];
        int i=0,j=0,start=0;
        while(i<left.length && j<right.length)
        {
            if(left[i]<right[j])
            {
                merged[start++]=left[i++];
            }
            else
            {
                merged[start++]=right[j++];
            }
        }
        if(i<left.length)
        {
            while(i<left.length)
                merged[start++]=left[i++];
        }
        if(j<right.length)
        {
            while(j<right.length)
                merged[start++]=right[j++];
        }
        return merged;
    }

}
