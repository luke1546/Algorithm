import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger i1 = new BigInteger(sc.next());
		BigInteger i2 = new BigInteger(sc.next());
		System.out.println(i1.add(i2));
		System.out.println(i1.subtract(i2));
		System.out.println(i1.multiply(i2));
	}
}