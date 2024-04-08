import java.util.regex.*;
import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        Pattern p = Pattern.compile("([0-9]+)([SDT])([*#]?)");
        Matcher m = p.matcher(dartResult);
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        while(m.find()){
            int score = Integer.parseInt(m.group(1));
            if(m.group(2).equals("D")) score*=score;
            if(m.group(2).equals("T")) score*=score*score;
            if(m.group(3).equals("#")) score*=-1;
            if(m.group(3).equals("*")){
                if(!dq.isEmpty())   dq.push(dq.pop()*2);
                score*=2;
            }
            dq.push(score);
        }
        while(!dq.isEmpty()) answer+=dq.pop();
        return answer;
    }
}