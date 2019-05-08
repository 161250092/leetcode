package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
	
	
	public List<List<Integer>> threeSum(int[] nums){
		HashSet<List<Integer>> ret = new HashSet<List<Integer>>();
		Arrays.sort(nums);
		int i=0,last = nums.length-1;
		while(i<last){
			int a = nums[i],j = i+1,k = last;
			while(j<k){
				int b = nums[j],c=nums[k],sum = a+b+c;
				if(sum == 0) {					
					ret.add(Arrays.asList(a,b,c));
				}
					
				if(sum <=0){	
					while(nums[j] == b && j<k)
						j++;
				}
				
				if(sum >=0){
					while(nums[k] == c && j<k) 
						k--;
				}
					
			}
			while(nums[i] == a && i<last) i++;
		}
			return new ArrayList(ret);
	
	}
	
}
