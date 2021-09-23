import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BJ_1786_찾기_0923 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] text = in.readLine().toCharArray();
		char[] pattern = in.readLine().toCharArray();

		int tLength = text.length, pLength = pattern.length;

		// 실패함수 만들기 : KMP의 아이디어를 똑같이 적용
		int[] pi = new int[pLength];
		// i : 접미사 포인터, j : 접두사 포인터
		for (int i = 1, j = 0; i < pLength; i++) {// i=1부터 시작: 첫글자 틀리면 0위치로 가야함
			while (j > 0 && pattern[i] != pattern[j]) {
				j = pi[j - 1];
			}
			if (pattern[i] == pattern[j])
				pi[i] = ++j;
		}

		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		// i : 텍스트 포인터 , j: 패턴 포인터
		for (int i = 0, j = 0; i < tLength; ++i) {

			while (j > 0 && text[i] != pattern[j])
				j = pi[j - 1];

			if (text[i] == pattern[j]) { // 두 글자 일치
				if (j == pLength - 1) { // j가 패턴의 마지막 인덱스라면
					cnt++; // 카운트 증가
					list.add((i + 1) - pLength);
					j = pi[j];
				} else { // 두 글자 일치하면 i, j 둘다 +1
					j++;
				}
			}
		}

		System.out.println(cnt);
		if (cnt > 0) {
			for(int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + 1 + " ");				
			}
		}
	}
}