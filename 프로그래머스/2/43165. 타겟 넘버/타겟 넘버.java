import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = bfs(numbers, target);
        return answer;
    }
    
    public static int bfs(int[] numbers, int target){
        int cnt = 0;
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0,0});
        while(!dq.isEmpty()){
            int cur[] = dq.poll();
            if(cur[0] == numbers.length-1){
                if(cur[1] + numbers[cur[0]] == target) cnt++;
                if(cur[1] - numbers[cur[0]] == target) cnt++;
                continue;
            }
            dq.offer(new int[]{cur[0]+1, cur[1] + numbers[cur[0]]});
            dq.offer(new int[]{cur[0]+1, cur[1] - numbers[cur[0]]});
        }
        return cnt;
    } 
}