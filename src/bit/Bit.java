package bit;

import java.util.*;

public class Bit {
    public int singleNumber(int[] nums) {

        HashMap<Integer,Integer> dictionary = new HashMap<>();
        for(int i:nums){
            if(dictionary.containsKey(i)){
                dictionary.put(i,2);
            }
            else
                dictionary.put(i,1);
        }

        Iterator it = dictionary.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            if(dictionary.get(entry.getKey())==1)
                return (int)entry.getKey();
        }

        return -1;
    }
    //线性，不开辟额外空间找唯一的数字 XOR消除了相同的数字
    public int singleNum(int[] nums){
        for(int i=0;i<nums.length-1;i++)
            nums[i+1] ^=nums[i];
        return nums[nums.length-1];


    }




}
