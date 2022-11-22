package days06;

import java.util.Scanner;

public class ControlOp_For10 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("정수를 입력하세요 : ");
		int num = sc.nextInt();
		int sum = 0;
		
		// 정수 하나를 입력 받아서 1부터 입력받은 정수까지 짝수의 합을 출력하세요.
		// 각각의 짝수들이 합산되었을때의 중간 합계를 모두 출력하고 최종 합계를 마지막에 출력하세요

		int i;
		
		for(i=1; i<=num; i++) {
			if( i%2 == 0) {
				sum = sum + i;
				System.out.println("1부터 " + i + "까지의 합 : " + sum);
			}
		}	
		System.out.println();
		sum = 0;
		for(i=2; i<=num; i+=2) {
				sum = sum + i;
				System.out.println("1부터 " + i + "까지의 합 : " + sum);
		}	
		
		System.out.println();
		sum = 0;
		for(i=1; i<=num; i++) {
			if( i%2 == 1)
				continue;   // 반복실행안에서 남아있는 아래 명령들을 실행하지 않고 다음 반복으로 이어지는 명령
			sum = sum + i;
			System.out.println("1부터 " + i + "까지의 합 : " + sum);
		}
	}

}
