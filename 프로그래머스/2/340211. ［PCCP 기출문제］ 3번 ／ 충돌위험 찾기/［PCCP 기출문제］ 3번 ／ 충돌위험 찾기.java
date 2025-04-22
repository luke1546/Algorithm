import java.util.*;

class Solution {
    static int ans = 0;
    static ArrayDeque<int[]> dqCur = new ArrayDeque<>();
    static ArrayDeque<ArrayDeque<Integer>> dqTarget = new ArrayDeque<>();
    static HashMap<Integer, Integer> map = new HashMap<>(); // String → int 키 변경
    static int gPoints[][];

    public int solution(int[][] points, int[][] routes) {
        gPoints = points;
        for (int[] route : routes) {
            int i = points[route[0] - 1][0];
            int j = points[route[0] - 1][1];
            dqCur.offer(new int[]{i, j});

            ArrayDeque<Integer> dq = new ArrayDeque<>();
            for (int t : route) dq.offer(t);
            dqTarget.offer(dq);
        }

        while (!dqCur.isEmpty()) {
            crashCheck();
            move();
        }

        return ans;
    }

    public static void crashCheck() {
        int size = dqCur.size();
        map.clear();

        for (int i = 0; i < size; i++) {
            int[] cur = dqCur.poll();
            int key = cur[0] * 1000 + cur[1]; // 좌표 → 정수 키
            map.put(key, map.getOrDefault(key, 0) + 1);
            dqCur.offer(cur);
        }

        for (int v : map.values()) {
            if (v > 1) ans++;
        }
    }

    public static void move() {
        int size = dqCur.size();
        for (int i = 0; i < size; i++) {
            int[] cur = dqCur.poll();
            ArrayDeque<Integer> dq = dqTarget.poll();
            boolean bCheck = getNextCur(cur, dq);
            if (bCheck) {
                dqCur.offer(cur);
                dqTarget.offer(dq);
            }
        }
    }

    public static boolean getNextCur(int[] cur, ArrayDeque<Integer> dq) {
        int[] target = {gPoints[dq.peek() - 1][0], gPoints[dq.peek() - 1][1]};
        if (target[0] != cur[0]) {
            if (target[0] > cur[0]) cur[0]++;
            else cur[0]--;
        } else if (target[1] != cur[1]) {
            if (target[1] > cur[1]) cur[1]++;
            else cur[1]--;
        } else {
            dq.poll();
            if (dq.isEmpty()) return false;
            return getNextCur(cur, dq);
        }
        return true;
    }
}
