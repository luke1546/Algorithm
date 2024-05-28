import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int max = 0, index = 0;
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

        for (int i = 0; i < N; i++) {
            if (max < arr[i][1]) {
                max = arr[i][1];
                index = i;
            }
        }

        int ans = max;
        int temp = arr[0][1];
        for (int i = 1; i <= index; i++) {
            if (arr[i][1] > temp) {
                ans += temp * (arr[i][0] - arr[i - 1][0]);
                temp = arr[i][1];
            } else {
                ans += temp * (arr[i][0] - arr[i - 1][0]);
            }
        }

        temp = arr[N - 1][1];
        for (int i = N - 2; i >= index; i--) {
            if (arr[i][1] > temp) {
                ans += temp * (arr[i + 1][0] - arr[i][0]);
                temp = arr[i][1];
            } else {
                ans += temp * (arr[i + 1][0] - arr[i][0]);
            }
        }

        System.out.println(ans);
    }
}
