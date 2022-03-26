package com.cisco.webex.signup.user.validation;

import java.util.*;

public class KanhTopology {

    public static void main(String args[]) {

        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        new KanhTopology().topologicalKahn(g.getVertex());
    }

    public void topologicalKahn(List<List<Integer>> vert)
    {

        Map<Integer,Integer> hmCount = getDependencyCount(vert);
        Queue<Integer> sortList = new LinkedList<>();
        for(int i=0;i<vert.size();i++)
        {
            if(!hmCount.containsKey(i))
                sortList.add(i);
        }
        while(!sortList.isEmpty()) {
            int n=sortList.poll();
            System.out.print(n+" -> ");
            List<Integer> neigh = vert.get(n);
            for (int indiNeigh : neigh) {
                hmCount.put(indiNeigh, hmCount.getOrDefault(indiNeigh, 0) - 1);
                if (hmCount.get(indiNeigh) <= 0)
                    sortList.add(indiNeigh);
            }


        }


    }

    private Map<Integer,Integer> getDependencyCount(List<List<Integer>> vert)
    {
        Map<Integer,Integer> hmCount = new HashMap<>();
        for(List<Integer> neigh:vert)
        {
            for(int n:neigh)
            {
                hmCount.put(n, hmCount.getOrDefault(n,0)+1);
            }
        }
        return hmCount;

    }
}
