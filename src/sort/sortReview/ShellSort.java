package sort.sortReview;

public class ShellSort {

//直接插入
    public static void insert_sort(int[] array){
         for(int i=1;i<array.length;i++){
             int temp = array[i];

             int j=0;
             for(j=i-1;j>=0&&array[j]>temp;j--)
                 array[j+1] = array[j];

             array[j+1] = temp;

         }


    }


/**shell 排序属于插入排序，算是一种改进
 * 步骤：
    从每组的第2个元素开始
    如果该元素小于有序的最大值，开始插入。
    循环条件 不越界＋小于该元素，进行唯一操作
    插入新数据
    group/2
 **/
    public static void shell_sort(int[] a){
            int group = a.length/2;

            while(group>0){
//从这一组的第二个元素开始插入
                for(int i=group;i<a.length;i++){

                    if(a[i]<a[i-group]){
                        int temp = a[i];
                        int j = i;
//循环条件:不越界＋可以后移
                        while(j>=group&&a[j-group]>temp){
                            a[j] = a[j-group];
                            j-=group;
                        }
//移动至可以插入的位置
                        a[j] = temp;
                    }
                }
//分组跨度减半
                group /=2;
            }

    }






}
