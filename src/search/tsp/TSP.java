package search.tsp;

import java.util.ArrayList;
import java.util.Scanner;

public class TSP {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        double[][] distances = new double[0][];
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(0,0));
        while(in.hasNext()) {
            int n = in.nextInt();
//          n+1个点
            distances = new double[n+1][n+1];
            for(int i=0;i<n;i++){
                int x = in.nextInt();
                int y = in.nextInt();
                points.add(new Point(x,y));
            }

            ArrayList<Integer>  list = new ArrayList<>();
            int[] left =new int[n];
            for(int i=1;i<=n;i++)
                left[i-1] = i;

            TSP s = new TSP();
            ArrayList<Integer> initList = new ArrayList<>();
            initList.add(0);
            ArrayList<ArrayList<Integer>> allPermutations = new ArrayList<>();
            s.permutation(initList,left,allPermutations);


            Point.computeDistance(points,distances);

            double minDistance = Integer.MAX_VALUE;
            int pathIndex = -1;
            for(int i=0;i<allPermutations.size();i++){
                double distanceSum = 0;
                for(int j=0;j<allPermutations.get(i).size()-1;j++){
                    ArrayList<Integer> curPaths = allPermutations.get(i);
                    distanceSum +=distances[curPaths.get(j)][curPaths.get(j+1)];
                }
                System.out.println("此次路径长度:"+distanceSum);

                if(distanceSum<minDistance) {
                    minDistance = distanceSum;
                    pathIndex = i;
                }


            }

            System.out.println("最短路径: "+minDistance);
            System.out.println("pathIndex: "+pathIndex);

        }

    }
 public void permutation(ArrayList<Integer> list,int[] left,ArrayList<ArrayList<Integer>> allPermutations){
        if(left.length==1){
            list.add(left[0]);
            list.add(0);
            allPermutations.add(list);
            return;
        }

        for(int i=0;i<left.length;i++){
            ArrayList<Integer> newList = new ArrayList<>();
            newList.addAll(list);
            newList.add(left[i]);

            int[] newLeft = new int[left.length-1];
            int index = 0;
            for(int j=0;j<left.length;j++){
                if(j!=i) {
                    newLeft[index] = left[j];
                    index++;
                }
            }
            permutation(newList,newLeft,allPermutations);
        }
    }



}
