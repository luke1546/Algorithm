import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Boolean> hm = new HashMap<>();
        Arrays.sort(phone_book, (o1, o2) -> o1.length() - o2.length());
        for(String phone : phone_book){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<phone.length(); i++){
                sb.append(phone.charAt(i));
                if(hm.get(sb.toString()) != null) answer = false;
            }
            hm.put(sb.toString(), true);
        }
        
        return answer;
    }
}