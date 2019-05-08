package sort.sortReview;

public class SelectSort {

    public static void select_sort(int[] a){
        for(int i=0;i<a.length-1;i++){
            int selectIndex = maxItemIndex(a,i+1);
            int temp = a[selectIndex];
            a[selectIndex] = a[i];
            a[i]  = temp;
        }
    }

    public static int maxItemIndex(int[] a,int start){
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i=start;i<a.length;i++){
            if(a[i]<min){
                index = i;
                min = a[i];
            }
        }
        return index;
    }


    /**
     * 堆排序
     * a[i]>=a[2*i+1] && a[i]>=a[2*i+2]
     * 例子：生序
     * 步骤 构造最大堆 O(n)
     * 重建堆 O(nlogn)
     *
     */


    public static void heap_sort(int[] a){
        for(int i= a.length/2-1;i>=0;i--){
//          从第一个非叶节点从下至上，从右到左调整结构
            adjustHeap(a,i,a.length);
        }

        for(int j=a.length-1;j>0;j--){
            swap(a,0,j);
            adjustHeap(a,0,j);
        }

    }


// 调整大顶堆
    public static void adjustHeap(int[] a,int i,int length){
        int temp = a[i];
        for(int k=i*2+1;k<length;k=k*2+1){
            if(k+1<length&&a[k]<a[k+1])
                k++;
            if(a[k]>temp){
                a[i] = a[k];
                i = k;
            }
            else
                break;
        }
        a[i] = temp;
    }


    public static void swap(int[] arr ,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b]  = temp;
    }

}
