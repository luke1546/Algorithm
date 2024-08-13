import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(),ans = n,c=2;
		while(true) {
			for(int i=c*c; i<=n; i+=c)	ans++;
			c++;
			if(c*c > n)	break;
		}
		System.out.println(ans);
		sc.close();
	}
}
