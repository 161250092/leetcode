package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class SubDomain {
	 public List<String> subdomainVisits(String[] cpdomains) {
	       Map<String,Integer> map  = new HashMap<String,Integer>();
	       for(String cd:cpdomains){
	    	   int i=cd.indexOf(' ');
	    	   int n = Integer.parseInt(cd.substring(0,i));
	    	   String s = cd.substring(i+1);
	    	   for(i=0;i<s.length();i++){
	    		   if(s.charAt(i)=='.'){
	    			   String  d = s.substring(i+1);
	    			   map.put(d, map.getOrDefault(d, 0)+n);
	    		   }
	    	   }
	    	   map.put(s, map.getOrDefault(s, 0)+n);
	       }
	       List<String> res = new ArrayList<String>();
	       for(String d:map.keySet()) res.add(map.get(d)+" "+d);
	       return res;
	       
	    }
	 public int numJewelsInStones(String J, String S) {
	      Set<Character> dict = new HashSet<Character>();
	      int count  = 0;
	      for(char ch:J.toCharArray()) dict.add(ch);
	      for(char ch:S.toCharArray()) if(dict.contains(ch))  count++;
	      return count;
	      
	 }
	 
	 public String[] findWords(String[] words) {
		 List<String> res = new ArrayList<String>();
	        for(String s:words){
	            if(s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*"))
	                res.add(s);
	        }
	        String[] answer = new String[res.size()];
	        return res.toArray(answer);
		}
}
