import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		String str = a%2==1 ? "SK" : "CY";
		System.out.println(str);
	}
}
