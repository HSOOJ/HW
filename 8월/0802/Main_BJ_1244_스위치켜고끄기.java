import java.util.Scanner;

public class Main_BJ_1244_스위치켜고끄기{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int []arr = new int[s];
			
		// 스위치 입력
		for(int i = 0; i < s; i++) {
			arr[i] = sc.nextInt();
		}
		
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int sex = sc.nextInt();
			int idx = sc.nextInt();
			
			if (sex == 1) { // 남자
				for(int j = idx-1; j < s; j+=idx) {
					arr[j] = (arr[j] == 1)? 0: 1;
				}
				
			} // if
			else { // 여자
				idx--;
				arr[idx] = (arr[idx] == 1)? 0: 1; // 받은 수 자리 1 <-> 0
				for(int j = 1; j <= idx; j++) {
					if(idx - j >= 0 && j+idx < s && arr[idx-j] == arr[idx+j]) {
						arr[idx-j] = (arr[idx-j] == 1)? 0: 1;
						arr[idx+j] = (arr[idx+j] == 1)? 0: 1;
					}
					else
						break;
				}
			} // else
		}
		
		// 출력
		for (int i = 0; i < s; i++) {
	        System.out.print(arr[i] + " ");
	        if ((i+1) % 20 == 0) {
	            System.out.println();
	        }
	    }

		sc.close();
	} // main
}
