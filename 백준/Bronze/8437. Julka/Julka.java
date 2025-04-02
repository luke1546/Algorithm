import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger total = new BigInteger(br.readLine());     // 총합
        BigInteger diff = new BigInteger(br.readLine());      // 차이

        BigInteger klaudia = total.add(diff).divide(BigInteger.valueOf(2));  // (S + D) / 2
        BigInteger natalia = total.subtract(diff).divide(BigInteger.valueOf(2));  // (S - D) / 2

        System.out.println(klaudia);
        System.out.println(natalia);
    }
}
