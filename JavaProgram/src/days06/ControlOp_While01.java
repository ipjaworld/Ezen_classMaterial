package days06;

import java.util.Scanner;

public class ControlOp_While01 {

	public static void main(String[] args) {
		
		// while 반복문
		// for 반복문은 정해진 횟수의 반복을 괄호안에 미리 정의 해놓고 반복하는 특징이 있습니다
		// while 문은 정해지지 않은 횟수의 반복을 처리하는데 주로 사용합니다.
		// 특정 조건이 만족할때까지 무한 수행합니다
		// while( true ) { } -> 이 반복문은 종료되지 않습니다 : 무한 반복
		
		// for문을 이용해서 10회 반복실행
		for( int i = 1; i<=10; i++) {
			System.out.println("for : " + i);
		}
		System.out.println();
		// i<=10  : 반복을 계속할 조건.   이 관계연산이 false 면 반복실행을 멈춥니다
		// while 문의 조건도 똑같이 사용됩니다.
		
		int a=1;
		while(a<=10) {  // for문과 달리 ()안에 다른건 다 빼고, 반복을 계속할 조건만 씁니다
			System.out.println("while : " + a);
			a++;
		}
		System.out.println();
		// 괄호안의 관계(비교)연산식의 참/거짓 유무를 먼저 판단한후 반복을 계속할지 결정합니다

		// while 문의 경우 위에서 코딩한것 처럼 a++ 명령에 의해 반복 유지 유무가 결정되는 것보단 
		// 특정 조건에 의해 순서와 반복횟수에 상관없이 반복이 결정되는 상황에 더 적절히 사용됩니다
		
		a = 0;
		for(  ;  ; ) {
			System.out.printf("for : " + a);
			a++;
			if( a>10) break;
		}
		System.out.println();
		
		a = 0;
		while(true) {
			System.out.printf("while : " + a);
			a++;
			if( a>10) break;
		}
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("\n메뉴 선택 : 1(저장), 2(불러오기), 3(종료)");
		int input = sc.nextInt();
		
		while(true) {
			
			if( input == 3 )break;
			
			switch(input) {
				case 1: System.out.printf("저장했습니다"); break;
				case 2: System.out.printf("불러왔습니다"); break;
				//case 3: System.out.printf("종료합니다"); break;
			}
			System.out.printf("\n메뉴 선택 : 1(저장), 2(불러오기), 3(종료)");
			input = sc.nextInt();
			
		}
		System.out.println("프로그램을 종료합니다");
		System.out.println("------------------------------------------");
		
		System.out.printf("\n메뉴 선택 : 1(저장), 2(불러오기), 3(종료)");
		input = sc.nextInt();
		
		while(input != 3) {
			switch(input) {
				case 1: System.out.printf("저장했습니다"); break;
				case 2: System.out.printf("불러왔습니다"); break;
				//case 3: System.out.printf("종료합니다"); break;
			}
			System.out.printf("\n메뉴 선택 : 1(저장), 2(불러오기), 3(종료)");
			input = sc.nextInt();
		}
		System.out.println("프로그램을 종료합니다");
		
		
	}

}
