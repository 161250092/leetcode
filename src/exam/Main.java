package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int getCount(String str,char c){
        int count = 0;
        if(str != null && str.length() > 0){
            for(int i = 0;i < str.length();i++){
                if((c>=65&&c<=90)&&c+32==str.charAt(i)){
                    count++;
                }
                else if((c>=97&&c<=122)&&c-32==str.charAt(i)){
                    count++;
                }
                else if(c == str.charAt(i)){
                    count++;
                }

            }
        }else{
            count = 0;
        }
        return count;
    }

    public static void main(String[] args) {


    }


    private int N=0;
    private int M=0;

    private ArrayList<Integer> score = new ArrayList();
    private ArrayList<String> opt = new ArrayList<>();

    public void getInformation(Scanner sc){
        N = sc.nextInt();
        M = sc.nextInt();

        sc.nextLine();
        String grades = sc.nextLine();

        String[] g =  grades.split(" ");
        for(int i=0;i<N;i++){
            score.add(Integer.parseInt(g[i]));
        }

        for(int i=0;i<M;i++){
            String operation =sc.nextLine();
            opt.add(operation);
        }

    }

    public void deal(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            getInformation(sc);
            for (int i = 0; i < M; i++) {
                String operation = opt.get(i).split(" ")[0];
                int first = Integer.parseInt(opt.get(i).split(" ")[1]);
                int second = Integer.parseInt(opt.get(i).split(" ")[2]);
                if (operation.equals("Q")) {
                    check(first, second);
                } else if (operation.equals("U")) {
                    update(first, second);
                }
            }

            score = new ArrayList<>();
            opt = new ArrayList<>();
        }

    }

    public int check(int start,int end){
        int max = 0;
        int endIndex = Math.max(start,end);
        int startIndex = Math.min(start,end);

        for(int i=startIndex-1;i<=endIndex-1;i++){
            if(max <= score.get(i))
                max = score.get(i);
        }
        System.out.println(max);
        return max;
    }

    public void update(int index,int newScore){
        score.set(index-1,newScore);
    }

    public boolean Find(int target, int [][] array) {
        int rowStart = 0;
        int rowEnd = array.length;
        int column = array[0].length-1;
        while(rowStart<=rowEnd){
            int mid =(rowStart+rowEnd)/2;

            if(mid>=array.length)
                break;

            if(array[mid][0]<=target&&array[mid][column]>=target){
                int start = 0;
                int end = array[0].length;

                while(start<=end){
                    int rowMid = (start+end)/2;
                    if(array[mid][rowMid]==target )
                        return true;
                    else if(array[mid][rowMid]>target)
                        end = rowMid-1;
                    else if(array[mid][rowMid]<target)
                        start = rowMid+1;
                }


            }

            else if(array[mid][0]>target){
                rowEnd = mid-1;
            }
            else if(array[mid][column]<target){
                rowStart = mid+1;
            }


        }

        return false;
    }

    public boolean Finds(int target, int [][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int i=rows-1,j=0;
        while(i>=0 && j<cols){
            if(array[i][j]>target)
                i--;
            else if(array[i][j]<target)
                j++;
            else
                return true;
        }
        return false;
    }

    public String replaceSpace(StringBuffer str) {
        String string = str.toString();
        return string.replaceAll(" ","%20");
    }



}
