package math;

import java.util.ArrayList;
import java.util.Comparator;

public class Back {


    public int movingCount(int threshold, int rows, int cols)
    {

        if(threshold==0) return 1;

        int[][] map = new int[rows][cols];

        backtracking(map,0,0,threshold);

        return countVisited(map);
    }

    public void backtracking(int[][] map,int x,int y,int threshold){

        if(x>=map.length||x<0)
            return;
        if(y>=map[0].length||y<0)
            return;
        if(map[x][y] == 1)
            return;

        if(getLocationSum(x,y)<=threshold){
            map[x][y] = 1;

            backtracking(map,x+1,y,threshold);

            backtracking(map,x-1,y,threshold);

            backtracking(map,x,y+1,threshold);

            backtracking(map,x,y-1,threshold);

        }

    }


    public int getLocationSum(int x,int y){

        String[] xs = (x+"").split("");
        String[] ys = (y+"").split("");
        int sum = 0;
        for(String a:xs){
            sum +=Integer.parseInt(a);
        }
        for(String b:ys){
            sum +=Integer.parseInt(b);

        }
        return sum;
    }

    public int countVisited(int[][] map){
        int count = 0;
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(map[i][j]!=0)
                    count++;
            }
        }
        return count;
    }

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();

        for(int i=0;i<=num.length-size;i++){
            int index = i;
            int[] array = new int[size];
            for(int j=0;j<size;j++) {
                array[j] = num[index++];
               // index++;
            }
           res.add(findMax(array));
        }
        return res;
    }

    public int findMax(int[] num){
        int max = Integer.MIN_VALUE;
        for(int i:num){
            if(i>max)
                max = i;
        }
        return max;
    }


    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length==1) return array[0];

        int res = array[0];
        int curMax = array[0];
        for(int i=1;i<array.length;i++){
            curMax = Math.max(curMax+array[i],array[i]);
            res = Math.max(res,curMax);
        }
        return res;
    }

    public String PrintMinNumber(int [] numbers) {
        int n;
        ArrayList<Integer> list= new ArrayList<Integer>();
        n=numbers.length;
        for(int i=0;i<n;i++){
            list.add(numbers[i]);
        }
        list.sort(new Comparator<Integer>() {

            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });


        StringBuilder s= new StringBuilder();
        for(int j:list){
            s.append(j);
        }
        return s.toString();

    }

    public int GetUglyNumber_Solution(int index) {
        return 0;
    }

    public int FirstNotRepeatingChar(String str) {
        char[] chars = str.toCharArray();
        for(int i=0;i<chars.length;i++){
            int count = 0;
            int target = chars[i];
            for(int j=0;j<chars.length;j++){
                if(chars[j]==target)
                    count++;
            }
            if(count == 1)
                return i;
        }
        return -1;
    }

    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        for(int i=0;i<array.length;i++) {
            if (array[i] == k)
                count++;

        }
        return count;
    }


}
