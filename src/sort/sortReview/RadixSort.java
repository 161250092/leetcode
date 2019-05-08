package sort.sortReview;

public class RadixSort {

//    LSD
    public static void radixSort(int[] a){
//  初始化桶
    int[][] bucket = new int[10][a.length];
//  每个桶的深度
    int[] bucketDepth = new int[10];
//  由最大数字决定调整次数
    int adjustTimes = (getMax(a)+"").length();
//
    int bucketIndex = 0;

    while(adjustTimes>0){


        int divide = (int)Math.pow(10,bucketIndex);
        for(int i=0;i<a.length;i++){

            int position =(a[i]/divide)%10;


            bucket[position][bucketDepth[position]] = a[i];
            bucketDepth[position]  = bucketDepth[position]+1;

        }

        int index = 0;
        for(int i=0;i<bucket.length;i++){
            for(int j=0;j<bucketDepth[i];j++){
                a[index] = bucket[i][j];
                index++;
            }
        }

        bucketDepth = new int[10];

        bucketIndex++;
        adjustTimes--;
    }


    }


    public static int getMax(int[] a){
        int max =a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]>max)
                max = a[i];
        }
        return max;
    }


}
