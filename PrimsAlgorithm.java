package com.cisco.webex.signup.user.validation;

public class PrimsAlgorithm {

    public static void main(String args[])
    {

        System.out.println(new PrimsAlgorithm().primsAlgorithm(new int[][] { { 0, 2, 0, 6, 0 },
            { 2, 0, 3, 8, 5 },
            { 0, 3, 0, 0, 7 },
            { 6, 8, 0, 0, 9 },
            { 0, 5, 7, 9, 0 } }));

    }

    /*
    This implementation only find out the distance of Minimum SPanning Tree(MST)
     */
    public int primsAlgorithm(int[][]graph)
    {
        int distance=0;
        boolean[]visited=new boolean[graph.length];
        visited[0]=true;
        int count=1, vertex=0;
        int min = Integer.MAX_VALUE;
        while(count<6) {
            min = Integer.MAX_VALUE;
            System.out.println(" vertex "+vertex+" -> ");

            for (int i = 0; i < graph.length; i++) {
                if (visited[i]) {
                    for (int j = 0; j < graph[i].length; j++) {
                        if (graph[i][j] != 0 && min > graph[i][j] &&!visited[j]) {

                            min=graph[i][j];
                            vertex=j;
                        }
                    }

                }
            }
            if(min!=Integer.MAX_VALUE)
                distance+=min;
            System.out.println(" min distance "+ min+" -> ");
            count++;
            visited[vertex]=true;
        }
        return distance;
    }
}
