import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        int limit = queue1.length*5;
        Deque<Integer> dq1 = new ArrayDeque<>();
        Deque<Integer> dq2 = new ArrayDeque<>();
        for(int i : queue1) {
            sum1+=i;
            dq1.offer(i);
        }
        for(int i : queue2) {
            sum2+=i;
            dq2.offer(i);
        }
        if((sum1+sum2)%2 != 0) return -1;
        while(true){
            if(sum1 > sum2){
                int x = dq1.poll();
                sum2+=x;
                sum1-=x;
                dq2.offer(x);
            }else if(sum1 < sum2){
                int x = dq2.poll();
                sum1+=x;
                sum2-=x;
                dq1.offer(x);
            }else{
                break;
            }
            answer++;
            if(answer > limit){
                return -1;
            }
        }
        return answer;
    }
}