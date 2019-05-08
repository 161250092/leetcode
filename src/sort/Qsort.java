package sort;

import java.util.*;

public class Qsort {


    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
            if(k>input.length)
                return res;


        if(input.length==1) {
            for(int i=0;i<k;i++)
                res.add(input[i]);
            return  res;
        }
        QuickSort(input,0,input.length-1);
        for(int i=0;i<k;i++)
            res.add(input[i]);

        return res;
    }

    private static void QuickSort(int[] num, int left, int right) {
        //如果left等于right，即数组只有一个元素，直接返回
        if (left >= right) {
            return;
        }
        //设置最左边的元素为基准值
        int key = num[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i = left;
        int j = right;
        while (i < j) {
            //j向左移，直到遇到比key小的值
            while (num[j] >= key && i < j) {
                j--;
            }
            //i向右移，直到遇到比key大的值
            while (num[i] <= key && i < j) {
                i++;
            }
            //i和j指向的元素交换
            if (i < j) {
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }
        }
        num[left] = num[i];
        num[i] = key;

        QuickSort(num, left, i - 1);
        QuickSort(num, i + 1, right);

    }

    public void quickSort(int[] L) {
        Qsort(L,0,L.length-1);
    }

    public void Qsort(int[] L,int low,int high) {
        int pivot;
        if(low<high) {
            //将L[low,high]一分为二,算出枢轴值pivot,该值得位置固定,不用再变化
            pivot=partition0(L,low,high);

            //对两边的数组分别排序
            Qsort(L,low,pivot-1);
            Qsort(L,pivot+1,high);
        }
    }

    //  选择一个枢轴值(关键字) 把它放到某个位置 使其左边的值都比它小 右边的值都比它大
    public int partition0(int[] L,int low,int high) {
        int pivotkey;
        pivotkey=L[low];
        //顺序很重要，要先从右边找
        while(low<high) {
            while(low<high && L[high]>=pivotkey) {  //从后往前找到比key小的放到前面去
                high--;
            }
            swap(L,low,high);
            while(low<high && L[low]<=pivotkey) {  //从前往后找到比key大的 放到后面去
                low++;
            }
            swap(L,low,high);
        } //遍历所有记录  low的位置即为 key所在位置, 且固定,不用再改变
        return low;
    }
    //交换数组的两个位置
    public void swap(int[] L,int i,int j) {
        int temp=L[i];
        L[i]=L[j];
        L[j]=temp;

    }


    int cnt = 0;
    public int InversePairs(int [] array) {
        if(array!=null)
            mergeSort(array,0,array.length-1);
        return cnt;
    }

    public void mergeSort(int[] a,int start,int end){
        if(start >= end)
            return;
        int mid = (start+end)/2;
        mergeSort(a,start,mid);
        mergeSort(a,mid+1,end);

        merge(a,start,mid,end);
//
//        for(int i:a){
//            System.out.print(i+" ");
//        }
//        System.out.println();
    }


    public void merge(int[] a,int start,int mid,int end){
        int[] tmp = new int[end - start + 1];
        int i = start,j = mid+1,k = 0;
        while(i<=mid && j<=end){
            if(a[i] <= a[j])
                tmp[k++] = a[i++];
            else{
                tmp[k++] = a[j++];
                cnt +=mid - i + 1;
            }
        }

        while(i<=mid)
            tmp[k++] = a[i++];
        while(j<=end)
            tmp[k++] = a[j++];
        for(k=0;k<tmp.length;k++)
            a[start+k] = tmp[k];

    }


    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int i =0;
        int j =array.length-1;
        ArrayList<Integer> res  = new ArrayList<Integer>();
        while(i<j){
            if(array[i]+array[j]==sum){
                res.add(array[i]);
                res.add(array[j]);
                break;
            }

            if(array[i]+array[j]>sum){
                j--;
            }

            if(array[i]+array[j]<sum){
                i++;
            }
        }

        return res;
    }

    public String LeftRotateString(String str,int n) {
        if(str.length()<=0) return "";
            int strLen = str.length();
            n = n%strLen;
            String first = str.substring(n,str.length());
            String second = str.substring(0,n);

            return first+second;
    }

    public String ReverseSentence(String str) {

        if(str.equals("")) return "";
        if(str.equals(" ")) return " ";


        String[] strings = str.split(" ");



        StringBuilder res  = new StringBuilder();
        for(int i=strings.length-1;i>=1;i--)
            res.append(strings[i]).append(" ");
        if(strings.length>0)
        res.append(strings[0]);
        return res.toString();

    }

    public void  reverse(String[] strings){
        for(int i=0;i<strings.length;i++) {
            StringBuilder stringBuilder = new StringBuilder();
            char[] chars = strings[i].toCharArray();
            for (int j = chars.length - 1; j >= 0; j--) {
                stringBuilder.append(chars[j]);
            }
            strings[i] = stringBuilder.toString();
        }


    }


    public boolean isContinuous(int [] numbers) {
        if(numbers==null||numbers.length==0)return false;
        Arrays.sort(numbers);
        int positiveNumIndex = 0;
        for(int i=0;i<numbers.length;i++)
            if(numbers[i]!=0){
            positiveNumIndex = i;
            break;
            }

         int interval = 0;
        for(int i = positiveNumIndex;i<numbers.length-1;i++){
            int intervalBetweenBorders = numbers[i+1]-numbers[i];
            if(intervalBetweenBorders==0) return false;

            interval += intervalBetweenBorders-1;
        }

        return interval <= positiveNumIndex;

    }





}

