import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static class Player implements Comparable<Player> {
        int level;
        String id;

        Player(int level, String id) {
            this.level = level;
            this.id = id;
        }

        @Override
        public int compareTo(Player o) {
            return this.id.compareTo(o.id);
        }
    }

    public static class Room {
        int level, count;
        ArrayList<Player> players = new ArrayList<>();

        Room(int level, Player player) {
            this.level = level;
            this.count = 1;
            this.players.add(player);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.players.size() == M) sb.append("Started!\n");
            else sb.append("Waiting!\n");
            Collections.sort(players);
            for (Player p : players) sb.append(p.level).append(" ").append(p.id).append("\n");
            return sb.toString();
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ArrayList<Room> rooms = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int level = Integer.parseInt(st.nextToken());
            String id = st.nextToken();
            Player player = new Player(level, id);
            boolean flag = false;
            
            for (Room room : rooms) {
                if (room.count < M && Math.abs(room.level - player.level) <= 10) {
                    room.players.add(player);
                    room.count++;
                    flag = true;
                    break;
                }
            }
            
            if (!flag) rooms.add(new Room(level, player));
        }
        
        for (Room r : rooms) sb.append(r);
        System.out.println(sb);
    }
}
