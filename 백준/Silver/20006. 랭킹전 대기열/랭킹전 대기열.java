import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static class Player{
		int level;
		String id;
		Player(int level, String id){
			this.level = level;
			this.id= id;
		};
	}

	public static class Room{
		ArrayList<Player> players = new ArrayList<>();
		Room(Player player){
			this.players.add(player);
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			if(this.players.size() == M) sb.append("Started!\n");
			else sb.append("Waiting!\n");
			Collections.sort(players, (o1,o2) -> o1.id.compareTo(o2.id));
			for(Player p : players)	sb.append(p.level).append(" ").append(p.id).append("\n");
			return sb.toString();
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static int N,M;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ArrayList<Room> rooms = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int level = Integer.parseInt(st.nextToken());
			String id = st.nextToken();
			boolean flag = false;
			Player player = new Player(level, id);
			for(int j=0; j<rooms.size(); j++) {
				if(rooms.get(j).players.size() < M && rooms.get(j).players.get(0).level - 10 <= player.level && rooms.get(j).players.get(0).level + 10 >= player.level) {
					rooms.get(j).players.add(player);
					flag = true;
					break;
				}
			}
			if(!flag) rooms.add(new Room(player));
		}
		for(Room r : rooms) sb.append(r.toString());
		System.out.println(sb.toString());
	}
}

/*
10 5
10 a
15 b
20 c
25 d
30 e
17 f
18 g
26 h
24 i
28 j

Started!
10 a
15 b
20 c
17 f
18 g
Started!
25 d
30 e
26 h
24 i
28 j
*/