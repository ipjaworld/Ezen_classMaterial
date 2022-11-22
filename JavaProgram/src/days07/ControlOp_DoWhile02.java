package days07;

import java.util.Scanner;

public class ControlOp_DoWhile02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1, n2, result=0, operator;	
		int isExit;
		
		// 두개의 숫자와 연산자를 입력 받아서 해당 숫자를 입력한 연산자로 연산한 결과를 출력합니다
		do {
			System.out.print("첫번째 정수 입력 : ");
			n1 =  sc.nextInt();
			System.out.print("두번째 정수 입력 :  ");
			n2 =  sc.nextInt();
			System.out.print("계산에 사용할 연산자 입력(+:1, -:2, x:3, ÷:4) : ");
			operator = sc.nextInt();
			
			switch(operator) {
				case 1: result = n1 + n2; break;
				case 2: result = n1 - n2; break;
				case 3: result = n1 * n2; break;
				case 4: result = n1 / n2; break;
			}
			System.out.println("result => " + result );
			System.out.print("계속할꺼니?(Yes:1, No:2)");
			isExit = sc.nextInt();
			
		}while( isExit == 1 );
		System.out.println("프로그램이 종료되었습니다");
	}

}




