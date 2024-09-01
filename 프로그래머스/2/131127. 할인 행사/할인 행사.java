import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> hm = new HashMap<>();        
        for(int i=0; i<want.length; i++){
            hm.put(want[i], number[i]);
        }
        
        for(int i=0; i<discount.length; i++){
            HashMap<String, Integer> hm2 = new HashMap<>(hm);
            boolean flag = true;
            for(int j=i; j<i+10; j++){
                if(hm2.get(discount[j]) != null) hm2.put(discount[j], hm2.get(discount[j])-1);
                if(j == discount.length -1) break;
            }
            for(String key : hm2.keySet()){
                if(hm2.get(key) > 0) flag = false;
            }
            if(flag) answer++;
        }
        return answer;
    }
}