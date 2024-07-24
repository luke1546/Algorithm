import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<String> road = new ArrayList<>();
    static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
    static long mod = (long)1e9 + 7;
    static long power[] = new long[500001];
    static ArrayList<Integer> al = new ArrayList<>();
    static String P;
    static long PWeight = 0;
    static int ans = 0;
    static int base = 31;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        for (int i = 0; i < V; i++) list.add(new ArrayList<>());
        for (int i = 0; i < V - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int v = st.nextToken().charAt(0);
            list.get(from).add(new int[]{to, v});
        }
        power[0] = 1;
        for (int i = 1; i < power.length; i++) {
            power[i] = power[i - 1] * base % mod;
        }

        P = br.readLine();
        for (int i = 0; i < P.length(); i++) {
            PWeight = (PWeight * base + P.charAt(i)) % mod;
        }

        dfs(0, 0);
        System.out.println(ans);
    }

    private static void dfs(int index, long weight) {
        if (weight == PWeight) ans++;
        for (int[] cur : list.get(index)) {
            al.add(cur[1]);
            long w = weight;
            if (al.size() > P.length()) {
                w = (w - al.get(al.size() - P.length() - 1) * power[P.length() - 1] % mod + mod) % mod;
            }
            w = (w * base + cur[1]) % mod;
            dfs(cur[0], w);
            al.remove(al.size() - 1);
        }
    }
}
