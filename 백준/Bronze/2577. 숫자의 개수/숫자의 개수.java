import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		char arr[] = Integer.toString(a*b*c).toCharArray();
		int iarr[] = new int[10];
		for(int i=0; i<arr.length; i++)
			iarr[arr[i]-'0']++;
		for(int i=0; i<iarr.length; i++)
			System.out.println(iarr[i]);
	}
}
