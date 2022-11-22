package days05;

import java.util.Scanner;

public class ControlOp_IF10 {

	public static void main(String[] args) {
		
		// 2022년 1월 1일은 토요일입니다
		// 2022년에 한해서 월과 일을 입력받은후 해당날짜의 요일을 출력하세요
		
		// 9월 30일 입력했다면
		// 1월 ~ 8월 날짜수를 합산합니다.  입력한 월의 전달까지 날짜 계산
		// 그리고 합산한 결과에 30(입력한 일)을 더합니다
		
		// 모두합산한 결과를 7로 나눈 나머지를 구합니다
		// 그리고 토요일에서부터 상대적인 위치로 요일을 출력합니다
		
		// 1. 요일을 계산할 월과 일을 입력 받습니다
		Scanner sc = new Scanner(System.in);
		System.out.printf("월 입력 : ");
		int m = sc.nextInt();
		System.out.printf("일 입력 : ");
		int d = sc.nextInt();
		
		int days = 0;   // 합산한 날짜수가 저장될 변수
		
		if( m == 1) days = 0;
		else if( m == 2) days = 31;
		else if( m == 3) days = 31+28;
		else if( m == 4) days = 31+28+31;
		else if( m == 5) days = 31+28+31+30;
		else if( m == 6) days = 31+28+31+30+31;
		else if( m == 7) days = 31+28+31+30+31+30;
		else if( m == 8) days = 31+28+31+30+31+30+31;
		else if( m == 9) days = 31+28+31+30+31+30+31+31;
		else if( m == 10) days = 31+28+31+30+31+30+31+31+30;
		else if( m == 11) days = 31+28+31+30+31+30+31+31+30+31;
		else if( m == 12) days = 31+28+31+30+31+30+31+31+30+31+30;
		
		days = days + d;
		
		int temp = days % 7;
		
		if( temp == 1 ) System.out.println("토요일입니다");
		else if( temp == 2 ) System.out.println("일요일입니다");
		else if( temp == 3 ) System.out.println("월요일입니다");
		else if( temp == 4 ) System.out.println("화요일입니다");
		else if( temp == 5 ) System.out.println("수요일입니다");
		else if( temp == 6 ) System.out.println("목요일입니다");
		else if( temp == 0 ) System.out.println("금요일입니다");
			
	}

}
