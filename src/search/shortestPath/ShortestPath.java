package search.shortestPath;

import java.util.HashMap;
import java.util.Map;

public class ShortestPath {


    public static void main(String[] args) {
        int bigNum = 10000;
        int[][] graph = {{0,12,bigNum,bigNum,bigNum,16,14},
                {12,0,10,bigNum,bigNum,7,bigNum},
                {bigNum,10,0,3,5,6,bigNum},
                {bigNum,bigNum,3,0,4,bigNum,bigNum},
                {bigNum,bigNum,bigNum,4,0,2,8},
                {16,7,6,bigNum,2,0,9},
                {14,bigNum,bigNum,bigNum,8,9,0}
        };
        new ShortestPath().dijkstra(graph);
    }
//更新 S,U
    public void update(int[][] graph,Map<Integer,Integer> s,Map<Integer,Integer> u){
            for(int sPeak:s.keySet()){
                for(int uPeak:u.keySet()){
                    if((graph[sPeak][uPeak]+s.get(sPeak))<u.get(uPeak))
                        u.put(uPeak,graph[sPeak][uPeak]+s.get(sPeak));
                }
            }
    }

/**狄杰斯特拉求最短路径

**/
    public int[]  dijkstra(int[][] graph){
        Map<Integer,Integer> s = new HashMap<Integer,Integer>();//solved
        Map<Integer,Integer> u = new HashMap<Integer,Integer>();//not solved

//      选取起点,加入S
        s.put(0,0);
//      将起点和各点加入U
        for(int i=1;i<graph[0].length;i++){
                u.put(i,graph[0][i]);

        }

        for(int i=1;i<graph.length;i++){
            int minPathPeak =-1;
            int minPath = Integer.MAX_VALUE;
            for(int peak:u.keySet()){
                if(u.get(peak)<minPath){
                    minPathPeak = peak;
                    minPath = u.get(peak);
                }
            }
            s.put(minPathPeak,u.get(minPathPeak));
            u.remove(minPathPeak);

            update(graph,s,u);
        }


        System.out.println(s.toString());
        System.out.println(u.toString());

        return null;
    }

}
