package days04;

import java.util.Scanner;

public class ControlOp_IF03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("정수를 입력하세요 : ");
		int a = sc.nextInt();

		if( a>0 ) {
			System.out.println("양수입니다");
		} else {
			
			if( a<0 ) {
				System.out.println("음수입니다");
			}else {
				System.out.println("0입니다");
			}
			
		} //   문법상 오류는 없지만 이방법 잘 사용되지 않습니다
		
		if( a>0 ) {
			System.out.println("양수입니다");
		} else  if( a<0 ) {
			System.out.println("음수입니다");
		}else {
			System.out.println("0입니다");
		}
		// 맨 위의 ( ) 안의 비교연산식으로 계산한 결과가 true 경우 { } 안의 명령이 실행됩니다.
		// false 인경우 다음  else if 의 비교연산식을 계산하고 true 경우 { } 안의 명령이 실행합니다.
		// if 도 else if 도 모두 false 라면   else  부분을 실행하고 종료합니다
			
		// 중괄호 안의 명령이 한개라면 중괄호는 역시 생략가능합니다
		if( a>0 ) System.out.println("입력한 정수는 양수입니다");
		else if(a<0) System.out.println("입력한 정수는 음수입니다");
		else System.out.println("입력한 정수는 0입니다");
		
		int kor=70 , eng=79, mat=75;
		// 평균점수가 80 이상이면 합격, 70이상 79이하면 대기순번, 나머지는 불합격을 출력해주세요
		double avg = (kor+eng+mat)/3.0;
		
		if( avg>=80) System.out.println("합격");
		else if( avg>=70 && avg <=79) System.out.println("대기순번");
		else System.out.println("불합격");
	}

}







