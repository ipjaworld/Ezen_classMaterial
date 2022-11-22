package days06;

import java.util.Scanner;

public class ControlOp_For15 {

	public static void main(String[] args) {
		
		// 정수하나를 입력 받아서 입력한 정수가 소수(prime number)인지 아닌지를 출력합니다
		// 소수(prime number) : 1 과 자기 자신의 숫자로만 나누어 떨어지는 숫자
		
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("소수인지 판단할 숫자를 입력하세요 ");
		int num = sc.nextInt();
		
		int i;
		int count = 0;  // 횟수 카운트용 변수
		
		for( i=1; i<=num; i++) {
			if( num % i  == 0 ) count++;
		}
		
		if( count == 2 )System.out.println("입력한 정수 " + num + " 은 소수입니다");
		else System.out.println("입력한 정수 " + num + " 은 소수가 아닙니다");
		*/
		
		// 1부터 100 사이의 소수들을 출력하세요
		
		int i, k, count;
		for( i=2; i<=100; i++ ) {  // 1부터 100사의 모든숫자를 소수인지 검사하기 위한 반복문
			count = 0;  // 검사할 숫자가 변할때마다 새로운 카운트를 해야하기때문에 검사절차 위에t서 0으로 초기화
			for( k=2; k<i/2; k++) {
				if( i%k == 0 ) count++;
			}
			if( count == 0 )System.out.printf("%d ",i);
		}
	}

}
