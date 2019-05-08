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

    public boolean match(char[] str, char[] pattern)
    {
        return match(str,0,pattern,0);
    }


    public boolean match(char[] str,int strIndex,char[] pattern,int patternIndex){

//       两边同时匹配结束
        if(strIndex == str.length&&patternIndex == pattern.length) return true;
//        字符串有剩余但是正则表达式已经匹配结束
        if(strIndex<str.length&&patternIndex>=pattern.length) return false;
//        字符串结束但是正则表达式未结束
        if(strIndex==str.length&&patternIndex<pattern.length) {
            while(patternIndex<pattern.length){
                if(pattern[patternIndex]!='*'&&(patternIndex+1>=pattern.length||pattern[patternIndex+1]!='*'))
                    return false;
                patternIndex++;
            }
            return true;
        }
//System.out.println(str[strIndex]+"  "+pattern[patternIndex]);
//      字符串和正则表达式都未结束

//        两者相同  or pattern[index] =='.'
        if(patternIndex==pattern.length-1) {
            if (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')
                return match(str, strIndex + 1, pattern, patternIndex + 1);

            else return false;
        }

        if(pattern[patternIndex+1]!='*')
            if(str[strIndex]==pattern[patternIndex]||pattern[patternIndex]=='.')
                return match(str,strIndex+1,pattern,patternIndex+1);

        if(pattern[patternIndex+1]=='*'){
            if(pattern[patternIndex]==str[strIndex]||pattern[patternIndex]=='.')
//1  或多  ,0,
                return match(str,strIndex+1,pattern,patternIndex)||match(str,strIndex,pattern,patternIndex+2);
//          ||match(str,strIndex+1,pattern,patternIndex+2)
            if(pattern[patternIndex]!=str[strIndex])
                return match(str,strIndex,pattern,patternIndex+2);

        }

        if(pattern[patternIndex]!=str[strIndex])
            return false;

        return false;

    }

//    + - . e  0-10


//  e 后只可以是整数
    public boolean isNumeric(char[] str) {
        if(str==null||str.length==0) return false;
        if(str[0]=='+'||str[0]=='-'&&str.length>=2)
            return state1(str,1);

        if(Character.isDigit(str[0]))
            return state1(str,0);

        return false;

    }

    public boolean state1(char[] str,int index){
        if(index==str.length)
            return true;

//        如果是整数继续状态1的循环
        if(Character.isDigit(str[index]))
            return state1(str,index+1);
//   index<str.length-1  使得 . E e 后面必定有  char
        if(str[index]=='.'&&index<str.length-1)
            return state2(str,index+1);

        if((str[index]=='e'||str[index]=='E')&&index<str.length-1)
            return state3(str,index+1,true);

        return false;
    }


    public boolean state2(char[] str,int index){
        if(index==str.length)
            return true;
        if(Character.isDigit(str[index]))
            return state2(str,index+1);

        if((str[index]=='e'||str[index]=='E')&&index<str.length-1)
            return state3(str,index+1,true);


        return false;
    }


    public  boolean state3(char[] str,int index,boolean startFlg){
        if(index==str.length)
            return true;

        if(startFlg){
            if((str[index]=='+'||str[index]=='-')&&index<str.length-1)
                return state3(str,index+1,false);
            if(Character.isDigit(str[index]))
                return state3(str,index+1,false);
            return  false;
        }

        if(Character.isDigit(str[index]))
            return state3(str,index+1,false);

        return false;

    }


    List<Character> charList = new ArrayList<>();
    List<Character> removeList = new ArrayList<>();
    public void Insert(char ch)
    {
        if(!charList.contains(ch))
            charList.add(ch);
        else {
            removeList.add(ch);
        }

    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {

        for(char ch:removeList){
            Character c = ch;
            charList.remove(c);
        }

        if(charList.isEmpty()) {
            return '#';
        }
        else {
            return charList.get(0);
        }
    }



}

