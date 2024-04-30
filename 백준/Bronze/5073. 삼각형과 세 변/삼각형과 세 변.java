import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int triangle[] = new int[3];
			for(int i=0; i<3; i++) triangle[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(triangle);
			if(triangle[0]==0 && triangle[1]==0 && triangle[2]==0) break;
			if(triangle[0]==triangle[1] && triangle[1]==triangle[2]) sb.append("Equilateral").append("\n");
			else if(triangle[0] + triangle[1] <= triangle[2]) sb.append("Invalid").append("\n");
			else if(triangle[0]==triangle[1] || triangle[0]==triangle[2] || triangle[1]==triangle[2]) sb.append("Isosceles").append("\n");
			else sb.append("Scalene").append("\n");
		}
		if(sb.length()!= 0) sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
}
