package com.cisco.webex.signup.user.validation;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class TestAlgorithms {

    public static void main(String args[])
    {
//        TestNode node = new TestNode();
//
//        TestNode.Node a = new TestNode().new Node(1);
//        TestNode.Node b = new TestNode().new Node(2);
//        TestNode.Node c = new TestNode().new Node(3);
//        TestNode.Node d = new TestNode().new Node(4);
//        TestNode.Node e = new TestNode().new Node(5);
//        TestNode.Node f = new TestNode().new Node(6);
//        TestNode.Node g = new TestNode().new Node(7);
//        TestNode.Node h = new TestNode().new Node(8);
//        TestNode.Node i = new TestNode().new Node(9);
//
//        List<TestNode.Node> neighborToA = new LinkedList<>();
//        neighborToA.add(c);
//        neighborToA.add(d);
//        neighborToA.add(h);
//        neighborToA.stream().forEach(neigh->a.addNeighbours(neigh));
//
//        List<TestNode.Node> neighborToB = new LinkedList<>();
//        neighborToB.add(c);
//        neighborToB.add(i);
//        neighborToB.add(a);
//        neighborToB.stream().forEach(neigh->b.addNeighbours(neigh));
//
//        List<TestNode.Node> neighborToC = new LinkedList<>();
//        neighborToC.add(e);
//        neighborToC.add(f);
//        neighborToC.add(g);
//        neighborToC.stream().forEach(neigh->c.addNeighbours(neigh));
//
//        TestNode graph = new TestNode();
//        graph.addVertex(1,neighborToA);
//        graph.addVertex(2,neighborToB);
//        graph.addVertex(3,neighborToC);

        int gra[][]=new int[][]{{ 0, 4, 0, 0, 0, 0, 0, 8, 0 },
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        System.out.println(new TestAlgorithms().dijsktraAlgo(gra));


    }

    public int dijsktraAlgo(int [][]graph)
    {

        PriorityQueue<Pair>pq = new PriorityQueue<>();
        int vertex=8;
        boolean[]visited = new boolean[graph.length];

        visited[0]=true;
        findAndAddNeighbors(pq,graph[0],visited,0);

        while(!pq.isEmpty() && pq.peek().index!=vertex)
        {
            Pair p = pq.poll();
            visited[p.index]=true;
            System.out.println("index "+ p.index +" distance: "+p.dist);
            findAndAddNeighbors(pq,graph[p.index],visited,p.dist);
        }
        return pq.peek().dist;

    }


    public void findAndAddNeighbors(PriorityQueue<Pair> pq, int[]graph,boolean[] visited, int nodeDist)
    {
        for(int i=0;i<graph.length;i++)
        {
            int vert=i;
            boolean found=false;
            if(graph[i]!=0&&!visited[i])
            {
                Iterator<Pair> it =pq.iterator();
                while(it.hasNext())
                {
                    Pair p = it.next();
                    if(p.index==i)
                    {
                        if(p.dist>nodeDist+graph[i])
                        {
                            it.remove();

                        }
                        else
                            found=true;
                        break;
                    }
                }
                if(!found)
                    pq.add(new Pair(graph[i]+nodeDist,i));
            }
        }
    }

    class Pair implements Comparable<Pair>
    {
        int dist;
        int index;
        Pair(int dist, int index)
        {
            this.dist=dist;
            this.index=index;
        }

        @Override
        public int compareTo(@NotNull Pair o) {
            return this.dist-o.dist;
        }
    }
}
