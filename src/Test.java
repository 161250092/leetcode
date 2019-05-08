import java.util.*;

public class Test {

    /**
     * 多行数据
     * 出错记录:次数
     * 合并相同文件名
     * 排序
     */

    ArrayList<String> list = new ArrayList<>();

    public void getInformation(){
        Scanner sc = new Scanner(System.in);
        String location = sc.nextLine();
        list.add(location);
//        System.out.println(list.toString());
    }
    public void record(ArrayList<String> list){
//               getInformation();
                TreeMap<String, Integer> record = new TreeMap<>();
                for (String location : list) {
                    String loc = dealString(location);
                    if (!record.containsKey(loc))
                        record.put(loc, 1);
                    else {
                        int oldValue = record.get(loc);
                        record.replace(loc, oldValue + 1);
                    }
                }
//                System.out.println(record);
                sort(record);
                list = new ArrayList<>();

    }

    public String dealString(String fullName){
//        System.out.println("deal: "+fullName );
        String[] names = fullName.split("\\\\");
        return names[names.length-1];
    }

    public String getValidName(String name){

        String[] strings = name.split("\\.");

        if(strings[0].length()>16)
            strings[0] = strings[0].substring(strings[0].length()-16,strings[0].length());

        return strings[0]+"."+strings[1];
    }

    public void sort(TreeMap<String,Integer> record){

        ArrayList<String> strings = new ArrayList<>();
        Set<String> keySet = record.keySet();
        Iterator<String> it = keySet.iterator();
        while(it.hasNext()){
            String key = it.next();
            int value = record.get(key);
//            System.out.println(key);
            key = getValidName(key);
            strings.add(key+" "+value);
        }
        if(strings.size()<=8) {
            for (int i = strings.size() - 1; i >= 0; i--) {
                System.out.println(strings.get(i));
            }
        }
        else {
            for (int i = strings.size() - 1; i >= strings.size() - 9; i--) {
                System.out.println(strings.get(i));
            }
        }

    }

    public int GetUglyNumber_Solution(int index) {
        if(index<7) return index;
        int[] res = new int[index];
        res[0] = 1;
        int t2 =0,t3=0,t5=0;
        for(int i=1;i<index;i++){
            res[i] = Math.min(res[t2]*2,Math.min(res[t3]*3,res[t5]*5));
            if(res[i] == res[t2]*2) t2++;
            if(res[i]==res[t3]*3) t3++;
            if(res[i]==res[t5]*5) t5++;
        }
        return res[index-1];

    }



    private static int[] nums = new int[256];
    static int length = 0;


    static {
        for(int i=0;i<50;i++){
            nums[i] = 1;
        }
    }

    public void Insert(Integer num) {
        if(length==0) {
            nums[length] = num;
            length++;
            return;
        }

        if(length==1){
            if(nums[0]>num){
                nums[1] = nums[0];
                nums[0] = num;
                length++;
                return;
            }
            else{
                nums[1] = num;
                length++;
                return;
            }
        }


        //insert among
        int insertIndex = -1;
        for(int i=0;i<length-1;i++){
            if(nums[i]>num){
                insertIndex =0;
                break;
            }
            if(nums[i]<num&&num<nums[i+1]) {
                insertIndex = i + 1;
                break;
            }
        }
        //insert in the end
        if(insertIndex==-1){
            nums[length] = num;
            length++;
            return;
        }

        //move
        for(int i=length;i>insertIndex;i--){
            nums[i] = nums[i-1];
        }

        nums[insertIndex] = num;
        length++;


    }

    public Double GetMedian() {

        if(length%2==0) {
            double res = ((double)nums[length/2]+(double)nums[length/2-1])/2;
            return res;
        }
        else{
            return (double)(nums[length/2]);
        }
    }




    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {

        if(rows==1&&cols==1&&matrix[0]==str[0]&&str.length==1)
            return true;
        char[][] mat = new char[rows][cols];
        char[][] visited = new char[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){

                mat[i][j] = matrix[i*cols+j];
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }

      //  boolean res = false;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j]==str[0]){
                    char[][] v = cloneV(visited);
                    v[i][j] = 1;
                    if(bfs(str,1,i,j,mat,v))
                        return true;
                }
            }
        }
        return false;

    }


    public boolean bfs(char[] str,int strIndex,int x,int y,char[][] mat,char[][] visited){
 //           System.out.println("x< "+mat[0].length+"  y< "+mat.length);
            System.out.println("x: "+x+"---"+"y: "+y);

            if(strIndex==str.length-1){
                if(x-1>=0&&str[strIndex]==mat[x-1][y]&&visited[x-1][y]==0)
                    return true;
                if(x+1<mat.length&&str[strIndex]==mat[x+1][y]&&visited[x+1][y]==0)
                    return  true;
                if(y-1>=0&&str[strIndex]==mat[x][y-1]&&visited[x][y-1]==0)
                    return true;
                if(y+1<mat[0].length&&str[strIndex]==mat[x][y+1]&&visited[x][y+1]==0)
                    return true;

                return false;
            }

            boolean up = false;
            boolean down = false;
            boolean left = false;
            boolean right = false;

            if(x-1>=0&&str[strIndex]==mat[x-1][y]&&visited[x-1][y]==0) {
                char[][] v = cloneV(visited);
                v[x-1][y] = 1;
                left = bfs(str, strIndex + 1, x - 1, y, mat, v);
            }

            if(x+1<mat.length&&str[strIndex]==mat[x+1][y]&&visited[x+1][y]==0) {
                char[][] v = cloneV(visited);
                v[x+1][y] = 1;
                right = bfs(str, strIndex + 1, x+1, y, mat, v);
            }

            if(y-1>=0&&str[strIndex]==mat[x][y-1]&&visited[x][y-1]==0){
                char[][] v = cloneV(visited);
                v[x][y-1] = 1;
                up = bfs(str,strIndex+1,x,y-1,mat,v);
            }

            if(y+1<mat[0].length&&str[strIndex]==mat[x][y+1]&&visited[x][y+1]==0){
                char[][] v= cloneV(visited);
                v[x][y+1] = 1;
                down = bfs(str,strIndex+1,x,y+1,mat,v);
            }

            return up||down||left||right;

    }

//深拷贝
    public char[][] cloneV(char[][] visited){
        char[][] v = new char[visited.length][visited[0].length];
        for(int i=0;i<visited.length;i++){
            for(int j=0;j<visited[0].length;j++){
                v[i][j] = visited[i][j];
            }
        }
        return v;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            int index = findNumIndex(nums2,nums1[i]);

            int greaterIndex = -1;

            for(int j=index+1;j<nums2.length;j++){
                if(nums2[j]>nums1[i]) {
                    greaterIndex = j;
                    break;
                }
            }
            if(greaterIndex!=-1){
                res[i] = nums2[greaterIndex];
            }
            else
                res[i] = -1;

        }
        return res;
    }


    private  int findNumIndex(int[] num,int target){
        for(int i=0;i<num.length;i++)
            if(num[i]==target)
                return i;
        return -1;
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i] = findNextGreateElements(nums,i);
        }
        return res;
    }

    private int findNextGreateElements(int[] nums,int numIndex){
        for(int i=numIndex+1;i<nums.length;i++){
            if(nums[i]>nums[numIndex])
                return nums[i];
        }
        for(int i=0;i<numIndex;i++){
            if(nums[i]>nums[numIndex])
                return nums[i];
        }
        return -1;
    }

}

