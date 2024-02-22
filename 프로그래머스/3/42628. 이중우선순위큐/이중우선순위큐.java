import java.util.*;
class Solution {
    // 최소값을 뽑을 pq
    static PriorityQueue<Integer> minPQ = new PriorityQueue<>((o1,o2) -> o1-o2);
    // 최소값에서 뽑아진 값들을 저장해두는 pq
    static PriorityQueue<Integer> polledMaxPQ = new PriorityQueue<>((o1,o2) -> o2-o1);
        
    // 최대값을 뽑을 pq
    static PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1,o2) -> o2-o1);
    // 최대값에서 뽑아진 값들을 저장해두는 pq
    static PriorityQueue<Integer> polledMinPQ = new PriorityQueue<>((o1,o2) -> o1-o2);
    public int[] solution(String[] operations) {
        for(String operation : operations){
            // System.out.println("1max" + maxPQ);
            // System.out.println("1pmin" + polledMinPQ);
            // System.out.println("1min" + minPQ);
            // System.out.println("1pmax" + polledMaxPQ);
            // System.out.println("------------");
            StringTokenizer st = new StringTokenizer(operation, " ");
            String str = st.nextToken();
            int v=0;
            if(str.equals("I")) offerPQ(Integer.parseInt(st.nextToken()));
            else v = Integer.parseInt(st.nextToken());
            if(v == 1)  pollMax();
            if(v == -1) pollMin();
        }
        
        int[] answer = new int[2];
        answer[0] = pollMax();
        answer[1] = pollMin();
        if(answer[0] != 0 && answer[1] == 0) answer[1] = answer[0];
        return answer;
    }
    
    public static void offerPQ(int N){
        minPQ.offer(N);
        maxPQ.offer(N);
    }
    
    public static int pollMax() {
        updatePQ();
        int value = 0;
        if(!maxPQ.isEmpty()) {
            value = maxPQ.poll();
            polledMinPQ.offer(value);
        }
        updatePQ();
        return value;
    }

    public static int pollMin(){
        updatePQ();
        int value = 0;
        if(!minPQ.isEmpty()) {
            value = minPQ.poll();
            polledMaxPQ.offer(value);
        }
        updatePQ();
        return value;
    }
    
    public static void updatePQ(){
        // System.out.println("2max" + maxPQ.peek());
        // System.out.println("2pmin" + polledMinPQ.peek());
        // System.out.println("2min" + minPQ.peek());
        // System.out.println("2pmax" + polledMaxPQ.peek());
        while(!minPQ.isEmpty()
              && !polledMinPQ.isEmpty() 
              && minPQ.peek() == polledMinPQ.peek()){
            minPQ.poll();
            polledMinPQ.poll();
        }
        while(!maxPQ.isEmpty() 
              && !polledMaxPQ.isEmpty() 
              && maxPQ.peek() == polledMaxPQ.peek()){
            maxPQ.poll();
            polledMaxPQ.poll();
        }
    }
}