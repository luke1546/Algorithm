import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		HashMap hm1 = new HashMap();
		HashMap hm2 = new HashMap();
		Scanner sc = new Scanner(System.in);
		hm1.put("black", 0L);
		hm1.put("brown", 1L);
		hm1.put("red", 2L);
		hm1.put("orange", 3L);
		hm1.put("yellow", 4L);
		hm1.put("green", 5L);
		hm1.put("blue", 6L);
		hm1.put("violet", 7L);
		hm1.put("grey", 8L);
		hm1.put("white", 9L);
		
		hm2.put("black", 1L);
		hm2.put("brown", 10L);
		hm2.put("red", 100L);
		hm2.put("orange", 1000L);
		hm2.put("yellow", 10000L);
		hm2.put("green", 100000L);
		hm2.put("blue", 1000000L);
		hm2.put("violet", 10000000L);
		hm2.put("grey", 100000000L);
		hm2.put("white", 1000000000L);
		
		long answer = 0;
		answer = (long)hm1.get(sc.next()) * 10;
		answer += (long)hm1.get(sc.next());
		answer *= (long)hm2.get(sc.next());
		
		System.out.println(answer);
//		black	0	1
//		brown	1	10
//		red	2	100
//		orange	3	1,000
//		yellow	4	10,000
//		green	5	100,000
//		blue	6	1,000,000
//		violet	7	10,000,000
//		grey	8	100,000,000
//		white	9	1,000,000,000
	}
}
