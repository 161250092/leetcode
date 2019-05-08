package search.tsp;

import java.util.ArrayList;

public class Point {
    int x;
    int y;
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }


    public static void computeDistance(ArrayList<Point> points,double[][] distances){
        for(int i=0;i<points.size();i++){
            for(int j=0;j<points.size();j++){
                distances[i][j] = getDistance(points.get(i),points.get(j));
                System.out.print(distances[i][j]+"   ");
            }
            System.out.println();
        }
    }

    private static double getDistance(Point p1,Point p2){
        double process = Math.pow(p1.x-p2.x,2)+Math.pow(p1.y-p2.y,2);
        return Math.sqrt(process);

    }

}
