package com.cisco.webex.signup.user.validation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FordFulkerson {

    public static void main(String args[])
    {

        int graph[][] = new int[][] {
            { 0, 16, 13, 0, 0, 0 }, { 0, 0, 10, 12, 0, 0 },
            { 0, 4, 0, 0, 14, 0 },  { 0, 0, 9, 0, 0, 20 },
            { 0, 0, 0, 7, 0, 4 },   { 0, 0, 0, 0, 0, 0 }
        };

        new FordFulkerson().fordFulkersonAlgo(0,graph,5);
    }

    public void fordFulkersonAlgo(int source,int [][] graph,int destination)
    {
        boolean pathAvailable=true;
        int result=0;
        Map<Integer,Integer> path = new HashMap<Integer, Integer>();
        while(pathAvailable) {
            pathAvailable = findPath(source, graph, path, destination);
            int bottleNeck = findBottleNeck(source,path,graph,destination);

            augmentGraph(source,destination,graph,path,bottleNeck);
            result+=bottleNeck;



            path=new HashMap<Integer, Integer>();
        }
        System.out.println("Max Flow: "+result);

    }

    public boolean findPath(int source,int[][]graph,Map<Integer,Integer> map,int destination)
    {
        boolean visited[]=new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while(!q.isEmpty())
        {
            int visit = q.poll();
            visited[visit]=true;
            for(int i=0;i<graph[visit].length;i++)
            {
                if(graph[visit][i]>0 && !visited[i])
                {
                    q.add(i);
                    map.put(i,visit);
                }
            }
            if(map.containsKey(destination))
                return true;
        }
        return false;
    }

    public int findBottleNeck(int source,Map<Integer,Integer> pathMap, int[][]graph,int destination)
    {
        int minV=Integer.MAX_VALUE;
        int start=destination;
        while(start!=source)
        {
            if(!pathMap.containsKey(destination))
                break;
            start= pathMap.get(destination);
            minV=Math.min(minV,graph[start][destination]);
            destination=start;
        }
        return minV==Integer.MAX_VALUE?0:minV;
    }

    public void augmentGraph(int source, int destination,int[][]graph, Map<Integer,Integer>path,int bottleneck)
    {
        int start=destination;
        while (source!=start)
        {
            if(!path.containsKey(destination))
                break;
            start=path.get(destination);
            graph[start][destination]-=bottleneck;
            graph[destination][start]+=bottleneck;
            destination=start;
        }

    }
}
