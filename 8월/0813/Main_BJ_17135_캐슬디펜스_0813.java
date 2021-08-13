/*
 * NxM 격자판 /  * N+1행에는 성
 * 
 * 궁수
 * 	3명 배치
 * 		- 성 있는 칸
 * 	공격
 * 		- 한 턴에 하나의 적만 공격 가능, 모든 궁수는 동시에 공격
 * 		- 거리가 D이하인 적 중에서 가장 가까운 적
 * 			- 여럿일 경우에는 가장 왼쪽에 있는 적
 * 		- 같은 적이 여러 궁수에게 공격당할 수 있음
 * 		- 적이 공격받으면 게임 제외
 * 적
 * 	공격 후 이동
 * 		- 아래로 한칸이동
 * 		- 성으로 이동하면 게임 제외
 * 
 * 모든 적이 제외되면 게임 끝
 * 
 * */

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_BJ_17135_캐슬디펜스_0813 {

	static int N, M, D;
	static int[][] arr;
	static int[][] play;
	static int[] archer = new int[3];
	static int res; // 공격으로 제거할 수 있는 적의 최대 수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 좌표
		M = sc.nextInt(); // 좌표
		D = sc.nextInt(); // 유효 사거리
		
		res = 0;

		arr = new int[N][M];
		play = new int[N][M];

		// 데이터 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		combination(0, 0);
		
		System.out.println(res);

		sc.close();
	} // main

	static class Enemy implements Comparable<Enemy> {
		int r;
		int c;
		int d; // 거리

		public Enemy(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Enemy [r=" + r + ", c=" + c + ", d=" + d + "]";
		}

		public int compareTo(Enemy o) {
			if (d == o.d)
				return c - o.c;
			else
				return d - o.d;
		}

	}

	private static void combination(int cnt, int start) {
		if (cnt == 3) {
			for(int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(archer));
				System.arraycopy(arr[i], 0, play[i], 0, M);
			}
			int min = attack(play);
			
			res = Math.max(res, min);
			return;
		}

		for (int i = start; i < M; i++) {
			archer[cnt] = i;
			combination(cnt + 1, i + 1);
		}

	} // combination

	private static int distance(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	} // distance

	private static int attack(int[][] play) {

		LinkedList<Enemy> queue = new LinkedList<>();    
		LinkedList<Enemy> deathNote = new LinkedList<>(); // 화살 맞은 적 
		
		int cnt = 0; // 처치한 적의 수
		
		// N번만큼 반복
		for(int i = 0; i < N; i++) { // N : 궁수
			
			for(int j = 0; j < 3; j++) { // 궁수 조합만큼 반복
				int idx = archer[j]; // 궁수 위치
				int nr;
				
				
				for(int k = 1; k <= D; k++) { // 유효 사거리만큼 반복
					nr = N - k; // 밑에서부터 처치할 수 있는 적 찾기
					
					for(int nc = 0; nc < M; nc++) {
						int d = distance(N, idx, nr, nc);
						// r1 : N , r1 : nr
						// c1 : idx, c2 : nc
						
						if(nr>-1 && nr<N && nc>-1 && nc<M  // 배열 범위 체크
								&& d<=D  && play[nr][nc]>0) {// 유효 사거리 내에 있고 적이면
							queue.offer(new Enemy(nr, nc, d)); //제거가능한 적으로 등록 
						}	
					}
				} // ~ D
				
				if(queue.size()>0) {
					Collections.sort(queue);
					deathNote.add(queue.poll());  //사거리가 제일 짧고, 왼쪽 놈을 deathNote에 추가 
				}
				queue.clear();
			}
			
			for(Enemy e : deathNote) {
				if(play[e.r][e.c] > 0) {
					play[e.r][e.c] = 0;
					cnt++;
				}
			}
			
			deathNote.clear();
			moveEnemy(play);
		}
		return cnt;		
	} // attack
	
	// 적 아래로 한칸씩 이동
	static void moveEnemy(int[][] play) {
		for (int i = N-1; i > 0; i--) { // 밑에서부터 위로  
			play[i] = play[i-1]; // 위의 값을 아래행에 덮어쓰기
		}
		play[0] = new int[M]; // 맨 위 0으로 초기화
	}
}
