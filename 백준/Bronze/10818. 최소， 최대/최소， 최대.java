import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();
		Arrays.sort(arr);
		System.out.print(arr[0] + " ");
		System.out.print(arr[arr.length-1]);
		sc.close();
	}
}
