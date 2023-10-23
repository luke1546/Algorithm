import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//딱알았어!
/*
 * 풀이
 * 1. 양쪽으로 최장증가수열을 구한다
 * 2. 각 숫자별 나올 수있는 최장증가수열을 배열에 저장
 * 3. 양쪽의 합이 가장 큰 것을 고른다. 끗!
 */
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int lArr[] = new int[N];
		int rArr[] = new int[N];
		int Array[] = new int[N];
		int lis[] = new int[N];
		
		Arrays.fill(lis, Integer.MAX_VALUE);
		for(int i=0; i<N; i++) 	Array[i] = Integer.parseInt(st.nextToken());
		int max = 0;
		for(int i=0; i<N; i++) {
			int index = Arrays.binarySearch(lis, Array[i]);
			if(index < 0) index = (index*-1)-1;
			lis[index] = Array[i];
			max = Math.max(max, index);
			lArr[i] = max+1;
		}
		
		Arrays.fill(lis, Integer.MAX_VALUE);
		max = 0;
		for(int i=0; i<N; i++) {
			int index = Arrays.binarySearch(lis, Array[N-1-i]);
			if(index < 0) index = (index*-1)-1;
			lis[index] = Array[N-1-i];
			max = Math.max(max, index);
			rArr[i] = max+1;
		}
//		System.out.println(Arrays.toString(lArr));
//		System.out.println(Arrays.toString(rArr));
		max = 0;
		for(int i=0; i<N; i++) max = Math.max(max, lArr[i] + rArr[N-1-i]);
		System.out.println(max-1);
	}
}
