package days05;

import java.util.Scanner;

public class ControlOp_Switch03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("월 입력 : ");
		int m = sc.nextInt();
		System.out.printf("일 입력 : ");
		int d = sc.nextInt();
		
		int days = 0;   // 합산한 날짜수가 저장될 변수
		
		switch(m) {
			case 12: days += 30;
			case 11: days += 31;
			case 10: days += 30;
			case 9: days += 31;
			case 8: days += 31;
			case 7: days += 30;
			case 6: days += 31;
			case 5: days += 30;
			case 4: days += 31;
			case 3: days += 28;
			case 2: days += 31;
			case 1:  days += 0;
		}
		
		days = days + d;
		
		int temp = days % 7;
		
		switch(temp) {
			case 1 : 
				System.out.println("토요일"); 
				break;
			case 2 : System.out.println("일요일"); break;
			case 3 : System.out.println("월요일"); break;
			case 4 : System.out.println("화요일"); break;
			case 5 : System.out.println("수요일"); break;
			case 6 : System.out.println("목요일"); break;
			case 0 : System.out.println("금요일"); break;
		}

	}

}
