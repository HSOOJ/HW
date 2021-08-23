import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// lCc - Combination

public class Main_BJ_1759_암호만들기_0823 {
	
	static int L, C;
	static char res[], ciper[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken()); // 뽑을 개수
		C = Integer.parseInt(st.nextToken()); // 전체 개수
	
		ciper = new char[C]; // 입력된 알파벳
		res = new char[L];	// 조합 결과
		
		
		// 데이터 입력
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			ciper[i] = st.nextToken().charAt(0);
		}
		
		// 알파벳 순서대로 해야하기 때문에 sort
		Arrays.sort(ciper);
		
		// 순열
		combi(0, 0, ciper[0], ciper, L, C);
		
	} // end main

	
	private static void combi(int cnt, int start, char pre, char[] ciper, int L, int C) {
		if(cnt == L) {
			// array to String
			String str = String.valueOf(res);
			
			// 모음 하나 자음 두 개 이상이면 결과 출력
			if(check(str)){
				System.out.println(str);
			}
			return;
		}

		// 조합 생성
		for(int i = start; i < C; i++) {
			res[cnt] = ciper[i];
			
			combi(cnt+1, i+1, ciper[i], ciper, L, C);
				
		}
		
	} // end combi
	
	// 모음 한 개 이상, 자음 두 개 이상인지 체크
	private static boolean check(String str) {
		String v [] = {"a", "e", "i", "o", "u"};
		
		int cntV = 0; // 모음 개수 count
		
		// 배열을 돌면서 스트링이 가지고 있으면 cnt++
		for(String x : v) {
			if(str.contains(x)) 
				cntV++;
		}
		
		// 모음이 1개 이상이면서 전체 문자열 길이에서 모음 개수를 빼도 2 이상인 경우
		if(1<= cntV && (str.length() - cntV) >= 2) 
			return true;
		
		return false;
	}
} // end class