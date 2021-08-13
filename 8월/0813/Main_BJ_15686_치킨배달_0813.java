/*
5 3
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_15686_치킨배달_0813 {
	
	static int N, M;
	static int cntH, cntC;
	static House[] house;
	static Chicken[] chicken;
	static Chicken[] res;
	static int chickenD = Integer.MAX_VALUE; // 도시의 치킨 거리

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 도시 크기
		M = sc.nextInt(); // 최대 치킨집 개수
		
		res = new Chicken[M]; // 남아있는 치킨집 조합
		
		int [][] arr = new int[N][N];
		
		cntH = 0; // 집 개수
		cntC = 0; // 치킨집 개수
	
		// 데이터 입력
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int tmp = sc.nextInt();
				if (tmp == 1) cntH++; // 집 개수 세기
				if (tmp == 2) cntC++; // 치킨집 개수 세기
				arr[i][j] = tmp;
			}
		}
		
		house = new House[cntH]; // 집 개수만큼 생성
		chicken = new Chicken[cntC]; // 치킨집 수 만큼 생성
		
		int idx1 = 0; // 집 인덱스
		int idx2 = 0; // 치킨집 인덱스
		
		// 집, 치킨집 좌표 저장
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int tmp = arr[i][j];
				if (tmp == 1) 
					house[idx1++] = new House(i, j);
				if (tmp == 2) 
					chicken[idx2++] = new Chicken(i, j);
			}
		}
		
		// 조합
		Comb(0, 0);
		
		// 출력
		System.out.println(chickenD);
		
		sc.close();
	} // main
	
	// 집 클래스
	static class House{
		int r;
		int c;
		public House(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		@Override
		public String toString() {
			return "House [r=" + r + ", c=" + c + "]";
		}
		
	} // house

	// 치킨 클래스
	static class Chicken{
		int r;
		int c;
		public Chicken(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		@Override
		public String toString() {
			return "Chicken [r=" + r + ", c=" + c + "]";
		}
		
	} // chicken
	
	private static void Comb(int cnt, int start) {
		if(cnt == M) { // M개의 치킨집 조합이 생성되면
			int r1, r2, c1, c2;
			int sum = 0;
			
			for(int i = 0; i < cntH; i++) {
				int min = Integer.MAX_VALUE;
				r1 = house[i].r;
				c1 = house[i].c;
				
				for(int j = 0; j < res.length; j++) {
					r2 = res[j].r;
					c2 = res[j].c;
//					System.out.println(r1 + " " + c1 + " " + r2 + " " + c2);
					int tmp = (Math.abs(r1-r2) + Math.abs(c1-c2)); // 집과 치킨집 거리
					
					if(min > tmp) min = tmp; // 거리의 최소
//					System.out.println(tmp);
				}
				sum += min; // 최소 값들의 합
			}
			if(chickenD > sum) chickenD = sum;
			
			return;
		}
		
		// 조합
		for(int i = start; i < cntC; i++) {
			res[cnt] = chicken[i];
			Comb(cnt+1, i+1);
		}
	}
}
