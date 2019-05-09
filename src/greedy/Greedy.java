package greedy;

import java.util.ArrayList;

import java.util.Arrays;


public class Greedy {
    public static void main(String[] args) {
        int[] g= {1,2,3,4};
        int[] s = {1,1,1};
        new Greedy().findContentChildren(g,s);
    }

    public int findContentChildren(int[] g, int[] s) {
        ArrayList<Integer> children = new ArrayList<>();
        for(int i:g)
            children.add(i);
        ArrayList<Integer> cookies  = new ArrayList<>();
        for(int i:s)
            cookies.add(i);

        int contentNum = 0;
        while(children.size()>0&&cookies.size()>0){
            int minContent = findMinContentChild(children);
            int minCookiesSatisfied = findMinCookiesSizeSatisfied(cookies,minContent);

            if(minCookiesSatisfied==-1)
                break;
            contentNum++;
        }

        return contentNum;

    }
    //找到满意度最小
    private int findMinContentChild(ArrayList<Integer> children){

        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i=0;i<children.size();i++){
           // System.out.println(children.get(i));
            if(children.get(i)<min) {
                min = children.get(i);
                index = i;
            }
        }
        children.remove(index);
        return min;
    }
    //找到超过满意度的最小值
    private int findMinCookiesSizeSatisfied(ArrayList<Integer> cookies,int content){
        int cookiesSize = Integer.MAX_VALUE;
        int index = -1;
        for(int i=0;i<cookies.size();i++){
            if(cookies.get(i)>=content && cookies.get(i)<cookiesSize){
                cookiesSize = cookies.get(i);
                index = i;
            }
        }
        if(index==-1)
            return -1;

        cookies.remove(index);
        return cookiesSize;
    }
}
