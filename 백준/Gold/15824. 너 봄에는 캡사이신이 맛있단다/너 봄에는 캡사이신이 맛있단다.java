import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static long m = 1000000007;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long ans = 0;
        st = new StringTokenizer(br.readLine(), " ");
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        // 미리 제곱 값을 계산해둠
        long[] pow = new long[N];
        pow[0] = 1;
        for (int i = 1; i < N; i++) {
            pow[i] = (pow[i - 1] * 2) % m;
        }

        for (int i = 0; i < N; i++) {
            long min = pow[N - 1 - i]; // 최소인 경우
            long max = pow[i]; // 최대인 경우
            min = (arr[i] * min) % m;
            max = (arr[i] * max) % m;
            ans = (ans + max - min + m) % m; // 음수가 되지 않도록 +m을 해줌
        }
        System.out.println(ans);
    }
}
