import java.util.*;

class Solution {
    static ArrayList<ArrayList<int[]>> 그래프 = new ArrayList<>();
    static PriorityQueue<int[]> pq;
    static int[] distance2;
    static int N;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        N = n;
        int answer = Integer.MAX_VALUE;
        for(int i=0; i<n; i++)  그래프.add(new ArrayList<>());
        for(int i=0; i<fares.length; i++){
            그래프.get(fares[i][0]-1).add(new int[]{fares[i][1]-1, fares[i][2]});
            그래프.get(fares[i][1]-1).add(new int[]{fares[i][0]-1, fares[i][2]});
        }
        
        int[] together = dijkstra(s);
        for(int i=0; i<n; i++){
            int[] alone =dijkstra(i+1);
            int cost = together[i] + alone[a-1] + alone[b-1];
            answer = Math.min(cost, answer);
        }
        return answer;
    }
    public static int[] dijkstra(int start){
        boolean[] visit = new boolean[N];
        start--;
        pq = new PriorityQueue<>((o1,o2) -> o1[1]-o2[1]);
        int[] distance = new int[N];
        Arrays.fill(distance,Integer.MAX_VALUE);
        pq.offer(new int[]{start,0});
        distance[start] = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(visit[cur[0]]) continue;
            visit[cur[0]] = true;
            for(int[] v : 그래프.get(cur[0])){
                if(!visit[v[0]] && distance[v[0]] > v[1] + cur[1]){
                    distance[v[0]] = v[1] + cur[1];
                    pq.offer(new int[]{v[0], distance[v[0]]});
                }
            }
        }
        return distance;
    }
}