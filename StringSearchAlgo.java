package com.cisco.webex.signup.user.validation;

import java.util.HashMap;
import java.util.Map;

public class StringSearchAlgo {

    public static void main(String args[])
    {
        new StringSearchAlgo().kmp("THISISSTRINGSEARCHALGO","STRING");
        new StringSearchAlgo().boyreMoore("THISISSTRINGSEARCHALGO","STRING");
    }
    //In Prefix we only match the start string with all the rest of the strings
    public void kmp(String input, String search)
    {
        int[]lps = new int[search.length()];
        int j=1,i=0;
        while(j<search.length())
        {
            if(search.charAt(i)==search.charAt(j))
            {
                //we store i+1, bcz when falling back in tthe search pattern for the Prefix, we start from the next character of last prefixed character
                lps[j]=i+1;
                j++;
                i++;
            }
            else
            {
                //if the characters does not match and i is greater than zero, we keep increasing tthe gap between i and j and keep pushing i to the prev
                //if(i>0&&j>0)
                if(i!=0)
                {
                    i=lps[i-1];
                    System.out.println(i+" value of i ");
                }
                else {
                    //if the characters does not match and i is equal to zero, we cannot find any more match and we push j forward.
                    //so keep on moving j forward untill a match is found with i
                    lps[j]=0;
                    j++;
                }
            }
        }

        for(int k:lps)
        {
            System.out.print(" "+ k +" ");
        }

        i=0;
        j=0;
        while(i<input.length())
        {
            if(input.charAt(i)==search.charAt(j))
            {
                i++;
                j++;
            }
            if(j==search.length())
            {
                int pos = i-j;
                System.out.println("Found the word at:"+pos);
                break;
            }
            //if the character does not match, we push pointer in our search string to the end of the Prefix string.
            if(i<input.length() && input.charAt(i)!=search.charAt(j))
            {
                if(j>0)
                {
                    j=lps[j-1];
                }
                else
                    i++;
            }
        }
    }

    public void boyreMoore(String input, String search)
    {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<search.length();i++)
        {
            map.put(search.charAt(i),search.length()-i-1);
        }
        map.put(search.charAt(search.length()-1),search.length());

        for(char c: map.keySet())
        {
            System.out.println(c+" "+map.get(c));
        }
        int j=search.length(),res=0,i=search.length()-1;
        while (res!=search.length() && j<input.length())
        {
            if(input.charAt(j)==search.charAt(i))
            {
                j--;
                i--;
                res++;
            }
            else
            {
                i=search.length()-1;
                res=0;
                j+=map.getOrDefault(input.charAt(j),map.get(search.charAt(search.length()-1)));
            }
            if(res==search.length())
            {
                System.out.println("Found the word");
                break;
            }
        }

    }
}
