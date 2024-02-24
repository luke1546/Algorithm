import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            sb.append("#");
            sb.append(s.charAt(i));
        }
        s = sb.append("#").toString();
        // s = sb.toString();
        for(int i=0; i<s.length(); i++){
            int cnt = 1;
            int l = 0;
            while(i-cnt >= 0 && i+cnt < s.length() && s.charAt(i-cnt) == s.charAt(i+cnt)){
                l++;
                cnt++;
            }
            answer=Math.max(answer,l);
        }
        return answer;
    }
}