import java.util.*;
class Solution {
    static ArrayList<ArrayList<int[]>> 그래프 = new ArrayList<>();
    static ArrayList<Integer> 방문기록 =  new ArrayList<>();
	static ArrayDeque<Integer> ans = new ArrayDeque<>();
    static int N, K, target[], minTarget[], maxTarget[];
    static boolean p = false;
    public int[] solution(int[][] edges, int[] target) {
        int[] answer = {};
        
		N = target.length;
		K = edges.length;
    
		minTarget = new int[N];
		maxTarget = new int[N];
        
		for(int i=0; i<N; i++)	그래프.add(new ArrayList<>());	//그래프 초기화
		Arrays.sort(edges, (o1,o2) -> o1[1]-o2[1]);
        
		for(int i=0; i<K; i++) {
			그래프.get(edges[i][0]-1).add(new int[] {edges[i][1]-1,0});
		}
        for(int i=0; i<N; i++)	{
//			maxTarget[i] = target[i];
			minTarget[i] = (int)Math.ceil((double)target[i]/3);
		}
        // System.out.println(Arrays.toString(target));
        // System.out.println(Arrays.toString(minTarget));
        
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        while(!p) {
			dq.offer(0);
			while(!dq.isEmpty()) {
				int x = dq.poll();
				if(그래프.get(x).size() != 0) {
					for(int i=0; i<그래프.get(x).size(); i++) {
						if(그래프.get(x).get(i)[1]!=1) {
							그래프.get(x).get(i)[1] = 1;
							dq.offer(그래프.get(x).get(i)[0]);
							break;
						}
					}
					if(dq.isEmpty()) {
						for(int i=1; i<그래프.get(x).size(); i++)
							그래프.get(x).get(i)[1] = 0;
						dq.offer(그래프.get(x).get(0)[0]);
					}
				}else {
					방문기록.add(x);
					minTarget[x]--;
					maxTarget[x]++;
					if(minTarget[x] == 0)	조건충족검사1();
                    // System.out.println(Arrays.toString(minTarget));
				}
			}
		}
        boolean c = true;
        for(int i=0; i<N; i++)
			if(maxTarget[i] > target[i])	c = false;
        
		if(!c){
            answer = new int[1];
            answer[0] = -1;
        }
		else{
            answer = new int[방문기록.size()];
            for(int i=0; i<방문기록.size(); i++) {
			int in = 방문기록.get(i);
			if(target[in]-1 <= ((maxTarget[in]-1)*3)) {
				target[in]--;
				answer[i] = 1;
			}
			else if(target[in]-2 <= ((maxTarget[in]-1)*3)) {
				target[in]-=2;
				answer[i] = 2;
			}
			else {
				target[in]-=3;
				answer[i] = 3;
			}
			maxTarget[in]--;
		}
        }
		
        return answer;
    }
    
    
	private static boolean 조건충족검사1() {	//minTarget 검사
		for(int i=0; i<N; i++)
			if(minTarget[i] > 0)	return false;
		p = true;
		return true;
	}
}