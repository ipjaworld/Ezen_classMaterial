package days09;

import java.util.Scanner;

public class Method08 {

	public static void main(String[] args) {
		
		int [] a = {56,54,87,89,25,36,57,98};
		Scanner sc = new Scanner(System.in);
		System.out.print("출력할 내용을 선택하세요(합계:1, 평균:2, 합계&평균:3) : ");
		int input = sc.nextInt();
		sumavg(input, a);
		// 전달인수 첫번째 1이면 합계 출력, 2이면 평균 출력, 3이면 총점 평균 출력
	}
	
	public static void sumavg(int k, int [] b) {
		// k : 메서드 호출시 전달된 정수 value,  b : 메서드 호출시 전달된 정수배열의 시작주소
		int sum = 0;
		for(int i=0; i<b.length; i++) sum+=b[i];
		double avg = sum / (double)b.length;
		if( k==1) System.out.printf("합계 : %d\n", sum);
		else if( k==2) System.out.printf("평균 : %.1f\n", avg);
		else System.out.printf("합계 : %d, 평균 : %.1f\n", sum, avg);
	}

}
