package days04;

import java.util.Scanner;

public class ControlOp_IF02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("정수를 입력하세요 : ");
		int a = sc.nextInt();
		int b = a % 2;
		
		if( b==0 ) {
			System.out.println("짝수입니다");
		}else{
			System.out.println("홀수입니다");
		}
		// 이전 예제가 조건에 따라 명령을 실행할지 안할지를 결정하는 경우였다면,
		// 현재는 조건에 따라  if절을 실행할지, else절을 실행할지는 결정합니다
		
		
		if( b==0 )  	
		 		System.out.println("짝수(even)입니다");			
		else
				System.out.println("홀수(odd)입니다");
		
		if( b==0 ) System.out.println("짝수(even)입니다");			
		else System.out.println("홀수(odd)입니다");
		
		
		System.out.println();
		int kor=70 , eng=98, mat=95;
		double avg = (kor+eng+mat)/3.0;
		// 평균이 80이상이면 "합격" 이라고 출력합니다
		if(avg >= 80) System.out.println("합격");
		
		// 평균이 80이상이면 합격, 그렇지 않으면 불합격 이라고 출력
		if(avg >= 80) System.out.println("합격");
		else System.out.println("불합격");
		
		
		
		
		System.out.println();
		// 평균 60이상이거나  영어점수가 80이상이라면  합격, 아니면 불합격
		if( (avg>=60) || ( eng>=80 ) ) System.out.println("합격");
		else System.out.println("불합격");
		
		
		System.out.println();
		// 평균 60이상이면서  모든과목 40이상 이라면 합격, 아니면 불합격
		if( (avg>=60) && ( eng>=40 ) && (mat>=40) && (kor>=40)) System.out.println("합격");
		else System.out.println("불합격");
		
		// 입력한 숫자가 40보다 크고 80보다 작은경우 if문 조건
		// 40 <= a <= 80   X
		// 40 <= a && a<=80  O
		
		
		System.out.println();
		// 년도 하나를 입력 받아서 변수에 저장하고  입력한 년도가 윤년인지 평년인지를 출력
		System.out.print("연도를 입력하세요 : ");
		int year = sc.nextInt();
		if( (year%4 == 0) && (year%100 != 0) || (year%400 == 0) )
			System.out.println("윤년입니다");
		else
			System.out.println("평윤년입니다");
		
		int y1 =year%4;
		int y2 =year%100;
		int y3 =year%400;
		if( (y1==0) && (y2!=0) || (y3==0))System.out.println("윤년입니다");
		else System.out.println("평년입니다");
		
		boolean b1 = (year%4) == 0;
		boolean b2 = (year%100) != 0;
		boolean b3 = (year%400) == 0;
		if( b1 && b2 || b3 )System.out.println("윤년입니다");
		else System.out.println("평년입니다");
		
		// 연산의 우선순위
		// 1. (  )
		// 2. 변수의 앞에 사용되었다는 가정하에  ++, --
		// 3. 곱셈  나눗셈, 나머지(%)
		// 4. 덧셈 뺄셈
		// 5. 비교(관계)연산
		// 6. 논리연산
		// 7. 대입연산 =
		
	}

}







