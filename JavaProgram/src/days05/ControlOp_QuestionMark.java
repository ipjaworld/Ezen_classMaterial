package days05;

import java.util.Scanner;

public class ControlOp_QuestionMark {

	public static void main(String[] args) {
		// ? : 
		// 간단한  if  else 를 대신할 수 있는 간략한 명령
		// 점수가 70이상이면 합격, 아니면 불합격을 출력하세요
		Scanner sc = new Scanner(System.in);				
		System.out.printf("점수를 입력하세요 : ");
		int score = sc.nextInt();
		
		String prnText;
		
		//if( score >= 70 ) prnText = "합격";
		//else  prnText = "불합격";
		
		prnText = (score>=70)? "합격":"불합격";  
		// 관계연산이 true 이면 : 의 왼쪽을  false 이면 오른쪽을 선택
		
		System.out.println(prnText);
		
		
		System.out.printf("기본급을 입력하세요 : ");
		int a = sc.nextInt();
		// 기본급 100만원 이상이면 50%, 100만원 미만이면 60%가산하여 지급액을 출력
		
		double per = (a>=1000000)? 0.5 : 0.6;
		int total = (int)(a + a*per);
		System.out.println("총지급액 " + total  );
		
		// total = (a>=1000000)? (int)(a + a*0.5) : (int)(a + a*0.6);
	}
}











