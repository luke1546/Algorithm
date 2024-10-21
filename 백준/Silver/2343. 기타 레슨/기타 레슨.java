
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        
        int max = 0; // 레슨 길이 중 최대값
        int sum = 0; // 레슨 길이들의 합
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]); // 가장 긴 레슨
            sum += arr[i]; // 레슨 길이의 총합
        }
        
        int s = max; // 최소 블루레이 크기
        int e = sum; // 최대 블루레이 크기
        int min = Integer.MAX_VALUE;
        
        while (s <= e) {
            int m = s + (e - s) / 2; // 중간값
            int v = calc(m, arr); // 블루레이 크기 m일 때 필요한 블루레이 개수 계산
            
            if (v <= M) { // M개 이하로 가능하면
                min = Math.min(min, m); // 최소 블루레이 크기 업데이트
                e = m - 1; // 더 작은 크기 탐색
            } else {
                s = m + 1; // 더 큰 크기 탐색
            }
        }
        
        System.out.println(min);
    }
    
    private static int calc(int m, int[] arr) {
        int cnt = 1; // 필요한 블루레이 개수 (최소 1개)
        int temp = m; // 현재 블루레이에 남은 용량
        
        for (int i = 0; i < N; i++) {
            if (temp - arr[i] < 0) { // 현재 블루레이에 담을 수 없으면
                cnt++; // 새로운 블루레이가 필요함
                temp = m; // 블루레이 크기 초기화
            }
            temp -= arr[i]; // 레슨을 블루레이에 담음
        }
        
        return cnt; // 필요한 블루레이 개수 반환
    }
}
