import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


//필요한 함수 3개	0930 ~ 1028 전략짜기 , 1028풀이시작! ~
// 특정 숫자를 Z로 바꾸는 함수 *해결*
// 덧셈(36진수 덧셈(문자열))
// 정렬(36진수 내림차순 정렬)
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str[] = new String[N];
		for(int i=0; i<N; i++)	str[i] = br.readLine();
		int K = Integer.parseInt(br.readLine());
		String AZ[][] = new String[36][2];
		
		for(int i=0; i<36; i++) {
			String[] temp = new String[str.length];
			for(int j=0; j<str.length; j++)	temp[j] = str[j];
			char c = (char)(i+'0');
			if(c > '9') c = (char)(c+7);
			transZ(temp,c);
			AZ[i][0] = addS2(temp);
			AZ[i][1] = Integer.toString(i);
		}
		Arrays.sort(AZ, (o1,o2)-> {
			if(o1[0].length() != o2[0].length())	return o2[0].length()-o1[0].length();
			else	return o2[0].compareTo(o1[0]);
		});
		for(int i=0; i<K; i++) {
			char c = (char)(Integer.parseInt(AZ[i][1])+'0');
			if(c > '9') c = (char)(c+7);
			transZ(str,c);
		}
		System.out.println(addS2(str));
//		System.out.println("1DZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZYM");
	}
	
	
	private static String addS1(String str1, String str2) {
		StringBuilder sb = new StringBuilder();
		String s1,s2;		//s1 : 긴거, s2 : 짧은거
		if(str1.length() >= str2.length()) {	
			s1 = str1;
			s2 = str2;
		}
		else	{
			s1 = str2;
			s2 = str1;
		}
		
		int size = s2.length();
		int dif = s1.length() - s2.length();
		
		int temp = 0,sum;
		for(int i=size-1; i>=0; i--) {
			sum = addC(s1.charAt(i+dif), s2.charAt(i),temp);
			temp=0;
			if(sum >= 36) {
				temp = 1;
				sum-=36;
			}
			if(sum < 10)	sb.append(sum);
			else	sb.append((char)(sum + '7'));
		}
		
		for(int i=dif-1; i>=0; i--) {
			char c = (char)(s1.charAt(i)+temp);
//			System.out.println(c);
			if(c > '9' && c < 'A') c= (char)(c+7);
			temp = 0;
			if(c > 'Z') {
				c = (char)(c-43);
				temp = 1;
			}
			sb.append(c);
		}
		if(temp != 0)	sb.append(temp);
		sb.reverse();
		return sb.toString();
	}

	private static int addC(char c1, char c2, int temp) {
		int num1 = c1-'0';
		int num2 = c2-'0';
		if(num1 > 10) num1-=7;
		if(num2 > 10) num2-=7;
		return num1+num2+temp;
	}
	private static String addS2(String[] str) {
		String s = "";
		for(int i=0; i<str.length; i++)	s = addS1(s,str[i]);
		return s;
	}

	private static void transZ(String[] str, char c) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length; i++) {
			for(int j=0; j<str[i].length(); j++) {
				if(str[i].charAt(j) == c)	sb.append('Z');
				else	sb.append(str[i].charAt(j));
			}
			str[i] = sb.toString();
			sb.setLength(0);
		}
	}
}
