package 刷题;

import java.util.HashMap;
import java.util.Map;

public class E {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0||s==null){
            return 0;
        }
        Map<Character,Integer> map=new HashMap<>();
        int n=s.length();
        int maxLen=0;
        int left=0;
        for (int i = 0; i < n; i++) {
            if(map.containsKey(s.charAt(i))){
                left=Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            maxLen=Math.max(maxLen,i-left+1);
        }
        return maxLen;
    }

}
