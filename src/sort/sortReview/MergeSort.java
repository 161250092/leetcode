package sort.sortReview;

public class MergeSort {

    public static void mergeSort(int[] a){
        int[] temp = new int[a.length];
        sort(a,0,a.length-1,temp);

    }

    public static void sort(int[] a,int left,int right,int[] temp){
        if(left<right){
            int mid = (left+right)/2;
            sort(a,left,mid,temp);
            sort(a,mid+1,right,temp);
            merge(a,left,mid,right,temp);
        }
    }

    public static void merge(int[] a,int left,int mid,int right,int[] temp){
            int i = left;// 左序列指针
            int j = mid+1;// 右序列指针
            int t = 0;// temp 指针

            while(i<=mid && j<=right){
                if(a[i]<=a[j])
                    temp[t++] = a[i++];
                else
                    temp[t++] = a[j++];
            }

            while(i<=mid)
                temp[t++] = a[i++];

            while(j<=right)
                temp[t++] = a[j++];

            t = 0;
            while(left<=right){
                a[left++] = temp[t++];
            }

    }



}
