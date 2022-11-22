package days04;

import java.util.Scanner;

public class ControlOp_IF04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("점수를 입력하세요 : ");
		int a = sc.nextInt();
		
		// 90 이상 A학점, 80~89 B학점, 70~79 C학점, 60~69 D학점, 60 미만 F학점	
		if( a >=90 ) {
			System.out.println("A학점");
		}else if( a>=80 && a<=89 ) {
			System.out.println("B학점");
		}else if( a>=70 && a<=79 ) {
			System.out.println("C학점");
		}else if( a>=60 && a<=69 ) {
			System.out.println("D학점");
		}else {
			System.out.println("F학점");
		}

		//-------------------------------------------------------
		if( a >=90 ) System.out.println("A학점");
		else if( a>=80 ) System.out.println("B학점");
		else if( a>=70 ) System.out.println("C학점");
		else if( a>=60 ) System.out.println("D학점");
		else 	System.out.println("F학점");
		
		//---------------------------------------------잘못된 사용 예
		if( a<60 )System.out.println("F학점");
		else if( a>=60) System.out.println("D학점");
		else if( a>=70) System.out.println("C학점");
		else if( a>=80) System.out.println("B학점");
		else System.out.println("A학점");
		
		//-------------------------------------------------------
		if( a < 60 )	System.out.println("F학점");
		else if( a < 70 ) System.out.println("D학점");
		else if( a < 80 ) 	System.out.println("C학점");
		else if( a < 90 ) 	System.out.println("B학점");
		else 	System.out.println("A학점");
		
	}

}





