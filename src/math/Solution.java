package math;

public class Solution {

    public static void main(String[] args) {
            int[] array = {0,2,1,5,4,3};
//        int[] array ={2,0,3,5,4,1};
            new Solution().sort(array,array.length);
            for(int i:array)
                System.out.print(i);

    }
    /**
     * 交换数组里n和0的位置
     *
     * @param array
     *            数组
     * @param len
     *            数组长度
     * @param n
     *            和0交换的数
     */
    // 不要修改以下函数内容


    public void swapWithZero(int[] array, int len, int n) {

//        System.out.println(n);
        int zeroIndex  = 0;
        for(int i = 0;i<len;i++) {
            if(array[i]==0)
            zeroIndex = i;
        }

        for(int i=0;i<len;i++){
            if(array[i] == n){
                array[i] = 0;
                array[zeroIndex] = n;
                break;
            }

        }

    }
    // 不要修改以上函数内容


    /**
     * 通过调用swapWithZero方法来排
     *
     * @param array
     *            存储有[0,n)的数组
     * @param len
     *            数组长度
     */
    public void sort(int[] array, int len) {
        // 完成这个函数
        if(len == 0||len==1) return;

        int n0 = array[0];
        this.swapWithZero(array,len,n0);

        for(int i=1;i<len-1;i++){
            for(int j=1;j<len;j++){
                if(array[j]==i){
                    this.swapWithZero(array,len,i);
                    break;
                }
            }
            this.swapWithZero(array,len,array[i]);
            this.swapWithZero(array,len,i);
        }
    }
}