package com.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QiuickSortTest {

    public static int[] quickSort(int []arr)
    {

        if(arr.length==0)
            return new int[0];
        if(arr.length==1)
            return arr;
        int pivot = arr[0];
        int[] left = smallerToPivot(arr, pivot);
        int[] right = greaterToPivot(arr, pivot);
        return join(quickSort(left),pivot,quickSort(right));
    }

    public static void main(String args[])
    {
        int []arr=quickSort(new int[]{11,10,3, 1, 7, 4, 2,9,12,8});
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }

    public static int[] smallerToPivot(int arr[], int pivot)
    {
        if(arr.length==0)
            return new int[0];
        if(arr.length==1)
            return arr;
        List<Integer> left = new ArrayList<Integer>();
        //int left[] = new int[arr.length];
        int i=0;
        for(int x:arr)
        {
            if(x<pivot)
            {
                left.add(x);
            }
        }
        return left.stream().mapToInt(j -> j).toArray();
    }

    public static int[] greaterToPivot(int arr[], int pivot)
    {
        if(arr.length==0)
            return new int[0];
        if(arr.length==1)
            return arr;
        List<Integer> right = new ArrayList<Integer>();
        int i=0;
        for(int x:arr)
        {
            if(x>pivot)
            {
                right.add(x);
            }
        }
        return right.stream().mapToInt(j -> j).toArray();
    }

    public static int[] join(int[]left, int pivot, int[]right)
    {
        int [] result=new int[left.length+right.length+1];
        int x=0;
        for(int i=0;i<left.length;i++)
        {
            result[x++]=left[i];
        }
        result[x++]=pivot;
        for(int i=0;i<right.length;i++)
        {
            result[x++]=right[i];
        }
        return result;
    }
}
