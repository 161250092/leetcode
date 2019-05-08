package divideAndConquer;

public class DivideAndConquer {

    //摩尔投票法 求出现次数大于一半的元素
    public int majorityElement(int[] nums) {
        if(nums.length==0) return -1;
        int major = nums[0];
        int count = 1;

        for(int i=1;i<nums.length;i++){
            if(count==0){
                major = nums[i];
                count=1;
                continue;
            }
            if(nums[i]==major){
                count++;
                continue;
            }
            if(nums[i]!=major)
                count--;
        }

        return major;

    }

}
