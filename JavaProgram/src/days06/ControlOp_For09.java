package days06;

import java.util.Scanner;

public class ControlOp_For09 {

	public static void main(String[] args) {
		
		// 10 개의 정수를 입력받아 그들의 합계와 평균을 출력하세요
		// 10개를 입력하는 중간에 종료를 원하면 0을 입력하여 입력을 종료하고
		// 최종 합계를 출력합니다.
		// 입력양식 
		// 입력 1: XX
		// 입력 2: XX
		// 입력 3: XX
		//.....
		// 입력10 : XX
		
		// 출력양식 
		// 입력한 정수들의 합계 : XXX
		// 입력한 정수들의 평균 : XX.X
				
		// 중간에 0을 입력하면 입력이 종료되고  그 동안 입력한 데이터만으로 합계평균을 출력하세요
		int sum=0, i, num;
		Scanner sc = new Scanner(System.in);
		
		for( i=1; i<=10; i++) {
			System.out.printf("%d 번째 숫자 입력(종료-0) : ", i);
			num = sc.nextInt();
			if( num == 0 ) break;
			sum += num;
		}
		

		double avg;
		if( sum == 0 ) {
			sum = 0;
			avg = 0.0;
		}else {
			avg = sum / (double)(i-1);
		}
		System.out.println("입력한 숫자들의 합계 : " + sum + " , 평균 : " + avg );
		
	}

}
