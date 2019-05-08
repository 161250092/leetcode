package sort.sortReview;

public class Runner {
    public static void main(String[] args) {
        int[] array={70,61,52,43,34,25,6,127,58,49};

//        ShellSort.shell_sort(array);
//        SelectSort.heap_sort(array);
//        SwapSort.QuickSort(array,0,array.length-1);
//        MergeSort.mergeSort(array);
        RadixSort.radixSort(array);
        showString(array);

    }


    public static void showString(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }

        System.out.println();
    }


}
