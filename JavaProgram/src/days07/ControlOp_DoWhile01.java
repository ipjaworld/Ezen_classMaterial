package days07;

import java.util.Scanner;

public class ControlOp_DoWhile01 {

	public static void main(String[] args) {
		int i;
		for( i=11  ; i<=10 ; i++ ) {
			System.out.printf("%d ", i);
		}
		System.out.println("\nfor 반복 종료후 i 변수 값 : " + i);
		System.out.println("-------------------------------------");
		
		i = 11;
		while( i<=10 ) {
			System.out.printf("%d ", i);
			i++;
		}
		System.out.println("\nwhile 반복 종료후 i 변수 값 : " + i);
		System.out.println("-------------------------------------");
		
		i=11;
		do {
			System.out.printf("%d ", i);
			i++;
		}while( i<=10 );
		System.out.println("\ndo-while 반복 종료후 i 변수 값 : " + i);
		
		
		// do while 의 특이점  while(조건) 을 후미에 기술합니다
		// while(조건)뒤에 ';' 세미콜론을 찍습니다.
		// if(조건);{} X
		// for(int i = 1; i<100; i++);{}  X  
		// while( i<100 );{} X
		// do { }while(  조건 );  O
		// do 에 속한 { } 안의 명령을 한번 먼저 실행후 조건을 테스트합니다	

		// while( true ) {
		//		if(   ) break;
		// }
		
		// do~ while 을 써서 사용자가 100을 입력하기전까지 입력된 모든 숫자를 합산해서 출력하세요
		Scanner sc = new Scanner(System.in);
		int input, sum = 0;
		do {
			System.out.print("정수를 입력하세요(종료:100) : ");
			input = sc.nextInt();
			sum = sum + input;
		}while( input != 100 );
		System.out.println("입력한 정수 합 : " + (sum-100) );
		System.out.println("프로그램 종료");
	}

}









