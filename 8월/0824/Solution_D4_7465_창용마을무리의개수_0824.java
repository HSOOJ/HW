import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 건너서라도 서로 알고 있는 관계라면 하나의 무리 -> 서로소 집합

public class Solution_D4_7465_창용마을무리의개수_0824 {
	
	static int N; // 마을 사람 수
	static int parents[]; // 서로 알고 있는 사람 배열
	
	private static void make() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	} // end make
	
	private static int find(int a) {
		if(a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	} // end find
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot)
			return false;
		
		parents[bRoot] = aRoot; // 대표자 합쳐버리기
		
		return true;
	} // end union

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> res = new ArrayList<>(); 
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken()); // 관계 수
			
			parents = new int[N+1];
			
			// 각각 집합 생성
			make();
			
			// 관계수를 입력 받아서 같은 무리인지 확인하기
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a, b);
			
			}

			// 같은 대표자를 가지고 있으면 같은 무리
			for (int i = 1; i <= N; i++) {
				int tmp = find(parents[i]);
				// 새로운 대표자라면 arraylist에 추가하기
				if(!res.contains(tmp)) {
					res.add(tmp);
				}
			}
			
			// 출력 : arraylist 길이만큼 출력하기
			System.out.println("#" + t + " " + res.size());
			
			// arraylist clear
			res.clear();
		}
	}
}
