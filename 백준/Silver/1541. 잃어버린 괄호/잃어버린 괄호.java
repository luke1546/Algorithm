import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    int answer = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    String[] strs = input.split("-");
    for(String str : strs)  answer -= calculate(str);
    if(!strs[0].equals("")) answer+=(calculate(strs[0])*2);
    System.out.println(answer);
  }

  private static int calculate(String str) {
    int a = 0;
    String[] nums = str.split("\\+");
    for(String num : nums)  if(!num.equals("")) a += Integer.parseInt(num);
    return a;
  }
}
