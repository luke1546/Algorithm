import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node{
        int i=0; // 숫자 값
        int n=0; // 등장 횟수
        Node(int i, int n){
            this.i = i;
            this.n = n;
        }
    }
    static int map[][] = new int[100][100];
    static int rowSize = 3; // 현재 행의 개수
    static int colSize = 3; // 현재 열의 개수
    public static void main(String args[])throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken())-1;
        int k = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int time = 0;
        while (time <= 100) {
            if (r < rowSize && c < colSize && map[r][c] == k) {
                System.out.println(time);
                return;
            }
            if (rowSize >= colSize) {
                행(); // R 연산
            } else {
                열(); // C 연산
            }
            time++;
        }
        System.out.println(-1); // 100초 내에 못 찾은 경우
    }
    private static void 열() {
        int newRowSize = 0;

        for (int j = 0; j < colSize; j++) {

            Map<Integer, Integer> countMap = new HashMap<>();

            for (int i = 0; i < rowSize; i++) {

                int num = map[i][j];

                if (num == 0) continue;

                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }

            // Map을 리스트로 변환
            List<Node> nodeList = new ArrayList<>();

            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {

                nodeList.add(new Node(entry.getKey(), entry.getValue()));
            }

            // 정렬: 등장 횟수 오름차순, 숫자 오름차순
            Collections.sort(nodeList, new Comparator<Node>() {

                @Override
                public int compare(Node o1, Node o2) {

                    if (o1.n != o2.n) {
                        return o1.n - o2.n;
                    } else {
                        return o1.i - o2.i;
                    }
                }
            });

            // 배열 갱신
            int idx = 0;

            for (Node node : nodeList) {

                if (idx >= 100) break;

                map[idx++][j] = node.i;
                if (idx >= 100) break;
                map[idx++][j] = node.n;
            }

            // 나머지 부분 0으로 채움
            for (int i = idx; i < rowSize; i++) {
                map[i][j] = 0;
            }

            // 최대 행 길이 업데이트
            newRowSize = Math.max(newRowSize, idx);
        }

        rowSize = Math.min(newRowSize, 100); // 최대 크기 100 제한
    }
    private static void 행() {
        int newColSize = 0;

        for (int i = 0; i < rowSize; i++) {

            Map<Integer, Integer> countMap = new HashMap<>();

            for (int j = 0; j < colSize; j++) {

                int num = map[i][j];

                if (num == 0) continue;

                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }

            // Map을 리스트로 변환
            List<Node> nodeList = new ArrayList<>();

            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {

                nodeList.add(new Node(entry.getKey(), entry.getValue()));
            }

            // 정렬: 등장 횟수 오름차순, 숫자 오름차순
            Collections.sort(nodeList, new Comparator<Node>() {

                @Override
                public int compare(Node o1, Node o2) {

                    if (o1.n != o2.n) {
                        return o1.n - o2.n;
                    } else {
                        return o1.i - o2.i;
                    }
                }
            });

            // 배열 갱신
            int idx = 0;

            for (Node node : nodeList) {

                if (idx >= 100) break;

                map[i][idx++] = node.i;
                if (idx >= 100) break;
                map[i][idx++] = node.n;
            }

            // 나머지 부분 0으로 채움
            for (int j = idx; j < colSize; j++) {
                map[i][j] = 0;
            }

            // 최대 열 길이 업데이트
            newColSize = Math.max(newColSize, idx);
        }

        colSize = Math.min(newColSize, 100); // 최대 크기 100 제한
    }
}
