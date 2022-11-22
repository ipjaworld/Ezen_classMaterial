package days05;

import java.util.Scanner;

public class ControlOp_Switch01 {

	public static void main(String[] args) {
		
		// 경우의 수를 나누는 기준이 되믄 관계연산식이 비교적 단순 비교일때 사용합니다
		// >, < , >= , <=아니고   == 일때 주로 사용합니다
		int a;
		Scanner sc = new Scanner(System.in);
		System.out.printf("정수를 입력하세요 : ");
		a = sc.nextInt();
		
		/*
		if( a == 1 ) System.out.println("1을(를) 입력하셨습니다");
		else if( a == 2 ) System.out.println("2을(를) 입력하셨습니다");
		else if( a == 3 ) System.out.println("3을(를) 입력하셨습니다");
		else if( a == 4 ) System.out.println("4을(를) 입력하셨습니다");
		else if( a == 5 ) System.out.println("5을(를) 입력하셨습니다");
		*/
		
		// switch 는 if와 비슷한 구조이지만, 변수값의 단순 참조에 의해 경우의 수가 분리됩니다
		switch(a) {
			case 1:
				System.out.println("1을(를) 입력하셨습니다");
				break;
			case 2:
				System.out.println("2을(를) 입력하셨습니다");
				break;
			case 3:
				System.out.println("3을(를) 입력하셨습니다");
				break;
			case 4:
				System.out.println("4을(를) 입력하셨습니다");
				break;
			case 5:
				System.out.println("5을(를) 입력하셨습니다");
				break;
		}
		// break : 자신을 감싸고 있는 if 문 또는 반복문의 경계( {  } )를 빠져나가라는 명령입니다
		//             try~catch 의 경계는 예외입니다.
	}

}









