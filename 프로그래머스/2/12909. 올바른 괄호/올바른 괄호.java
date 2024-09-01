import java.util.*;

class Solution {
    boolean solution(String s) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') dq.push(1);
            else if(!dq.isEmpty()) dq.pop();
            else return false;
        }
        if(dq.isEmpty()) return true;
        return false;
    }
}