import java.util.Scanner;
import java.util.TreeSet;

public class HUAWEI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            int n = Integer.parseInt(scanner.next());
            int[] input = new int[n];
            int index = 0;
            while (n > 0) {
                input[index] = Integer.parseInt(scanner.next());
                index++;
                n--;
            }
            sort(input);
        }


//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int ans = 0, x;
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                x = sc.nextInt();
//                ans += x;
//            }
//        }
//        System.out.println(ans);
    }


    private static void sort(int[] a){
        TreeSet<Integer> set = new TreeSet<>();
        for(int i:a)
            set.add(i);
        for(int i:set)
            System.out.println(i);
    }


    public void sort(int[] array, int len) {
        // 完成这个函数


    }
}
