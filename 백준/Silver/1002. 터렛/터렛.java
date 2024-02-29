import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int x1,x2,y1,y2,r1,r2;
		for(int tc=1; tc<=T; tc++) {
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			r1 = sc.nextInt();
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			r2 = sc.nextInt();
			double d = d(x1,y1,x2,y2);
			if(d==0 && r1==r2)
				System.out.println(-1);
			else if(Math.abs(r1-r2) < d && d < r1+r2) {
				System.out.println(2);
			}
			else if(r1+r2 == d || Math.abs(r1-r2) == d)
				System.out.println(1);
			else
				System.out.println(0);
				
		}
	}

	private static double d(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
	}
}
