package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] numss){
		HashSet<List<Integer>> ret = new HashSet<List<Integer>>();
		Arrays.sort(numss);
		int i=0,last = numss.length-1;
		while(i<last-2){
			int a = numss[i],j = i+1, k = j+1, l = last;
			while(  k < last){
			 int b = numss[j],c = numss[k],d= numss[l],sum = a+b+c+d;
			 if(sum == 0)
				 ret.add(Arrays.asList(a,b,c,d));
			 	
			 if(sum >= 0){
				 while(numss[l] == d && l>k ){
					 l--;
				 }
			 }
				 
			 if( sum <=0 ){
				 while(numss[k] == c && k<l){
					 k++;
				 }
				 
			 }
			 
			 
			}
			
		}
		
		return new ArrayList(ret);
	}	
	public List<List<Integer>> fourSum1(int[] numss,int target){
		HashSet<List<Integer>> ret = new HashSet<List<Integer>>();
		Arrays.sort(numss);
		for(int i=0;i<numss.length-2;i++){
			for(int j= i+2;j<numss.length;j++){
				int start = i;
				int end = j;
				for(int k = start+1;k<end -1;k++){
					for(int l = k+1;l<end;l++){
					if(numss[start]+numss[end]+numss[k]+numss[l] == target)
						ret.add(Arrays.asList(numss[start],numss[k],numss[l],numss[end]));
					}					
				}
			}
		}
		return new ArrayList(ret);
	}
	
	 public List<List<Integer>> fourSum(int[] nums, int target) {
		    ArrayList<List<Integer>> ans = new ArrayList<>();
		    if(nums.length<4)return ans;
		    Arrays.sort(nums);
		    for(int i=0; i<nums.length-3; i++){
		        if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target)break; //first candidate too large, search finished
		        if(nums[i]+nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3]<target)continue; //first candidate too small
		        if(i>0&&nums[i]==nums[i-1])continue; //prevents duplicate result in ans list
		        for(int j=i+1; j<nums.length-2; j++){
		            if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target)break; //second candidate too large
		            if(nums[i]+nums[j]+nums[nums.length-1]+nums[nums.length-2]<target)continue; //second candidate too small
		            if(j>i+1&&nums[j]==nums[j-1])continue; //prevents duplicate results in ans list
		            int low=j+1, high=nums.length-1;
		            while(low<high){
		                int sum=nums[i]+nums[j]+nums[low]+nums[high];
		                if(sum==target){
		                    ans.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
		                    while(low<high&&nums[low]==nums[low+1])low++; //skipping over duplicate on low
		                    while(low<high&&nums[high]==nums[high-1])high--; //skipping over duplicate on high
		                    low++; 
		                    high--;
		                }
		                //move window
		                else if(sum<target)low++; 
		                else high--;
		            }
		        }
		    }
		    return ans;
		}
	
}
