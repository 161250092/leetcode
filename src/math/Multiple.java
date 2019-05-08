package math;

public class Multiple {


    public static void main(String[] args) {
//            System.out.println((long)65535*(long)65535);
//            System.out.println(new math.Multiple().multiply("65535","65535"));
        System.out.println(new Multiple().RectCover(50));
    }

//  AB*CD  =  AC (BC+ AD) BD,然后   从后到前满十进位
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0"))
            return "0";

        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        int[] result = new int[ch1.length+ch2.length-1];
        int[] n1 = new int[ch1.length];
        int[] n2 = new int[ch2.length];

        for(int i=0;i<ch1.length;i++)
            n1[i] = ch1[i]-'0';
        for(int i=0;i<ch2.length;i++)
            n2[i] = ch2[i]-'0';

//      index 为k 表示实际数字是result[0]*10^k,
        for(int i=0;i<ch1.length;i++){
            for(int j=0;j<ch2.length;j++){
                result[i+j] +=n1[i]*n2[j];
            }
        }
//      除了第一位外，所有其他位需要进位
        for(int i=result.length-1;i>0;i--){
            result[i-1]+=result[i]/10;
            result[i] = result[i]%10;
        }

        StringBuilder resultStr= new StringBuilder();
        for (int aResult : result) {
//            System.out.println(aResult);
            resultStr.append("").append(aResult);
        }
        return resultStr.toString();
     }



    public int RectCover(int target) {
        if(target==1)
            return 1;
        if(target==2)
            return 2;
        return RectCover(target-1)+RectCover(target-2);
    }

    public double Power(double base, int exponent) {

        return Math.pow(base,exponent);
    }
}

