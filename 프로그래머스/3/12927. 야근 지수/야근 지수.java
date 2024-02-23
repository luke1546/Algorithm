import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2-o1);
        for(int i=0; i<works.length; i++)   pq.offer(works[i]);
        while(n-->0)    pq.offer(pq.poll()-1);
        if(pq.peek() <= 0)  return 0;
        while(!pq.isEmpty())    answer+=Math.pow(pq.poll(),2);
        return answer;
    }
}